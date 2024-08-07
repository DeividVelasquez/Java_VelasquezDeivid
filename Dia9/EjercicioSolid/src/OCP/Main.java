package OCP;

public class Main {
    public static void main(String[] args) {
        Figura rectangulo = new Rectangulo(4, 6);
        Figura circulo = new circulo(3);
        Figura triangulo = new triangulo(2, 3);

        System.out.println("Área del rectangulo: " + rectangulo.area());
        System.out.println("Área del circulo: " + circulo.area());
        System.out.println("Área del triangulo: " + triangulo.area());
    }
}
