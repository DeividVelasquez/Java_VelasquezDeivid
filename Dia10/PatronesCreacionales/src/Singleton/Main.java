package Singleton;

public class Main {
    public static void main(String[] args) {
        Singleton a = Singleton.getInstance();
        Singleton b = Singleton.getInstance();

        if(a == b){
            System.out.println("La instancia es única");
        }
    }
}
