package Ejercicio2;

public class EncantamientoFuego implements Encantamiento {
    
    @Override
    public void activar(){
        System.out.println("El arma se ilumina con un aura de fuego");
    }

    @Override
    public void aplicar(){
        System.out.println("El ataque añade daño de fuego.");
    }

    @Override
    public void desactivar(){
        System.out.println("El aura de fuego se desvanece.");
    }
}
