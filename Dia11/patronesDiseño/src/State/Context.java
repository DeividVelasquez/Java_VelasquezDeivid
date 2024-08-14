/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package State;

class Context {
    private State state;

    public void setState(State state) {
        this.state = state;
    }

    public void request() {
        state.handleRequest();
    }
}
