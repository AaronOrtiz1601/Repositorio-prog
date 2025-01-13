
package psp.unidad02.relacion02.actividad02;


import java.util.Random;

// Se define la clase Pizzero que implementa la interfaz Runnable
public class Pizzero implements Runnable {
    
    // ID del pizzero
    private final int id;
    
    // Bandeja compartida para colocar las pizzas
    private final Bandeja bandeja;
    
    // Instancia de la clase Random para generar tiempos aleatorios
    private final Random random = new Random();

    // Constructor que recibe el ID del pizzero y la bandeja
    public Pizzero(int id, Bandeja bandeja) {
        this.id = id;
        this.bandeja = bandeja;
    }

    // Método que ejecuta el trabajo del pizzero
    @Override
    public void run() {
        // Mensaje de inicio del trabajo del pizzero
        System.out.printf("Pizzero %d: comenzando a trabajar.%n", id);
        
        try {
            // Bucle para que el pizzero siga trabajando mientras no sea interrumpido
            while (!Thread.currentThread().isInterrupted()) {
                
                // Mensaje al comenzar a preparar una pizza
                System.out.printf("Pizzero %d: comenzando a preparar una pizza.%n", id);
                
                // Tiempo de preparación aleatorio entre 5 y 10 segundos
                int tiempoPreparacion = (5 + random.nextInt(6)) * 1000; 
                
                // Simulación del tiempo de preparación de la pizza
                Thread.sleep(tiempoPreparacion);

                // Colocar la pizza en la bandeja
                bandeja.depositarPizza();
                
                // Mensaje cuando la pizza se coloca en la bandeja
                System.out.printf("Pizzero %d: pizza colocada en la bandeja.%n", id);
            }
        } catch (InterruptedException e) {
            // Mensaje cuando el pizzero termina su jornada debido a una interrupción
            System.out.printf("Pizzero %d: ha terminado su jornada.%n", id);
        }
    }
}
