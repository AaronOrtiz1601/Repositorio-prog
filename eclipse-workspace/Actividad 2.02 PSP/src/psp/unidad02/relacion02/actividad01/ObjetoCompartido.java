package psp.unidad02.relacion02.actividad01;

import java.util.ArrayList;
import java.util.List;

public class ObjetoCompartido {
    private final List<Integer> primos = new ArrayList<>();

    // Método sincronizado para añadir números primos
    public synchronized void agregarPrimo(int primo) {
        primos.add(primo);
    }

    // Método para obtener todos los primos
    public synchronized List<Integer> obtenerPrimos() {
        return new ArrayList<>(primos);
    }
}
