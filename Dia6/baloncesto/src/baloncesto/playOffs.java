/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package baloncesto;

import java.util.Date;

public class playOffs extends partido {
    public String ronda;
    
    public playOffs(String equipoLocal, String equipoVisitante, int cestasLocal, int cestasVisitante, boolean estado, Date fechaPartido, String ronda){
        super(equipoLocal, equipoVisitante, cestasLocal, cestasVisitante, estado, fechaPartido);
        this.ronda = ronda;
    }
    
    public String getRonda(){
        return ronda;
    }
    
    public void setRonda(String ronda){
        this.ronda = ronda;
    }
    
}
