package Ejercicio2;

import java.util.Scanner;

public class FabricaDeArmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Armeria armeria = new Armeria();
        Encantamiento encantamiento = null;
        Arma arma = null;

        System.out.println("Bienvenido al juego de Fábrica de Armas!");

        // Selección de encantamiento
        System.out.println("Selecciona un encantamiento:");
        System.out.println("1. Encantamiento de Fuego");
        System.out.println("2. Encantamiento Vorpal");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> encantamiento = new EncantamientoFuego();
            case 2 -> encantamiento = new EncantamientoVorpal();
            default -> {
                System.out.println("Encantamiento no válido.");
                System.exit(0);
            }
        }

        // Selección de herrero
        System.out.println("Selecciona un herrero para fabricar tu arma:");
        System.out.println("1. Herrero Élfico");
        System.out.println("2. Herrero Enano");
        choice = scanner.nextInt();

        switch (choice) {
            case 1 -> {
                armeria.seleccionarHerrero(new HerreroElfico());
                arma = armeria.fabricarArma(encantamiento);
            }
            case 2 -> {
                armeria.seleccionarHerrero(new HerreroEnano());
                arma = armeria.fabricarArma(encantamiento);
            }
            default -> {
                System.out.println("Herrero no válido.");
                System.exit(0);
            }
        }

        // Interacción con el arma fabricada
        if (arma != null) {
            System.out.println("\nHas fabricado un " + arma + " con encantamiento.");

            while (true) {
                System.out.println("\nAcciones:");
                System.out.println("1. Blandir el arma");
                System.out.println("2. Atacar con el arma");
                System.out.println("3. Soltar el arma");
                System.out.println("4. Salir");
                choice = scanner.nextInt();

                switch (choice) {
                    case 1 -> arma.blandir();
                    case 2 -> arma.atacar();
                    case 3 -> arma.soltar();
                    case 4 -> {
                        System.out.println("Saliendo...");
                        System.exit(0);
                    }
                    default -> System.out.println("Opción no válida.");
                }
            }
        }
    }
}

