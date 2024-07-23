package trainer;

public class trainer {
    private int identificacion;
    private String nombres;
    private String apellidos;
    private String celular;
    private String salon;

    public trainer(int identificacion, String nombres, String apellidos, String celular, String salon){
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.celular = celular;
        this.salon = salon;
    }

    public int getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(int identificacion) {
        this.identificacion = identificacion;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public String getSalon() {
        return salon;
    }

    public void setSalon(String salon) {
        this.salon = salon;
    }

    @Override
    public String toString() {
        return "\n Camper{" +
                "\n identificacion = " + identificacion + '\'' +
                "\n nombres = " + nombres + '\'' +
                "\n apellidos = " + apellidos + '\'' +
                "\n Numero de celular = " + celular + '\'' +
                "\n Salon = " + salon + '\'' +
                "\n }";
    }

}
