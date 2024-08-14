/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Composite;

public class Mian {
    
    public static void main(String[] args) {
        Component leaf1 = new Leaf();
        Component leaf2 = new Leaf();
        Composite composite = new Composite();
        
        composite.add(leaf1);
        composite.add(leaf2);
        composite.operation();
    }
}

