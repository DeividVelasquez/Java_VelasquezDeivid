/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

public class Main {
    public static void main(String[] args) {
        Coffee coffee = new SimpleCoffee();
        coffee = new ArequipeDecorator(coffee);
        System.out.println(coffee.getDescription());
        System.out.println("Cost: " + coffee.cost()); 
    }
}

