package prog.ud06.actividad611.coleccion.diccionario;

/**
 * Clase Diccionario
 * 
 *Clase que representa un diccionario  que asocia nombres con valores genericos
 */

import java.util.HashMap;
import java.util.Map;

public class Diccionario<V> {

    // Mapa interno para almacenar las entradas del diccionario
    private Map<String, V> diccionario;

    /**
     * Constructor que inicializa un nuevo diccionario vacío.
     */
    public Diccionario() {
        diccionario = new HashMap<>();
    }

    /**
     * Método para comprobar la existencia de una entrada en el diccionario con el nombre proporcionado.
     * @param nombre - Nombre de la entrada a comprobar.
     * @return true si existe una entrada con el nombre proporcionado, false en caso contrario.
     */
    public boolean contieneNombre(String nombre) {
        return diccionario.containsKey(nombre);
    }

    /**
     * Método para añadir una nueva entrada al diccionario.
     * @param nombre - Nombre de la entrada a añadir. No puede ser null ni coincidir con una entrada existente.
     * @param valor - Valor a almacenar en la entrada. No puede ser null.
     * @throws DiccionarioException - Si ya existe una entrada con el nombre proporcionado en el diccionario.
     * @throws IllegalArgumentException - Si el nombre o el valor son null.
     */
    public void add(String nombre, V valor) {
        if (nombre != null && !contieneNombre(nombre)) {
            if (valor != null) {
                diccionario.put(nombre, valor);
            } else {
                throw new IllegalArgumentException("El valor no puede ser null.");
            }
        } else if (nombre == null) {
            throw new IllegalArgumentException("El nombre no puede ser null.");
        } else if (contieneNombre(nombre)) {
            throw new DiccionarioException();
        }
    }

    /**
     * Método para obtener el valor almacenado en una entrada del diccionario a partir de su nombre.
     * @param nombre - Nombre de la entrada a recuperar.
     * @return Valor almacenado en la entrada con el nombre proporcionado. Si no existe, devuelve null.
     */
    public V getEntrada(String nombre) {
        return diccionario.get(nombre);
    }
}
