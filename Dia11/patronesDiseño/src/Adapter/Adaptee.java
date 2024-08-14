/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;


public class Adaptee {
    
    private String name;
    
    public Adaptee(String name){
        this.name = name;
    }
    
    public void specificRequest(){
        System.out.println("Called specific request on Adaptee " + name);
    }
}
