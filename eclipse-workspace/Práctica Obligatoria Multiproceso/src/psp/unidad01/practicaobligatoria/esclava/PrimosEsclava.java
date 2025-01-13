package psp.unidad01.practicaobligatoria.esclava;

import java.util.*;

public class PrimosEsclava {
    public static void main(String[] args) {
        int inicio = Integer.parseInt(args[0]);
        int fin = Integer.parseInt(args[1]);

        List<Integer> primosEncontrados = new ArrayList<>();

        // Buscar números primos en el rango
        for (int i = inicio; i <= fin; i++) {
            if (esPrimo(i)) {
                primosEncontrados.add(i);
             // Imprimir el primo encontrado
                System.out.println(i);  
            }
        }
    }

   /**
    * Metodo que se encarga de comprobar si un numero es primo o no
    * @param num
    * @return boolean
    */
    public static boolean esPrimo(int num) {
        if (num <= 1) return false;
        for (int i = 2; i <= Math.sqrt(num); i++) {
            if (num % i == 0) return false;
        }
        return true;
    }
}
