public class Carrera {
    private static final Object testigo = new Object();
    private static long tiempoInicio;
    private static int turno = 1;

    public static void main(String[] args) {
        tiempoInicio = System.currentTimeMillis();

        Corredor corredor1 = new Corredor("Atleta 1", 1);
        Corredor corredor2 = new Corredor("Atleta 2", 2);
        Corredor corredor3 = new Corredor("Atleta 3", 3);
        Corredor corredor4 = new Corredor("Atleta 4", 4);

        corredor1.start();
        corredor2.start();
        corredor3.start();
        corredor4.start();
    }

    public static class Corredor extends Thread {
        private String nombre;
        private int orden;

        public Corredor(String nombre, int orden){
            this.nombre = nombre;
            this.nombre = nombre;
        }

        @Override
        public void run(){
            synchronized (testigo){
                try {

                    while (orden != turno) {
                        testigo.wait();
                    }

                    System.out.println(nombre + " comenzó a correr.");
                    long tiempoCarrera = 9000 + (long)(Math.random() * 2000);
                    Thread.sleep(tiempoCarrera);
                    long tiempoFinal = System.currentTimeMillis();
                    System.out.println(nombre + " terminó de correr en " + (tiempoFinal - tiempoInicio) / 1000.0 + " segundos.");

                    turno++;
                    testigo.notify();

                } catch(InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
