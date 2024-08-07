package ISP;

public class Comedor {
    private Comiendo comensal;

    public Comedor(Comiendo comensal){
        this.comensal = comensal;
    }

    public void inicialComida(){
        comensal.comer();
    }
}
