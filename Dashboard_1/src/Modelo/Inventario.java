package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Inventario {
    
    private String proveedorID;
    private String categoriaID;
    private String nombre;
    private float precio;
    private int existenciaMinima;
    private String sucursalID;
    private String FechaExp; 
    private int cantidad;

    public Inventario() {
    }

    public Inventario(String proveedorID, String categoriaID, String nombre, float precio, int existenciaMinima, String sucursalID, String FechaExp, int cantidad) {
        this.proveedorID = proveedorID;
        this.categoriaID = categoriaID;
        this.nombre = nombre;
        this.precio = precio;
        this.existenciaMinima = existenciaMinima;
        this.sucursalID = sucursalID;
        this.FechaExp = FechaExp;
        this.cantidad = cantidad;
    }

    public String getProveedorID() {
        return proveedorID;
    }

    public void setProveedorID(String proveedorID) {
        this.proveedorID = proveedorID;
    }

    public String getCategoriaID() {
        return categoriaID;
    }

    public void setCategoriaID(String categoriaID) {
        this.categoriaID = categoriaID;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public float getPrecio() {
        return precio;
    }

    public void setPrecio(float precio) {
        this.precio = precio;
    }

    public int getExistenciaMinima() {
        return existenciaMinima;
    }

    public void setExistenciaMinima(int existenciaMinima) {
        this.existenciaMinima = existenciaMinima;
    }

    public String getSucursalID() {
        return sucursalID;
    }

    public void setSucursalID(String sucursalID) {
        this.sucursalID = sucursalID;
    }

    public String getFechaExp() {
        return FechaExp;
    }

    public void setFechaExp(String FechaExp) {
        this.FechaExp = FechaExp;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    

    
    public int InsertarProducto(Inventario i) {
        int r = 0;
        
        String sql = "{call spAgregarProductoInventario(?, ?, ?, ?, ?)}";
        try {
            CallableStatement cs = new Conexion().getConnect().prepareCall(sql);
            
            
            
            cs.setString(1, i.getProveedorID());
            cs.setString(2,i.getCategoriaID());
            cs.setString(3, i.getNombre());
            cs.setFloat(4, i.getPrecio());
            cs.setInt(5,i.getExistenciaMinima());
            
            r = cs.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return r;
    }
    
    public void LlenarTablaStockMinimo(JTable tblStockMinimo, int SucursalID) throws SQLException{        
        Conexion con = new Conexion();
        Connection conn = con.getConnect();
        
        CallableStatement procedimientoAlmacenado = conn.prepareCall("{call spStockMinimo (" + SucursalID + ")}");
        
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("ProveedorID");
        model.addColumn("Proveedor");
        model.addColumn("ProductoID");
        model.addColumn("Producto");
        model.addColumn("StockActual");
        model.addColumn("StockMinimo");
        model.addColumn("Tipo Unidad");
        
       tblStockMinimo.setModel(model);
       
       String[] datos = new String[7];
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
               model.addRow(datos);
           }
       }catch(SQLException e){
            JOptionPane.showMessageDialog(null, "ERROR" + e.toString());
        }  
    }
}
