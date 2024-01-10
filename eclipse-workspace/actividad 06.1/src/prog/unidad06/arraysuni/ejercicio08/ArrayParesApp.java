package prog.unidad06.arraysuni.ejercicio08;

public class ArrayParesApp {

  public static void main(String[] args) {
    int [] array = new int [20];
    int contador = 0;
    int numeros = 2;
    do
      if (numeros % 2 == 0)
      {
        array [contador] = numeros;
        contador ++;
        numeros++;
        System.out.println(array[contador]);
      }while (contador !=20);
    }

  }


