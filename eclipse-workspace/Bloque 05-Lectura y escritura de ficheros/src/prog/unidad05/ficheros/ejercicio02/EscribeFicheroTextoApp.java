package prog.unidad05.ficheros.ejercicio02;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class EscribeFicheroTextoApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);

 // Ruta al fichero
    String rutaFichero;
    // ¿Vamos a añadir (true) o a comenzar desde vacío (false)?
    boolean anyadir = false;
    
    System.out.println("Introduce la ruta del archivo que quieres sobreescribir o que quieres crear:");
    rutaFichero = sc.nextLine();
    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(rutaFichero, 
    anyadir))){
      
      String linea = null;
     do {
       
       System.out.println("Escribe lo que quieras introducir en el fichero linea por linea(vacia para terminar)");
       linea = sc.nextLine();
        flujoSalida.printf("%s%n",linea );
      }while (linea != "");
      
    } catch (IOException e) {
      
    }
  }

}
