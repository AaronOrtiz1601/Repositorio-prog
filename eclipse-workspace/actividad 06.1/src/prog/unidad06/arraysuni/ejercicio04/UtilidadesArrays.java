package prog.unidad06.arraysuni.ejercicio04;
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
  public static int  getMinimoArrayEntero (int [] array)
  {
    int minimo = 2147483647;
    try {
    if (array.length == 0)
    {
      throw new IllegalArgumentException();
    }
    
    for (int i = 0 ; i < array.length ; i ++)
    {
      if ( minimo > array[i])
      {
        minimo = array [i];
      }
    }
  }catch (NullPointerException e)
  {
    throw new IllegalArgumentException();
  }
  
    return minimo;
  }
  public static int  getMaximoArrayEntero (int [] array)
  {
    
    int maximo = -2147483647;
    try
    {
    if (array.length == 0)
    {
      throw new IllegalArgumentException();
    }
    
    for (int i = 0 ; i < array.length ; i ++)
    {
      if ( maximo < array[i])
      {
        maximo = array [i];
      }
    }
    }catch (NullPointerException e)
    {
      throw new IllegalArgumentException();
    }
    return maximo;
  }
  public static int enteroApareceEnArrayEntero (int [] array,int valor)
  {
    int contador = 0;
    if (array == null)
    {
      contador = 0;
    }else if (array.length == 0)
    {
      contador = 0;
    }else {
    
    for (int i = 0 ; i < array.length ; i ++)
    {
      if ( valor == array[i])
      {
        contador++;
      }
    }
    }
  
  
    return contador;
  }

}
