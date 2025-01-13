package apartadoc;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class SumarFichero {

  //Hacemos una comprobación de que esta recibiendo el nombre del fichero
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Por favor, proporciona el nombre del fichero.");
            return;
        }
        //Asignamos una variable a ese nombre de fichero
        String fichero = args[0];
        int suma = 0;

        // Sumar las cantidades en el fichero
        try (BufferedReader lector = new BufferedReader(new FileReader(fichero))) {
            String linea;
            while ((linea = lector.readLine()) != null) {
                if (!linea.trim().isEmpty()) { 
                    suma += Integer.parseInt(linea.trim()); 
                }
            }
        } catch (IOException e) {
            System.err.println("Error al leer el fichero: " + fichero);
            e.printStackTrace();
        } catch (NumberFormatException e) {
            System.err.println("Error al convertir una línea a número en el fichero: " + fichero);
            e.printStackTrace();
        }

        // Imprimir la suma para que la clase principal la capture
        System.out.println(suma);
    }
}
