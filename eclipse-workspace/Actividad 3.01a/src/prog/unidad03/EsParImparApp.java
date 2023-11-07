package prog.unidad03;

import java.util.Scanner;

public class EsParImparApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int numero1;
    int resultado;
    System.out.println("Introduce un numero y te dire si es par o impar ");
    numero1=Integer.parseInt(sc.nextLine());
    resultado=numero1%2;
    if(resultado==0)
    {
      System.out.println("El numero es par");
    }else {
      System.out.println("El numero es impar");
    }
    
  }

}
