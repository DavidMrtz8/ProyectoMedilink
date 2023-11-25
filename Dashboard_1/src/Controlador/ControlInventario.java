package Controlador;

import Modelo.Conexion;
import Modelo.Inventario;
import java.awt.Component;
import java.awt.Font;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

public class ControlInventario {
    Inventario inventario = new Inventario();
    
    public String CategoriaSelected(int categoriaID) {
        String categoria = "";

        if (categoriaID == 0) {
            categoria = "0";
        }

        if (categoriaID == 1) {
            categoria = "CG01";
        }

        if (categoriaID == 2) {
            categoria = "CG02";
        }

        if (categoriaID == 3) {
            categoria = "CG03";
        }

        if (categoriaID == 4) {
            categoria = "CG04";
        }

        if (categoriaID == 5) {
            categoria = "CG05";
        }

        if (categoriaID == 6) {
            categoria = "CG06";
        }

        if (categoriaID == 7) {
            categoria = "CG07";
        }

        if (categoriaID == 8) {
            categoria = "CG08";
        }

        return categoria;
    }
    
    public String ProveedorSelected(int proveedorID) {
        String proveedor = "";

        if (proveedorID == 0) {
            proveedor = "0";
        }

        if (proveedorID == 1) {
            proveedor = "MP001";
        }

        if (proveedorID == 2) {
            proveedor = "MP002";
        }

        if (proveedorID == 3) {
            proveedor = "MP003";
        }

        if (proveedorID == 4) {
            proveedor = "MP004";
        }

        if (proveedorID == 5) {
            proveedor = "MP005";
        }

        if (proveedorID == 6) {
            proveedor = "MP006";
        }

        if (proveedorID == 7) {
            proveedor = "MP007";
        }

        if (proveedorID == 8) {
            proveedor = "MP008";
        }

        if (proveedorID == 9) {
            proveedor = "MP009";
        }

        if (proveedorID == 10) {
            proveedor = "MP010";
        }
        
        if (proveedorID == 11) {
            proveedor = "MP011";
        }
        
        if (proveedorID == 12) {
            proveedor = "MP012";
        }
        
        if (proveedorID == 13) {
            proveedor = "MP013";
        }

        return proveedor;
    }
    
    public void RellenarCombo(String tabla, String valor, JComboBox combo){
        
        String sql = "select * from " + tabla;
        Statement st;
        
        Conexion con = new Conexion();
        Connection conn = con.getConnect();
        
        try{
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);
            
            while(rs.next()){
                combo.addItem(rs.getString(valor));
            }
        }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }    
    }
    
    public void LlenarTablaInventario(JTable tabla, int SucursalID) throws SQLException{        
        Conexion con = new Conexion();
        Connection conn = con.getConnect();
        
        String sucursal = SucursalSelected(SucursalID);
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spMostrarInventario (" + "'" + sucursal + "'" + ")}");
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Proveedor");
        model.addColumn("ProductoID");
        model.addColumn("Producto");
        model.addColumn("Precio");
        model.addColumn("Existencia");
        model.addColumn("Tipo de Unidad");
        model.addColumn("Sucursal");
        model.addColumn("Fecha de Expiración");
        
       tabla.setModel(model);
       
       tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
       
       String[] datos = new String[8];
       try{
           ResultSet rs = procedimientoAlmacenado.executeQuery();
           while(rs.next()){
               datos[0] = rs.getString(1);
               datos[1] = rs.getString(2);
               datos[2] = rs.getString(3);
               datos[3] = rs.getString(4);
               datos[4] = rs.getString(5);
               datos[5] = rs.getString(6);
               datos[6] = rs.getString(7);
               datos[7] = rs.getString(8);
               model.addRow(datos);
           }
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        } 
       
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
    }
    
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
    
    public String SucursalSelected (int sucursalID){
        String sucursal = "";
        
        if(sucursalID == 0){
            sucursal = "0";
        }
        
        if(sucursalID == 1){
            sucursal = "SC01";
        }
        
        if(sucursalID == 2){
            sucursal = "SC02";
        }
        
        if(sucursalID == 3){
            sucursal = "SC03";
        }
        
        if(sucursalID == 4){
            sucursal = "SC04";
        }
        
        if(sucursalID == 5){
            sucursal = "SC05";
        }
        
        if(sucursalID == 6){
            sucursal = "SC06";
        }
        
        return sucursal;
    }
    
    public void BuscarProductoInventario(JTable tabla, String productoID, int sucursalID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();
        
        String sucursal = SucursalSelected(sucursalID);
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spBuscarProductoInventario (" + "'" + productoID + "'" + ", " + "'" + sucursal  + "'" + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Proveedor");
        model.addColumn("ProductoID");
        model.addColumn("Producto");
        model.addColumn("Precio");
        model.addColumn("Existencia");
        model.addColumn("Tipo de Unidad");
        model.addColumn("Sucursal");
        model.addColumn("Fecha de Expiración");

        tabla.setModel(model);
        
        tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
        String[] datos = new String[8];
        try {
            ResultSet rs = procedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[6] = rs.getString(7);
                datos[7] = rs.getString(8);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
    }

    public void guardarProductoDetalle(JComboBox jcbProveedorID, JComboBox jcbCategoriaID, JTextField txtPrecio, JTextField txtStockMinimo, JTextField producto) {

        if (producto.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir el nombre del producto");
            return;
        }

        if (jcbCategoriaID.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una categoria");
            return;
        }

        if (jcbProveedorID.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un proveedor");
            return;
        }

//        if (jcbSucursalID.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Debe seleccionar una sucursal");
//            return;
//        }

        if (txtPrecio.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir el precio del producto");
            return;
        }
        
        if (!esNumero(txtPrecio.getText())) {
            JOptionPane.showMessageDialog(null, "El valor introducido para el precio no es un valor numérico");
            return;
        }

//        if (txtCantidad.getText().isEmpty()) {
//            JOptionPane.showMessageDialog(null, "Debe introducir la cantidad del producto");
//            return;
//        }
//        
//        if (!esNumero(txtCantidad.getText())) {
//            JOptionPane.showMessageDialog(null, "El valor introducido para la cantidad no es un valor numérico");
//            return;
//        }

        if (txtStockMinimo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir la existencia mínima del producto");
            return;
        }

        if (!esNumero(txtStockMinimo.getText())) {
            JOptionPane.showMessageDialog(null, "El valor introducido para la existencia mínima no es un valor numérico");
            return;
        }


        Date fechaActual = new Date();

//        if (fechaExp == null) {
//            JOptionPane.showMessageDialog(null, "Se deben ingresar una fecha valida", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }

        //float precio = Float.parseFloat(txtPrecio.getText());
        if (Float.parseFloat(txtPrecio.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese un precio valido. El precio no puede ser menor o igual a cero");
            return;
        }

//        if (Integer.parseInt(txtCantidad.getText()) <= 0) {
//            JOptionPane.showMessageDialog(null, "Ingrese una cantidad valida. La cantidad no puede ser menor o igual a cero");
//            return;
//        }

        //int existencia = Integer.parseInt(txtStockMinimo.getText());
        if (Integer.parseInt(txtStockMinimo.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Ingrese una existencia valida");
            return;
        }

//        if (fechaExp.before(fechaActual)) {
//            JOptionPane.showMessageDialog(null, "Se deben ingresar una fecha valida. La fecha ingresada es menor a la fecha actual", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        String categoria = CategoriaSelected(jcbCategoriaID.getSelectedIndex());
        String proveedor = ProveedorSelected(jcbProveedorID.getSelectedIndex());
        
        inventario.setProveedorID(proveedor);
        inventario.setCategoriaID(categoria);
        inventario.setNombre(producto.getText());
        inventario.setPrecio(Float.parseFloat(txtPrecio.getText()));
        inventario.setExistenciaMinima(Integer.parseInt(txtStockMinimo.getText()));
//        inventario.setSucursalID(jcbSucursalID.getSelectedIndex());
//        inventario.setFechaExp(dateStringFechaExp);
//        inventario.setCantidad(Integer.parseInt(txtCantidad.getText()));
        inventario.InsertarProducto(inventario);

        JOptionPane.showMessageDialog(null, "Producto registrado");
    }
    
    private static boolean esNumero(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
}
