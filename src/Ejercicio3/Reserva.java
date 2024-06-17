/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author User
 */
public class Reserva {
    private Cliente cliente;
    private Habitacion habitacion;
    private int dias;

    public Reserva(Cliente cliente, Habitacion habitacion, int dias) {
        this.cliente = cliente;
        this.habitacion = habitacion;
        this.dias = dias;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Habitacion getHabitacion() {
        return habitacion;
    }

    public int getDias() {
        return dias;
    }

    public double calcularTotal() {
        return dias * habitacion.getPrecio();
    }

    @Override
    public String toString() {
        return "Reserva [cliente=" + cliente + ", habitacion=" + habitacion + ", dias=" + dias + ", total=" + calcularTotal() + "]";
    }
}
