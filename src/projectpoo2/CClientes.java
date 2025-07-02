/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package projectpoo2;

import java.sql.*;
import java.util.ArrayList;
/**
 *
 * @author Fran
 */
public class CClientes {
    
    public ArrayList<Cliente> cargarTableroClientes(){
        CConexion oc = new CConexion();
        ArrayList<Cliente> listaClientes = new ArrayList<>(); 
        String sql = "SELECT id, cell, name FROM TClientes"; 
        Statement st = null;
        ResultSet rs = null;

        try {
            st = oc.establecerConexion().createStatement();
            rs = st.executeQuery(sql);
            while (rs.next()) {
                int id = rs.getInt("id");
                String cell = rs.getString("cell");
                String name = rs.getString("name");
                Cliente cliente = new Cliente(id, cell, name); 
                listaClientes.add(cliente);
            }
        } catch (SQLException e) {
            System.out.println( "Error al cargar clientes desde la base de datos: " + e.toString());
        } finally {
            try {
                if (rs != null) rs.close();
                if (st != null) st.close();
            } catch (SQLException e) {
                System.out.println( "Error al cerrar recursos de la BD: " + e.toString());
            }
            oc.cerrarConexion(); 
        }
        return listaClientes;
    }//**
    
    public int insertarTableroClientes(String cell, String name){
        CConexion o = new CConexion();
        ResultSet rs = null;
        String sql = "INSERT INTO TClientes(cell, name) VALUES (?,?)";
        int newid = -1;
        try {
            PreparedStatement ps = o.establecerConexion().prepareStatement(sql,Statement.RETURN_GENERATED_KEYS);
            ps.setString(1, cell);
            ps.setString(2, name);
            
            ps.execute();
            rs = ps.getGeneratedKeys();
            newid = rs.getInt(1);
        } catch (Exception e) {
            System.out.println( "SAFE..FAIL: "+ e.toString());
        }finally{
            o.cerrarConexion();
        }
        return newid;
    }//**
        
    public void modificarTableroClientes(int id,  String cell, String name){
        CConexion o = new CConexion();
        String sql = "UPDATE TClientes SET cell = ?, name = ? WHERE id = ?;";
        
        try {
            PreparedStatement ps = o.establecerConexion().prepareStatement(sql);
           
            ps.setString(1, cell);
            ps.setString(2, name); 
            ps.setInt(3, id);
            
            ps.execute();
            
        } catch (Exception e) {
            System.out.println( "MODIFY..FAIL: "+ e.toString());
        }finally{
            o.cerrarConexion();
        }
    
    }//**
    
     public void eleiminarTableroClientes(int id){
        CConexion o = new CConexion();
        String sql = "DELETE FROM TClientes WHERE id = ?;";
        
        try {
            PreparedStatement ps = o.establecerConexion().prepareStatement(sql);
            ps.setInt(1, id);
            
            ps.execute();
            
         } catch (Exception e) {
           System.out.println( "DELETE..FAIL: "+ e.toString());
        }finally{
            o.cerrarConexion();
        }
    }//**
     
}
