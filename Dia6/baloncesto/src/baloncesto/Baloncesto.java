/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package baloncesto;
import java.util.Scanner;

public class Baloncesto {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        playOffs partido1 = new playOffs("Bucaros","National",15,9,true,"2020-10-22", "Final");
        liga partido2 = new liga("barrancaYork","RealTapitas",5,25,true,"2023-09-30",3);
        
        while(true){
            System.out.println("Menu principal de Baloncesto");
            System.out.println("Bienvenido usuario ¿Que deseas hacer hoy?");
            System.out.println("1. Visualizar la informacion");
            System.out.println("2. Modificar informacion");
            System.out.println("3. Finalizar partidos");
            System.out.println("4. Salir");
            int option = sc.nextInt();
            switch(option){
                case 1:
                    while(true){
                        System.out.println("Visualizacion de informacion");
                        System.out.println("1. Partido de liga");
                        System.out.println("2. Partido de PlayOff");
                        System.out.println("3. Salir");
                        int option1 = sc.nextInt();
                        switch(option1){
                            case 1:
                                partido2.verInformacion();
                                break;
                            case 2:
                                partido1.verInformacion();
                                break;
                            case 3:
                                System.out.println("Saliendo ...");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                        break;
                    }
                    break;
                case 2:
                    while(true){
                        System.out.println("Modificacion de informacion");
                        System.out.println("1. Partido de liga");
                        System.out.println("2. Partido de PlayOff");
                        System.out.println("3. Salir");
                        int option2 = sc.nextInt();
                        switch(option2){
                            case 1:
                                partido2.modificarInformacion();
                                break;
                            case 2:
                                partido1.modificarInformacion();
                                break;
                            case 3:
                                System.out.println("Saliendo ...");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                        break;
                    }
                    break;
                case 3:
                    while(true){
                        System.out.println("Finalizar partido");
                        System.out.println("1. Partido de liga");
                        System.out.println("2. Partido de PlayOff");
                        System.out.println("3. Salir");
                        int option3 = sc.nextInt();
                        switch(option3){
                            case 1:
                                partido2.finalizarPartido();
                                break;
                            case 2:
                                partido1.finalizarPartido();
                                break;
                            case 3:
                                System.out.println("Saliendo ...");
                                break;
                            default:
                                System.out.println("Opcion incorrecta");
                        }
                        break;
                    }
                    break;
                case 4:
                    System.out.println("Saliendo...");
                    break;
                default:
                    System.out.println("Opcion invalida");
            }
        }
        
    }
    
}
