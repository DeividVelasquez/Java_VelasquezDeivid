package ISP;

public class LugarTrabajo {
    private Trabajador trabajador;

    public LugarTrabajo(Trabajando trabajador){
        this.trabajador = (Trabajador) trabajador;
    }

    public void iniciarTrabajo(){
        trabajador.trabajar();
    }
}
