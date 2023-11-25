package Modelo;

import java.sql.CallableStatement;
import java.sql.SQLException;
import javax.swing.JOptionPane;

public class Proveedores {
    private String proveedor;
    private String direccion;
    private String rtn;
    private String contacto;
    private String correo;

    public Proveedores() {
    }

    
    public Proveedores(String proveedor, String direccion, String rtn, String contacto, String correo) {
        this.proveedor = proveedor;
        this.direccion = direccion;
        this.rtn = rtn;
        this.contacto = contacto;
        this.correo = correo;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getRtn() {
        return rtn;
    }

    public void setRtn(String rtn) {
        this.rtn = rtn;
    }

    public String getContacto() {
        return contacto;
    }

    public void setContacto(String contacto) {
        this.contacto = contacto;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }
    
    public int InsertarProveedor(Proveedores p) {
        int r = 0;

        String sql = "{call spAgregarProveedor(?, ?, ?, ?, ?)}";
        try {
            CallableStatement cs = new Conexion().getConnect().prepareCall(sql);
            
            cs.setString(1, p.getProveedor());
            cs.setString(2, p.getDireccion());
            cs.setString(3, p.getRtn());
            cs.setString(4, p.getContacto());
            cs.setString(5, p.getCorreo());

            r = cs.executeUpdate();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return r;
    }
}
