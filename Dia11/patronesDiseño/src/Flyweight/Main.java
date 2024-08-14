/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Flyweight;

public class Main {
    public static void main(String[] args) {
        FlyweightFactory factory = new FlyweightFactory();
        Flyweight flyweight1 = factory.getFlyweight("A");
        flyweight1.operation("First use");

        Flyweight flyweight2 = factory.getFlyweight("A");
        flyweight2.operation("Second use");

        System.out.println(flyweight1 == flyweight2);
    }
}
