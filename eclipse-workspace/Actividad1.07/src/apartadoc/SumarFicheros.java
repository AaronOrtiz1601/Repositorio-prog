package apartadoc;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SumarFicheros {

    // Lista de ficheros
  private static final String[] FICHEROS = {
      "C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.07\\informatica.txt",
      "C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.07\\gerencia.txt",
      "C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.07\\contabilidad.txt",
      "C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.07\\comercio.txt",
      "C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.07\\rrhh.txt"
  };

    public static void main(String[] args) {
        int sumaTotal = 0;

        // Procesar cada fichero uno por uno con uno con un for each
        for (String fichero : FICHEROS) {
            try {
                // Lanzar un proceso para sumar el fichero
              ProcessBuilder builder = new ProcessBuilder("java", "-cp", "C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.07\\bin", "apartadoc.SumarFichero", fichero);
                Process process = builder.start();

                // Leer la salida del proceso
                BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                // Leer la suma del proceso
                String resultado = reader.readLine();

                // Esperar a que el proceso termine
                int exitCode = process.waitFor();
                if (exitCode != 0) {
                    System.out.println("El proceso terminó con un código de error para " + fichero + ": " + exitCode);
                }

                // Comprobar si se obtuvo un resultado
                if (resultado != null && !resultado.trim().isEmpty()) {
               // Sumar el resultado
                    sumaTotal += Integer.parseInt(resultado); 
                } else {
                    System.out.println("No se obtuvo resultado de " + fichero);
                }

            } catch (IOException e) {
                System.err.println("Error al ejecutar el proceso para el fichero " + fichero);
                e.printStackTrace();
            } catch (NumberFormatException e) {
                System.err.println("Error al convertir el resultado a número para el fichero " + fichero);
                e.printStackTrace();
            } catch (InterruptedException e) {
                System.err.println("El proceso fue interrumpido para el fichero " + fichero);
             // Restablecer el estado de interrupción
                Thread.currentThread().interrupt(); 
            }
        }

        // Mostrar el resultado final
        System.out.println("La suma total de todas las cantidades es: " + sumaTotal);
    }
}
