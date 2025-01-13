package psp.unidad02.actividad202.CalculaPrimosRunnableApp;

import java.util.ArrayList;
import java.util.List;

public class CalculaPrimosRunnableApp implements Runnable {
    private int inicio;
    private int fin;
    private List<Integer> primos = new ArrayList<>();
    private long tiempoInicio;
    private long tiempoFin;

    public CalculaPrimosRunnableApp(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        tiempoInicio = System.currentTimeMillis(); // Tiempo al iniciar
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                primos.add(i);
            }
        }
        tiempoFin = System.currentTimeMillis(); // Tiempo al finalizar
    }

    private boolean esPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }

    public List<Integer> getPrimos() {
        return primos;
    }

    public long getTiempoTotal() {
        return tiempoFin - tiempoInicio;
    }

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
            List<CalculaPrimosRunnableApp> tareas = new ArrayList<>();
            List<Thread> hilos = new ArrayList<>();
            long inicioTiempo = System.currentTimeMillis();

            // Crear y lanzar los hilos
            for (int i = 0; i < numHilos; i++) {
                int inicio = inicioRango + i * tamRango;
                int fin = (i == numHilos - 1) ? finRango : inicio + tamRango - 1;

                CalculaPrimosRunnableApp tarea = new CalculaPrimosRunnableApp(inicio, fin);
                tareas.add(tarea);

                Thread hilo = new Thread(tarea);
                hilos.add(hilo);
                hilo.start(); // Inicia el hilo
            }

            // Esperar a que todos los hilos terminen
            for (Thread hilo : hilos) {
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
            for (int i = 0; i < tareas.size(); i++) {
                CalculaPrimosRunnableApp tarea = tareas.get(i);
                int primosEncontrados = tarea.getPrimos().size();
                totalPrimos += primosEncontrados;

                System.out.printf("Hilo %d: Primos encontrados: %d, Tiempo empleado: %d ms%n",
                        i + 1, primosEncontrados, tarea.getTiempoTotal());
            }

            System.out.printf("\nTiempo total empleado en el programa: %d ms. Se encontraron %d números primos.%n",
                    tiempoTotal, totalPrimos);

        } catch (NumberFormatException e) {
            System.err.println("Error: Los valores de los parámetros deben ser enteros.");
        }
    }
}
