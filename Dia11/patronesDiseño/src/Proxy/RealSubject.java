/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Proxy;

class RealSubject implements Subject {
    @Override
    public void request() {
        System.out.println("RealSubject request");
    }
}
