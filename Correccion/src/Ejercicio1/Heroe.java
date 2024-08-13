package Ejercicio1;

public class Heroe extends Personaje {
    private static Heroe instance;
    private String poder;

    private Heroe(String nombre, int edad, String poder){
        super(nombre, edad);
        this.poder = poder;
    }

    public static Heroe getInstance(String nombre, int edad, String poder){
        if(instance == null){
            instance = new Heroe(nombre, edad, poder);
        }else {
            System.out.println("Error: Ya existe un héroe registrado con el nombre " + instance.getNombre() + " la edad de " + instance.getEdad() + " y el poder de " + instance.getPoder());
        }
        return instance;
    }

    public String getPoder(){
        return poder;
    }

    public void setPoder(String poder){
        this.poder = poder;
    }

    public static Heroe getInstance() {
        return instance;
    }

    public static void setInstance(Heroe instance) {
        Heroe.instance = instance;
    }
}
