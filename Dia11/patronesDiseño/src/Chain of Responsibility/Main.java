/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chain_of_Responsibility;

public class Main {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();
        
        handlerA.setNextHandler(handlerB);

        handlerA.handleRequest(5);  
        handlerA.handleRequest(15); 
        handlerA.handleRequest(25); 
    }
}
