package Modelo;

public class Reportes {
    private int sucursalID;
    private String Ciudad;

    
    public Reportes(){
        sucursalID = 0;
        Ciudad = "";
    }
    
    public int getSucursalID() {
        return sucursalID;
    }

    public void setSucursalID(int sucursalID) {
        this.sucursalID = sucursalID;
    }

    public String getCiudad() {
        return Ciudad;
    }

    public void setCiudad(String Ciudad) {
        this.Ciudad = Ciudad;
    }
    
        @Override
    public String toString() {
        return getCiudad();
    }
}
