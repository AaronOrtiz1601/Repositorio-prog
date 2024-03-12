package prog.unidad05.ficheros2.ejercicio05;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class CuentaAparicionesPalabraApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rutaFichero = "actividad503e-quijote.txt";
        String palabraAContar;
        System.out.println("Introduce la palabra a contar");
        palabraAContar = sc.nextLine();
        int contador = 0;

        try (BufferedReader flujoEntrada = new BufferedReader(new FileReader(rutaFichero))) {
            String linea;

            // Mientras haya líneas
            while ((linea = flujoEntrada.readLine()) != null) {
                if (linea != null) {
                    String[] palabras = linea.split("\\s+");
                    for (String palabra : palabras) {
                        if (palabraAContar.equals(palabra)) {
                            contador++;
                        }
                    }
                }
            }

            System.out.println("La palabra " + palabraAContar + " se repite en el texto " + contador + " veces");

        } catch (FileNotFoundException e) {
            System.out.println("No se encontró el archivo");
        } catch (IOException e) {
            System.out.println("Error de lectura del archivo");
        }
    }
}
