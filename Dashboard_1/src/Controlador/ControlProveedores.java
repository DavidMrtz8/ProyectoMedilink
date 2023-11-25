package Controlador;

import Modelo.Conexion;
import Modelo.Proveedores;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ControlProveedores {
    Proveedores proveedor = new Proveedores();
    
    private class BoldHeaderRenderer extends DefaultTableCellRenderer {

        @Override
        public Component getTableCellRendererComponent(
                JTable table, Object value, boolean isSelected, boolean hasFocus, int row, int column) {
            Component c = super.getTableCellRendererComponent(table, value, isSelected, hasFocus, row, column);
            JLabel label = (JLabel) c;
            label.setText("<html><b>" + value + "</b></html>");
            return label;
        }
    }
    
    
    public void LlenarTablaProveedores(JTable tabla) throws SQLException{        
        Conexion con = new Conexion();
        Connection conn = con.getConnect();
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spMostrarProveedores()}");
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ProveedorID");
        model.addColumn("Nombre");
        model.addColumn("Direccion");
        model.addColumn("RTN");
        model.addColumn("Contacto");
        model.addColumn("Correo");
        
       tabla.setModel(model);
       
       tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
       
       String[] datos = new String[6];
       try{
           ResultSet rs = procedimientoAlmacenado.executeQuery();
           while(rs.next()){
               datos[0] = rs.getString(1);
               datos[1] = rs.getString(2);
               datos[2] = rs.getString(3);
               datos[3] = rs.getString(4);
               datos[4] = rs.getString(5);
               datos[5] = rs.getString(6);
               model.addRow(datos);
           }
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        } 
       
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
    }
    
    public void guardarProveedor(JTextField txtNombreProveedor, JTextField direccion, JTextField txtRTN, JTextField txtContacto, JTextField txtCorreo) {
        
        if (txtNombreProveedor.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir el nombre del proveedor.");
            return;
        }
        
        if (direccion.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir la dirección del proveedor.");
            return;
        }
        if (txtRTN.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir el RTN del proveedor.");
            return;
        }
        
        if (!esNumero(txtRTN.getText())) {
            JOptionPane.showMessageDialog(null, "El RTN debe ser unicamente numérico.");
            return;
        }

        if (txtRTN.getText().length() < 14 || txtRTN.getText().length() > 14) {
            JOptionPane.showMessageDialog(null, "El RTN debe ser un valor numérico de 14 posiciones.");
            return;
        }
        
        if (txtContacto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir el contacto del proveedor.");
            return;
        }

        if (txtCorreo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir el correo del proveedor.");
            return;
        }

        if(!validarCorreo(txtCorreo.getText())){
            JOptionPane.showMessageDialog(null, "El correo que ingresado no es valido.");
            return;
        }
        
        proveedor.setProveedor(txtNombreProveedor.getText());
        proveedor.setDireccion(direccion.getText());
        proveedor.setRtn(txtRTN.getText());
        proveedor.setContacto(txtContacto.getText());
        proveedor.setCorreo(txtCorreo.getText());
        proveedor.InsertarProveedor(proveedor);
        JOptionPane.showMessageDialog(null, "Proveedor registrado");
        LimpiarInputs(txtNombreProveedor, direccion, txtRTN, txtContacto, txtCorreo);
    }

    private void LimpiarInputs(JTextField txtNombreProveedor, JTextField direccion, JTextField txtRTN, JTextField txtContacto, JTextField txtCorreo) {
        txtNombreProveedor.setText("");
        txtRTN.setText("");
        direccion.setText("");
        txtCorreo.setText("");
        txtContacto.setText("");
    }

    private static boolean esNumero(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public static boolean validarCorreo(String correo) {
        // Patrón de expresión regular para validar direcciones de correo electrónico
        String patronCorreo = "^[A-Za-z0-9+_.-]+@(.+)$";

        Pattern pattern = Pattern.compile(patronCorreo);
        Matcher matcher = pattern.matcher(correo);

        return matcher.matches();
    }
}
