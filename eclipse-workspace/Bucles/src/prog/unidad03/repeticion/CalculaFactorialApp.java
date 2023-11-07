package prog.unidad03.repeticion;

import java.util.Scanner;

public class CalculaFactorialApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int factorial;
    long calculo=1;
    System.out.println("Dime un numero entero mayor que 0 y te dire su factorial");
    do
    {
      factorial=Integer.parseInt(sc.nextLine());
      if (factorial<=0) {
        System.out.println("El numero que has introducido no sirve,vuelve a introducirlo");
        
      }
    }while(factorial<=0);
    for(int i=factorial;i>0;i--)
    {
      calculo=calculo*i;
    }
    System.out.println("El factorial vale "+calculo);

  }

}
