package ISP;

public class Trabajador implements Trabajando, Comiendo {
    @Override
    public void trabajar(){
        System.out.println("El trabajador está trabajando");
    }

    @Override
    public void comer(){
        System.out.println("El trabajador está comiendo");
    }
}
