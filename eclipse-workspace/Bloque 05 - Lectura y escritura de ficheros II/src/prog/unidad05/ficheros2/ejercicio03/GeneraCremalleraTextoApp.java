package prog.unidad05.ficheros2.ejercicio03;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class GeneraCremalleraTextoApp {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String rutaFichero1 = "cremallera1.txt";
        String rutaFichero2 = "Cremallera2.txt";
        String rutaFichero3 = "CremalleraFinal.txt";
        boolean anyadir = false;

        try (
            BufferedReader fichero1 = new BufferedReader(new FileReader(rutaFichero1));
            BufferedReader fichero2 = new BufferedReader(new FileReader(rutaFichero2));
            PrintWriter flujoSalida = new PrintWriter(new FileWriter(rutaFichero3, anyadir))
        ) {
            String linea1 = null;
            String linea2 = null;

            
            while ((linea1 = fichero1.readLine()) != null && (linea2 = fichero2.readLine()) != null) {
               
               
                    System.out.println(linea1);
                    flujoSalida.println(linea1);
                
               
               
                    System.out.println(linea2);
                    flujoSalida.println(linea2);
                
            }
            while ((linea1 = fichero1.readLine()) != null) {
              System.out.println(linea1);
              flujoSalida.println(linea1);
          }

          while ((linea2 = fichero2.readLine()) != null) {
              System.out.println(linea2);
              flujoSalida.println(linea2);
          }
           
        } catch (Exception e) {
            e.getMessage(); 
        } 
    }
}
