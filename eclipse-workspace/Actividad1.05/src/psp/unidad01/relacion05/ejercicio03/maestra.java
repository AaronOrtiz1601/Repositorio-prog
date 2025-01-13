package psp.unidad01.relacion05.ejercicio03;

import java.io.File;
import java.io.IOException;

public class maestra {

    public static void main(String[] args) {
        try {
            // Crear un único objeto ProcessBuilder
            ProcessBuilder proceso = new ProcessBuilder();

            // Definir el directorio de trabajo donde está el JAR
            proceso.directory(new File("C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.05\\src\\psp\\unidad01\\relacion05\\ejercicio03"));

            // Proceso 1: Ejecutar el JAR con el argumento "archivo1.txt"
            proceso.command("java", "-jar", "Ejecutable3.jar", "archivo1.txt");
            Process proceso1 = proceso.start();
            proceso1.waitFor();

            // Proceso 2: Ejecutar el JAR con el argumento "archivo2.txt"
            proceso.command("java", "-jar", "Ejecutable3.jar", "archivo2.txt");
            Process proceso2 = proceso.start();
            proceso2.waitFor();

            // Proceso 3: Ejecutar el JAR sin argumento (nombre de archivo por defecto)
            proceso.command("java", "-jar", "Ejecutable3.jar");
            Process proceso3 = proceso.start();
            proceso3.waitFor();

        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
    }
}
