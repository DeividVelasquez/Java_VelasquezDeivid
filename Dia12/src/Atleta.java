import java.util.Random;

class Atleta extends Thread {
    private static final Random random = new Random();
    private final Carrera carrera;
    private final int id;

    public Atleta(Carrera carrera, int id) {
        this.carrera = carrera;
        this.id = id;
    }

    @Override
    public void run() {
        try {
            carrera.correr(id);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private void esperarTiempoAleatorio() throws InterruptedException {
        int tiempo = 9000 + random.nextInt(2000); // Tiempo entre 9000 y 11000 ms
        Thread.sleep(tiempo);
    }
}
