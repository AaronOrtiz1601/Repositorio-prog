package prog.unidad03;

import java.util.Scanner;

public class NumeroCifrasApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int numero;
    System.out.println("Dime un numero y te dire si tiene 1,2,3 o mas de 3 cifras");
    numero=Integer.parseInt(sc.nextLine());
    if (numero<10) {
      System.out.println("El numero tiene una cifra");
      
    }else if (numero<100) {
      System.out.println("El numero tiene dos cifras");
      
    }else if (numero>=100) {
      System.out.println("El numero tiene tres cifras");
      
    }else if (numero>1000) {
      System.out.println("El numero tiene mas de tres cifras");
    }

  }

}
