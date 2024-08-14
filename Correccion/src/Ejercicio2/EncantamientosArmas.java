package Ejercicio2;

import java.util.Scanner;

public class EncantamientosArmas {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Encantamiento encantamiento = null;
        Arma arma = null;

        System.out.println("Bienvenido al juego de Encantamientos y Armas!");

        System.out.println("Selecciona un encantamiento:");
        System.out.println("1. Encantamiento de Fuego");
        System.out.println("2. Encantamiento Vorpal");
        int choice = scanner.nextInt();

        switch (choice) {
            case 1 -> encantamiento = new EncantamientoFuego();
            case 2 -> encantamiento = new EncantamientoVorpal();
            default -> System.out.println("Encantamiento no válido.");
        }

        System.out.println("Selecciona un tipo de arma:");
        System.out.println("1. Espada");
        System.out.println("2. Martillo");
        choice = scanner.nextInt();

        switch (choice) {
            case 1 -> arma = new Espada(encantamiento);
            case 2 -> arma = new Martillo(encantamiento);
            default -> System.out.println("Arma no válida.");
        }

        if (arma != null) {
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

