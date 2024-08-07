package DIP;

public class SMSServicion implements notificacionServicio {
    @Override
    public void enviarNotificacion(String mensaje){
        System.out.println("Enviar SMS: " + mensaje);
    }
}
