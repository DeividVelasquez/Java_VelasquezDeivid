package FactoryMethod;

// Producto en concreto
public class Cash implements PayMethod {
    @Override
    public String pay(){
        return "Pagando con efectivo";
    }
}
