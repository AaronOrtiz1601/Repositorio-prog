package mainApp;

import java.util.Scanner;

import conversiones.biblioteca;

public class probandoCombersiones {

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    biblioteca biblioteca = new biblioteca(); 

    while (true) {
      System.out.println("Seleccione una opción:");
      System.out.println("1. Convertir CSV a Binario");
      System.out.println("2. Convertir Binario a CSV");
      System.out.println("3. Ordenar archivo CSV");
      System.out.println("4. Ordenar archivo Binario");
      System.out.println("5. Convertir Binario a CSV ordenado");
      System.out.println("6. Salir");
      int opcion = scanner.nextInt();

      switch (opcion) {
      case 1:
        String csvToBinario = scanner.nextLine();
        biblioteca.fichero_CSV_To_Binario("Libro1.csv");
        break;
      case 2:
        String binarioToCsv = scanner.nextLine();
        biblioteca.fichero_Binario_To_Csv("Libro1.dat");
        break;
      case 3:
        String ordenarCsv = scanner.nextLine();
        biblioteca.ordenar_Archivo_CSV("Libro1.csv");
        break;
      case 4:
        String ordenarBinario = scanner.nextLine();
        biblioteca.ordenar_Archivo_Binario("Libro1.dat");
        break;
      case 5:
        String binarioToCsvOrdenado = scanner.nextLine();
        biblioteca.fichero_Binario_To_CSV_Ordenado("Libro1.dat");
        break;
      case 6:
        System.out.println("Saliendo...");
        scanner.close();
        System.exit(0);
        break;
      default:
        System.out.println("Opción inválida. Intente de nuevo.");
      }
    }


  }

}
