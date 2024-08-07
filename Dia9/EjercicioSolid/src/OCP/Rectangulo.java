package OCP;

public class Rectangulo extends Figura {
    public double largo;
    public double ancho;

    public Rectangulo(double largo, double ancho){
        this.largo = largo;
        this.ancho = ancho;
    }

    @Override
    public double area(){
        return largo * ancho;
    }
}
