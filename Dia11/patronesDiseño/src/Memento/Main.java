/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State1");
        originator.setState("State2");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State3");
        caretaker.addMemento(originator.saveStateToMemento());

        originator.setState("State4");

        System.out.println("Current State: " + originator.getState()); 
        originator.getStateFromMemento(caretaker.getMemento(0));
        System.out.println("Restored State: " + originator.getState()); 
    }
}
