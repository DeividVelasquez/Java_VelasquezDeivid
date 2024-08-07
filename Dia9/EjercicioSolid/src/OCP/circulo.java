package OCP;

public class circulo extends Figura {
    public double radio;

    public circulo(double radio){
        this.radio = radio;
    }

    @Override
    public double area(){
        return Math.PI * radio * radio;
    }
}
