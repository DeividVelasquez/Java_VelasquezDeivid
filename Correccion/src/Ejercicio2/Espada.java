package Ejercicio2;

public class Espada extends Arma {
    public Espada(Encantamiento encantamiento){
        super(encantamiento);
    }

    @Override
    public void blandir(){
        encantamiento.activar();
        System.out.println("Blandiendo la espada.");
    }

    @Override
    public void atacar(){
        encantamiento.aplicar();
        System.out.println("Atacando con la espada.");
    }

    @Override
    public void soltar(){
        encantamiento.desactivar();
        System.out.println("Soltando la espada.");
    }
}
