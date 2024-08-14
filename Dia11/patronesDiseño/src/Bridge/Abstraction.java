/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Bridge;

abstract class Abstraction {
    protected Implementation implementation;

    public Abstraction(Implementation implementation) {
        this.implementation = implementation;
    }

    public abstract void operation();
}
