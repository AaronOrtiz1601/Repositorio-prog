package psp.unidad02.actividad202.CalculaPrimosApp;
import java.util.ArrayList;
import java.util.List;

public class CalculaPrimosApp extends Thread {
    private int inicio;
    private int fin;
    private List<Integer> primos = new ArrayList<>();
    private long tiempoInicio;
    private long tiempoFin;

    public CalculaPrimosApp(int inicio, int fin) {
        this.inicio = inicio;
        this.fin = fin;
    }

    @Override
    public void run() {
        tiempoInicio = System.currentTimeMillis(); // Comienza el tiempo
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                primos.add(i);
            }
        }
        tiempoFin = System.currentTimeMillis(); // Termina el tiempo
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
}
