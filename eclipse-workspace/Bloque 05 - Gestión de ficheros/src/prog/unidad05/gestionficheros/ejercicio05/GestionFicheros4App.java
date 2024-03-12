package prog.unidad05.gestionficheros.ejercicio05;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class GestionFicheros4App {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    boolean condicion = false;
    do {
   System.out.println("MENU");
   System.out.println("0) Salir");
   System.out.println("1) Listar Ficheros");
   System.out.println("2) Copiar Ficheros");
   System.out.println("3) Mover Ficheros");
   System.out.println("4) Borrar Ficheros");
   System.out.println("5) Crear Ficheros");
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
  case 2:
    System.out.println("introduzca la ruta del archivo que quieres copiar:");
    String ruta1 = sc.nextLine();
    System.out.println("introduzca la ruta del archivo que quieres copiar:");
    String ruta2 = sc.nextLine();
    copiar(ruta1,ruta2);
    break;
  case 3:
    System.out.println("introduzca la ruta del archivo que quieres copiar:");
    String ruta3 = sc.nextLine();
    System.out.println("introduzca la ruta del archivo que quieres copiar:");
    String ruta4 = sc.nextLine();
    copiar(ruta3,ruta4);
    break;
  case 4:
    System.out.println("introduzca la ruta del archivo que quieres borrar:");
    String ruta5 = sc.nextLine();
    borrar(ruta5);
    break;
  case 5:
    System.out.println("Introduzca la ruta del archivo que quieres crear:");
    String ruta6 = sc.nextLine();
    crear(ruta6);
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
    private static void copiar(String rutaOrigen, String rutaDestino) {
      Path origen = Path.of(rutaOrigen);
      Path destino = Path.of(rutaDestino);

      try {
          Files.copy(origen, destino);
          System.out.println("Archivo copiado con éxito.");
      } catch (IOException e) {
          System.err.println("Error al copiar el archivo: " + e.getMessage());
      }
  }
    
    private static void mover(String rutaOrigen, String rutaDestino) {
      Path origen = Path.of(rutaOrigen);
      Path destino = Path.of(rutaDestino);

      try {
          Files.move(origen, destino);
          System.out.println("Archivo copiado con éxito.");
      } catch (IOException e) {
          System.err.println("Error al mover el archivo: " + e.getMessage());
      }
      }
      private static void borrar(String ruta) {
        Path origen = Path.of(ruta);
       

        try {
            Files.deleteIfExists(origen);
            System.out.println("Archivo borrado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al borrar el archivo: " + e.getMessage());
        }
  }
      private static void crear(String ruta) {
        Path origen = Path.of(ruta);
       

        try {
            Files.createDirectories(origen);
            System.out.println("Archivo creado con éxito.");
        } catch (IOException e) {
            System.err.println("Error al creado el archivo: " + e.getMessage());
        }
  }

  }


