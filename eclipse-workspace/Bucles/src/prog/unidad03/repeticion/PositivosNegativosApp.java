package prog.unidad03.repeticion;

import java.util.Scanner;

public class PositivosNegativosApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
   int numero;
   do {
   System.out.println("Introduce un numero y te dire si el numero es positivo o negativo(0 para terminar) ");
   numero=Integer.parseInt(sc.nextLine());
   if(numero>0)
   {
     System.out.println("El numero "+numero+" es positivo");
   }else if (numero<0)
   {
     System.out.println("El numero "+numero+" es negativo");
   }
   
   }while(numero!=0);
  }

}
