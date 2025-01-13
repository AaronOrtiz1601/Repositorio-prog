package psp.unidad02.relacion02.actividad01;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class CalculaPrimosCompartidosApp {

  public static void main(String[] args) {
    // Verificar que se han pasado dos parámetros al programa
    if (args.length != 2) {
      // Mostrar un mensaje de error si no se proporcionan exactamente dos números
      System.err.println("Error: Debes proporcionar dos números enteros positivos (límite inferior y superior).");
      // Terminar la ejecución del programa
      return;
    }

    // Declarar las variables para los límites inferior y superior
    int limiteInferior, limiteSuperior;

    // Intentar convertir los parámetros recibidos en números enteros
    limiteInferior = Integer.parseInt(args[0]);
    limiteSuperior = Integer.parseInt(args[1]);

    // Comprobar que los números ingresados son positivos y que el límite inferior
    // no es mayor que el límite superior
    if (limiteInferior <= 0 || limiteSuperior <= 0 || limiteInferior > limiteSuperior) {
      // Mostrar un mensaje de error si los parámetros no son válidos
      System.err.println(
          "Error: Los parámetros deben ser positivos y el límite inferior no puede ser mayor que el superior.");
      // Terminar la ejecución del programa
      return;
    }

    // Crear una instancia del objeto compartido que contendrá los resultados
    ObjetoCompartido compartido = new ObjetoCompartido();

    // Obtener el número de procesadores disponibles en el sistema
    int numProcesadores = Runtime.getRuntime().availableProcessors();

    // Crear una lista para almacenar los hilos que se van a ejecutar
    List<Thread> hilos = new ArrayList<>();

    // Calcular el rango total de números que se deben procesar
    int rangoTotal = limiteSuperior - limiteInferior + 1;

    // Calcular el tamaño del subrango que cada hilo procesará
    int tamRango = rangoTotal / numProcesadores;

    // Calcular el resto del rango que no puede dividirse equitativamente entre los
    // hilos
    int resto = rangoTotal % numProcesadores;

    // Inicializar el punto de inicio del primer subrango
    int inicio = limiteInferior;

    // Crear y configurar cada hilo de trabajo
    for (int i = 0; i < numProcesadores; i++) {
      // Calcular el punto final del subrango actual
      int fin = inicio + tamRango - 1;

      // Si hay un resto, asignar uno de los números sobrantes al subrango actual
      if (i < resto)
        fin++;

      // Crear un nuevo trabajador que procese el subrango [inicio, fin]
      Worker worker = new Worker(inicio, fin, compartido);

      // Crear un hilo para ejecutar el trabajador
      Thread hilo = new Thread(worker);

      // Añadir el hilo a la lista de hilos
      hilos.add(hilo);

      // Iniciar la ejecución del hilo
      hilo.start();

      // Actualizar el punto de inicio para el siguiente subrango
      inicio = fin + 1;
    }

    // Esperar a que todos los hilos terminen su ejecución
    for (Thread hilo : hilos) {
      try {
        // Bloquear hasta que el hilo termine
        hilo.join();
      } catch (InterruptedException e) {
        // Mostrar un mensaje de error si algún hilo es interrumpido
        System.err.println("Error: Un hilo fue interrumpido.");
      }
    }

    // Obtener los números primos encontrados desde el objeto compartido
    List<Integer> primos = compartido.obtenerPrimos();

    // Ordenar la lista de números primos en orden ascendente
    Collections.sort(primos);

    // Mostrar los números primos encontrados
    System.out.println("Números primos encontrados: " + primos);
  }
}
