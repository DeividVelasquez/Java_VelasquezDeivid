package FactoryMethod;

// producto en concreto
public class Paypal implements PlayMethod {
    @Override
    public String play(){
        return "Pagando con Paypal";
    }
}
