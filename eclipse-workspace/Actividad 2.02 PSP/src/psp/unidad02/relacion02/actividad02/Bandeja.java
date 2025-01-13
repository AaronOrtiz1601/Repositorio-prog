package psp.unidad02.relacion02.actividad02;

public class Bandeja {
    // Atributo que guarda el numero de pizzas en la bandeja
    private int pizzas = 0;

    // Metodo sincronizado para depositar una pizza en la bandeja
    public synchronized void depositarPizza() {
        // Incrementar el contador de pizzas
        pizzas++;
        // Imprimir mensaje indicando que una pizza ha sido colocada en la bandeja
        System.out.printf("Pizza colocada en la bandeja. Total en bandeja: %d.%n", pizzas);
        // Notificar a los hilos esperando (clientes) que hay pizzas disponibles
        notifyAll();
    }

    // Metodo sincronizado para tomar una pizza de la bandeja
    public synchronized boolean tomarPizza() {
        // Comprobar si hay pizzas en la bandeja
        if (pizzas > 0) {
            // Decrementar el contador de pizzas
            pizzas--;
            // Imprimir mensaje indicando que una pizza ha sido tomada de la bandeja
            System.out.printf("Pizza tomada de la bandeja. Total en bandeja: %d.%n", pizzas);
            return true; // Indicar que la pizza fue tomada con exito
        } else {
            // Si no hay pizzas, retornar false
            return false;
        }
    }

    // Metodo sincronizado para obtener el numero de pizzas actuales en la bandeja
    public synchronized int obtenerPizzas() {
        // Retornar el numero de pizzas en la bandeja
        return pizzas;
    }
}
