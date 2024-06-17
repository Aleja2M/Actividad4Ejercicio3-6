
package Ejercicio6;

/**
6 Crear un programa que permita simular una alcancía digital. La alcancía
* permite gestionar el ingreso de monedas, el usuario en todo momento puede 
* consultar la cantidad de dinero que posee y la cantidad de transacciones de
* ingreso y egreso de dinero y cantidad de dinero en cada transacción.
 */
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Alcancia {
    private double saldo; // Saldo total de dinero en la alcancía
    private int numTransacciones; // Número total de transacciones
    private List<Transaccion> transacciones; // Lista para almacenar las transacciones
    
    private static final DecimalFormat df = new DecimalFormat("#,###.##"); // Formato para mostrar el saldo
    
    // Constructor de la clase Alcancia
    public Alcancia() {
        this.saldo = 0;
        this.numTransacciones = 0;
        this.transacciones = new ArrayList<>();
    }

    // Método para ingresar dinero a la alcancía
    public void ingresarDinero(double cantidad) {
        saldo += cantidad;
        numTransacciones++;
        transacciones.add(new Transaccion("Ingreso", cantidad));
        System.out.println(df.format(cantidad) + " pesos ingresados a la alcancía.");
    }

    // Método para egresar dinero de la alcancía
    public void egresarDinero(double cantidad) {
        if (cantidad <= saldo) {
            saldo -= cantidad;
            numTransacciones++;
            transacciones.add(new Transaccion("Egreso", cantidad));
            System.out.println(df.format(cantidad) + " pesos egresados de la alcancía.");
        } else {
            System.out.println("No hay suficiente saldo en la alcancía para realizar el egreso.");
        }
    }

    // Método para consultar el saldo total de la alcancía
    public double consultarSaldo() {
        return saldo;
    }

    // Método para consultar el número de transacciones realizadas
    public int consultarNumTransacciones() {
        return numTransacciones;
    }

    // Método para consultar todas las transacciones realizadas
    public void consultarTransacciones() {
        System.out.println("Historial de Transacciones:");
        for (Transaccion t : transacciones) {
            System.out.println(t);
        }
    }

    // Clase interna Transaccion para representar una transacción de ingreso o egreso
    private class Transaccion {
        private String tipo; // "Ingreso" o "Egreso"
        private double cantidad; // Cantidad de dinero en la transacción

        // Constructor de la clase Transaccion
        public Transaccion(String tipo, double cantidad) {
            this.tipo = tipo;
            this.cantidad = cantidad;
        }

        @Override
        public String toString() {
            return "Tipo: " + tipo + ", Cantidad: " + df.format(cantidad);
        }
    }

    public static void main(String[] args) {
        Alcancia alcancia = new Alcancia();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\nMenu:");
            System.out.println("1. Ingresar dinero");
            System.out.println("2. Egresar dinero");
            System.out.println("3. Consultar saldo");
            System.out.println("4. Consultar número de transacciones");
            System.out.println("5. Consultar historial de transacciones");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la cantidad de dinero a ingresar: ");
                    String cantidadIngresoStr = scanner.nextLine().trim().replace(",", "");
                    try {
                        double cantidadIngreso = Double.parseDouble(cantidadIngresoStr);
                        alcancia.ingresarDinero(cantidadIngreso);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Formato de número incorrecto.");
                    }
                    break;
                case 2:
                    System.out.print("Ingrese la cantidad de dinero a egresar: ");
                    String cantidadEgresoStr = scanner.nextLine().trim().replace(",", "");
                    try {
                        double cantidadEgreso = Double.parseDouble(cantidadEgresoStr);
                        alcancia.egresarDinero(cantidadEgreso);
                    } catch (NumberFormatException e) {
                        System.out.println("Error: Formato de número incorrecto.");
                    }
                    break;
                case 3:
                    double saldo = alcancia.consultarSaldo();
                    System.out.println("Saldo actual en la alcancía: " + df.format(saldo));
                    break;
                case 4:
                    int numTransacciones = alcancia.consultarNumTransacciones();
                    System.out.println("Número total de transacciones: " + numTransacciones);
                    break;
                case 5:
                    alcancia.consultarTransacciones();
                    break;
                case 6:
                    System.out.println("Saliendo del programa...");
                    scanner.close();
                    return;
                default:
                    System.out.println("Opción no válida, intente de nuevo.");
            }
        }
    }
}




































