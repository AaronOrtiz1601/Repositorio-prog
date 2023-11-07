package prog.unidad03;

import java.util.Scanner;

public class NombreMesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int numero=0;
    System.out.println("Dime un numero del 1 al 12 y te dire el mes del año que se corresponda con ese numero");
    numero=Integer.parseInt(sc.nextLine());
    switch(numero) {
    case 1:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Enero''");
      break;
    case 2:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Febrero''");
      break;
    case 3:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Marzo''");
      break;
    case 4:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Abril''");
      break;
    case 5:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Mayo''");
      break;
    case 6:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Junio''");
      break;
    case 7:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Julio''");
      break;
    case 8:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Agosto''");
      break;
    case 9:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Septiembre''");
      break;
    case 10:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Octubre''");
      break;
    case 11:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Noviembre''");
      break;
    case 12:
      System.out.println("El mes con posición "+numero+" tiene el nombre de ''Diciembre''");
      break;
      default:
        System.out.println("Ese numero no esta en la lista");
        break;
        
    }

  }

}
