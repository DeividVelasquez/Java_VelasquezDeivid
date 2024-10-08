/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

public class Adapter implements Target {
    
    private Adaptee adaptee;
    
    public Adapter(Adaptee adaptee){
        this.adaptee = adaptee;
    }
    
    @Override
    public void request(){
        adaptee.specificRequest();
    }
}
