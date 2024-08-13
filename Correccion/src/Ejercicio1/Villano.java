package Ejercicio1;

public class Villano extends Personaje {
    private String habilidad;

    Villano(String nombre, int edad, String habilidad){
        super(nombre, edad);
        this.habilidad = habilidad;        
    }

    public String getHabilidad(){
        return habilidad;
    }

    public void setHabilidad(String habilidad){
        this.habilidad = habilidad;
    }
}
