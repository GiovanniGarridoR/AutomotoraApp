/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bd;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author DUOC
 */
public class Conexion {
      private final static String baseDatos = "automotora_app";
    private final static String usuario = "root";
    private final static String password = "";
    
    
    public Connection obtenerConexion()
    {
        Connection connection = null;
        
        try{
            //Class.forName("com.mysql.jdbc.Driver");
            Class.forName("com.mysql.cj.jdbc.Driver");
      
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+baseDatos, usuario, password);
            
            System.out.println("Conexion ok");
            
      
        }catch(SQLException e)
        {
            System.out.println("Error BD: "+ e.getMessage());
        }
        catch(Exception ex)
        {
            System.out.println("Error: "+ ex.getMessage());
        
        }
        
        return connection;
    
    }
    
    
}
