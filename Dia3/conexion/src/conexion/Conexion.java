/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
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

        String nombres = obtenerEntradaObligatoria(sc, "los nombres");
        String apellidos = obtenerEntradaObligatoria(sc, "los apellidos");
        String direccion = obtenerEntradaObligatoria(sc, "la direccion");
        String fecha_nacimiento = obtenerEntradaObligatoria(sc, "la fecha de nacimiento (YYYY-MM-DD)");
        System.out.println("Ingresa el titulo: ");
        String titulo = sc.nextLine();

        try {
            ps = con.prepareStatement("INSERT INTO persona (nombres, apellidos, direccion, fecha_nacimiento, titulo) VALUES (?, ?, ?, ?, ?)");
            ps.setString(1, nombres);
            ps.setString(2, apellidos);
            ps.setString(3, direccion);
            ps.setString(4, fecha_nacimiento);
            ps.setString(5, titulo);

            ps.executeUpdate();
            System.out.println("Los datos se insertaron correctamente. :)");
            
            ps.close();
            con.close();

        } catch (Exception e) {
            System.out.println("Error al insertar los datos: " + e.getMessage());
        }
    }
    
    public void viewpersona(){
        Conexion cn = new Conexion();
        Connection con = cn.Conexion();
        Statement st;
        ResultSet rs;
        
        try {
            st = cn.con.createStatement();
            rs = st.executeQuery("select * from persona");
            while (rs.next()) {
                System.out.println(rs.getInt("id") + " - " + rs.getString("nombres") + " - " + rs.getString("apellidos") + " - " + rs.getString("direccion") + " - " + rs.getDate("fecha_nacimiento") + " - " + rs.getString("titulo"));
            }
            con.close();
        } catch (Exception e) {
            System.out.println("Error al ver los datos: " + e.getMessage());
        }
        
    }
    
    public void updatepersona(Scanner sc) {
        Conexion cn = new Conexion();
        Connection con = cn.Conexion();
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn.viewpersona();

        try {
            System.out.println("Ingrese el id a actualizar: ");
            int id = sc.nextInt();
            sc.nextLine();

            ps = con.prepareStatement("SELECT COUNT(*) FROM persona WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                ps.close();  

                ps = con.prepareStatement("UPDATE persona SET nombres = ?, apellidos = ?, direccion = ?, fecha_nacimiento = ?, titulo = ? WHERE id = ?");

                String nombres = obtenerEntradaObligatoria(sc, "los nombres actualizados");
                String apellidos = obtenerEntradaObligatoria(sc, "los apellidos actualizados");
                String direccion = obtenerEntradaObligatoria(sc, "la dirección actualizada");
                String fecha_nacimiento = obtenerEntradaObligatoria(sc, "la fecha de nacimiento actualizada (YYYY-MM-DD)");
                System.out.println("Ingresa el título actualizado");
                String titulo = sc.nextLine();

                ps.setString(1, nombres);
                ps.setString(2, apellidos);
                ps.setString(3, direccion);
                ps.setString(4, fecha_nacimiento);
                ps.setString(5, titulo);
                ps.setInt(6, id);

                int rowsAffected = ps.executeUpdate();
                System.out.println("Filas actualizadas: " + rowsAffected);
            } else {
                System.out.println("El id ingresado no está registrado en la tabla persona.");
            }
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();

        } catch (Exception e) {
            System.out.println("Error al actualizar los datos: " + e.getMessage());
        }
    }
    
    public void deletepersona() {
        Conexion cn = new Conexion();
        Connection con = cn.Conexion();
        Scanner sc = new Scanner(System.in);
        PreparedStatement ps = null;
        ResultSet rs = null;
        cn.viewpersona();

        try {
            System.out.println("Ingrese el id a actualizar: ");
            int id = sc.nextInt();
            sc.nextLine();

            ps = con.prepareStatement("SELECT COUNT(*) FROM persona WHERE id = ?");
            ps.setInt(1, id);
            rs = ps.executeQuery();

            if (rs.next() && rs.getInt(1) > 0) {
                ps.close();  
                
                ps = con.prepareStatement("DELETE FROM persona WHERE id = ?");
                ps.setInt(1, id);
                
                int NFilas = ps.executeUpdate();
                System.out.println("Filas eliminadas" + NFilas);
                
            } else {
                
                System.out.println("El id ingresado no está registrado en la tabla persona.");
            }
            
            cn.viewpersona();
            
            if (rs != null) rs.close();
            if (ps != null) ps.close();
            if (con != null) con.close();
            
        }catch(Exception e){
            System.out.println("Error al eliminara los datos: " + e.getMessage());
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
        
        int option;
        
        do{
            System.out.println("Menú de persona");
            System.out.println("1. Agregar persona");
            System.out.println("2. Ver persona");
            System.out.println("3. Actualizar persona");
            System.out.println("4. Eliminar persona");
            System.out.println("5. Salir del Menú persona");
            
            System.out.println("Selecciones una opción: ");
            option = sc.nextInt();
            sc.nextLine();
            
            switch (option){
                case 1:
                    cn.addpersona(sc);
                    break;
                case 2:
                    cn.viewpersona();
                    break;
                case 3:
                    cn.updatepersona(sc);
                    break;
                case 4:
                    cn.deletepersona();
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción inválida. Intente de nuevo");
            }
        } while (option != 5);
        
    }
    
}
