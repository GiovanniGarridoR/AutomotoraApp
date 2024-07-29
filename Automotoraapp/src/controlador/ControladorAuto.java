/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import bd.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import modelo.Vehiculo;
/**
 *
 * @author DUOC
 */
public class ControladorAuto {
    public boolean agregarVehiculo( Vehiculo vehiculo)
    {
        try {
            //creamos la conexion
            Conexion con = new Conexion();
            Connection cn = con.obtenerConexion();
            
            //crear consulta sql
            String query = "INSERT INTO vehiculo (patente,anio_fabricacion,precio,marca,es_nuevo) VALUES(?,?,?,?,?)";
            
            PreparedStatement ps= cn.prepareStatement(query);
            //modificar values
            ps.setString(1, vehiculo.getPatente());
            ps.setInt(2, vehiculo.getAnio_fabricacion());
            ps.setInt(3, vehiculo.getPrecio());
            ps.setString(4, vehiculo.getMarca());
            ps.setBoolean(5, vehiculo.isEs_nuevo());
           
            
            
            
           
            
            //ejecutar
            ps.executeUpdate();
            //cerrar ps
            ps.close();
            //cerrar conexion
            cn.close();
            
            return true;
            
        } catch (SQLException e) {
            //mensaje por error
            System.out.println("error bd"+e.getMessage());
            return false;
        }
        
        
    }
    
    public Vehiculo buscarVehiculo(String patente)
    {
        Vehiculo vh = new Vehiculo();
    
     try {
            Conexion con = new Conexion();
            Connection cnt = con.obtenerConexion();
               
            String query = "SELECT * FROM vehiculo WHERE patente = ? ";
            PreparedStatement ps = cnt.prepareStatement(query);
            ps.setString(1, patente);
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
               
               vh.setPatente(rs.getString("patente"));
               vh.setPrecio(rs.getInt("precio"));
               vh.setMarca(rs.getString("marca"));
            }
              
            rs.close();
            ps.close();
            cnt.close();
               
        } catch (SQLException e) {
            
               System.out.println("Error BD: "+ e.getMessage());
        }
        
        return vh;
    }
    
      public ArrayList<Vehiculo> traerVehiculo()
    {
        ArrayList<Vehiculo> listaVehiculos = new ArrayList<>();
        
           try {
            Conexion con = new Conexion();
            Connection cnt = con.obtenerConexion();
               
            String query = "SELECT  patente,marca,anio_fabricacion,precio,es_nuevo  FROM vehiculo";
            PreparedStatement ps = cnt.prepareStatement(query);
            
            ResultSet rs = ps.executeQuery();
            
            while(rs.next())
            {
                Vehiculo vehiculo = new Vehiculo();
                
                vehiculo.setPatente(rs.getString("patente"));
                vehiculo.setMarca(rs.getString("Marca"));
                vehiculo.setPrecio(rs.getInt("precio"));
                vehiculo.setAnio_fabricacion(rs.getInt("anio_fabricacion"));
                vehiculo.setEs_nuevo(rs.getBoolean("es_nuevo"));
              
                
                
                listaVehiculos.add(vehiculo);
                
            }
              
            rs.close();
            ps.close();
            cnt.close();
               
        } catch (SQLException e) {
            
               System.out.println("Error BD: "+ e.getMessage());
        }
  
        return listaVehiculos;
    
    }
    
    
}
