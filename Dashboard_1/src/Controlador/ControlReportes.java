package Controlador;

import Modelo.Conexion;
import java.awt.Color;
import java.awt.Component;
import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.plaf.BorderUIResource;
import javax.swing.plaf.ColorUIResource;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import org.jfree.chart.ChartFactory;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.data.category.CategoryDataset;
import org.jfree.data.category.DefaultCategoryDataset;

public class ControlReportes {

    
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
    
    public void RellenarComboSucursal(String tabla, String valor, JComboBox combo) {

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

    public void LlenarTablaStockMinimo(JTable tblStockMinimo, int SucursalID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();
        
        String sucursal = SucursalSelected(SucursalID);
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spStockMinimo (" + "'" + sucursal + "'" +")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ProveedorID");
        model.addColumn("Proveedor");
        model.addColumn("ProductoID");
        model.addColumn("Producto");
        model.addColumn("StockActual");
        model.addColumn("StockMinimo");
        model.addColumn("Tipo Unidad");

        tblStockMinimo.setModel(model);

        tblStockMinimo.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
        String[] datos = new String[7];
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
        tblStockMinimo.setShowGrid(false);
        tblStockMinimo.setIntercellSpacing(new java.awt.Dimension(15, 0));
        UIManager.put("Table.focusCellHighlightBorder", new BorderUIResource.EmptyBorderUIResource(0, 0, 0, 0));
        UIManager.put("Table.gridColor", new ColorUIResource(Color.WHITE));

        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblStockMinimo.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        tblStockMinimo.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        tblStockMinimo.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tblStockMinimo.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);

    }

    public void LlenarTablaProveedores(JTable Tabla) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spProductosDistribuidos()}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ProveedorID");
        model.addColumn("Nombre");
        model.addColumn("Direccion");
        model.addColumn("Contacto");
        model.addColumn("RTN");
        model.addColumn("Correo");
        model.addColumn("Productos Distribuidos");

        Tabla.setModel(model);

        Tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
        String[] datos = new String[7];
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
        Tabla.setIntercellSpacing(new java.awt.Dimension(15, 0));
        UIManager.put("Table.focusCellHighlightBorder", new BorderUIResource.EmptyBorderUIResource(0, 0, 0, 0));
        UIManager.put("Table.gridColor", new ColorUIResource(Color.WHITE));
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Tabla.getColumnModel().getColumn(0).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
    }

    public void LlenarTablaProductosProximosCaducar(JTable Tabla, int SucursalID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        String sucursal = SucursalSelected(SucursalID);
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spProductosProximosCaducar (" + "'" + sucursal + "'" + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Producto");
        model.addColumn("Cantidad");
        model.addColumn("Tipo Unidad");
        model.addColumn("Fecha de caducidad");
        model.addColumn("Categoria");
        model.addColumn("Sucursal");
        model.addColumn("Proveedor");
        model.addColumn("Dias Restantes");
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
                datos[7] = rs.getString(8);
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
        Tabla.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
    }

    public void LlenarTablaExistenciaPorCategoria(JTable Tabla, int SucursalID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        String sucursal = SucursalSelected(SucursalID);
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spExistenciasCategoria (" + "'" + sucursal + "'" + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("CategoriaID");
        model.addColumn("Categoria");
        model.addColumn("Existencia Actual");
        model.addColumn("Tipo Unidad");

        Tabla.setModel(model);

        Tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
        String[] datos = new String[4];
        try {
            ResultSet rs = procedimientoAlmacenado.executeQuery();
            while (rs.next()) {
                datos[0] = rs.getString(1);
                datos[1] = rs.getString(2);
                datos[2] = rs.getString(3);
                datos[3] = rs.getString(4);
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
    }

    public void LlenarTablaDevolucionProductos(JTable Tabla) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spReporteDevoluciones()}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ProductoID");
        model.addColumn("Nombre del producto");
        model.addColumn("Precio Unitario");
        model.addColumn("Cantidad Devuelta");
        model.addColumn("Tipo de Unidad");
        model.addColumn("Motivo Devolución");
        model.addColumn("Fecha de Devolución");
        model.addColumn("Sucursal");
        model.addColumn("Proveedor");

        Tabla.setModel(model);
        
        Tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());

        String[] datos = new String[9];
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
                datos[8] = rs.getString(9);
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
        Tabla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(6).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(7).setCellRenderer(rightRenderer);
    }

    public void LlenarTablaSalidaInventario(JTable tblTabla, int SucursalID, String FechaInicio, String FechaFinal) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        String sucursal = SucursalSelected(SucursalID);
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spSalidaInventario (" + "'" + FechaInicio + "'" + ", " + "'" + FechaFinal + "'" + ", " + "'" + sucursal + "'" + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre del Producto");
        model.addColumn("Cantidad");
        model.addColumn("Tipo de Unidad");
        model.addColumn("Precio Unitario");
        model.addColumn("Precio Total");
        model.addColumn("Fecha de salida");
        tblTabla.setModel(model);

        tblTabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
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
        tblTabla.setShowGrid(false);
        tblTabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        UIManager.put("Table.focusCellHighlightBorder", new BorderUIResource.EmptyBorderUIResource(0, 0, 0, 0));
        UIManager.put("Table.gridColor", new ColorUIResource(Color.WHITE));
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        tblTabla.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        tblTabla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        tblTabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        tblTabla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
    }

    public void LlenarTablaProductosSinExistencia(JTable Tabla) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call sp_productos_sin_existencia()}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ProductoID");
        model.addColumn("Nombre");
        model.addColumn("Categoría");
        model.addColumn("Proveedor");
        model.addColumn("Precio");
        model.addColumn("Existencia Mínima");
        model.addColumn("Tipo Unidad");
        Tabla.setModel(model);

        Tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());
        
        String[] datos = new String[7];
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
        Tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
    }

    public void LlenarTablaHistoricoPrecios(JTable Tabla, int year) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call sp_calcular_precios_promedio_trimestrales(" + year + ")}");

        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("Nombre del producto");
        model.addColumn("Primer Trimestre");
        model.addColumn("Segundo Trimestre");
        model.addColumn("Tercer Trimestre");
        model.addColumn("Cuatro Trimestre");
        model.addColumn("Precio Promedio");

        Tabla.setModel(model);
        
        Tabla.getTableHeader().setDefaultRenderer(new BoldHeaderRenderer());

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
        Tabla.setShowGrid(false);
        Tabla.setIntercellSpacing(new java.awt.Dimension(0, 0));
        UIManager.put("Table.focusCellHighlightBorder", new BorderUIResource.EmptyBorderUIResource(0, 0, 0, 0));
        UIManager.put("Table.gridColor", new ColorUIResource(Color.WHITE));
        
        DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
        rightRenderer.setHorizontalAlignment(SwingConstants.RIGHT);
        Tabla.getColumnModel().getColumn(1).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(2).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(3).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(4).setCellRenderer(rightRenderer);
        Tabla.getColumnModel().getColumn(5).setCellRenderer(rightRenderer);
    }

    /*----------------------------- Graficas ------------------------------------------------*/
    public CategoryDataset getDataset(String sucursal) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        String query = "CALL spExistenciasCategoriaGrafico(?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, sucursal);
        ResultSet rs = stmt.executeQuery();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        while (rs.next()) {
            String categoria = rs.getString("Categoria");
            int existenciaActual = rs.getInt("Existencia Actual");
            dataset.addValue(existenciaActual, "Existencia Actual", categoria);
        }

        rs.close();
        stmt.close();
        conn.close();

        return dataset;
    }

    public JFreeChart createChart(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Existencia de productos por categoría",
                "Categoría",
                "Existencia Actual",
                dataset
        );
        chart.setBackgroundPaint(Color.white);
        return chart;
    }

    public CategoryDataset getDatasetStockMinimo(String sucursalID) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        String query = "CALL spStockMinimo(?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, sucursalID);
        ResultSet rs = stmt.executeQuery();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        while (rs.next()) {
            String producto = rs.getString("Producto");
            int stockActual = rs.getInt("StockActual");
            int stockMinimo = rs.getInt("StockMinimo");

            dataset.addValue(stockActual, "Stock Actual", producto);
            dataset.addValue(stockMinimo, "Stock Mínimo", producto);
        }

        rs.close();
        stmt.close();
        conn.close();

        return dataset;
    }

    public JFreeChart createChartStockMinimo(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Stock Actual vs. Stock Mínimo",
                "Producto",
                "Cantidad",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(Color.white);
        return chart;
    }

    public CategoryDataset getDatasetSalidaInventario(String fechaInicio, String fechaFinal, String sucursal) throws SQLException {
        Conexion con = new Conexion();
        Connection conn = con.getConnect();

        String query = "CALL spSalidaInventarioGrafica(?, ?, ?)";
        PreparedStatement stmt = conn.prepareStatement(query);
        stmt.setString(1, fechaInicio);
        stmt.setString(2, fechaFinal);
        stmt.setString(3, sucursal);
        ResultSet rs = stmt.executeQuery();

        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        while (rs.next()) {
            String producto = rs.getString("Nombre del Producto");
            double precioTotal = rs.getDouble("Precio Total");

            dataset.addValue(precioTotal, "Precio Total", producto);
        }

        rs.close();
        stmt.close();
        conn.close();

        return dataset;
    }

    public JFreeChart createChartSalidaInventario(CategoryDataset dataset) {
        JFreeChart chart = ChartFactory.createBarChart(
                "Salida de Inventario",
                "Producto",
                "Precio Total",
                dataset,
                PlotOrientation.VERTICAL,
                true,
                true,
                false
        );

        chart.setBackgroundPaint(Color.white);
        return chart;
    }

    public void actualizarFecha(JLabel labelFecha) {
        // Obtener la fecha actual
        Date fechaActual = new Date();

        // Definir el formato de la fecha
        SimpleDateFormat formatoFecha = new SimpleDateFormat("dd/MM/yyyy");

        // Formatear la fecha actual en el formato deseado
        String fechaFormateada = formatoFecha.format(fechaActual);

        // Establecer la fecha formateada en el label
        labelFecha.setText(fechaFormateada);
    }

    /*
    private int registrosPorPagina = 10;
    private int numeroPagina = 1;
    
    public void paginar(JTable jTable) {
        try {
            Conexion con = new Conexion();
            Connection conn = con.getConnect();
            String sql = "SELECT * FROM mi_tabla LIMIT ?, ?";
            PreparedStatement stmt = conn.prepareStatement(sql);

            // Calcular el índice de inicio para la página actual
            int startIndex = (numeroPagina - 1) * registrosPorPagina;
            
            stmt.setInt(1, startIndex);
            stmt.setInt(2, registrosPorPagina);

            // Ejecutar la consulta y obtener los resultados
            ResultSet result = stmt.executeQuery();

            // Actualizar el JTable con los datos obtenidos
            DefaultTableModel model = (DefaultTableModel) jTable.getModel();
            model.setRowCount(0); // Limpiar el modelo actual

            while (result.next()) {
                // Leer los datos de la fila actual y agregarlos al modelo de la tabla
                Object[] rowData = {
                    result.getInt("id"),
                    result.getString("nombre"),
                    // Agregar aquí las columnas restantes de la tabla
                };
                model.addRow(rowData);
            }

            // Cerrar las conexiones y liberar recursos
            result.close();
            stmt.close();
            conn.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void paginaAnterior(JTable jTable) {
        numeroPagina--;
        paginar(jTable);
    }

    public void paginaSiguiente(JTable jTable) {
        numeroPagina++;
        paginar(jTable);
    }

     */
}
