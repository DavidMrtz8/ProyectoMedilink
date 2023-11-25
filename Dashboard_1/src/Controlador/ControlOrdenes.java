package Controlador;

import Modelo.Conexion;
import Modelo.Devoluciones;
import Modelo.OrdenesEntrada;
import Modelo.OrdenesSalida;
import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.Date;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

public class ControlOrdenes {

    OrdenesEntrada OrdenEntrada = new OrdenesEntrada();
    OrdenesSalida OrdenSalida = new OrdenesSalida();
    OrdenesEntrada Oe = new OrdenesEntrada();
    OrdenesEntrada ordenesE = new OrdenesEntrada();
    OrdenesSalida ordenesS = new OrdenesSalida();
    Devoluciones devolucion = new Devoluciones();
    DefaultTableModel modelo = new DefaultTableModel();
    
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
//    public void BuscarProducto(JTextField productoID, JTextField Producto, JTextField ProvID, JTextField Proveedor) {
//        int r;
//        try {
//            int codCliente = Integer.parseInt(productoID.getText());
//            if (codCliente.equals("") || esNumero(codCliente)) {
//                JOptionPane.showMessageDialog(null, "Debe ingresar un codigo de producto valido");
//            } else {
//                OrdenesEntrada ordenE = OrdenEntrada.ListarProductos(codCliente);
//                if (ordenE.getProductoID()!= null) {
//                    Producto.setText(ordenE.getProducto());
//                    ProvID.setText(ordenE.getProveedorID());
//                    Proveedor.setText(ordenE.getProveedor());
//                } 
////                else {
////                    r = JOptionPane.showConfirmDialog(null, "Cliente No registrado, ¿Desea Registrar?");
////                    if (r == 0) {
////                        WindowClienteNuevo cn = new WindowClienteNuevo(wv, true, cacheLogin);
////                        cn.setVisible(true);
////                    }
////                    DNI.requestFocus();
////                }
//            }
//        } catch (HeadlessException e) {
//            JOptionPane.showMessageDialog(null, "Faltan Datos");
//        }
//    }

    
    public String SucursalSelected(int sucursalID) {
        String sucursal = "";

        if (sucursalID == 0) {
            sucursal = "0";
        }

        if (sucursalID == 1) {
            sucursal = "SC01";
        }

        if (sucursalID == 2) {
            sucursal = "SC02";
        }

        if (sucursalID == 3) {
            sucursal = "SC03";
        }

        if (sucursalID == 4) {
            sucursal = "SC04";
        }

        if (sucursalID == 5) {
            sucursal = "SC05";
        }

        if (sucursalID == 6) {
            sucursal = "SC06";
        }

        return sucursal;
    }
    
        
    
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
    
    
    public void RellenarCombo(String tabla, String valor, JComboBox combo) {

        String sql = "select * from " + tabla;
        Statement st;

        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            while (rs.next()) {
                combo.addItem(rs.getString(valor));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
    }

    public void RellenarComboProductos(int categoriaID, int sucursalID, JComboBox combo) {
        String sucursal = SucursalSelected(sucursalID);
        String categoria = CategoriaSelected(categoriaID);
        
        String sql = "select pd.Nombre, i.Existencia from producto_detalle as pd\n"
                + "inner join inventario as i on pd.ProductoID = i.ProductoID\n"
                + "where pd.CategoriaID = " + "'" + categoria + "'" + " and i.SucursalID = " + "'" + sucursal + "'";
        Statement st;

        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo.getModel();
            boolean isFirstIteration = true;
            while (rs.next()) {
                String nombre = rs.getString("Nombre");

                if (isFirstIteration) {
                    model.removeAllElements();
                    model.addElement("Seleccione un producto");
                    isFirstIteration = false;
                }

                model.addElement(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
    }
    
        public void RellenarComboBoxProductos(String producto, int sucursalID, JComboBox combo) {
        String sucursal = SucursalSelected(sucursalID);
        
        String sql = "select pd.Nombre, sum(i.Existencia) as 'Existencia' from producto_detalle as pd\n"
                + "inner join inventario as i on pd.ProductoID = i.ProductoID\n"
                + "where pd.Nombre like concat(" + "'" + producto + "', '%')" + " and i.SucursalID = " + "'" + sucursal + "' group by pd.Nombre";
        Statement st;

        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        
        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo.getModel();
            boolean isFirstIteration = true;
            while (rs.next()) {
                String nombre = rs.getString("Nombre");

                if (isFirstIteration) {
                    model.removeAllElements();
                    model.addElement("Seleccione un producto");
                    isFirstIteration = false;
                }

                model.addElement(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
    }
    
        
   public void LimpiarComboBox(JComboBox productos){
      productos.removeAllItems();
      productos.addItem("Seleccione un Producto");
   }
        
    public void BuscarProducto(JTextField productoID, JTextField Producto, JTextField ProvID, JTextField Proveedor) {
        String codProduc = productoID.getText();
        if (!codProduc.isEmpty()) {
            try {
                // Attempt to parse the text as an integer
                int productID = Integer.parseInt(codProduc);

                OrdenesEntrada ordenE = OrdenEntrada.ListarProductos(productID);
                Producto.setText(ordenE.getProducto());
                ProvID.setText(ordenE.getProveedorID());
                Proveedor.setText(ordenE.getProveedor());

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un codigo de producto valido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un codigo de producto valido");
        }
    }

//    public void BuscarProductoOrdenSalida(JTextField productoID, JTextField Producto, JComboBox sucursal, JTextField existencia) {
//
//        String codProduc = productoID.getText();
//        if (!codProduc.isEmpty()) {
//            try {
//                // Attempt to parse the text as an integer
//                int productID = Integer.parseInt(codProduc);
//
//                OrdenesSalida ordenS = OrdenSalida.ListarProductos(productID, sucursal.getSelectedIndex());
//                Producto.setText(ordenS.getProducto());
//                existencia.setText(Integer.toString(ordenS.getExistencia()));
//            } catch (NumberFormatException e) {
//                JOptionPane.showMessageDialog(null, "Debe ingresar un codigo de producto valido");
//            }
//        } else {
//            JOptionPane.showMessageDialog(null, "Debe ingresar un codigo de producto valido");
//        }
//    }
    public void BuscarProductosOrdenSalida(JComboBox productos, JComboBox sucursal, JTextField existencia, JTextField productoID) {
        String produc = (String) productos.getSelectedItem();

        String sucursalID = SucursalSelected(sucursal.getSelectedIndex());
        
        OrdenesSalida ordenS = OrdenSalida.ListarProductos(produc, sucursalID);
        //Producto.setText(ordenS.getProducto());
        existencia.setText(Integer.toString(ordenS.getExistencia()));
        productoID.setText(ordenS.getProductoID());

    }

    public void BuscarProductosOrdenEntrada(JComboBox productos, JComboBox sucursal, JTextField proveedorID, JTextField proveedor, JTextField productoID) {
        String produc = (String) productos.getSelectedItem();
        
        String sucursalS = SucursalSelected(sucursal.getSelectedIndex());
        
        OrdenesEntrada ordenE = OrdenEntrada.ListarProductosOrdenEntrada(produc, sucursalS);
//        OrdenesSalida ordenS = OrdenSalida.ListarProductos(produc, sucursal.getSelectedIndex());
        //Producto.setText(ordenS.getProducto());
        proveedorID.setText(ordenE.getProveedorID());
        productoID.setText(ordenE.getProductoID());
        proveedor.setText(ordenE.getProveedor());

    }
    
    public void BuscarProductoOrdenSalidaNombre(JTextField productoID, JTextField Producto) {

        String codProduc = productoID.getText();
        if (!codProduc.isEmpty()) {
            try {
                // Attempt to parse the text as an integer
                int productID = Integer.parseInt(codProduc);

                OrdenesSalida ordenS = OrdenSalida.ListarProductosNombre(productID);
                Producto.setText(ordenS.getProducto());
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Debe ingresar un codigo de producto valido");
            }
        } else {
            JOptionPane.showMessageDialog(null, "Debe ingresar un codigo de producto valido");
        }
    }

    public void LlenarTablaOrdenesEntrada(JTable tabla, int SucursalID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();
        
        String sucursal = SucursalSelected(SucursalID);
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spMostrarOrdenesEntrada (" + "'" +sucursal + "'" + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("OrdenID");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Tipo de Unidad");
        model.addColumn("Precio");
        model.addColumn("Fecha de Pedido");

        tabla.setModel(model);

        tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
        String[] datos = new String[6];
        try {
            ResultSet rs = procedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
    }

        public void BuscarOrdenEntrada(JTable tabla, int OrdenID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spBuscarOrdenesEntrada (" + OrdenID + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("OrdenID");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Tipo de Unidad");
        model.addColumn("Precio");
        model.addColumn("Fecha de Pedido");

        tabla.setModel(model);

        tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
        String[] datos = new String[6];
        try {
            ResultSet rs = procedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
    }
    
    public void LlenarTablaOrdenesSalida(JTable tabla, int SucursalID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        String sucursal = SucursalSelected(SucursalID);
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spMostrarOrdenesSalida (" + "'" +sucursal + "'" + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("OrdenID");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Tipo de unidad");
        model.addColumn("Precio");
        model.addColumn("Fecha del pedido");

        tabla.setModel(model);

        tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
        String[] datos = new String[6];
        try {
            ResultSet rs = procedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
    }

    public void BuscarOrdenesSalida(JTable tabla, int ordenID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spBuscarOrdenesSalida (" + ordenID + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("OrdenID");
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Tipo de unidad");
        model.addColumn("Precio");
        model.addColumn("Fecha del pedido");

        tabla.setModel(model);
        
        tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());

        String[] datos = new String[6];
        try {
            ResultSet rs = procedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tabla.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tabla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
    }
    
    public void agregarProducto(JTable tabla, JTextField productID, JComboBox product, JTextField provID, JTextField prov, JTextField precioU, JTextField cant, JComboBox sucur, JDateChooser fechaExp, JComboBox categoria) {
        modelo = (DefaultTableModel) tabla.getModel();

        String sucursal = (String) sucur.getSelectedItem();

        if ("Seleccionar Sucursal".equals(sucursal)) {
            JOptionPane.showMessageDialog(null, "Seleccione una sucursal.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
//        if (categoria.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Seleccione una categoría.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }
        
        if (product.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        if (productID.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "Debe introducir el productoID.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (provID.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "El proveedorID no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (prov.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "El nombre del proveedor no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (precioU.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "El precio unitario no puede estar vacío.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!esNumero(precioU.getText())) {
            JOptionPane.showMessageDialog(null, "El valor introducido para el precio no es un valor numérico.");
            return;
        }

        if (Float.parseFloat(precioU.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Precio introducido no valido. El precio debe ser mayor a cero.");
            return;
        }

        if (cant.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "La cantidad no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!esNumero(cant.getText())) {
            JOptionPane.showMessageDialog(null, "El valor introducido para la cantidad no es un valor numérico.");
            return;
        }

        if (Integer.parseInt(cant.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Cantidad introducida no valida. El pedido debe ser mayor a cero productos.");
            return;
        }



        //Date fechaActual = new Date();
//        Date fechaExp = fechaExp.getDate();
//        String pattern = "yyyy-MM-dd";    // Formato de fecha en la cadena
//
//        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
//
//        java.util.Date utilDate = dateFormat.parse();
//        java.sql.Date sqlDate = new java.sql.Date(utilDate.getTime());
        Date fechaExpiracionIngresada = fechaExp.getDate();

        LocalDate fechaActual = LocalDate.now();
        LocalDate fechaE = fechaExpiracionIngresada.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();

        LocalDate fechaMinima = fechaActual.plusDays(30);

        if (fechaE.isBefore(fechaMinima)) {
            JOptionPane.showMessageDialog(null, "Se debe ingresar una fecha válida. La fecha ingresada es menor a la fecha mínima requerida (30 días después de la fecha actual).", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        SimpleDateFormat dateFormatFechaExp = new SimpleDateFormat("yyyy-MM-dd"); // Por ejemplo, "dd/MM/yyyy" o "yyyy-MM-dd"

        Date fechaEx = fechaExp.getDate();
        String fechaExpiracion = dateFormatFechaExp.format(fechaEx);

        ArrayList Lista = new ArrayList();
        Lista.add(productID.getText());
        Lista.add(product.getSelectedItem());
        Lista.add(Float.parseFloat(precioU.getText()));
        Lista.add(Integer.parseInt(cant.getText()));
        Lista.add(fechaExpiracion);
        Lista.add(provID.getText());
        Lista.add(prov.getText());
        Lista.add(sucursal);
        Object[] ob = new Object[8];
        ob[0] = Lista.get(0);
        ob[1] = Lista.get(1);
        ob[2] = Lista.get(2);
        ob[3] = Lista.get(3);
        ob[4] = Lista.get(4);
        ob[5] = Lista.get(5);
        ob[6] = Lista.get(6);
        ob[7] = Lista.get(7);
        modelo.addRow(ob);
        tabla.setModel(modelo);

        LimpiarTextFields(productID, product, provID, prov, precioU, cant, categoria, fechaExp);
    }

    private void LimpiarTextFields(JTextField productID, JComboBox product, JTextField provID, JTextField prov, JTextField precioU, JTextField cant, JComboBox categoria, JDateChooser fechaExp) {
        productID.setText("");
        cant.setText("");
        precioU.setText("");
        product.setSelectedIndex(0);
        categoria.setSelectedIndex(0);
        prov.setText("");
        provID.setText("");
        //fechaExp.;

    }

    private static boolean esNumero(String input) {
        try {
            Double.parseDouble(input);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public void agregarProductoOrdenSalida(JTable tabla, JTextField productID, JComboBox product, JTextField cant, JComboBox sucur, JComboBox categoria, JTextField existencia) {

        modelo = (DefaultTableModel) tabla.getModel();

//        if (productID.getText().isBlank()) {
//            JOptionPane.showMessageDialog(null, "Debe introducir el productoID.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }

//        if (categoria.getSelectedIndex() == 0) {
//            JOptionPane.showMessageDialog(null, "Seleccione una categoría.", "Error", JOptionPane.ERROR_MESSAGE);
//            return;
//        }

        String sucursal = (String) sucur.getSelectedItem();

        if ("Seleccionar Sucursal".equals(sucursal)) {
            JOptionPane.showMessageDialog(null, "Seleccione una sucursal valida", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (product.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Seleccione un producto.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (existencia.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "La existencia no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!esNumero(existencia.getText())) {
            JOptionPane.showMessageDialog(null, "El valor introducido para la existencia no es un valor numérico.");
            return;
        }

        if (Integer.parseInt(existencia.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "Producto sin existencia en el inventario.");
            return;
        }

        if (cant.getText().isBlank()) {
            JOptionPane.showMessageDialog(null, "La cantidad no puede estar vacía.", "Error", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (!esNumero(cant.getText())) {
            JOptionPane.showMessageDialog(null, "El valor introducido para la cantidad no es un valor numérico.");
            return;
        }

        if (Integer.parseInt(cant.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad solicitada debe ser mayor que cero.");
            return;
        }

        if (Integer.parseInt(existencia.getText()) - Integer.parseInt(cant.getText()) < 0) {
            JOptionPane.showMessageDialog(null, "No hay suficiente existencia en el inventario de este producto para llevar a cabo la orden.");
            return;
        }

        for (int i = 0; i < tabla.getRowCount(); i++) {
            String sucursalTabla = tabla.getValueAt(i, 3).toString();

            if (sucur.getSelectedItem() != sucursalTabla) {
                JOptionPane.showMessageDialog(null, "El pedido se debe realizar en una sola sucursal.");
                return;
            }
        }

        ArrayList Lista = new ArrayList();
        Lista.add(productID.getText());
        Lista.add(product.getSelectedItem());
        Lista.add(Integer.parseInt(cant.getText()));
        Lista.add(sucursal);
        Object[] ob = new Object[4];
        ob[0] = Lista.get(0);
        ob[1] = Lista.get(1);
        ob[2] = Lista.get(2);
        ob[3] = Lista.get(3);
        modelo.addRow(ob);
        tabla.setModel(modelo);

        limpiarTextFields(productID, cant);
    }

    private void limpiarTextFields(JTextField productID, JTextField cant) {
        productID.setText("");
        cant.setText("");
    }

    public void EliminarRegistroTabla(JTable tabla) {
        int fsel, resp;
        try {
            fsel = tabla.getSelectedRow();
            if (fsel == -1) {
                JOptionPane.showMessageDialog(null, "Debe seleccionar el producto a eliminar", "Advertencia", JOptionPane.WARNING_MESSAGE);
            } else {
                resp = JOptionPane.showConfirmDialog(null, "¿Esta seguro de eliminar este registro?", "Eliminar", JOptionPane.YES_NO_OPTION);
                if (resp == JOptionPane.YES_OPTION) {
                    modelo = (DefaultTableModel) tabla.getModel();
                    modelo.removeRow(fsel);

                }
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }

    public void guardarOrdenEntrada(JComboBox sucursal) {
        try {
            String sucursalID = SucursalSelected(sucursal.getSelectedIndex());

            Oe.setSucursalID(sucursalID);
            Oe.InsertarOrdenEntrada(Oe);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal al momento de ingresar el pedido");
        }

    }

    public void guardarOrdenSalida() {
        try {
            Oe.InsertarOrdenSalida();
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal al momento de ingresar el pedido");
        }

    }

    public void guardarOrdenSalidaDetalle(JTable tabla, JComboBox sucursal) {
        try {
            for (int i = 0; i < tabla.getRowCount(); i++) {
                String sucursalID = SucursalSelected(sucursal.getSelectedIndex());
                String productoID = tabla.getValueAt(i, 0).toString();
                int cantidad = Integer.parseInt(tabla.getValueAt(i, 2).toString());

                ordenesS.setProductoID(productoID);
                ordenesS.setCantidad(cantidad);
                ordenesS.setSucursalID(sucursalID);
                ordenesS.InsertarOrdenSalidaDetalles(ordenesS);
            }

            if (tabla.getRowCount() > 0) {
                JOptionPane.showMessageDialog(null, "Pedido ingresado exitosamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal al momento de ingresar el pedido");
        }
    }

        public void ActualizarExistencia(JTable tabla, JComboBox sucursal) {
        try {
            for (int i = 0; i < tabla.getRowCount(); i++) {
                String sucursalID = SucursalSelected(sucursal.getSelectedIndex());
                String productoID = tabla.getValueAt(i, 0).toString();
                int cantidad = Integer.parseInt(tabla.getValueAt(i, 2).toString());

                ordenesS.setProductoID(productoID);
                ordenesS.setCantidad(cantidad);
                ordenesS.setSucursalID(sucursalID);
                                
                ordenesS.ActualizarExistencia(ordenesS);
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal al momento de ingresar el pedido");
        }
    }

    public void DevolucionProductos(JComboBox SucursalID, JTextField Producto, JTextField cantidadDevuelta) {
        try {
            
            String sucursal = SucursalSelected(SucursalID.getSelectedIndex());
            String productoID = Producto.getText();
            int cantidadDev = Integer.parseInt(cantidadDevuelta.getText());
            
            
            devolucion.setCantidaDevuelta(cantidadDev);
            devolucion.setProductoID(productoID);
            devolucion.setSucursalID(sucursal);
            
            devolucion.ActualizarExistencia(devolucion);
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal al momento de ingresar el pedido");
        }
    }
        

    public void guardarOrdenEntradaDetalle(JTable tabla, JComboBox sucursal) {
        try {
            String sucursalID = SucursalSelected(sucursal.getSelectedIndex());
            String pattern = "yyyy-MM-dd";
            //SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
            SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);

            for (int i = 0; i < tabla.getRowCount(); i++) {
                String productoID = tabla.getValueAt(i, 0).toString();
                float precioUnitario = Float.parseFloat(tabla.getValueAt(i, 2).toString());
                int cantidad = Integer.parseInt(tabla.getValueAt(i, 3).toString());
                java.util.Date utilDate = dateFormat.parse(tabla.getValueAt(i, 4).toString());
                java.sql.Date fechaExp = new java.sql.Date(utilDate.getTime());

                //Date fechaExp = dateFormat.parse(tabla.getValueAt(i, 4).toString());
                String proveedorID = tabla.getValueAt(i, 5).toString();
                ordenesE.setProductoID(productoID);
                ordenesE.setCantidad(cantidad);
                ordenesE.setPrecioUnitario(precioUnitario);
                ordenesE.setProveedorID(proveedorID);
                ordenesE.setSucursalID(sucursalID);
                ordenesE.setFechaExp(fechaExp);

                ordenesE.InsertarOrdenEntradaDetalles(ordenesE);
            }

            if (tabla.getRowCount() > 0) {
                JOptionPane.showMessageDialog(null, "Pedido ingresado exitosamente");
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, "Algo salió mal al momento de ingresar el pedido");
        }

    }

    public static boolean isNumeric(String str) {
        try {
            double numericValue = Double.parseDouble(str);
            return true;
        } catch (NumberFormatException e) {
            return false;
        }
    }
    
    public void LlenarTablaDevolucionProductos(JTable Tabla) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spMostrarDevoluciones()}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DevoluciónID");
        model.addColumn("Nombre del producto");
        model.addColumn("Cantidad Devuelta");
        model.addColumn("Tipo de Unidad");
        model.addColumn("Motivo Devolución");
        model.addColumn("Fecha de Devolución");
        model.addColumn("");
        model.addColumn("Sucursal");
        model.addColumn("Proveedor");

        Tabla.setModel(model);
        
        TableColumnModel columnModel = Tabla.getColumnModel();
        
        TableColumn column = columnModel.getColumn(6);
        column.setPreferredWidth(0);
        
        Tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());

        String[] datos = new String[10];
        try {
            ResultSet rs = procedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
                datos[4] = rs.getString(5);
                datos[5] = rs.getString(6);
                datos[7] = rs.getString(7);
                datos[8] = rs.getString(8);
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
        Tabla.setShowGrid(false);
        Tabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        UIManager.put("Table.focusCellHighlightBorder", new BorderUIResource.EmptyBorderUIResource(0, 0, 0, 0));
        UIManager.put("Table.gridColor", new ColorUIResource(Color.WHITE));

        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Tabla.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
    }
    
        public void BuscarDevolucionProductos(JTable Tabla, int devolucionID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spBuscarDevoluciones(" + devolucionID + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("DevoluciónID");
        model.addColumn("Nombre del producto");
        model.addColumn("Cantidad Devuelta");
        model.addColumn("Tipo de Unidad");
        model.addColumn("Motivo Devolución");
        model.addColumn("Fecha de Devolución");
        //model.addColumn("Estado de Devolución");
        model.addColumn("Proveedor");

        Tabla.setModel(model);

        Tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
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
                model.addRow(datos);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
        Tabla.setShowGrid(false);
        Tabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        UIManager.put("Table.focusCellHighlightBorder", new BorderUIResource.EmptyBorderUIResource(0, 0, 0, 0));
        UIManager.put("Table.gridColor", new ColorUIResource(Color.WHITE));

        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Tabla.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
    }
        
   public void RellenarComboProductosDevoluciones(int categoriaID, JComboBox combo) {
       String categoria = CategoriaSelected(categoriaID);
       
       String sql = "select DISTINCT pd.Nombre,  i.Existencia from producto_detalle as pd\n"
                + "inner join inventario as i on pd.ProductoID = i.ProductoID\n"
                + "where pd.CategoriaID = " + "'" +categoria + "'" + " and i.SucursalID = 'SC01'";
        Statement st;

        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo.getModel();
            boolean isFirstIteration = true;
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                 
                if (isFirstIteration) {
                    model.removeAllElements();
                    model.addElement("Seleccione un producto");
                    isFirstIteration = false;
                }
                model.addElement(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
    }
   
   
      public void RellenarComboBoxProductosDevoluciones(String producto, JComboBox combo) {
       //String categoria = CategoriaSelected(categoriaID);
       
       String sql = "select DISTINCT pd.Nombre,  i.Existencia from producto_detalle as pd\n"
                + "inner join inventario as i on pd.ProductoID = i.ProductoID\n"
                + "where pd.Nombre like concat( " + "'" +producto + "', '%')" + " and i.SucursalID = 'SC01'";
        Statement st;

        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        try {
            st = conn.createStatement();
            ResultSet rs = st.executeQuery(sql);

            DefaultComboBoxModel<String> model = (DefaultComboBoxModel<String>) combo.getModel();
            boolean isFirstIteration = true;
            while (rs.next()) {
                String nombre = rs.getString("Nombre");
                 
                if (isFirstIteration) {
                    model.removeAllElements();
                    model.addElement("Seleccione un producto");
                    isFirstIteration = false;
                }
                model.addElement(nombre);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }
    }
   
   
    public void BuscarProductosID(JComboBox productos, JTextField productoID, JTextField proveedorID) {
        String produc = (String) productos.getSelectedItem();

        Devoluciones dev = devolucion.BuscarProductoID(produc);
        productoID.setText(dev.getProductoID());
        proveedorID.setText(dev.getProveedorID());
    }
    
    public void guardarDevolucion(JComboBox jcbSucursalID, JComboBox producto, JTextField txtMotivo, JTextField cantidadDev, JDateChooser txtFechaDev, JTextField txtProductoID, JTextField txtProveedorID) {        
        if (producto.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar un producto");
            return;
        }
        
        if (jcbSucursalID.getSelectedIndex() == 0) {
            JOptionPane.showMessageDialog(null, "Debe seleccionar una categoria");
            return;
        }
        
        if (txtMotivo.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir el motivo de la devolución del producto");
            return;
        }

        if (cantidadDev.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "Debe introducir la cantidad devuelta del producto");
            return;
        }

        if (!esNumero(cantidadDev.getText())) {
            JOptionPane.showMessageDialog(null, "El valor introducido para la cantidad devuelta no es un valor numérico");
            return;
        }

        if (Integer.parseInt(cantidadDev.getText()) <= 0) {
            JOptionPane.showMessageDialog(null, "La cantidad devuelta debe ser mayor que cero.");
            return;
        }
        
        if (txtProductoID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ProductoID no valido.");
            return;
        }
        
        if (txtProveedorID.getText().isEmpty()) {
            JOptionPane.showMessageDialog(null, "ProveedorID no valido.");
            return;
        }

        SimpleDateFormat dateFormatFechaExp = new SimpleDateFormat("yyyy-MM-dd"); // Por ejemplo, "dd/MM/yyyy" o "yyyy-MM-dd"

        Date fechaEx = txtFechaDev.getDate();
        String fechaExpiracion = dateFormatFechaExp.format(fechaEx);
        
        String sucursal = SucursalSelected(jcbSucursalID.getSelectedIndex());
        
        devolucion.setMotivo(txtMotivo.getText());
        devolucion.setProductoID(txtProductoID.getText());
        devolucion.setCantidaDevuelta(Integer.parseInt(cantidadDev.getText()));
        devolucion.setFechaDevolucion(fechaExpiracion);
        devolucion.setProveedorID(txtProveedorID.getText());
        devolucion.setSucursalID(sucursal);
        devolucion.InsertarProductoDevoluciones(devolucion);
        //devolucion.setProveedorID(Inte);
//        inventario.setProveedorID(jcbProveedorID.getSelectedIndex());
//        inventario.setCategoriaID(jcbCategoriaID.getSelectedIndex());
//        inventario.setNombre(producto.getText());
//        inventario.setPrecio(Float.parseFloat(txtPrecio.getText()));
//        inventario.setExistenciaMinima(Integer.parseInt(txtStockMinimo.getText()));
//        inventario.InsertarProducto(inventario);
        JOptionPane.showMessageDialog(null, "Devolución registrada.");
    }
    
}
