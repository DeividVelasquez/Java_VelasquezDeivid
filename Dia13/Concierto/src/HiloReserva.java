public class HiloReserva extends Thread {
    private ReservaEntradas sistemaReserva;
    private int cantidad;
    
    public HiloReserva(ReservaEntradas sistemaReserva, int cantidad){
        this.sistemaReserva = sistemaReserva;
        this.cantidad = cantidad;
    }

    @Override
    public void run(){
        sistemaReserva.ReservaEntrada(cantidad);
    }
}
