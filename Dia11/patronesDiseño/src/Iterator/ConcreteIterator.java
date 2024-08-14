/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Iterator;
    
import java.util.List;

class ConcreteIterator implements Iterator {
    private List<String> items;
    private int position = 0;

    public ConcreteIterator(List<String> items) {
        this.items = items;
    }

    @Override
    public boolean hasNext() {
        return position < items.size();
    }

    @Override
    public Object next() {
        return hasNext() ? items.get(position++) : null;
    }
}
