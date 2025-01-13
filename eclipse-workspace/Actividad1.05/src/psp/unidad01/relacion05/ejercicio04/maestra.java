package psp.unidad01.relacion05.ejercicio04;

import java.io.File;
import java.io.IOException;

public class maestra {

    public static void main(String[] args) {
        try {
            // Crear el objeto ProcessBuilder
            ProcessBuilder proceso = new ProcessBuilder();

            // Definir el directorio de trabajo donde está el JAR
            File directorio = new File("C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.05\\src\\psp\\unidad01\\relacion05\\ejercicio04");
            
            proceso.directory(directorio);

            // Configurar el comando para ejecutar el sumador.jar
            proceso.command("java", "-jar", "sumador.jar");

            // Redirigir la entrada desde un archivo (input.txt) con la ruta absoluta
            File inputFile = new File("C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.05\\src\\psp\\unidad01\\relacion05\\ejercicio04\\input.txt");
           
            proceso.redirectInput(inputFile);

            // Redirigir la salida hacia un archivo (output.txt) con la ruta absoluta
            File outputFile = new File("C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.05\\src\\psp\\unidad01\\relacion05\\ejercicio04\\output.txt");
            proceso.redirectOutput(outputFile);

            // Iniciar el proceso
            Process procesos = proceso.start();

            // Esperar a que el proceso termine
            procesos.waitFor();
            System.out.println("El proceso se completó correctamente. Verifica el archivo output.txt para el resultado.");

        } catch (IOException e) {
            System.err.println("Error al iniciar el proceso: " + e.getMessage());
            e.printStackTrace();
        } catch (InterruptedException e) {
            System.err.println("Error: El proceso fue interrumpido.");
            e.printStackTrace();
        }
    }
}
