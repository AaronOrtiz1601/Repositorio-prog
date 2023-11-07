package prog.unidad03.repeticion;

import java.util.Scanner;

public class CalculaDivisoresApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int numeros;
    System.out.println("Dime un numero entero y te dire sus divisores");
    numeros=Integer.parseInt(sc.nextLine());
    for(int i=0;i<numeros;i++)
    {
      if(numeros%(i+1)==0)
      {
        System.out.println("El numero "+(i+1)+" es divisor de "+numeros);
      }
    }

  }

}
