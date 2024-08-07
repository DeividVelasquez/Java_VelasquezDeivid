package DIP;

public class NotificacionUsuarion {
    private notificacionServicio NotificacionServicio;

    public NotificacionUsuarion(notificacionServicio NotificacionServicio){
        this.NotificacionServicio = NotificacionServicio; 
    }

    public void notificarUsuario(String mensaje){
        NotificacionServicio.enviarNotificacion(mensaje);
    }
}
