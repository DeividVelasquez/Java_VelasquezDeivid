package Singleton;
public class Singleton {
   // 1. La constante INSTANCE es la instancia única de la clase
    private static final Singleton INSTANCE = new Singleton();

    //2. Construccion oculto.
    private Singleton(){}

    //3. Método estático de acceso público que retorna la instacia única.
    public static Singleton getInstance(){
        return INSTANCE;
    }
}
