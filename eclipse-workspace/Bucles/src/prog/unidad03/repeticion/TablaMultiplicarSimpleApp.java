package prog.unidad03.repeticion;

import java.util.Scanner;

public class TablaMultiplicarSimpleApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int numero;
    System.out.println("Dime el numero del que quieras saber su tabla de multiplicar");
    numero=Integer.parseInt(sc.nextLine());
    for(int i=0;i<10;i++)
    {
      System.out.println("Tabla del "+numero);
      System.out.println(i+1 +"*"+numero+"="+((i+1)*numero));
    }

  }

}
