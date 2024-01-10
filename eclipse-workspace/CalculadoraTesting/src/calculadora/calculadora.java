package calculadora;

public class calculadora {
  
public static int suma ( int a,int b) {
  return a + b;
}
public static int resta ( int a,int b) {
  return a - b;
}
public static int multiplicar (int a, int b) {
  return a * b;
}
public static int dividir ( int a,int b ) {
  return a / b;
}
public static boolean esPositivo ( int a) {
  boolean prueba = false;
  if ( a > 0)
  {
    prueba = true;
  }
  return prueba;
}
public static boolean esPrimo ( int a)
{
  boolean prueba = false;
  int contador = 0;
  for (int i = 1; i <= a ; i++)
  {
    if (a % i == 0)
    {
      contador ++;
    }
  }
  if (contador == 2)
  {
    prueba = true;
  }
  return prueba;
  
}

}
