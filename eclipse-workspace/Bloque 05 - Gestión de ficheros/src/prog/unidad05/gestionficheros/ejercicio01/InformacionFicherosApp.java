package prog.unidad05.gestionficheros.ejercicio01;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Scanner;

public class InformacionFicherosApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rutaFichero = "";

        do {
            System.out.println("Introduzca la ruta a un archivo (en blanco para acabar) :");
            rutaFichero = sc.nextLine();
            Path ruta = Path.of(rutaFichero);

            if (!Files.exists(ruta)) {
                System.out.print("El fichero existe");

                if (Files.isDirectory(ruta)) {
                    System.out.println(" y es una carpeta.");
                } else {
                    System.out.println(" y es un fichero.");
                }
            } else {
                System.out.println("El fichero no existe");
            }

        } while (!rutaFichero.isEmpty());
    }
}
