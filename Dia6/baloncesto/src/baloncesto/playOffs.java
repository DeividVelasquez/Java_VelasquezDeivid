/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

public class playOffs extends partido {
    public String ronda;
    
    public playOffs(String equipoLocal, String equipoVisitante, int cestasLocal, int cestasVisitante, boolean estado, String fechaPartido, String ronda){
        super(equipoLocal, equipoVisitante, cestasLocal, cestasVisitante, estado, fechaPartido);
        this.ronda = ronda;
    }
    
    public String getRonda(){
        return ronda;
    }
    
    public void setRonda(String ronda){
        this.ronda = ronda;
    }
    
    public void partidoinfo(){
        System.out.println("Informacion del partido de PlayOffs");
        System.out.println("Fecha del partido: " + fechaPartido);
        if(estado == true){
            System.out.println("El partido se encuentra en juego");
        } else {
            System.out.println("El partido no se encuentra en juego");
        }
        System.out.println("Equipo local: " + equipoLocal);
        System.out.println("Equipo visitante: " + equipoVisitante);
        System.out.println("Cestas de equipo local: " + cestasLocal);
        System.out.println("Cestas de equipo visitante: " + cestasVisitante);
        System.out.println("Ronda del partido: " + ronda);
    }
    
    @Override
    public void verInformacion(){
        System.out.println("Partido de PlayOffs");
        System.out.println("¿Que tipo de informacion quiere visualizar?");
        System.out.println("1. Informacion general de partido");
        System.out.println("2. Marcador actual de partido");
        System.out.println("3. Resultado de partido");
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
            case 5:
                System.out.println("Saliendo....");
                break;
            default:
                System.out.println("Opcion incorrecta");
        }
    }
    
    @Override 
    public void modificarInformacion(){
        System.out.println("Modificar informacion del partido");
        System.out.println("¿Que tipo de informacion quiere modificar?");
        System.out.println("1. Equipo Local");
        System.out.println("2. Equipo Visitante");
        System.out.println("3. Cestas del equipo local");
        System.out.println("4. Cestas del equipo visitante");
        System.out.println("5. Fecha del partido");
        System.out.println("6. Ronda del pedido");
        System.out.println("7. Saliendo");
        
        int option =  sc.nextInt();
        switch(option){
            case 1:
                System.out.println("Ingrese el nuevo equipo local");
                String rta = sc.nextLine();
                setEquipoLocal(rta);
                System.out.println("Se ingreso el nuevo equipo local exitosamente");
                break;
            case 2:
                System.out.println("Ingrese el nuevo equipo visitante");
                String rta2 = sc.nextLine();
                setEquipoVisitante(rta2);
                System.out.println("Se ingreso el nuevo equipo visitante exitosamente");
                break;
            case 3:
                System.out.println("Ingrese el numero de cestas del equipo local");
                int rta3 = sc.nextInt();
                setCestasLocal(rta3);
                System.out.println("Se ingreso el numero de cestas del equipo local exitosamente");
                break;
            case 4:
                System.out.println("Ingrese el numero de cestas del equipo visitante");
                int rta4 = sc.nextInt();
                setCestasVisitante(rta4);
                System.out.println("Se ingreso el numero de cestas del equipo visitante exitosamente");
                break;
            case 5:
                System.out.println("Ingrese la nueva fecha del partido(YYYY-MM-DD)");
                String rta5 = sc.nextLine();
                setFechaPartido(rta5);
                System.out.println("Se ingreso la nueva fecha del partido exitosamente");
                break;
            case 6:
                System.out.println("Ingrese la nueva ronda del partido");
                System.out.println("Octavos, Cuartos, Final");
                String rta6 = sc.nextLine();
                if("Octavos".equals(rta6) || "Cuartos".equals(rta6) || "Final".equals(rta6)){
                    setRonda(rta6);
                    System.out.println("Se ingreso la nueva ronda: " + getRonda());
                }else{
                    System.out.println("No existe la ronda ingresada " + rta6);
                }
                break;
            case 7:
                System.out.println("Saliendo....");
                break;
            default:
                System.out.println("Opcion invalidad");
                
        }
    }
    
}
