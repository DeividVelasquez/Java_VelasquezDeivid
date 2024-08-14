package Ejercicio2;

public class Martillo extends Arma {
    Martillo(Encantamiento encantamiento){
        super(encantamiento);
    }

    @Override
    public void blandir(){
        encantamiento.activar();
        System.out.println("Blandiendo el martillo.");
    }

    @Override
    public void atacar(){
        encantamiento.aplicar();
        System.out.println("Atacando con el martillo.");
    }

    @Override
    public void soltar(){
        encantamiento.desactivar();
        System.out.println("Soltando el martillo.");
    }
}
