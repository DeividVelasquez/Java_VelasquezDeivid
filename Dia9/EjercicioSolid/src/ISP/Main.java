package ISP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige el tipo de trabajador: ");
        System.out.println("1. Trabajador Humano");
        System.out.println("2. Robot");
        int option = sc.nextInt();
        sc.nextLine();

        Trabajando trabajador;
        Comiendo comensal = null;

        if (option == 1){
            trabajador = new Trabajador();
            comensal = (Comiendo) trabajador;
        } else {
            trabajador = new Robot();
        }

        LugarTrabajo lugarTrabajo = new LugarTrabajo(trabajador);

        System.out.println("Elige la acción a realizar: ");
        System.out.println("1. Trabajar");
        if (option == 1){
            System.out.println("2. Comer");
        }
        int accion = sc.nextInt();
        if (accion ==  1){
            lugarTrabajo.iniciarTrabajo();
        } else if (accion == 2 && option == 1){
            Comedor comedor = new Comedor(comensal);
            comedor.inicialComida();
        } else {
            System.out.println("Opción no válida.");
        }
        
        sc.close();
    }
}
