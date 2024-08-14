/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Adapter;

public class Client {

    public static void main(String[] args) {
        Target target;
        target = new Adapter(new Adaptee("Adaptee One"));
        target.request();
    }
}
