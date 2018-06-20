/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;

import conexion.Conexion;
import interfaces.metodos;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import modelo.movie;


/**
 *
 * @author LN710Q
 */
public class Movieda implements metodos<movie>{
    private static final String SQL_INSERT="INSERT INTO movie (idMovie,nombre,director,pais,clasificacion,anio,en_proyecto) VALUES(?,?,?,?,?,?,?)";
    private static final String SQL_UPDATE="UPDATE movie SET director=?,clasificacion=?,pais=?,anio=?,en_proyeccion=? WHERE nombre=?";
    private static final String SQL_DELETE="DELETE FROM movie WHERE nombre=?";
    private static final String SQL_READ="SELECT * FROM movie WHERE nombre=?";
    private static final String SQL_READALL="SELECT * FROM movie";
    private static final Conexion con=Conexion.conectar();
    @Override
    public boolean create(movie g) {
        PreparedStatement ps;
        try{
            ps=con.getCnx().prepareStatement(SQL_INSERT);
            ps.setString(4, g.getNombre());
            ps.setString(5, g.getDirector());
            ps.setString(6, g.getClasificacion());
            ps.setString(7, g.getPais());
          
            ps.setInt(2, g.getAnio());
            ps.setBoolean(3,true);
            
            if(ps.executeUpdate()>0){
                return true;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(Movieda.class.getName()).log(Level.SEVERE,null,ex);
        
        } finally{
            con.cerrarConexion();
        }
        return false;        
    }

    @Override
    public boolean delete(Object key) {
        PreparedStatement ps;
        try{
            ps=con.getCnx().prepareStatement(SQL_DELETE);
            ps.setString(1, key.toString());
            if(ps.executeUpdate()>0){
                return true;
            }
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(Movieda.class.getName()).log(Level.SEVERE,null,ex);
        
        } finally{
            con.cerrarConexion();
        }
        return false;  
    }

    @Override
    public boolean update(movie c) {
        PreparedStatement ps;
        try{
            System.out.println(c.getId());
            ps=con.getCnx().prepareStatement(SQL_UPDATE);
            ps.setString(4, c.getNombre());
            ps.setString(5, c.getDirector());
            ps.setString(6, c.getClasificacion());
            ps.setString(7, c.getPais());
            
            ps.setInt(2, c.getAnio());
            ps.setBoolean(3, c.getEn_proyeccion());
            
           
            if(ps.executeUpdate()>0){
                return true;
            }
            
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(Movieda.class.getName()).log(Level.SEVERE,null,ex);
        
        } finally{
            con.cerrarConexion();
        }
        return false; 
    }

    @Override
    public movie read(Object key) {
        movie f=null;
        PreparedStatement ps;
        ResultSet rs;
        try{
            ps=con.getCnx().prepareStatement(SQL_READ);
           ps.setString(1, key.toString());
            rs =ps.executeQuery();
            while(rs.next()){
                f=new movie(rs.getInt(1),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(2),rs.getBoolean(3));
            }
            rs.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(Movieda.class.getName()).log(Level.SEVERE,null,ex);
        
        } finally{
            con.cerrarConexion();
        }
        return f;
    }

    @Override
    public ArrayList<movie> readAll() {
        ArrayList<movie> all=new ArrayList();
        Statement s;
        ResultSet rs;
        try{
            s=con.getCnx().prepareStatement(SQL_READALL);
            rs=s.executeQuery(SQL_READALL);
            while(rs.next()){
                all.add(new movie(rs.getInt(1),rs.getString(4),rs.getString(5),rs.getString(6),rs.getString(7),rs.getInt(2),rs.getBoolean(3)));
            }
            rs.close();
            }catch (SQLException ex){
            System.out.println(ex.getMessage());
            Logger.getLogger(Movieda.class.getName()).log(Level.SEVERE,null,ex);
        
        } finally{
            con.cerrarConexion();
        }
        return all;
    }
    
    
}
