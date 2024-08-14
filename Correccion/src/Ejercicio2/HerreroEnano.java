package Ejercicio2;

class HerreroEnano extends Herrero {
    @Override
    public Arma fabricarArma(Encantamiento encantamiento) {
        System.out.println("El herrero enano forja un arma robusta.");
        return new Martillo(encantamiento);
    }
}
