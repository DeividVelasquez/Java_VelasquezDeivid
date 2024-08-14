/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Chain_of_Responsibility;

class ConcreteHandlerB extends Handler {
    @Override
    public void handleRequest(int request) {
        if (request < 20) {
            System.out.println("Handler B handled request " + request);
        } else if (nextHandler != null) {
            nextHandler.handleRequest(request);
        }
    }
}
