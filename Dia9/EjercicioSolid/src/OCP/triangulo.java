package OCP;

public class triangulo extends Figura{
    public double base;
    public double alto;

    public triangulo(double base, double alto){
        this.base = base;
        this.alto = alto;
    }

    @Override
    public double area(){
        return (base*alto) / 2;
    }

}
