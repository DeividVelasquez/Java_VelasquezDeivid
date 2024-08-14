/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

public class Main {
    public static void main(String[] args) {
        Context context = new Context();
        
        State stateA = new ConcreteStateA();
        State stateB = new ConcreteStateB();
        
        context.setState(stateA);
        context.request(); 
        
        context.setState(stateB);
        context.request(); 
    }
}
