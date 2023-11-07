package prog.unidad03.repeticion;

import java.util.Scanner;

public class CuentaParesApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int rep;
    int numeros;
    int par=0;
    
    System.out.println("¿Cuantos numeros pares quieres introducir?");
    rep=Integer.parseInt(sc.nextLine());
    do
      
    {
     
    for( int i=par;i!=rep;i++)
    {
      
      System.out.println("Introduce el numero "+(i+1)); 
      numeros=Integer.parseInt(sc.nextLine());
      if(numeros%2==0){
        par++;
        
      }
    
    }
   if(par<rep)
   {
     System.out.println("Te queda " +(rep-par)+" numeros por introducir");
   }else 
   {
     System.out.println("Has introducido ya todos los numeros pares");
   }
    }while(par==rep);

  }

}
