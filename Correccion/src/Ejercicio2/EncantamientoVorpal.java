package Ejercicio2;

public class EncantamientoVorpal implements Encantamiento {
    
    @Override
    public void activar(){
        System.out.println("El arma brilla con una luz roja.");
    }

    @Override
    public void aplicar(){
        System.out.println("El ataque tiene una alta probabilidad de ser crítico.");
    }

    @Override
    public void desactivar(){
        System.out.println("El brillo rojo del arma desaparece.");
    }
}
