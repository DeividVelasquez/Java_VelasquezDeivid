/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baloncesto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;
import java.util.Scanner;
import javax.swing.JOptionPane;
import java.util.InputMismatchException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Baloncesto {

    private Connection con;
    public Connection Conexion() {
        Properties props = new Properties();
        try (InputStream input = getClass().getClassLoader().getResourceAsStream("Config.properties")) {
            if (input == null) {
                throw new IllegalStateException("Archivo Config.properties no encontrado");
            }

            props.load(input);

            String url = props.getProperty("Url");
            String user = props.getProperty("User");
            String password = props.getProperty("Password");

            if (url == null || user == null || password == null) {
                throw new IllegalStateException("Una o más propiedades de conexión no están definidas");
            }

            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(url, user, password);
            System.out.println("Conexión exitosa a la base de datos");
        } catch (IOException | ClassNotFoundException | SQLException | IllegalStateException e) {
            System.err.println("Error en la conexión :(, error: " + e);
            JOptionPane.showMessageDialog(null, "Error en la conexión: " + e.toString());
        }
        return con;
    }
    
    private static final DateTimeFormatter FORMATO_FECHA = DateTimeFormatter.ofPattern("yyyy-MM-dd");

    private static boolean esFechaValida(String fecha) {
        try {
            LocalDate.parse(fecha, FORMATO_FECHA);
            return true; // La fecha es válida
        } catch (DateTimeParseException e) {
            return false; // La fecha no es válida
        }
    }
    
    public void addPartido(Scanner sc){
         Baloncesto bl = new Baloncesto();
         Connection con = bl.Conexion();
         PreparedStatement ps = null;
         PreparedStatement ps2 = null;
         ResultSet rs = null;
         
         System.out.println("¿Que tipo de partido deseas ingresar?");
         System.out.println("1. Liga");
         System.out.println("2. PlayOffs");
         System.out.println("3. Salir");
         int option = sc.nextInt();
         sc.nextLine();
         
         switch(option){
             case 1:

                try {
                    
                    String equipoLocal = obtenerDatoObligatorio(sc, "el nombre del equipo local");
                    String equipoVisitante = obtenerDatoObligatorio(sc, "el nombre del equipo visitante");
                    int cestasLocal = obtenerDatoObligatorioint(sc, "el numero de cestas del equipo local");
                    int cestasVisitante = obtenerDatoObligatorioint(sc, "el numero de cestas del equipo visitante");

                    String estado;
                    while(true){
                        System.out.println("Ingresa el estado en el que se encuentra el partido(Activo, Finalizado)(Obligatorio)");
                        estado = sc.nextLine();
                        estado = estado.substring(0, 1).toUpperCase() + estado.substring(1).toLowerCase();

                        if("Activo".equals(estado) || "Finalizado".equals(estado)){
                            break;
                        } else {
                            System.out.println(estado + " no fue reconocido como un estado valido");
                        }
                       
                    }

                    String fechaPartido;
                    while(true){
                        System.out.println("Ingresa la fecha del partido(YYYY-MM-DD)");
                        fechaPartido = sc.nextLine().trim();

                        if (esFechaValida(fechaPartido)) {
                           break;
                       } else {
                           System.out.println("Fecha inválida. Asegúrate de que esté en formato YYYY-MM-DD y sea una fecha válida.");
                       }
                    }

                    //partido de liga
                    int jornada = obtenerDatoObligatorioint(sc, "el numero de la jornada ");
                    
                    
                    ps = con.prepareStatement("INSERT INTO partido (equipoLocal, equipoVisitante, cestasLocal, cestasVisitante, estado, fechaPartido) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                        ps2 = con.prepareStatement("INSERT INTO liga (id_partido, jornada) VALUES (?, ?)");

                        ps.setString(1, equipoLocal);
                        ps.setString(2, equipoVisitante);
                        ps.setInt(3, cestasLocal);
                        ps.setInt(4, cestasVisitante);
                        ps.setString(5, estado);
                        ps.setString(6, fechaPartido);

                        ps.executeUpdate();
                        rs = ps.getGeneratedKeys();

                        if (rs.next()) {
                            int id_partido = rs.getInt(1);
                            ps2.setInt(1, id_partido);
                            ps2.setInt(2, jornada);

                            ps2.executeUpdate();
                        }

                        System.out.println("Datos insertados correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al insertar los datos a la base de datos: " + e.getMessage());
                    }
                break;
             case 2: 
                
                try {
                    
                    String equipoLocal = obtenerDatoObligatorio(sc, "el nombre del equipo local");
                    String equipoVisitante = obtenerDatoObligatorio(sc, "el nombre del equipo visitante");
                    int cestasLocal = obtenerDatoObligatorioint(sc, "el numero de cestas del equipo local");
                    int cestasVisitante = obtenerDatoObligatorioint(sc, "el numero de cestas del equipo visitante");

                    String estado;
                    while(true){
                        System.out.println("Ingresa el estado en el que se encuentra el partido(Activo, Finalizado)(Obligatorio)");
                        estado = sc.nextLine();
                        estado = estado.substring(0, 1).toUpperCase() + estado.substring(1).toLowerCase();

                        if("Activo".equals(estado) || "Finalizado".equals(estado)){
                            break;
                        } else {
                            System.out.println(estado + " no fue reconocido como un estado valido");
                        }
                    }

                    String fechaPartido;
                    while(true){
                        System.out.println("Ingresa la fecha del partido(YYYY-MM-DD)");
                        fechaPartido = sc.nextLine().trim();

                        if (esFechaValida(fechaPartido)) {
                           break;
                       } else {
                           System.out.println("Fecha inválida. Asegúrate de que esté en formato YYYY-MM-DD y sea una fecha válida.");
                       }
                    }

                    //partido de playOffs
                    String ronda;
                    while(true){
                        System.out.println("Ingresa la ronda en la que se encuentra el partido(Octavos, Cuartos, Final)");
                        ronda = sc.nextLine();
                        ronda = ronda.substring(0, 1).toUpperCase() + ronda.substring(1).toLowerCase();

                        if("Octavos".equals(ronda) || "Cuartos".equals(ronda) || "Final".equals(ronda)){
                            break;
                        } else {
                            System.out.println("Ronda no identificada. Por favor ingresa una valida");
                        }
                    }
                    
                    
                    ps = con.prepareStatement("INSERT INTO partido (equipoLocal, equipoVisitante, cestasLocal, cestasVisitante, estado, fechaPartido) VALUES (?, ?, ?, ?, ?, ?)", Statement.RETURN_GENERATED_KEYS);
                        ps2 = con.prepareStatement("INSERT INTO playOffs (id_partido, ronda) VALUES (?, ?)");

                        ps.setString(1, equipoLocal);
                        ps.setString(2, equipoVisitante);
                        ps.setInt(3, cestasLocal);
                        ps.setInt(4, cestasVisitante);
                        ps.setString(5, estado);
                        ps.setString(6, fechaPartido);

                        ps.executeUpdate();
                        rs = ps.getGeneratedKeys();

                        if (rs.next()) {
                            int id_partido = rs.getInt(1);
                            ps2.setInt(1, id_partido);
                            ps2.setString(2, ronda);

                            ps2.executeUpdate();
                        }

                        System.out.println("Datos insertados correctamente.");
                    } catch (Exception e) {
                        System.out.println("Error al insertar los datos a la base de datos: " + e.getMessage());
                    }
                break;
            case 3:
                System.out.println("Saliendo...");
                break;
             default:
                 System.out.println("Opcion incorrecta");
         }
          
    }
    
    public void viewPartido(){
        Baloncesto bl = new Baloncesto();
        Connection con = bl.Conexion();
        Scanner sc = new Scanner(System.in);
        Statement st;
        ResultSet rs;
        
        System.out.println("¿Que tipo de partidos deseas ver?");
        System.out.println("1. Liga");
        System.out.println("2. PlayOffs");
        System.out.println("3. Saliendo");
        int option = sc.nextInt();
        sc.nextLine();
        
        switch(option){
            case 1:
                try{
                    st = bl.con.createStatement();
                    rs = st.executeQuery("SELECT * FROM partido INNER JOIN liga ON partido.id = liga.id_partido");

                    while(rs.next()){
                        System.out.println("ID = " + rs.getInt("id") + " - " + "Equipo Local = " + rs.getString("equipoLocal") + " - " + "Equipo Visitante = " + rs.getString("equipoVisitante") + " - " + "Cestas equipo local = " + rs.getInt("cestasLocal") + " - " + "Cestas equipo Visitante = " + rs.getInt("cestasVisitante") + " - " + "Estado = " + rs.getString("estado") + " - " + "Fecha del partido = " + rs.getString("fechaPartido") + " - " + "Jornada = " +rs.getInt("jornada"));
                    }
                    con.close();
                
                } catch(Exception e){
                    System.out.println("Error al ver la base de datos: " + e.getMessage());
                }
            case 2:
                try{
                    st = bl.con.createStatement();
                    rs = st.executeQuery("SELECT * FROM partido INNER JOIN playOffs ON partido.id = playOffs.id_partido");
                    while(rs.next()){
                        System.out.println("ID = " + rs.getInt("id") + " - " + "Equipo Local = " + rs.getString("equipoLocal") + " - " + "Equipo Visitante = " + rs.getString("equipoVisitante") + " - " + "Cestas equipo local = " + rs.getInt("cestasLocal") + " - " + "Cestas equipo Visitante = " + rs.getInt("cestasVisitante") + " - " + "Estado = " + rs.getString("estado") + " - " + "Fecha del partido = " + rs.getString("fechaPartido") + " - " + "Jornada = " +rs.getInt("jornada"));
                    }
                    con.close();
                    
                } catch(Exception e){
                    System.out.println("Error al ver la base de datos: " + e.getMessage());
                }
        }
        
    }
    
        public void updatePartido(Scanner sc) {
        Baloncesto bl = new Baloncesto();
        Connection con = null;
        PreparedStatement ps = null;
        PreparedStatement ps2 = null;
        ResultSet rs = null;

        try {
            con = bl.Conexion();
            System.out.println("¿Qué tipo de partido deseas actualizar?");
            System.out.println("1. Liga");
            System.out.println("2. PlayOffs");
            System.out.println("3. Salir");

            int option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingrese el id del partido de liga que desea actualizar ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    ps = con.prepareStatement("SELECT COUNT(*) FROM liga WHERE id = ?");
                    ps.setInt(1, id);
                    rs = ps.executeQuery();

                    if (rs.next() && rs.getInt(1) > 0) {
                        rs.close();
                        ps.close();

                        ps = con.prepareStatement("UPDATE partido SET equipoLocal = ?, equipoVisitante = ?, cestasLocal = ?, cestasVisitante = ?, estado = ?, fechaPartido = ? WHERE id = ?");
                        ps2 = con.prepareStatement("UPDATE liga SET jornada = ? WHERE id_partido = ?");

                        String equipoLocal = obtenerDatoObligatorio(sc, "el nombre del equipo local");
                        String equipoVisitante = obtenerDatoObligatorio(sc, "el nombre del equipo visitante");
                        int cestasLocal = obtenerDatoObligatorioint(sc, "el número de cestas del equipo local");
                        int cestasVisitante = obtenerDatoObligatorioint(sc, "el número de cestas del equipo visitante");

                        String estado;
                        while (true) {
                            System.out.println("Ingresa el estado en el que se encuentra el partido (Activo, Finalizado) (Obligatorio)");
                            estado = sc.nextLine();
                            estado = estado.substring(0, 1).toUpperCase() + estado.substring(1).toLowerCase();

                            if ("Activo".equals(estado) || "Finalizado".equals(estado)) {
                                break;
                            } else {
                                System.out.println(estado + " no fue reconocido como un estado válido");
                            }
                        }

                        String fechaPartido;
                        while (true) {
                            System.out.println("Ingresa la fecha del partido (YYYY-MM-DD)");
                            fechaPartido = sc.nextLine().trim();

                            if (esFechaValida(fechaPartido)) {
                                break;
                            } else {
                                System.out.println("Fecha inválida. Asegúrate de que esté en formato YYYY-MM-DD y sea una fecha válida.");
                            }
                        }

                        int jornada = obtenerDatoObligatorioint(sc, "el número de la jornada");

                        ps.setString(1, equipoLocal);
                        ps.setString(2, equipoVisitante);
                        ps.setInt(3, cestasLocal);
                        ps.setInt(4, cestasVisitante);
                        ps.setString(5, estado);
                        ps.setString(6, fechaPartido);
                        ps.setInt(7, id);

                        ps2.setInt(1, jornada);
                        ps2.setInt(2, id);

                        ps.executeUpdate();
                        ps2.executeUpdate();

                        System.out.println("Datos actualizados correctamente.");
                    } else {
                        System.out.println("No se encontró un partido de liga con el ID proporcionado.");
                    }
                    break;

                case 2:
                    System.out.println("Ingrese el id del partido de PlayOffs que desea actualizar ");
                    int id2 = sc.nextInt();
                    sc.nextLine();

                    ps = con.prepareStatement("SELECT COUNT(*) FROM playOffs WHERE id = ?");
                    ps.setInt(1, id2);
                    rs = ps.executeQuery();

                    if (rs.next() && rs.getInt(1) > 0) {
                        rs.close();
                        ps.close();

                        ps = con.prepareStatement("UPDATE partido SET equipoLocal = ?, equipoVisitante = ?, cestasLocal = ?, cestasVisitante = ?, estado = ?, fechaPartido = ? WHERE id = ?");
                        ps2 = con.prepareStatement("UPDATE playOffs SET ronda = ? WHERE id_partido = ?");

                        String equipoLocal = obtenerDatoObligatorio(sc, "el nombre del equipo local");
                        String equipoVisitante = obtenerDatoObligatorio(sc, "el nombre del equipo visitante");
                        int cestasLocal = obtenerDatoObligatorioint(sc, "el número de cestas del equipo local");
                        int cestasVisitante = obtenerDatoObligatorioint(sc, "el número de cestas del equipo visitante");

                        String estado;
                        while (true) {
                            System.out.println("Ingresa el estado en el que se encuentra el partido (Activo, Finalizado) (Obligatorio)");
                            estado = sc.nextLine();
                            estado = estado.substring(0, 1).toUpperCase() + estado.substring(1).toLowerCase();

                            if ("Activo".equals(estado) || "Finalizado".equals(estado)) {
                                break;
                            } else {
                                System.out.println(estado + " no fue reconocido como un estado válido");
                            }
                        }

                        String fechaPartido;
                        while (true) {
                            System.out.println("Ingresa la fecha del partido (YYYY-MM-DD)");
                            fechaPartido = sc.nextLine().trim();

                            if (esFechaValida(fechaPartido)) {
                                break;
                            } else {
                                System.out.println("Fecha inválida. Asegúrate de que esté en formato YYYY-MM-DD y sea una fecha válida.");
                            }
                        }

                        //partido de playOffs
                        String ronda;
                        while(true){
                            System.out.println("Ingresa la ronda en la que se encuentra el partido(Octavos, Cuartos, Final)");
                            ronda = sc.nextLine();
                            ronda = ronda.substring(0, 1).toUpperCase() + ronda.substring(1).toLowerCase();

                            if("Octavos".equals(ronda) || "Cuartos".equals(ronda) || "Final".equals(ronda)){
                                break;
                            } else {
                                System.out.println("Ronda no identificada. Por favor ingresa una valida");
                            }
                        }

                        ps.setString(1, equipoLocal);
                        ps.setString(2, equipoVisitante);
                        ps.setInt(3, cestasLocal);
                        ps.setInt(4, cestasVisitante);
                        ps.setString(5, estado);
                        ps.setString(6, fechaPartido);
                        ps.setInt(7, id2);

                        ps2.setString(1, ronda);
                        ps2.setInt(2, id2);

                        ps.executeUpdate();
                        ps2.executeUpdate();

                        System.out.println("Datos actualizados correctamente.");
                    } else {
                        System.out.println("No se encontró un partido de liga con el ID proporcionado.");
                    }
                    break;
                case 3:
                    System.out.println("Saliendo...");
                    return;

                default:
                    System.out.println("Opción no válida.");
            }
        } catch (Exception e) {
            System.out.println("Error al editar el partido: " + e.getMessage());
        }
        
    }
        
    public void deletePartido(Scanner sc) {
        Baloncesto bl = new Baloncesto();
        Connection con = null;
        PreparedStatement ps = null;

        try {
            con = bl.Conexion();
            System.out.println("Ingrese el id del partido que desea eliminar:");
            int id = sc.nextInt();
            sc.nextLine();

            ps = con.prepareStatement("DELETE FROM partido WHERE id = ?");
            ps.setInt(1, id);

            int affectedRows = ps.executeUpdate();

            if (affectedRows > 0) {
                System.out.println("El partido y sus registros relacionados fueron eliminados correctamente.");
            } else {
                System.out.println("No se encontró un partido con el ID proporcionado.");
            }
        } catch (SQLException e) {
            System.out.println("Error al eliminar el partido: " + e.getMessage());
        }
    }
    
    private static String obtenerDatoObligatorio(Scanner sc, String campo) {
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
    
    private static int obtenerDatoObligatorioint(Scanner sc, String campo) {
        int entrada = -1; // Valor predeterminado para indicar un valor no establecido
        boolean entradaValida = false;

        while (!entradaValida) {
            System.out.println("Ingresa " + campo + " (obligatorio)");
            try {
                entrada = sc.nextInt();
                sc.nextLine();
                entradaValida = true; // Si la entrada es correcta, salimos del bucle
            } catch (InputMismatchException e) {
                // Limpiar el buffer del scanner en caso de entrada incorrecta
                sc.next(); 
                System.out.println("Entrada inválida. Por favor, ingresa un número entero.");
            }
        }
        return entrada;
    }
    
    public static void main(String[] args) {
        Baloncesto bl = new Baloncesto();
        Scanner sc = new Scanner(System.in );
        
        int option;
        
        do {
            System.out.println("Bienvenido al sistema");
            System.out.println("Que desea realizar el dia de hoy");
            System.out.println("1. Agregar partido");
            System.out.println("2. Ver informacion de partido");
            System.out.println("3. Modificar partido");
            System.out.println("4. Eliminar partido");
            System.out.println("5. Salir");
            option = sc.nextInt();
            sc.nextLine();

            switch(option){
                case 1:
                    bl.addPartido(sc);
                    break;
                case 2:
                    bl.viewPartido();
                    break;
                case 3:
                    bl.updatePartido(sc);
                    break;
                case 4:
                    bl.deletePartido(sc);
                    break;
                case 5:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion incorrecta");
            }   
            
        } while (option != 5);
        
    }
    
}
