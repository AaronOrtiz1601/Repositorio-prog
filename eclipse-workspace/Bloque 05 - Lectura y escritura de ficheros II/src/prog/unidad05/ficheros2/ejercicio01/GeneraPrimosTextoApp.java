package prog.unidad05.ficheros2.ejercicio01;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GeneraPrimosTextoApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Ruta al fichero
        String rutaFichero;
        // ¿Vamos a añadir (true) o a comenzar desde vacío (false)?
        boolean anyadir = false;

        System.out.println("Introduce la ruta del archivo que quieres sobreescribir o que quieres crear:");
        rutaFichero = sc.nextLine();
        try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(rutaFichero, anyadir))) {

            String linea = null;

            System.out.println("Aqui tienes los numeros primos entre el 1 y el 500");
            for (int i = 2; i <= 500; i++) {
                int contador = 0;
                for (int j = 1; j <= i; j++) {

                    if (i % j == 0) {
                        contador++;
                    }
                }
                if (contador == 2) {
                    linea = String.valueOf(i);
                    flujoSalida.printf("%s%n", linea);
                }
            }

        } catch (IOException e) {
            e.printStackTrace(); // Manejo básico de excepciones. Puedes personalizar según tus necesidades.
        }

        sc.close(); // Cerrar el Scanner después de su uso.
    }
}
