package prog.unidad05.ficheros2.ejercicio04;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class QuitaComentariosApp {

  
    
        public static void main(String[] args) {
            Scanner sc = new Scanner(System.in);
            String rutaFichero1 = "actividad503d.java";
            
            String rutaFichero3 = "actividad503d_salida.java";
            boolean anyadir = false;
            

            try (
                BufferedReader fichero1 = new BufferedReader(new FileReader(rutaFichero1));
                PrintWriter flujoSalida = new PrintWriter(new FileWriter(rutaFichero3, anyadir))
            ) {
                String linea = null;
                boolean primeraLinea = true;
                

                
                while ((linea = fichero1.readLine()) != null) {
                  if (!linea.trim().startsWith("//")) {
                    // La escribimos en la salida
                    // Si no es la primera línea, termina la anterior con un salto de linea
                    if (!primeraLinea) {
                      flujoSalida.println();
                    } else {
                      // Si es la primera linea, ya las siguientes no lo seran
                      primeraLinea = false;
                    }
                    flujoSalida.print(linea);
                  }
                        
                }
                    
                
               
            } catch (Exception e) {
                e.getMessage(); 
            } 
        }
    


  }


