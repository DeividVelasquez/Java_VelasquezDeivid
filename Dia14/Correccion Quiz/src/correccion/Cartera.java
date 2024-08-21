/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correccion;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Cartera implements PatronCartera {
    private String anho;

    public Cartera(String anho) {
        this.anho = anho;
    }

    @Override
    public void agregarTarjeta(Tarjeta t) {
        String sql = "INSERT INTO Tarjetas (numeroDeCuenta, valorApertura, mes, tipo) VALUES (?, ?, ?, ?)";
        try (Connection conn = new Conexion().establecerConexion();
             PreparedStatement stmt = conn.prepareStatement(sql)) {

            stmt.setString(1, t.getNumeroDeCuenta());
            stmt.setDouble(2, t.cuotaDeManejo());
            stmt.setString(3, t.getMes());
            stmt.setString(4, t.getClass().getSimpleName());

            stmt.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void imprimirListaDeTarjetas() {
    String sql = "SELECT * FROM Tarjetas";
    try (Connection conn = new Conexion().establecerConexion();
         Statement stmt = conn.createStatement();
         ResultSet rs = stmt.executeQuery(sql)) {

        while (rs.next()) {
            // Obtener los valores directamente del ResultSet
            String numeroDeCuenta = rs.getString("numeroDeCuenta");
            double valorApertura = rs.getDouble("valorApertura");
            String mes = rs.getString("mes");
            String tipo = rs.getString("tipo");

            // Mostrar los datos obtenidos
            System.out.println("Número de Cuenta: " + numeroDeCuenta);
            System.out.println("Valor de Apertura: " + valorApertura);
            System.out.println("Mes: " + mes);
            System.out.println("Tipo: " + tipo);
            System.out.println("----------------------"); // Separador para claridad
        }
    } catch (SQLException e) {
        e.printStackTrace();
    }
}
    public String getAnho() {
        return anho;
    }
}
