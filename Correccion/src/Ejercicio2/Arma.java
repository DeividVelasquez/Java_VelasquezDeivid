package Ejercicio2;

public abstract class Arma {
    protected Encantamiento encantamiento;

    Arma(Encantamiento encantamiento){
        this.encantamiento = encantamiento;
    }

    public abstract void blandir();
    public abstract void atacar();
    public abstract void soltar();
}
