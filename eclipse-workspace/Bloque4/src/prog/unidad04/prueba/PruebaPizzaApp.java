package prog.unidad04.prueba;

import java.util.Scanner;
import prog.unidad04.atributoss.*;

public class PruebaPizzaApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    System.out.println("Programa de manejo de pizzas");
    //pedimos el numero de pizzas
    System.out.println("Numero de pizzas");
    int numPizzas=Integer.parseInt(sc.nextLine());
    // si nos has dicho que hagamos alguna pizza
    if (numPizzas > 0) {
      // para cada pizza
      for(int i=0;i<=numPizzas;i++)
      {
      Pizza pizza = new Pizza();
      // solicitamos los datos
      System.out.println("Introduzca el tamaño de la pizza "+(i+1));
      pizza.size=sc.nextLine();
      System.out.println("introduce el tipo de la pizza");
      
      // si el tamaño no es correcto sacamos un mensaje
          if (!pizza.SIZE_MEDIANA.equals("mediana")||!pizza.SIZE_FAMILIAR.equals("familiar")) {
            System.out.println("El tamaño es incorrecto");
            
            
          }
          System.out.println("introduce el tipo de la pizza");
          pizza.tipo=sc.nextLine();
          if (!pizza.tipo.equals(pizza.TIPO_4QUESOS)||!pizza.tipo.equals(pizza.TIPO_MARGARITA)|| !pizza.tipo.equals(pizza.TIPO_FUNGHY)) {
            System.out.println("El tipo  es incorrecto");
            
            
          }
      }
    }
  }

}
