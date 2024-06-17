/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Ejercicio3;

/**
 3. Crea un sistema para gestionar reservas en un hotel. Se desea emitir un ticket
 * donde esté la habitación reservada, datos personales del cliente y el pago
 * por la habitación. Crear un menú que simule gestionar habitaciones, usuarios
 * y crear la reserva (impresión de ticket).
 */
import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Hotel hotel = new Hotel();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Menu:");
            System.out.println("1. Gestionar habitaciones");
            System.out.println("2. Gestionar clientes");
            System.out.println("3. Crear reserva");
            System.out.println("4. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    gestionarHabitaciones(hotel, scanner);
                    break;
                case 2:
                    gestionarClientes(hotel, scanner);
                    break;
                case 3:
                    crearReserva(hotel, scanner);
                    break;
                case 4:
                    System.out.println("Saliendo del sistema...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }

    private static void gestionarHabitaciones(Hotel hotel, Scanner scanner) {
        System.out.print("Ingrese el número de la habitación: ");
        int numero = scanner.nextInt();
        System.out.print("Ingrese el tipo de habitación: ");
        String tipo = scanner.next();
        System.out.print("Ingrese el precio de la habitación: ");
        double precio = scanner.nextDouble();

        Habitacion habitacion = new Habitacion(numero, tipo, precio);
        hotel.agregarHabitacion(habitacion);
        System.out.println("Habitación agregada: " + habitacion);
    }

    private static void gestionarClientes(Hotel hotel, Scanner scanner) {
        System.out.print("Ingrese el nombre del cliente: ");
        String nombre = scanner.next();
        System.out.print("Ingrese la cédula del cliente: ");
        String cedula = scanner.next();
        System.out.print("Ingrese el teléfono del cliente: ");
        String telefono = scanner.next();

        Cliente cliente = new Cliente(nombre, cedula, telefono);
        hotel.agregarCliente(cliente);
        System.out.println("Cliente agregado: " + cliente);
    }

    private static void crearReserva(Hotel hotel, Scanner scanner) {
        System.out.println("Lista de clientes:");
        for (Cliente cliente : hotel.getClientes()) {
            System.out.println(cliente);
        }
        System.out.print("Ingrese la cédula del cliente que hace la reserva: ");
        String cedulaCliente = scanner.next();
        Cliente cliente = hotel.buscarCliente(cedulaCliente);

        if (cliente == null) {
            System.out.println("Cliente no encontrado.");
            return;
        }

        System.out.println("Lista de habitaciones:");
        for (Habitacion habitacion : hotel.getHabitaciones()) {
            System.out.println(habitacion);
        }
        System.out.print("Ingrese el número de la habitación a reservar: ");
        int numHabitacion = scanner.nextInt();
        Habitacion habitacion = hotel.buscarHabitacion(numHabitacion);

        if (habitacion == null) {
            System.out.println("Habitación no encontrada.");
            return;
        }

        System.out.print("Ingrese el número de días de la reserva: ");
        int dias = scanner.nextInt();

        Reserva reserva = new Reserva(cliente, habitacion, dias);
        System.out.println("Reserva creada: " + reserva);
    }
}
