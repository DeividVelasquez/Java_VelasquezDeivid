
package baloncesto;

import java.util.Scanner;

public class partido {
    Scanner sc = new Scanner(System.in);

    protected String equipoLocal;
    protected String equipoVisitante;
    protected int cestasLocal;
    protected int cestasVisitante;
    protected boolean estado;
    protected String fechaPartido;

    public partido(String equipoLocal, String equipoVisitante, int cestasLocal, int cestasVisitante, boolean estado, String fechaPartido){
        this.equipoLocal = equipoLocal;
        this.equipoVisitante = equipoVisitante;
        this.cestasLocal = cestasLocal;
        this.cestasVisitante = cestasVisitante;
        this.estado = estado;
        this.fechaPartido = fechaPartido;
    }


    public String getEquipoLocal(){
        return equipoLocal;
    }

    public void setEquipoLocal(String equipoLocal){
        this.equipoLocal = equipoLocal;
    }

    public String getEquipoVisitante(){
        return equipoVisitante;
    }

    public void setEquipoVisitante(String equipoVisitante){
        this.equipoVisitante = equipoVisitante;
    }

    public int getCestasLocal(){
        return cestasLocal;
    }

    public void setCestasLocal(int cestasLocal){
        this.cestasLocal = cestasLocal;
    }

    public int getCestasVisitante(){
        return cestasVisitante;
    }

    public void setCestasVisitante(int cestasVisitante){
        this.cestasVisitante = cestasVisitante;
    }

    public boolean getEstado(){
        return estado;
    }

    public void setEstado(String estado){
        if (estado.toLowerCase().equals("activo")){
            this.estado=true;
        }else{
            this.estado=false;
        }
    }

    public String getFechaPartido(){
        return fechaPartido;
    }

    public void setFechaPartido(String fechaPartido) {
        this.fechaPartido = fechaPartido;
    }
    
    public void equipoGanador(){
        System.out.println("El equipo ganador del partido fue: ");
        if(estado==true){
            System.out.println("El partido sigue en juego.");
        }else{
            if(cestasLocal>cestasVisitante){
                System.out.println("El equipo local, " + getEquipoLocal());
            }else{
                System.out.println("El equipo visitante, " + getEquipoVisitante());
            }
        }
    }

    public void partidoResultados(){
        System.out.println("Los resultados del partido fueron: ");
        if(estado==true){
            System.out.println("El partido sigue en juego.");
        }else{
            System.out.println("Equipo local: " + equipoLocal + " realizo: " + cestasLocal + "cestas." +
               "\nEquipo visitante: " + equipoVisitante + " realizo: " + cestasVisitante + "cestas.");
        }
    }

    public void partidoMarcador(){
        System.out.println("Marcador actual del partido");
        System.out.println("Equipo local: " + equipoLocal + "  Cestas: " + cestasLocal +
               "\nEquipo visitante: " + equipoVisitante + "  Cestas: " + cestasVisitante);
    }

    public void partidoInfo(){
        System.out.println("Información del partido");
        System.out.println("Fecha del partido: " + fechaPartido);
        if (estado == true){
            System.out.println("El partido se encuentra activo.");
        }else{
            System.out.println("El partido no se encuentra activo.");
        }
        System.out.println("Enfrentamiento entre:");
        System.out.println("Equipo Local: " + equipoLocal);
        System.out.println("Cestas: " + cestasLocal);
        System.out.println("Equipo Visitante: " + equipoVisitante);
        System.out.println("Cestas: " + cestasVisitante);
    }

    public void verInformacion(){
        System.out.println("Información de Partido");
        System.out.println("¿Qué tipo de información quiere visualizar?");
        System.out.println("1. Informacion general de partido");
        System.out.println("2. Marcador actual de partido");
        System.out.println("3. Resultados de partido");
        System.out.println("4. Equipo Ganador");
        System.out.println("5. Salir ...");
        int option = sc.nextInt();
        switch(option){
            case 1:
                partidoInfo();
                break;
            case 2:
                partidoMarcador();
                break;
            case 3:
                partidoResultados();
                break;
            case 4:
                equipoGanador();
                break;
            default:
                System.out.println("Volviendo...");
                break;
        }
    }

    public void modificarInformacion(){
        System.out.println("Modificar Informacion de Partido");
        System.out.println("¿Qué tipo de información quiere modificar?");
        System.out.println("1. Equipo Local");
        System.out.println("2. Equipo Visitante");
        System.out.println("3. Cestas del Equipo local");
        System.out.println("4. Cestas del Equipo visitante");
        System.out.println("5. Fecha del partido");
        System.out.println("6. Salir");
        int option = sc.nextInt();
        switch(option){
            case 1:
                System.out.println("Ingrese el nuevo equipo local:");
                String rta = sc.nextLine();
                setEquipoLocal(rta);
                System.out.println("Se ingresó el nuevo equipo local exitosamente");
                break;
                
            case 2:
                System.out.println("Ingrese el nuevo equipo visitante:"); 
                String rta2 = sc.nextLine();
                setEquipoVisitante(rta2);
                System.out.println("Se ingresó el nuevo equipo visitante exitosamente");
                break;
            case 3:
                System.out.println("Ingrese el numero de cestas del equipo local:");
                int rta3 = sc.nextInt();
                setCestasLocal(rta3);
                System.out.println("Se ingresó el numero de cestas del equipo local exitosamente");
                break;
            case 4:
                System.out.println("Ingrese el numero de cestas del equipo visitante:");
                int rta4 = sc.nextInt();
                setCestasVisitante(rta4);
                System.out.println("Se ingresó el numero de cestas del equipo visitante exitosamente");
                break;      
            case 5:
                System.out.println("Ingrese la nueva fecha del partido");
                String rta6 = sc.nextLine();
                setFechaPartido(rta6);
                System.out.println("Se ingresó la nueva fecha del partido exitosamente");
                break;
            case 6:
                System.out.println("Saliendo ...");
                break;
                
            default:
                System.out.println("Opcion incorrecta.");
            
        }
    }
    
    public void finalizarPartido(){
        System.out.println("Finalizar el partido");
        if(getCestasLocal() == getCestasVisitante()){
            System.out.println("El partido acabo en un empate");
        }else if(getCestasLocal() > getCestasVisitante()){
            System.out.println("El partido finalizo ganando el equipo local: " + getEquipoLocal());
        } else if(getCestasLocal() < getCestasVisitante()){
            System.out.println("El partido finalizo ganando el equipo visitante: " + getEquipoVisitante());
        }
    }

}

