/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Interpreter;

public class Main {
    public static void main(String[] args) {
        Expression isMale = new TerminalExpression("John");
        Expression isMarriedWoman = new TerminalExpression("Jane");

        Expression isJohnOrJane = new OrExpression(isMale, isMarriedWoman);

        System.out.println(isJohnOrJane.interpret("John")); 
        System.out.println(isJohnOrJane.interpret("Jane")); 
        System.out.println(isJohnOrJane.interpret("Tom"));  
    }
}
