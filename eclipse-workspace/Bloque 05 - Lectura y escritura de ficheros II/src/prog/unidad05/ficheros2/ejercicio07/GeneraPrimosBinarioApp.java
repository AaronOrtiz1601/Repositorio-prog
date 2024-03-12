package prog.unidad05.ficheros2.ejercicio07;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Scanner;

public class GeneraPrimosBinarioApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    // Cambiar por la ruta al fichero
       String nuevoFichero;
       // Abrimos flujo de entrada de bytes desde el fichero
       nuevoFichero = "primos.bin";
       boolean anyadir = false;
       try (FileOutputStream flujoSalida = new FileOutputStream(nuevoFichero, anyadir)) {
        int bytes = -1;
         // Mientras haya bytes
         for (int i = 2; i <= 255; i++) {
           int contador = 0;
           for (int j = 1; j <= i; j++) {

               if (i % j == 0) {
                   contador++;
               }
           }
           if (contador == 2) {
             bytes = i;
               flujoSalida.write(bytes);
           }
       }
         System.out.println("La copia fue realizada con exito");
       } catch (FileNotFoundException e) {
         // Hacer algo si no se encuentra el fichero
       } catch (IOException e) {
         // Hacer algo si no se puede leer desde el fichero
       }

  }

}
