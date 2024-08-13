package Ejercicio1;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int option;

        do{
            System.out.println("Bienvenido al programa de heroes");
            System.out.println("Que deseas crear?");
            System.out.println("1. Heroe");
            System.out.println("2. Villano");
            System.out.println("3. Salir");
            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1:
                    System.out.println("Ingresa el nombre del heroe:");
                    String nombreHeroe = sc.nextLine();
                    System.out.println("Ingresa la edad del heroe:");
                    int edadHeroe = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa el poder del heroe:");
                    String poderHeroe = sc.nextLine();
                    Heroe heroe = Heroe.getInstance(nombreHeroe, edadHeroe, poderHeroe);
                    System.out.println("Héroe creado: " + heroe.getNombre() + " con la edad de " + heroe.getEdad() + " y el poder " + heroe.getPoder());

                    break;
                
                case 2:
                    System.out.println("Ingreasa el nombre del villano:");
                    String nombreVillano = sc.nextLine();
                    System.out.println("Ingresa la edad del villano:");
                    int edadVillano = sc.nextInt();
                    sc.nextLine();
                    System.out.println("Ingresa la habilidad del villano:");
                    String habilidadVillano = sc.nextLine();
                    Villano villano = new Villano(nombreVillano, edadVillano, habilidadVillano);
                    System.out.println("Villano creado: " + villano.getNombre() + " con la edad de " + villano.getEdad() + " y la habilidad de " + villano.getHabilidad());

                    break;
                
                case 3:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opción incorrecta");
            }

        }while(option != 3);
    }
}
