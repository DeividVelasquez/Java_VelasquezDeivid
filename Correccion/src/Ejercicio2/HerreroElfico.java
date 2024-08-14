package Ejercicio2;

class HerreroElfico extends Herrero {
    @Override
    public Arma fabricarArma(Encantamiento encantamiento) {
        System.out.println("El herrero elfo fabrica un arma mágica.");
        return new Espada(encantamiento);
    }
}
