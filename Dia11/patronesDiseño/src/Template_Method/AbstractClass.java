/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Template_Method;

abstract class AbstractClass {
    // Método plantilla
    public void templateMethod() {
        step1();
        step2();
        step3();
    }

    protected abstract void step1();
    protected abstract void step2();
    
    // Método final
    private void step3() {
        System.out.println("Common step 3");
    }
}
