package prog.unidad03.repeticion;

import java.util.Scanner;

public class ContarNumerosPositivos {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
   int numero;
   int positivos=0;
   do {
   System.out.println("Introduce un numero entero positivo o cero ");
   numero=Integer.parseInt(sc.nextLine());
   if(numero>0)
   {
     positivos++;
   }
   
   }while(numero>=0);
   positivos++;
   System.out.println("Has introducido "+ positivos+" numeros positivos");

  }

}
