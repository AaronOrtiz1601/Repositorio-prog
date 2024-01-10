package prog.unidad06.arraysuni.ejercicio01;
import java.util.Iterator;
import java.util.Scanner;
public class Array8App {

  public static void main(String[] args) {
    int numerosMayores50 = 0;
    double mediaArrayEntre10Y30 = 0;
    int numerosParaMedia = 0;
    Scanner sc = new Scanner(System.in);
    double[] numeros = new double [8];
    for (int i = 0;i < numeros.length;i++)
    {
      System.out.println("Introduce el numero "+ ( i + 1)+ ":");
      numeros[i] = Double.parseDouble(sc.nextLine());
    }
    //suma
    double suma = 0;
    for (double numero : numeros) {
      suma += numero;
      
    }
   
    // Calculamos la suma de los elementos mayores que 36
   double sumaMayores36 = 0;
    for ( double numero: numeros)
    {
      if ( numero > 36)
      {
        sumaMayores36 += numero;
      }
    }
    for (int i = 0;i < numeros.length;i++)
    {
      if (numeros[i] > 50 )
      {
        numerosMayores50 ++; 
      }
    }
    for (int i = 0;i < numeros.length;i++)
    {
      if (numeros[i] >= 10 && numeros[i] <= 30 )
      {
        mediaArrayEntre10Y30 = mediaArrayEntre10Y30 + numeros[i];
        numerosParaMedia ++;
      }
    }
    
    System.out.println("La suma total vale: " + suma);
    System.out.println("La suma total de los numeros mayores de 36 es: " + sumaMayores36);
    System.out.println("Hay " + numerosMayores50 +" numeros mas grandes de 50" );
    System.out.println("La media de los numeros entre 10 y 30 es de " + (mediaArrayEntre10Y30/numerosParaMedia));
    
  }

}
