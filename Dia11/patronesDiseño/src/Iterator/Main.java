/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Iterator;

public class Main {
    public static void main(String[] args) {
        ConcreteCollection collection = new ConcreteCollection();
        collection.addItem("Item1");
        collection.addItem("Item2");
        collection.addItem("Item3");

        Iterator iterator = collection.createIterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
