package Prototype;

public class Main {
    public static void main(String[] args) {
        carro carroOriginal = new carro("BMW", "Negro");

        carro cocheChafa = (carro) carroOriginal.clonar();

        carroOriginal.mostrarInfo();
        cocheChafa.mostrarInfo();
    }
}
