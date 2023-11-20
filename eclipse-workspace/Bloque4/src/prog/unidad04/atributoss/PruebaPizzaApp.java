package prog.unidad04.atributoss;

import java.util.Scanner;

public class PruebaPizzaApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int numeroPizzas;
    String tipo;
    System.out.println("Dime cuantas pizzas quieres");
    numeroPizzas=Integer.parseInt(sc.nextLine());
    for(int i=0;i<numeroPizzas;i++)
    {
      System.out.println("Introduce el tamaño de la pizza (mediana o grande) "+(i+1));
      Pizza pizza= new Pizza();
      pizza.tipo(tipo);
      
      
      
     
    }

  }

}
