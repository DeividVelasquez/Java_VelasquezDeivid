public class ReservaEntradas {
    private int EntradasDisponibles;

    public ReservaEntradas(int EntradasDisponibles){
        this.EntradasDisponibles = EntradasDisponibles;
    }

    public synchronized boolean ReservaEntrada(int cantidad){
        if (EntradasDisponibles >= cantidad){
            System.out.println("El cliente " + Thread.currentThread().getName() + " reservo " + cantidad + " entradas.");
            EntradasDisponibles -= cantidad;

            return true;
        } else {
            System.out.println("El cliente " + Thread.currentThread().getName() + " no pudo reservar "  + cantidad + " entradas.");
            return false;
        }
    }

    public int obtenerEntradasDispo(){
        return EntradasDisponibles;
    }
}
