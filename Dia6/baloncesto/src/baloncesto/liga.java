/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;


public class liga extends partido {
    
    public int jornada;
    
    public liga (String equipoLocal, String equipoVisitante, int cestasLocal, int cestasVisitante, boolean estado, String fechaPartido, int jornada){
        super(equipoLocal, equipoVisitante, cestasLocal, cestasVisitante, estado, fechaPartido);
        this.jornada = jornada;
    }
    
    public int getJornada(){
        return jornada;
    }
    
    public void setJornada(int jornada){
        this.jornada = jornada;
    }
    
    @Override
    public void partidoInfo(){
        System.out.println("Informacion del partido de Liga");
        System.out.println("Fecha del partido: " + fechaPartido);
        if (estado == true){
            System.out.println("El partido se encuentra en juego");
        }else{
            System.out.println("El partido ya ha finalizado");
        }
        System.out.println("Equipo Local: " + equipoLocal);
        System.out.println("Equipo Visitante: " + equipoVisitante);
        System.out.println("Cestas de equipo Local: " + cestasLocal);
        System.out.println("Cestas de equipo Visitante: " + cestasVisitante);

    }
    
    @Override
    public void verInformacion(){
        System.out.println("Partido de Liga");
        System.out.println("¿Qué tipo de información quiere visualizar?");
        System.out.println("1. Informacion general de partido");
        System.out.println("2. Marcador actual de partido");
        System.out.println("3. Resultados de partido");
        System.out.println("4. Equipo Ganador");
        System.out.println("5. Salir");
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
                System.out.println("Saliendo...");
                break;
        }
    }
    
    @Override
    public void modificarInformacion(){
        System.out.println("Modificar Informacion Partido");
        System.out.println("¿Qué tipo de información quiere modificar?");
        System.out.println("1. Equipo Local");
        System.out.println("2. Equipo Visitante");
        System.out.println("3. Cestas del Equipo local");
        System.out.println("4. Cestas del Equipo visitante");
        System.out.println("5. Fecha del partido");
        System.out.println("6. Jornada de Liga");
        System.out.println("7. Salir");
        int option = sc.nextInt();
        switch(option){
            case 1->{
                System.out.println("Ingrese el nuevo equipo local");
                String rta = sc.nextLine();
                setEquipoLocal(rta);
                System.out.println("Se ingresó el nuevo equipo local exitosamente");
                break;
                
            }case 2->{
                System.out.println("Ingrese el nuevo equipo Visitante");
                String rta = sc.nextLine();
                setEquipoVisitante(rta);
                System.out.println("Se ingresó el nuevo equipo Visitante exitosamente");
                break;
            }case 3->{
                System.out.println("Ingrese el numero de cestas del equipo local");
                int rta = sc.nextInt();
                setCestasLocal(rta);
                System.out.println("Se ingresó el numero de cestas del equipo local exitosamente");
                break;
            }case 4->{
                System.out.println("Ingrese el numero de cestas del equipo visitante");
                int rta = sc.nextInt();
                setCestasVisitante(rta);
                System.out.println("Se ingresó el numero de cestas del equipo visitante exitosamenta");
                break;
            }case 5->{
                System.out.println("Ingrese la nueva fecha del partido(YYYY-MM-DD)");
                String rta = sc.nextLine();
                setFechaPartido(rta);
                System.out.println("Se ingresó la nueva fecha del partido exitosamente");
                break;
            }case 6->{
                System.out.println("Ingrese la jornada del partido de liga");
                int rta = sc.nextInt();
                setJornada(rta);
                System.out.println("Se ingresó la nueva fecha del partido exitosamente");
                break;
            }default->{
                System.out.println("Saliendo...");
                break;
            }
        }
    }
    
    
}
