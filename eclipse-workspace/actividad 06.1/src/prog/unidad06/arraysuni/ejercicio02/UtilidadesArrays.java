package prog.unidad06.arraysuni.ejercicio02;
import java.util.Random;
public class UtilidadesArrays { 
  public static int[] generaArrayEnteroAleatorio(int longitud, int valorMinimo , int valorMaximo)
  {
   if (longitud < 1)
   {
     throw new IllegalArgumentException();
   }
  
   if ( valorMinimo > valorMaximo)
   {
     throw new IllegalArgumentException();
   }
    int[] array = new int [longitud];
    for (int i = 0 ; i < array.length ; i++)
    { 
     int numero = new Random().nextInt(valorMaximo - valorMinimo + 1) + valorMinimo;
      array[i] = numero;
    }
    return array ;
  }

}
