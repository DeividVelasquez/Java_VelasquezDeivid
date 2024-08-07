package SRP;

public class Main {
    public static void main(String[] args) {
        Empleado empleado = new Empleado("Daniela", 2000);
        CalcularSalario calcular = new CalcularSalario();

        double salarioAnual = calcular.calcularSalarioAnual(empleado);
        System.out.println("Salario anual: " + salarioAnual);
    }
}
