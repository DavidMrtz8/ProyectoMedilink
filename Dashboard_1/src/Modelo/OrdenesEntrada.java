package Modelo;

import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Date;
import javax.swing.JOptionPane;


public class OrdenesEntrada {
    private String ProductoID;
    private String ProveedorID;
    private String Producto;
    private String Proveedor;
    private float PrecioUnitario;
    private int Cantidad;
    private String SucursalID;
    private Date FechaExp;
    
     public OrdenesEntrada(){
     
     }

    public OrdenesEntrada(String ProductoID, String ProveedorID, String Producto, String Proveedor, float PrecioUnitario, int Cantidad, String SucursalID, Date FechaExp) {
        this.ProductoID = ProductoID;
        this.ProveedorID = ProveedorID;
        this.Producto = Producto;
        this.Proveedor = Proveedor;
        this.PrecioUnitario = PrecioUnitario;
        this.Cantidad = Cantidad;
        this.SucursalID = SucursalID;
        this.FechaExp = FechaExp;
    }

    public String getProductoID() {
        return ProductoID;
    }

    public void setProductoID(String ProductoID) {
        this.ProductoID = ProductoID;
    }

    public String getProveedorID() {
        return ProveedorID;
    }

    public void setProveedorID(String ProveedorID) {
        this.ProveedorID = ProveedorID;
    }

    public String getProducto() {
        return Producto;
    }

    public void setProducto(String Producto) {
        this.Producto = Producto;
    }

    public String getProveedor() {
        return Proveedor;
    }

    public void setProveedor(String Proveedor) {
        this.Proveedor = Proveedor;
    }

    public float getPrecioUnitario() {
        return PrecioUnitario;
    }

    public void setPrecioUnitario(float PrecioUnitario) {
        this.PrecioUnitario = PrecioUnitario;
    }

    public int getCantidad() {
        return Cantidad;
    }

    public void setCantidad(int Cantidad) {
        this.Cantidad = Cantidad;
    }

    public String getSucursalID() {
        return SucursalID;
    }

    public void setSucursalID(String SucursalID) {
        this.SucursalID = SucursalID;
    }

    public Date getFechaExp() {
        return FechaExp;
    }

    public void setFechaExp(Date FechaExp) {
        this.FechaExp = FechaExp;
    }

    
    
    public OrdenesEntrada ListarProductos(int productoID){
        OrdenesEntrada ordenEntrada = new OrdenesEntrada();
        
        String sql = "select pd.Nombre, pd.ProveedorID, p.Nombre\n" +
                    "from producto_detalle as pd\n" +
                    "inner join proveedor as p on pd.ProveedorID = p.ProveedorID\n" +
                    "where pd.ProductoID = ?";
        try {
            PreparedStatement ps = new Conexion().getConnect().prepareStatement(sql);

            ps.setInt(1, productoID);
            ResultSet rs = ps.executeQuery();
            while(rs.next()){
                ordenEntrada.setProducto(rs.getString(1));
                ordenEntrada.setProveedorID(rs.getString(2));
                ordenEntrada.setProveedor(rs.getString(3));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ordenEntrada;
    }
    
        public OrdenesEntrada ListarProductosOrdenEntrada(String producto, String sucursalID) {
        OrdenesEntrada ordenEntrada = new OrdenesEntrada();

            String sql = "select pd.Nombre, pd.ProductoID, pd.ProveedorID, p.Nombre\n"
                    + "from producto_detalle as pd\n"
                    + "inner join inventario as i on pd.ProductoID = i.ProductoID\n"
                    + "inner join proveedor as p on pd.ProveedorID = p.ProveedorID\n"
                    + "where pd.Nombre = ? and i.SucursalID = ?";
        try {
            PreparedStatement ps = new Conexion().getConnect().prepareStatement(sql);

            ps.setString(1, producto);
            ps.setString(2, sucursalID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ordenEntrada.setProducto(rs.getString(1));
                ordenEntrada.setProductoID(rs.getString(2));
                ordenEntrada.setProveedorID(rs.getString(3));
                ordenEntrada.setProveedor(rs.getString(4));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ordenEntrada;
    }
    
       public int InsertarOrdenEntrada(OrdenesEntrada o) {
        int r = 0;

        String sql = "{call spInsertarOrdenesEntrada(?)}";
        try {
            CallableStatement cs = new Conexion().getConnect().prepareCall(sql);

            cs.setString(1, o.getSucursalID());
            r = cs.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return r;
    }
        
       public int InsertarOrdenSalida() {
        int r = 0;

        String sql = "{call spInsertarOrdenSalida()}";
        try {
            CallableStatement cs = new Conexion().getConnect().prepareCall(sql);

            r = cs.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return r;
    }
       
    public int InsertarOrdenEntradaDetalles(OrdenesEntrada oe) {
        int r = 0;

        String sql = "{call spInsertarOrdenesEntradaDetalles(?, ?, ?, ?, ?, ?)}";
        try {
            CallableStatement cs = new Conexion().getConnect().prepareCall(sql);
            cs.setString(1, oe.getProductoID());
            cs.setInt(2, oe.getCantidad());
            cs.setFloat(3, oe.getPrecioUnitario());
            cs.setString(4, oe.getProveedorID());
            cs.setString(5, oe.getSucursalID());
            cs.setDate(6, oe.getFechaExp());

            r = cs.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return r;
    }
    

}
