
package psp.unidad02.relacion02.actividad02;


import java.util.Random;

// Se define la clase Cliente que implementa la interfaz Runnable
public class Cliente implements Runnable {
    // Se declara el identificador del cliente
    private final int id;
    // Se declara la bandeja de pizzas
    private final Bandeja bandeja;
    // Se crea un objeto Random para generar números aleatorios
    private final Random random = new Random();

    // Constructor de la clase Cliente, recibe un id y una bandeja
    public Cliente(int id, Bandeja bandeja) {
        this.id = id;
        this.bandeja = bandeja;
    }

    // Método run que define el comportamiento del hilo
    @Override
    public void run() {
        // Mensaje indicando que el cliente comienza a buscar pizzas
        System.out.printf("Cliente %d: comenzando a buscar pizzas.%n", id);
        // Se inicializa el contador de pizzas comidas
        int pizzasComidas = 0;

        // Bucle que se ejecuta mientras el cliente no haya comido 5 pizzas
        while (pizzasComidas < 5) {
            // Mensaje indicando que el cliente entra en la tienda
            System.out.printf("Cliente %d: entrando en la tienda.%n", id);
            // Se intenta tomar una pizza de la bandeja
            boolean comioPizza = bandeja.tomarPizza();

            // Si el cliente consigue una pizza
            if (comioPizza) {
                pizzasComidas++; // Incrementa el contador de pizzas comidas
                // Mensaje indicando que el cliente comió una pizza
                System.out.printf("Cliente %d: comió una pizza (%d de 5).%n", id, pizzasComidas);
                // El cliente da un paseo después de comer la pizza
                darPaseo(20, 30); // Paseo tras comer pizza
            } else {
                // Mensaje indicando que no encontró pizza
                System.out.printf("Cliente %d: no encontró pizzas.%n", id);
                // El cliente da un paseo si no encuentra pizza
                darPaseo(10, 15); // Paseo tras no encontrar pizza
            }
        }
        // Mensaje indicando que el cliente ya comió suficiente y se va a casa
        System.out.printf("Cliente %d: comió suficiente y se va a casa.%n", id);
    }

    // Método privado que simula el paseo del cliente
    private void darPaseo(int min, int max) {
        try {
            // Calcula un tiempo aleatorio entre los valores min y max
            int tiempo = (min + random.nextInt(max - min + 1)) * 1000;
            // Mensaje indicando que el cliente está dando un paseo
            System.out.printf("Cliente %d: dando un paseo (%d ms).%n", id, tiempo);
            // El cliente duerme el tiempo calculado
            Thread.sleep(tiempo);
        } catch (InterruptedException e) {
            // Mensaje de error si el paseo es interrumpido
            System.err.printf("Cliente %d: paseo interrumpido.%n", id);
        }
    }
}
