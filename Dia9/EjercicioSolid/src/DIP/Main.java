package DIP;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Elige el tipo de notificación: ");
        System.out.println("1. Email");
        System.out.println("2. SMS");
        int option = sc.nextInt();
        sc.nextLine();

        notificacionServicio NotificacionServicio;

        if (option == 1){
            NotificacionServicio = new EmailServicion();
        } else {
            NotificacionServicio = new SMSServicion();
        }

        NotificacionUsuarion notificacionUsuarion = new NotificacionUsuarion(NotificacionServicio);


        System.out.println("Ingresa el mensaje a enviar:");
        String mensaje = sc.nextLine();

        notificacionUsuarion.notificarUsuario(mensaje);
        sc.close();
    }    
}
