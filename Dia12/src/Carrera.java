class Carrera {
    private int atletaActual = 0;
    private final Object testigo = new Object();
    private boolean corriendo = true;

    public void correr(int id) throws InterruptedException {
        synchronized (testigo) {
            while (atletaActual != id) {
                testigo.wait();
            }
            // Atleta comienza a correr
            System.out.println("Atleta " + (id+1) + " está corriendo.");
            long inicio = System.currentTimeMillis();
            new Atleta(this, (id + 1) % 4).start(); // Inicia el siguiente atleta
            esperarTiempoAleatorio();
            long fin = System.currentTimeMillis();
            System.out.println("Atleta " + id + " terminó en " + (fin - inicio) + " ms.");
            atletaActual = (id + 1) % 4;
            testigo.notifyAll(); // Notifica al siguiente atleta
        }
    }

    private void esperarTiempoAleatorio() throws InterruptedException {
        int tiempo = 9000 + new Random().nextInt(2000); // Tiempo entre 9000 y 11000 ms
        Thread.sleep(tiempo);
    }

    public void iniciarCarrera() {
        new Atleta(this, 0).start(); // Comienza la carrera con el primer atleta
    }
}


