/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Decorator;

class ArequipeDecorator extends CoffeeDecorator {
    
    public ArequipeDecorator(Coffee coffee) {
        super(coffee);
    }

    @Override
    public String getDescription() {
        return coffee.getDescription() + ", Arequipe";
    }

    @Override
    public double cost() {
        return coffee.cost() + 1.0;
    }
}
