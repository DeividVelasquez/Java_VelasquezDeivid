/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correccion;

public class Visa extends Tarjeta {

    public Visa(String numeroDeCuenta, double valorApertura, String mes) {
        super(numeroDeCuenta, valorApertura, mes);
    }

    @Override
    public double cuotaDeManejo() {
        double descuentoAplicado = Descuento.DIAMANTE.aplicarDescuento(getValorApertura());
        return descuentoAplicado;
    }
}

