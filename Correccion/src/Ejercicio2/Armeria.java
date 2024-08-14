package Ejercicio2;

class Armeria {
    private Herrero herrero;

    public void seleccionarHerrero(Herrero herrero) {
        this.herrero = herrero;
    }

    public Arma fabricarArma(Encantamiento encantamiento) {
        return herrero.fabricarArma(encantamiento);
    }
}