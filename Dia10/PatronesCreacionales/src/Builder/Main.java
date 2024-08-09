package Builder;

public class Main {
    public static void main(String[] args) {
        carro Carro = new carro.Builder()
                                .setMotor("V8")
                                .setRuedas(4)
                                .setModelo("BMW")
                                .build();
        System.out.println("Coche construido con éxito");
    }
}
