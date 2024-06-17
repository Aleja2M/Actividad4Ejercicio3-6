/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 *
 * @author User
 */
import java.util.ArrayList;
import java.util.List;

public class Hotel {
    private List<Habitacion> habitaciones = new ArrayList<>();
    private List<Cliente> clientes = new ArrayList<>();

    public void agregarHabitacion(Habitacion habitacion) {
        habitaciones.add(habitacion);
    }

    public void agregarCliente(Cliente cliente) {
        clientes.add(cliente);
    }

    public Habitacion buscarHabitacion(int numero) {
        for (Habitacion h : habitaciones) {
            if (h.getNumero() == numero) {
                return h;
            }
        }
        return null;
    }

    public Cliente buscarCliente(String cedula) {
        for (Cliente c : clientes) {
            if (c.getCedula().equals(cedula)) {
                return c;
            }
        }
        return null;
    }

    public List<Habitacion> getHabitaciones() {
        return habitaciones;
    }

    public List<Cliente> getClientes() {
        return clientes;
    }
}

