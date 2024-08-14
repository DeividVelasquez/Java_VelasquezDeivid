/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Iterator;

import java.util.ArrayList;
import java.util.List;


class ConcreteCollection implements IterableCollection {
    private List<String> items = new ArrayList<>();

    public void addItem(String item) {
        items.add(item);
    }

    @Override
    public Iterator createIterator() {
        return new ConcreteIterator(items);
    }
}
