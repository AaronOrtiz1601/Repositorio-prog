package prog.unidad03.repeticion;

import java.util.Scanner;

public class DetectorPrimosApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int primo;
    int contador=0;
    System.out.println("Dime un numero entero mayor que 1 y te dire si es primo");
    do
    {
      primo=Integer.parseInt(sc.nextLine());
      if (primo<1) {
        System.out.println("El numero que has introducido no sirve,vuelve a introducirlo");
        
      }
    }while(primo<1);
    for(int i=0;i<primo;i++)
    {
      if(primo%(i+1)==0)
      {
        contador++;
      }
    }
    if(contador==2)
    {
      System.out.println("El numero introducido es primo ");
    }else
    {
      System.out.println("El numero introducido no es primo ");

    }
    

  }

}

