
package psp.unidad02.relacion02.actividad02;


import java.util.ArrayList;
import java.util.List;

// Se define la clase principal de la pizzería
public class PizzeriaLuigi {

    // Método principal que ejecuta la simulación
    public static void main(String[] args) {
        // Procesar parámetros de entrada
        int numPizzeros = 2; 
        int numClientes = 5; 

        // Comprobar si se pasan los parámetros desde la línea de comandos
        if (args.length == 2) {
            try {
                // Intentar convertir los parámetros a enteros
                numPizzeros = Integer.parseInt(args[0]);
                numClientes = Integer.parseInt(args[1]);

                // Validar que los números sean mayores que 1
                if (numPizzeros < 1 || numClientes < 1) throw new NumberFormatException();
            } catch (NumberFormatException e) {
                // Mostrar mensaje de error si los parámetros no son válidos
                System.err.println("Error: Los parámetros deben ser números enteros mayores que 1.");
                return; // Terminar la ejecución en caso de error
            }
        }

        // Mostrar mensaje de inicio de la simulación con los parámetros seleccionados
        System.out.printf("Iniciando simulación con %d pizzeros y %d clientes.%n", numPizzeros, numClientes);

        // Crear la bandeja compartida entre pizzeros y clientes
        Bandeja bandeja = new Bandeja();

        // Crear hilos pizzeros
        List<Thread> hilosPizzeros = new ArrayList<>();
        // Crear los hilos para cada pizzero
        for (int i = 1; i <= numPizzeros; i++) {
            Pizzero pizzero = new Pizzero(i, bandeja); 
            Thread hilo = new Thread(pizzero); 
            hilosPizzeros.add(hilo); 
            hilo.start(); 
        }

        // Crear hilos clientes
        List<Thread> hilosClientes = new ArrayList<>();
        // Crear los hilos para cada cliente
        for (int i = 1; i <= numClientes; i++) {
            Cliente cliente = new Cliente(i, bandeja); 
            Thread hilo = new Thread(cliente); 
            hilosClientes.add(hilo); 
            hilo.start(); 
        }

        // Esperar a que todos los clientes terminen
        for (Thread hilo : hilosClientes) {
            try {
                hilo.join(); // Esperar a que cada hilo cliente termine
            } catch (InterruptedException e) {
                // Mostrar mensaje de error si un hilo cliente es interrumpido
                System.err.println("Error: Un hilo cliente fue interrumpido.");
            }
        }

        // Notificar a los pizzeros que terminen una vez que todos los clientes han terminado
        System.out.println("Todos los clientes han terminado. Cerrando la pizzería.");
        // Interrumpir los hilos pizzeros para que terminen
        for (Thread hilo : hilosPizzeros) {
            hilo.interrupt(); // Interrumpimos los hilos pizzeros
        }
    }
}
