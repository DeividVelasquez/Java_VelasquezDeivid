package FactoryMethod;

public class Main {
    public static void main(String[] args) {
        creador Creador = new creadorPC();
        Producto producto = Creador.metodoFabrica();
        producto.use();
    }
}
