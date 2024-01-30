package prog.unidad06.arraysobjetos.ejercicio01;

import java.util.Scanner;

public class GestionaLibrosApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int opcion = 0;
    int movimiento = 0;
    String titulo;
    String autor;
    int año;
    Libro [] biblioteca = new Libro [10];
    System.out.println("GESTIÓN DE LIBROS");
    System.out.println("-------------------");
    do
    {
      System.out.println("(1) Agregar libro");
      System.out.println("(2) Mostrar todos los libros");
      System.out.println("(3) Buscar libro por título");
      System.out.println("(4) Buscar libro por año de publicación");
      System.out.println("(0) Salir del menú");
      opcion = Integer.parseInt(sc.nextLine());
      switch(opcion)
      {
      case 1:
        System.out.println("Dime el titulo de tu libro");
         titulo = Scanner.nextLine();
        
      }
    }while(opcion != 0);

  }

}
