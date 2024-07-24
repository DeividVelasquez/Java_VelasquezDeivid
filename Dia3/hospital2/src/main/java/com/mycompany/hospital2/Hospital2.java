
package com.mycompany.hospital2;
import java.sql.Connection;


public class Hospital2 {

    public static 
    
    
    
    
    
    public static void main(String[] args) {
        ConexionMySQL conexionMySQL = new ConexionMySQL();
        Connection connection;
        
        connection = conexionMySQL.conectarMySQL();
        if(connection != null) {
            System.out.println("La conexion con Mysql ha sido establecida!");
            
            conexionMySQL.cerrarConexionMySQL(connection);
        } else {
            System.out.println("Error al establecer la conexion");
        }
    }
}
