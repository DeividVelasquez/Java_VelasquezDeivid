/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Memento;

import java.util.List;
import java.util.ArrayList;

class Caretaker {
    private List<Originator.Memento> mementoList = new ArrayList<>();

    public void addMemento(Originator.Memento memento) {
        mementoList.add(memento);
    }

    public Originator.Memento getMemento(int index) {
        return mementoList.get(index);
    }
}
