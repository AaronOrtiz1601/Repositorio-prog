package prog.unidad06.mapas.ejercicio05;
import java.util.Scanner;
import java.util.Set;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
public class CalculaModaApp {
      public static void main(String[] args) {
          Scanner sc = new Scanner(System.in);
            int contador = 0;
            
          Map<Integer, Integer> frecuencias = new HashMap<>();
          
          System.out.print("Ingrese la cantidad de números a generar: ");
           int cantidadNumeros = Integer.parseInt(sc.nextLine());

        
          System.out.print("Ingrese el valor mínimo del intervalo: ");
          int valorMinimo = Integer.parseInt(sc.nextLine());

          
          System.out.print("Ingrese el valor máximo del intervalo: ");
          int valorMaximo = Integer.parseInt(sc.nextLine());

          
          if (valorMinimo >= valorMaximo) {
              System.out.println("Error: El valor mínimo debe ser menor que el valor máximo.");
              return;
          }

         
          Random random = new Random();

         int[] serie = new int [cantidadNumeros];
          System.out.println("Números aleatorios generados:");

          for (int i = 0; i < cantidadNumeros; i++) {
              int numeroAleatorio = random.nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;
              System.out.print(numeroAleatorio+",");
               serie [i] = numeroAleatorio;
              
          }
         
          for (int valor :serie)
          {
         
            int frecuencia = frecuencias.getOrDefault(valor, 0);
            frecuencia++;
            frecuencias.put(valor, frecuencia);
          }
          int moda = 0;
          int frecuenciaModa = 0;
          boolean modaIniciada = false;
          for (int valor: frecuencias.keySet()) {

            int frecuencia = frecuencias.get(valor);
            if (!modaIniciada || frecuencia > frecuenciaModa) {
              moda = valor;
              frecuenciaModa = frecuencia;
              modaIniciada = true;
            }
          }
          System.out.println("La moda de la serie es " + moda + " y aparece " + frecuenciaModa + " veces en la serie");

          
  }


}
