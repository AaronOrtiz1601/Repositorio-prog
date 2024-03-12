package prog.unidad05.ficheros.ejercicio05;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;

public class CreceDiscosApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
   
     String titulo;
     String artista;
     int añoDePublicacion;
     double precio;
     String Cd;

 // Ruta al fichero
    String rutaFichero;
    // ¿Vamos a añadir (true) o a comenzar desde vacío (false)?
    boolean anyadir = false;
    
    System.out.println("Introduce la ruta del archivo que quieres sobreescribir o que quieres crear:");
    rutaFichero = sc.nextLine();
    try (PrintWriter flujoSalida = new PrintWriter(new FileWriter(rutaFichero, 
    anyadir))){
      
     
     
       
       System.out.println("Dime el titulo del disco");
       titulo = sc.nextLine();
       System.out.println("Dime el artista");
       artista = sc.nextLine();
       System.out.println("Dime el año de publicacion del disco");
       añoDePublicacion = Integer.parseInt(sc.nextLine());
       System.out.println(añoDePublicacion);
       System.out.println("Dime el precio del disco");
       precio = Double.parseDouble(sc.nextLine());
       System.out.println("¿Es el disco un cd?(s para si y n para no");
       Cd = sc.nextLine();
       CreceDiscos almacen = new CreceDiscos(titulo, artista, añoDePublicacion, precio, Cd);
        flujoSalida.printf("%s%n",almacen.aTexto() );
      
      
    } catch (IOException e) {
      
    

  }

}
}
