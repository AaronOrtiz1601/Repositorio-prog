package prog.unidad05.gestionficheros.ejercicio02;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GestionFicheros1App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean condicion = false;
    do {
   System.out.println("MENU");
   System.out.println("0) Salir");
   System.out.println("1) Listar Ficheros");
   System.out.print("Seleccione opción:");
   int opcion = Integer.parseInt(sc.nextLine());
   
   switch (opcion) {
  case 0: 
    System.out.println("Hasta pronto");
    condicion = true;
    break;
  case 1:
    System.out.println("introduzca la ruta de la carpeta a lista:");
    String ruta = sc.nextLine();
    listar(ruta);
    break;
 
    
    
  
  default:
    System.out.println("Ese valor no esta recogido dentro de las opciones, vuelva a intentarlo");
    
  }
    }while (!condicion);
  }
    private static void listar (String ruta)
    {
      Path path = Path.of(ruta);
      if(Files.exists(path) && Files.isDirectory(path))
      {
        try {
          List<Path> ficheros = Files.list(path).collect(Collectors.toList());
          for (Path fichero: ficheros) {
            // Si es una carpeta o un fichero añade la cabecera
            if (Files.isDirectory(fichero)) {
              System.out.print("Carpeta: ");
            } else {
              System.out.print("Fichero: ");
            }
            /// Y después el nombre
            System.out.println(fichero.getFileName());
          }
        } catch (IOException e) {
          // TODO Auto-generated catch block
          e.printStackTrace();
        }
      }
    }
}
