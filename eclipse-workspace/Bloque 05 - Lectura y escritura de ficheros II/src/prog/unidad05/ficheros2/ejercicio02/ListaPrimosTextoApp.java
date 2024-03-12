package prog.unidad05.ficheros2.ejercicio02;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

public class ListaPrimosTextoApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    String rutaFichero;
    System.out.println("Introduce la ruta al archivo a mostrar:");
   rutaFichero = sc.nextLine();
    try (BufferedReader flujoEntrada = new BufferedReader(new 
    FileReader(rutaFichero))) {
      
      // Mientras haya líneas
      String linea = null;
      do {
        // Intenta leer la siguiente línea
        linea = flujoEntrada.readLine();
        // Si se pudo leer una línea
        if (linea != null) {
          System.out.println(linea);
        }
      } while (linea != null);
      
      
      
    } catch (FileNotFoundException e) {
    } catch (IOException e) {
    
    }

  }

}
