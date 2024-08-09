package AbstractFactory;

public class Main {
    public static void main(String[] args) {
        FabricaMuebles fabrica = new FabricaSilla();

        silla Silla = fabrica.crearSilla();
        cama Cama = fabrica.crearCama();

        Silla.sentarse();
        Cama.acostarse();
    }
}
