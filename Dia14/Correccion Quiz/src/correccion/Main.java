/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correccion;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean repeticion = true;
        Scanner scanner = new Scanner(System.in);
        Cartera cartera = new Cartera("2024"); // Año de ejemplo

        while (repeticion) {
            System.out.println("Selecciona una opción:");
            System.out.println("1 - Insertar tarjeta");
            System.out.println("2 - Ver tarjetas");
            System.out.println("3 - Salir");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> {
                    // Insertar tarjeta
                    System.out.print("Número de cuenta: ");
                    String numeroDeCuenta = scanner.nextLine();
                    System.out.print("Valor de apertura: ");
                    double valorApertura = scanner.nextDouble();
                    scanner.nextLine();
                    System.out.print("Mes: ");
                    String mes = scanner.nextLine();
                    System.out.print("Tipo de tarjeta (Joven, Nomina, Visa): ");
                    String tipo = scanner.nextLine();

                    Tarjeta tarjeta = switch (tipo) {
                        case "Joven" -> new Joven(numeroDeCuenta, valorApertura, mes);
                        case "Nomina" -> new Nomina(numeroDeCuenta, valorApertura, mes);
                        case "Visa" -> new Visa(numeroDeCuenta, valorApertura, mes);
                        default -> null;
                    };

                    if (tarjeta != null) {
                        cartera.agregarTarjeta(tarjeta);
                    } else {
                        System.out.println("Tipo de tarjeta no válido.");
                    }
                }
                case 2 -> cartera.imprimirListaDeTarjetas();
                case 3 -> repeticion = false;
                default -> System.out.println("Opción no válida.");
            }
        }

        scanner.close();
    }
}

