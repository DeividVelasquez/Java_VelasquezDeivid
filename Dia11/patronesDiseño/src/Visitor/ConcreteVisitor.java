/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Visitor;

class ConcreteVisitor implements Visitor {
    @Override
    public void visit(Element element) {
        if (element instanceof ConcreteElementA) {
            System.out.println(((ConcreteElementA) element).operationA());
        } else if (element instanceof ConcreteElementB) {
            System.out.println(((ConcreteElementB) element).operationB());
        }
    }
}