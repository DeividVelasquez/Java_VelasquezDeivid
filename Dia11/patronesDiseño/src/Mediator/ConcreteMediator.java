/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Mediator;

import java.util.ArrayList;
import java.util.List;

class ConcreteMediator implements Mediator {
    private List<Colleague> colleagues = new ArrayList<>();

    public void addColleague(Colleague colleague) {
        colleagues.add(colleague);
    }

    @Override
    public void send(String message, Colleague colleague) {
        for (Colleague c : colleagues) {
            if (c != colleague) {
                ((ConcreteColleague1)c).receive(message);  // Casting específico para el ejemplo
            }
        }
    }
}
