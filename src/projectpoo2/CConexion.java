/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpoo2;

import java.sql.*;
import javax.swing.JOptionPane;
/**
 *
 * @author Fran
 */
public class CConexion {
    Connection conectar = null;
    String bd = "DBTiendaOnline.db";
    String cadena = "jdbc:sqlite:"+ System.getProperty("user.dir")+"/"+bd;
    
    public Connection establecerConexion(){ 
        try{
            Class.forName("org.sqlite.JDBC");
            conectar = DriverManager.getConnection(cadena); 
        }catch(Exception e){
            System.out.println( "CONEXION...FAIL: "+e.toString());
            
        }
        return conectar;
    }
    
    public void cerrarConexion(){
        try {
            if (conectar != null){
                conectar.close(); 
            }
        } catch (Exception e) {
               System.out.println( "CONEXION CLOSE...FAIL: "+e.toString());

        }
    }
    
    
}
