package prog.unidad05.ficheros.ejercicio03;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class CuentaBytesEnArchivoApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
 // Cambiar por la ruta al fichero
    String rutaFichero;
    int numeroContar;
    int contador = 0;
    // Abrimos flujo de entrada de bytes desde el fichero
    System.out.println("Introduce la ruta del archivo que quieres sobreescribir o que quieres crear:");
    rutaFichero = sc.nextLine();
    System.out.println("Introduce el byte a contabilizar");
    numeroContar  = Integer.parseInt(sc.nextLine());
    try (FileInputStream flujoEntrada = new FileInputStream(rutaFichero)) {
     
      // Mientras haya bytes
      int leido = -1;
      do {
        // Intenta leer el siguiente byte
        leido = flujoEntrada.read();
       
        // Si se pudo leer el byte
        if (leido != -1) {
          if (leido == numeroContar)
          {
            contador++;
          }
        }
        // El flujo se cierra solo
      } while (leido != -1);
      System.out.println("El numero " + numeroContar + " se repite " + contador + " veces ");
    } catch (FileNotFoundException e) {
      // Hacer algo si no se encuentra el fichero
    } catch (IOException e) {
      // Hacer algo si no se puede leer desde el fichero
    }
  }

}
