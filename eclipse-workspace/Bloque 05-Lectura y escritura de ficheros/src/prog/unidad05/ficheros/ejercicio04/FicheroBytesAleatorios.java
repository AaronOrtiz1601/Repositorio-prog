package prog.unidad05.ficheros.ejercicio04;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

public class FicheroBytesAleatorios {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
       String rutaFichero;
       int longitudFichero;
       int limiteInferior;
       int limiteSuperior;
       boolean prueba = false;
       System.out.println("Introduce la ruta del archivo que quieres sobreescribir o que quieres crear:");
       rutaFichero = sc.nextLine();
       System.out.println("Introduce la longitud del fichero binario");
       longitudFichero  = Integer.parseInt(sc.nextLine());
       do {
       System.out.println("Introduce el limite inferior (debe ser igual o menor que el segundo)");
       limiteInferior  = Integer.parseInt(sc.nextLine());
       System.out.println("Introduce el limite superior (debe ser igual o mayor que el primero)");
       limiteSuperior  = Integer.parseInt(sc.nextLine());
       if (limiteInferior<= limiteSuperior)
       {
         prueba = true;
       }else
       {
         System.out.println("Las longitudes introducidas no son validas, introducelas bien porfavor");
       }
       }while(!prueba);
       
 
       
     
       boolean anyadir = false;
     
       try (FileOutputStream flujoSalida = new FileOutputStream(rutaFichero, 
       anyadir)){
         
         Random rand = new Random();
         for (int i = 0; i < longitudFichero; i++) {
           
           int randomNumber = rand.nextInt((limiteSuperior - limiteInferior) + 1) + limiteInferior;
           flujoSalida.write(randomNumber);
         }
         System.out.println("Fichero creado");
       } catch (IOException e) {
         System.out.println("Error");
       }

  }

}
