package prog.unidad03.repeticion;

import java.util.Scanner;

public class NumerosCrecientesApp {

  public static void main(String[] args) {
    int numeros;
    int numeros2;
   
    Scanner sc=new Scanner (System.in);
    System.out.println("Introduce un numero entero");
    numeros=Integer.parseInt(sc.nextLine());
    do
   {
      
    System.out.println("Introduce ahora un numero mayor que "+numeros+"(Introduce un numero menor o igual para terminar)");
    numeros2=Integer.parseInt(sc.nextLine());
    if(numeros2>numeros)
    {
      numeros=numeros2-1;
     
    }
   
   }while(numeros2>numeros);
    System.out.println("Terminado");
  }

}
