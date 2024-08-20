// La carrera amable
// Tenemos ocho atletas en una carrera de 100m
// Cada atleta llega a meta entre 9 y 11s.
// Cuando uno llega a la meta, espera al siguiente y cruza la meta. El nuevo que ha llegado espera por el siguiente, y asi susesivamente
// tras cruzarla, imprime su nombre y el tiempo actual 
// PROGRAMAR DICHO ESQUEMA MEDIANTE UNA CLASE ATLETA QUE IMPLEMENTE RUNNABLE
// Thread.sleep y Math.random para la carrera
// synchronized, wait y notify para la meta 
// System.currentTimeMills o Calendar para ver tiempos

import java.util.Random;

class Atleta implements Runnable {
    private static final Object meta = new Object(); // Objeto compartido para sincronización
    private static int atletasEnMeta = 0; // Contador para rastrear cuántos atletas han llegado a la meta
    private final String nombre;

    public Atleta(String nombre) {
        this.nombre = nombre;
    }

    @Override
    public void run() {
        try {
            // Simula el tiempo de carrera: entre 9000ms (9s) y 11000ms (11s)
            int tiempoCarrera = new Random().nextInt(2000) + 9000; // 2000ms de rango (11s - 9s)
            Thread.sleep(tiempoCarrera); // Simula el tiempo que el atleta tarda en correr

            synchronized (meta) {
                atletasEnMeta++; // Incrementa el contador de atletas que han llegado a la meta
                // Imprime el nombre del atleta y el tiempo en el que llega a la meta
                long tiempoActual = System.currentTimeMillis();
                System.out.println(nombre + " cruzó la meta en " + tiempoActual + "ms.");

                // Si no es el último atleta, espera al siguiente
                if (atletasEnMeta < 8) {
                    meta.wait(); // Espera a que el siguiente atleta llegue
                }

                // Notifica al siguiente atleta para que cruce la meta
                meta.notifyAll();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Thread[] atletas = new Thread[8];
        for (int i = 0; i < atletas.length; i++) {
            atletas[i] = new Thread(new Atleta("Atleta " + (i + 1)));
        }

        for (Thread atleta : atletas) {
            atleta.start();
        }
    }
}
