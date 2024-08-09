package AbstractFactory;

public class FabricaSilla implements FabricaMuebles {
    public silla crearSilla(){
        return new sillaComedor();
    }

    public cama crearCama(){
        return new camaDoble();
    }
}
