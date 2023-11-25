package Modelo;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;

public class Conexion {
    private Connection connect;
    
    public Connection getConnect() {
        return connect;
    }
    
    public Statement getStatement(){
        Statement stm = null;
        try {
            stm = connect.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
        return stm;
    }
    
    public Conexion(){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/medilinkbd?zeroDateTimeBehavior=CONVERT_TO_NULL";
            connect = DriverManager.getConnection(url,"root","Edwar_david2");
            
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}
