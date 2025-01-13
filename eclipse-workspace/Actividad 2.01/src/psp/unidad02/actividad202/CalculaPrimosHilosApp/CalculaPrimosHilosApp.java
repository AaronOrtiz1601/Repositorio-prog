package psp.unidad02.actividad202.CalculaPrimosHilosApp;

import java.util.ArrayList;
import java.util.List;

import psp.unidad02.actividad202.CalculaPrimosApp.CalculaPrimosApp;

public class CalculaPrimosHilosApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.err.println("Error: Insuficiente número de parámetros.");
            System.err.println("Uso: java CalculaPrimosHilosApp <valor inicial> <valor final> [<número de hilos>]");
            return;
        }

        try {
            int inicioRango = Integer.parseInt(args[0]);
            int finRango = Integer.parseInt(args[1]);

            if (inicioRango <= 0 || finRango <= 0 || inicioRango >= finRango) {
                System.err.println("Error: Los valores de los parámetros deben ser enteros, positivos y mayores que 0.");
                return;
            }

            int nucleosDisponibles = Runtime.getRuntime().availableProcessors();
            int rango = finRango - inicioRango + 1;
            int numHilos = args.length == 3 ? Integer.parseInt(args[2]) : nucleosDisponibles;
            numHilos = Math.min(numHilos, rango);

            System.out.println("Número de hilos que se intentará usar: " + numHilos);

            int tamRango = rango / numHilos;
            List<CalculaPrimosApp> hilos = new ArrayList<>();
            long inicioTiempo = System.currentTimeMillis();

            // Crear y lanzar los hilos
            for (int i = 0; i < numHilos; i++) {
                int inicio = inicioRango + i * tamRango;
                int fin = (i == numHilos - 1) ? finRango : inicio + tamRango - 1;

                CalculaPrimosApp hilo = new CalculaPrimosApp(inicio, fin);
                hilos.add(hilo);
                hilo.start(); // Inicia el hilo
            }

            // Esperar a que todos los hilos terminen
            for (CalculaPrimosApp hilo : hilos) {
                try {
                    hilo.join(); // Bloquea hasta que el hilo termine
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            long finTiempo = System.currentTimeMillis();
            long tiempoTotal = finTiempo - inicioTiempo;

            int totalPrimos = 0;

            // Mostrar los resultados por hilo
            System.out.println("\n--- Resultados por hilo ---");
            for (int i = 0; i < hilos.size(); i++) {
                CalculaPrimosApp hilo = hilos.get(i);
                int primosEncontrados = hilo.getPrimos().size();
                totalPrimos += primosEncontrados;

                // Mostrar el tiempo empleado por cada hilo
                System.out.printf("Hilo %d: Primos encontrados: %d, Tiempo empleado: %d ms%n",
                        i + 1, primosEncontrados, hilo.getTiempoTotal());
            }

            System.out.printf("\nTiempo total empleado en el programa: %d ms. Se encontraron %d números primos.%n",
                    tiempoTotal, totalPrimos);

        } catch (NumberFormatException e) {
            System.err.println("Error: Los valores de los parámetros deben ser enteros.");
        }
    }
}
