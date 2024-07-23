/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package camper;

/**
 *
 * @author camper
 */

class Camper {
    private String identificacion;
    private String nombres;
    private String apellidos;
    private String direccion;
    private String acudiente;
    private String telefonoCelular;
    private String telefonoFijo;
    private String estado;
    private String riesgo;

    // Constructor
    public Camper(String identificacion, String nombres, String apellidos, String direccion, 
                  String acudiente, String telefonoCelular, String telefonoFijo, 
                  String estado, String riesgo) {
        this.identificacion = identificacion;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.acudiente = acudiente;
        this.telefonoCelular = telefonoCelular;
        this.telefonoFijo = telefonoFijo;
        this.estado = estado;
        this.riesgo = riesgo;
    }

    // Getters y Setters
    public String getIdentificacion() {
        return identificacion;
    }

    public void setIdentificacion(String identificacion) {
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

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getAcudiente() {
        return acudiente;
    }

    public void setAcudiente(String acudiente) {
        this.acudiente = acudiente;
    }

    public String getTelefonoCelular() {
        return telefonoCelular;
    }

    public void setTelefonoCelular(String telefonoCelular) {
        this.telefonoCelular = telefonoCelular;
    }

    public String getTelefonoFijo() {
        return telefonoFijo;
    }

    public void setTelefonoFijo(String telefonoFijo) {
        this.telefonoFijo = telefonoFijo;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getRiesgo() {
        return riesgo;
    }

    public void setRiesgo(String riesgo) {
        this.riesgo = riesgo;
    }

    @Override
    public String toString() {
        return "\n Camper{" +
                "\n identificacion='" + identificacion + '\'' +
                ",\n nombres='" + nombres + '\'' +
                ",\n apellidos='" + apellidos + '\'' +
                ",\n direccion='" + direccion + '\'' +
                ",\n acudiente='" + acudiente + '\'' +
                ",\n telefonoCelular='" + telefonoCelular + '\'' +
                ",\n telefonoFijo='" + telefonoFijo + '\'' +
                ",\n estado='" + estado + '\'' +
                ",\n riesgo='" + riesgo + '\'' +
                "\n }";
    }
}


