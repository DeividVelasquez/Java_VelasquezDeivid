package Prototype;

public class carro implements Prototipo {
    private String modelo;
    private String color;

    public carro(String modelo, String color){
        this.modelo = modelo;
        this.color = color;
    }

    public Prototipo clonar(){
        try{
            return (carro) super.clone();
        }catch (CloneNotSupportedException e){
            e.printStackTrace();
            return null;
        }
    }

    public void mostrarInfo(){
        System.out.println("Modelo: " + modelo + ", Color: " + color);
    }
}
