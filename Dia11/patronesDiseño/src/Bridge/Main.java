/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bridge;

public class Main {
    public static void main(String[] args) {
        Implementation implA = new ConcreteImplementationA();
        Abstraction abs = new RefinedAbstraction(implA);
        abs.operation(); 
        
        Implementation implB = new ConcreteImplementationB();
        abs = new RefinedAbstraction(implB);
        abs.operation(); 
    }
}
