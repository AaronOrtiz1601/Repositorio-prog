package prog.unidad06.arraysuni.ejercicio05;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays;

public class ProcesaAleatoriosApp {

  public static void main(String[] args) {
    int [] array =  UtilidadesArrays.generaArrayEnteroAleatorio(150, 1, 300);
    System.out.println("El numero mas grande del array es "+UtilidadesArrays.getMaximoArrayEntero(array));
    System.out.println("El numero mas pequeño del array es "+UtilidadesArrays.getMinimoArrayEntero(array));
    System.out.println("El numero mas grande del array se repite en este "+ UtilidadesArrays.enteroApareceEnArrayEntero(array,UtilidadesArrays.getMaximoArrayEntero(array) ));
    System.out.println("El numero mas pequeño del array se repite en este "+ UtilidadesArrays.enteroApareceEnArrayEntero(array,UtilidadesArrays.getMinimoArrayEntero(array) ));
  }

}
