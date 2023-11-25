/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Modelo;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;


/**
 *
 * @author ldareas
 */
public class Devoluciones {
    private int DevolucionID;
    private String Motivo;
    private String ProductoID;
    private int CantidaDevuelta;
    private String FechaDevolucion;
    private String ProveedorID;
    private String SucursalID;
    
    public Devoluciones() {
    }

    public Devoluciones(int DevolucionID, String Motivo, String ProductoID, int CantidaDevuelta, String FechaDevolucion, String ProveedorID, String SucursalID) {
        this.DevolucionID = DevolucionID;
        this.Motivo = Motivo;
        this.ProductoID = ProductoID;
        this.CantidaDevuelta = CantidaDevuelta;
        this.FechaDevolucion = FechaDevolucion;
        this.ProveedorID = ProveedorID;
        this.SucursalID = SucursalID;
    }

    public int getDevolucionID() {
        return DevolucionID;
    }

    public void setDevolucionID(int DevolucionID) {
        this.DevolucionID = DevolucionID;
    }

    public String getMotivo() {
        return Motivo;
    }

    public void setMotivo(String Motivo) {
        this.Motivo = Motivo;
    }

    public String getProductoID() {
        return ProductoID;
    }

    public void setProductoID(String ProductoID) {
        this.ProductoID = ProductoID;
    }

    public int getCantidaDevuelta() {
        return CantidaDevuelta;
    }

    public void setCantidaDevuelta(int CantidaDevuelta) {
        this.CantidaDevuelta = CantidaDevuelta;
    }

    public String getFechaDevolucion() {
        return FechaDevolucion;
    }

    public void setFechaDevolucion(String FechaDevolucion) {
        this.FechaDevolucion = FechaDevolucion;
    }

    public String getProveedorID() {
        return ProveedorID;
    }

    public void setProveedorID(String ProveedorID) {
        this.ProveedorID = ProveedorID;
    }

    public String getSucursalID() {
        return SucursalID;
    }

    public void setSucursalID(String SucursalID) {
        this.SucursalID = SucursalID;
    }
    
  public int InsertarProductoDevoluciones(Devoluciones i) {
        int r = 0;
        
        String sql = "{call spInsertarNuevaDevolucion(?, ?, ?, ?, ?, ?)}";
        try {
            CallableStatement cs = new Conexion().getConnect().prepareCall(sql);
            
            cs.setString(1, i.getMotivo());
            cs.setString(2,i.getProductoID());
            cs.setInt(3, i.getCantidaDevuelta());
            cs.setString(4, i.getFechaDevolucion());
            cs.setString(5,i.getProveedorID());
            cs.setString(6,i.getSucursalID());
            
            r = cs.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return r;
    }    
    
    public Devoluciones BuscarProductoID(String producto) {
        Devoluciones devolucion = new Devoluciones();

        String sql = "select pd.ProductoID, pd.ProveedorID \n"
                + "from producto_detalle as pd\n"
                + "where pd.Nombre = ?";
        try {
            PreparedStatement ps = new Conexion().getConnect().prepareStatement(sql);

            ps.setString(1, producto);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                devolucion.setProductoID(rs.getString(1));
                devolucion.setProveedorID(rs.getString(2));
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return devolucion;
    }
    
        public int ActualizarExistencia(Devoluciones d) {
        int r = 0;

        try {
            String updateStatement = "{call spDevolucionProducto(?, ?, ?)}";

            Connection conn = new Conexion().getConnect();
            PreparedStatement preparedStatement = conn.prepareStatement(updateStatement);
            preparedStatement.setInt(1, d.getCantidaDevuelta());
            preparedStatement.setString(2, d.getProductoID());
            preparedStatement.setString(3, d.getSucursalID());

            r = preparedStatement.executeUpdate();

            preparedStatement.close();
            conn.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }

        return r;
    }
}
