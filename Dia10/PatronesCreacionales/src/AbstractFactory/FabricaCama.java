package AbstractFactory;

public class FabricaCama implements FabricaMuebles {
    public silla crearSilla(){
        return new sillaComedor();
    }

    public cama crearCama(){
        return new camaDoble();
    }
}
