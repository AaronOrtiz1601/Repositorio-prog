package prog.unidad06.arraysuni.ejercicio10;

import java.util.Scanner;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays;

public class BuscarYRemplazarApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in); 
    int [] array =  UtilidadesArrays.generaArrayEnteroAleatorio(30, 0, 20);
    int sustituir;
    int sustituto;
    for (int i = 0 ; i < array.length;i++) {
     
      System.out.print(array[i]+ " ");
      if (i == 29)
      {
        System.out.println("");
      }
     
      
    }
    System.out.println("Dime el valor a sustituir");
    sustituir = Integer.parseInt(sc.nextLine());
    System.out.println("Dime el valor sustituto");
    sustituto = Integer.parseInt(sc.nextLine());
    
    for ( int i = 0; i<array.length;i++)
    {
      if (array[i]!= sustituir)
      {
      System.out.print(array[i] + " ");
      }else
      {
        array[i] = sustituto;
        System.out.print("'"+array[i]+"' ");
      }
    }
  }

}
