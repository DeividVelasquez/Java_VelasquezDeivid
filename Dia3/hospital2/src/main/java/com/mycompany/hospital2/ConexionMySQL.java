
package com.mycompany.hospital2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexionMySQL {
    private final String driver = "com.mysql.cj.jdbc.Driver";
    private final String database = "Hospital";
    private final String hostname = "localhost";
    private final String port = "3306";
    private final String username = "campus2023";
    private final String password = "campus2023";
    
    public Connection conectarMySQL() {
        String url = "jdbc:mysql://" + hostname + ":" + port + "/" + database;
        Connection conn;
        
        try{
            Class.forName(driver);
            conn = DriverManager.getConnection(url, username, password);
        }catch(ClassNotFoundException | SQLException ex) {
            System.out.println(ex.getMessage());
            return null;
        }
        return conn;
    } 
    
    public void cerrarConexionMySQL(Connection conn){
        try{
            conn.close();
        }catch (SQLException ex){
            System.out.println(ex.getMessage());
            return;
        }
        System.out.println("Se ha cerrado la conexion MySQL");
    }
}


