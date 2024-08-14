/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;


class SimpleCoffee implements Coffee {
    
    @Override
    public String getDescription() {
        return "Capuccino coffee";
    }

    @Override
    public double cost() {
        return 5.0;
    }
}
