/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import javax.swing.JOptionPane;
import java.sql.PreparedStatement;
import java.util.Scanner;
/**
 *
 * @author camper
 */
public class Conexion {
    Connection con;
    public Connection Conexion() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Hospital", "campus2023", "campus2023");
        } catch (Exception ex) {
            System.err.println("Error" + ex);
        }
        return con;
    }
    
    public void addpersona(Scanner sc){
        Conexion cn = new Conexion();
        Connection con = cn.Conexion();
        PreparedStatement ps = null;
        Statement st;
        ResultSet rs;
        System.out.println("Ingresa ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        String nombres = obtenerEntradaObligatoria(sc, "los nombres");
        String apellidos = obtenerEntradaObligatoria(sc, "los apellidos");
        String direccion = obtenerEntradaObligatoria(sc, "la direccion");
        String fecha_nacimiento = obtenerEntradaObligatoria(sc, "la fecha de nacimiento (YYYY-MM-DD)");
        System.out.println("Ingresa el titulo: ");
        String titulo = sc.nextLine();

        
        try {
            ps = con.prepareStatement("INSERT INTO persona (id, nombres, apellidos, direccion, fecha_nacimiento, titulo) VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, id);
            ps.setString(2, nombres);
            ps.setString(3, apellidos);
            ps.setString(4, direccion);
            ps.setString(5, fecha_nacimiento);
            ps.setString(6, titulo);

            ps.executeUpdate();
            System.out.println("Los datos se insertaron correctamente. :)");

        } catch (Exception e) {
            System.out.println("Error al insertar los datos: " + e.getMessage());
        }
    }
    
    private static String obtenerEntradaObligatoria(Scanner sc, String campo) {
        String entrada;
        while(true){
            System.out.println("Ingresa " + campo + " (obligatorio)");
            entrada = sc.nextLine().trim();
            if (!entrada.isEmpty()){
                break;
            } else {
                System.out.println(campo + " es un campo obligatorio. Por favor, ingrésalo. :)");
            }
        }
        return entrada;
    }
    
    public static void main(String[] args) {
        Conexion cn = new Conexion();
        Scanner sc = new Scanner(System.in);
        cn.addpersona(sc);
        Statement st;
        ResultSet rs;
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("select * from persona");
            while (rs.next()){
                System.out.println(rs.getInt("id") + rs.getString("nombres"));
            }
        } catch (Exception e) {
            
        }
    }
    
}
