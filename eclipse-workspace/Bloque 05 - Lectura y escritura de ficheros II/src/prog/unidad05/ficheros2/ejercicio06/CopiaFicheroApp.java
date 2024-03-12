package prog.unidad05.ficheros2.ejercicio06;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class CopiaFicheroApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    // Cambiar por la ruta al fichero
       String rutaFicheroACopiar;
       String nuevoFichero;
       // Abrimos flujo de entrada de bytes desde el fichero
       rutaFicheroACopiar = "actividad503f.pdf";
       nuevoFichero = "actividad503fCopia.pdf";
       boolean anyadir = false;
       try (FileInputStream flujoEntrada = new FileInputStream(rutaFicheroACopiar);
           FileOutputStream flujoSalida = new FileOutputStream(nuevoFichero, anyadir)) {
        
         // Mientras haya bytes
         int leido = -1;
         do {
           // Intenta leer el siguiente byte
           leido = flujoEntrada.read();
          
           // Si se pudo leer el byte
           if (leido != -1) {
             flujoSalida.write(leido);
           }
           
         } while (leido != -1);
         System.out.println("La copia fue realizada con exito");
       } catch (FileNotFoundException e) {
         // Hacer algo si no se encuentra el fichero
       } catch (IOException e) {
         // Hacer algo si no se puede leer desde el fichero
       }

  }

}
