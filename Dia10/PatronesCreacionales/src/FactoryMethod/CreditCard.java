package FactoryMethod;

// producto en concreto
public class CreditCard implements PayMethod {
    @Override
    public String pay(){
        return "Pagando con tarjeta de crédito"
    }
}
