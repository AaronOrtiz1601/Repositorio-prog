package psp.unidad02.relacion02.actividad01;

public class Worker implements Runnable {
  // Declaración de las variables de instancia para el rango de números (inicio,
  // fin) y el objeto compartido
  private final int inicio;
  private final int fin;
  private final ObjetoCompartido compartido;

  // Constructor de la clase Worker, que recibe los parametros del rango y el
  // objeto compartido
  public Worker(int inicio, int fin, ObjetoCompartido compartido) {
    // Asignar el valor del limite inferior al atributo inicio
    this.inicio = inicio;
    // Asignar el valor del limite superior al atributo fin
    this.fin = fin;
    // Asignar el objeto compartido que se usara para almacenar los primos
    // encontrados
    this.compartido = compartido;
  }

  // Metodo run que se ejecutara cuando se inicie el hilo
  @Override
  public void run() {
    // Iterar sobre el rango de numeros desde 'inicio' hasta 'fin'
    for (int i = inicio; i <= fin; i++) {
      // Comprobar si el numero es primo
      if (esPrimo(i)) {
        // Si el numero es primo, agregarlo al objeto compartido
        compartido.agregarPrimo(i);
      }
    }
  }

  // Metodo para verificar si un numero es primo
  private boolean esPrimo(int num) {
    // Los numeros menores que 2 no son primos
    if (num < 2)
      return false;

    // Iterar desde 2 hasta la raiz cuadrada de 'num' para verificar si tiene
    // divisores
    for (int i = 2; i <= Math.sqrt(num); i++) {
      // Si 'num' es divisible por 'i', no es primo
      if (num % i == 0)
        return false;
    }

    // Si no se encontraron divisores, el numero es primo
    return true;
  }
}
