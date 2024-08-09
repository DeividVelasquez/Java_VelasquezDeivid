package FactoryMethod;

public class FactoryPayMethod  {
    // creador 
    public enum PMTypes{Paypal, CreditCard, Cash}

    public static PayMethod getPayMethod(PMTypes payMethod){
        switch (payMethod) {
            case Paypal:
                return new Paypal();
                break;
                
            case CreditCard:
                return new CreditCard();
                break;

            case Cash:
                return new Cash();
                break;

            default:
                break;
        }
    }
}