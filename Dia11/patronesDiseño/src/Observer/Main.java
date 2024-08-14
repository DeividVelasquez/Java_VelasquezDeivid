/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Observer;

/**
 *
 * @author camper
 */
public class Main {
    public static void main(String[] args) {
        ConcreteSubject subject = new ConcreteSubject();
        
        ConcreteObserver observer1 = new ConcreteObserver("Observer1");
        ConcreteObserver observer2 = new ConcreteObserver("Observer2");
        
        subject.addObserver(observer1);
        subject.addObserver(observer2);
        
        subject.setState("State1"); 
    }
}
