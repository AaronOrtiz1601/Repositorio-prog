package prog.unidad06.arraysuni.ejercicio07;

import java.util.Scanner;

public class SuperArrayApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int numero;
    System.out.println("Por que numero quieres que empiece tu super array");
    numero = Integer.parseInt(sc.nextLine());
    int [] superArray = new int [30];
    for (int i = 0 ; i < superArray.length; i++)
    {
      if (i == 0)
      {
        superArray [i] = numero;
      }else
      {
        numero++;
        numero = numero *2;
        superArray [i] = numero ;
      }
      
    }
    for (int i = superArray.length -1 ; i >= 0 ; i--)
    {
      System.out.println(superArray [i]);
    }
    
    
    

  }

}
