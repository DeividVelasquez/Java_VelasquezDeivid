/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package correccion;

public class Nomina extends Tarjeta {

    public Nomina(String numeroDeCuenta, double valorApertura, String mes) {
        super(numeroDeCuenta, valorApertura, mes);
    }

    @Override
    public double cuotaDeManejo() {

        double descuentoAplicado = Descuento.PLATINO.aplicarDescuento(getValorApertura());
        return descuentoAplicado;
    }
}
