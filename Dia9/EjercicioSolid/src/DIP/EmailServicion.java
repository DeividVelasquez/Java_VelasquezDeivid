package DIP;

public class EmailServicion implements notificacionServicio {
    @Override
    public void enviarNotificacion(String mensaje){
        System.out.println("Enviando email: " + mensaje);
    }
}
