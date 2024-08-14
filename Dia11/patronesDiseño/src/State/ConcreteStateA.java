/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

class ConcreteStateA implements State {
    @Override
    public void handleRequest() {
        System.out.println("Handling request in State A");
    }
}
