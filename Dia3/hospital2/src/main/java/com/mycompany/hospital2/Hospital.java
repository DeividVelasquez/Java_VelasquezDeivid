package com.mycompany.hospital2;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class Hospital {

    private static final String url = "jdbc:mysql://localhost:3306/Hospital";
    private static final String user = "root";
    private static final String password = "deivid0421";

    public static Connection getConnection() throws SQLException {
        return DriverManager.getConnection(url, user, password);
    }
    
    public static void addpersona(Scanner sc){
        System.out.println("Ingresa ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        String nombres = obtenerEntradaObligatoria(sc, "los nombres");
        String apellidos = obtenerEntradaObligatoria(sc, "los apellidos");
        String direccion = obtenerEntradaObligatoria(sc, "la direccion");   
        String fecha_nacimiento = obtenerEntradaObligatoria(sc, "la fecha de nacimiento(YYYY-MM-DD)");
        System.out.println("Ingresa el titulo: ");
        String titulo = sc.nextLine();

        String query = "INSERT INTO persona (id, nombres, apellidos, direccion, fecha_nacimiento, titulo) VALUES (?, ?, ?, ?, ?, ?)";

        try(Connection c = getConnection();
            PreparedStatement stmt = c.prepareStatement(query)) {
            
            stmt.setInt(1, id);
            stmt.setString(2, nombres);
            stmt.setString(3, apellidos);
            stmt.setString(4, direccion);
            stmt.setString(5, fecha_nacimiento);
            stmt.setString(6, titulo);

            stmt.executeUpdate();
            System.out.println("Los datos se insertaron correctamente. :)");

        }catch(SQLException e) {
            System.out.println("Error al insertar los datos: " + e.getMessage());
        }
    }

    public static void viewpersona() {
        String query = "SELECT * FROM persona";

        try(Connection conn = getConnection();
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query)){
                while(rs.next()) {
                    int id = rs.getInt("id");
                }
            }
    }

    private static String obtenerEntradaObligatoria(Scanner sc, String campo) {
        String entrada;
        while (true) {
            System.out.println("Ingresa " + campo + " (Obligatorio): ");
            entrada = sc.nextLine().trim();
            if (!entrada.isEmpty()) {
                break;
            } else {
                System.out.println(campo + " es un campo obligatorio. Por favor, ingrésalo.");
            }
        }
        return entrada;
    }
    


    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do{
            System.out.println("Menú Principal");
            System.out.println("1. CRUD persona");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    int optionpersona;
                    do{
                        System.out.println("Menú CRUD persona");
                        System.out.println("1. Agregar persona");
                        optionpersona = sc.nextInt();
                        sc.nextLine();

                        switch (optionpersona) {
                            case 1:
                                addpersona(sc);
                                break;
                        
                            default:
                                break;
                        }
                    } while (optionpersona != 6);
                    break;
            
                default:
                    break;
            }
        }while (option != 6);
    }
}
