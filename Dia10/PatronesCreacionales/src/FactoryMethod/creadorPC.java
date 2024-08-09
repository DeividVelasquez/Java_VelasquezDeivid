package FactoryMethod;

public class creadorPC extends creador {
    public Producto metodoFabrica(){
        return new computador();
    }
}
