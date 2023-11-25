package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class OrdenesSalida {
    private String ProductoID;
    private String ProveedorID;
    private String Producto;
    private String Proveedor;
    private float PrecioUnitario;
    private int Cantidad;
    private String SucursalID;
    private int Existencia;
    private String CategoriaID;

    public OrdenesSalida() {
    }

    public OrdenesSalida(String ProductoID, String ProveedorID, String Producto, String Proveedor, float PrecioUnitario, int Cantidad, String SucursalID, int Existencia, String CategoriaID) {
        this.ProductoID = ProductoID;
        this.ProveedorID = ProveedorID;
        this.Producto = Producto;
        this.Proveedor = Proveedor;
        this.PrecioUnitario = PrecioUnitario;
        this.Cantidad = Cantidad;
        this.SucursalID = SucursalID;
        this.Existencia = Existencia;
        this.CategoriaID = CategoriaID;
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

    public int getExistencia() {
        return Existencia;
    }

    public void setExistencia(int Existencia) {
        this.Existencia = Existencia;
    }

    public String getCategoriaID() {
        return CategoriaID;
    }

    public void setCategoriaID(String CategoriaID) {
        this.CategoriaID = CategoriaID;
    }

   

    public OrdenesSalida ListarProductos(String producto, String sucursalID) {
        OrdenesSalida ordenSalida = new OrdenesSalida();
        
        String sql = "select pd.Nombre, sum(i.Existencia), pd.ProductoID\n"
                + "from producto_detalle as pd\n"
                + "inner join inventario as i on pd.ProductoID = i.ProductoID\n"
                + "where pd.Nombre = ? and i.SucursalID = ? group by pd.Nombre, pd.ProductoID";
        try {
            PreparedStatement ps = new Conexion().getConnect().prepareStatement(sql);

            ps.setString(1, producto);
            ps.setString(2, sucursalID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ordenSalida.setProducto(rs.getString(1));
                ordenSalida.setExistencia(rs.getInt(2));
                ordenSalida.setProductoID(rs.getString(3));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ordenSalida;
    }
    
        public OrdenesSalida ListarProductosOrdenSalida(int categoriaID, int sucursalID) {
        OrdenesSalida ordenSalida = new OrdenesSalida();

            String sql = "select pd.Nombre, i.Existencia from producto_detalle as pd\n"
                    + "inner join inventario as i on pd.ProductoID = i.ProductoID\n"
                    + "where pd.CategoriaID = ? and i.SucursalID = ?";
        try {
            PreparedStatement ps = new Conexion().getConnect().prepareStatement(sql);

            ps.setInt(1, categoriaID);
            ps.setInt(2, sucursalID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ordenSalida.setProducto(rs.getString(1));
                ordenSalida.setExistencia(rs.getInt(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ordenSalida;
    }
    
        public OrdenesSalida ListarProductosNombre(int productoID) {
        OrdenesSalida ordenSalida = new OrdenesSalida();

        String sql = "select pd.Nombre\n"
                + "from producto_detalle as pd\n"
                + "where pd.ProductoID = ? ";
        try {
            PreparedStatement ps = new Conexion().getConnect().prepareStatement(sql);

            ps.setInt(1, productoID);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                ordenSalida.setProducto(rs.getString(1));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return ordenSalida;
    }
    
        public int InsertarOrdenSalidaDetalles(OrdenesSalida os) {
        int r = 0;

        String sql = "{call spInsertarOrdenesSalidaDetalles(?, ?, ?)}";
        try {
            CallableStatement cs = new Conexion().getConnect().prepareCall(sql);
            cs.setString(1, os.getProductoID());
            cs.setInt(2, os.getCantidad());
            cs.setString(3, os.getSucursalID());

            r = cs.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return r;
    }
        
    public int ActualizarExistencia(OrdenesSalida os) {
        int r = 0;

        try {
            String updateStatement = "{call RealizarVenta(?, ?, ?)}";

            Connection conn = new Conexion().getConnect();
            PreparedStatement preparedStatement = conn.prepareStatement(updateStatement);
            preparedStatement.setInt(1, os.getCantidad());
            preparedStatement.setString(2, os.getProductoID());
            preparedStatement.setString(3, os.getSucursalID());

            r = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return r;
    }

}
