package LSP;

public class Main {
    public static void main(String[] args) {
        Ave paloma = new Paloma();
        Ave avestrus = new Avestrus();

        ObservarAve observarAve = new ObservarAve();

        System.out.println("Observando a Palomo III");
        observarAve.observar(paloma);

        System.out.println("Observando a DragonPlay");
        observarAve.observar(avestrus);
    }
}
