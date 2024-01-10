package prog.unidad06.arraysuni.ejercicio03;

import java.util.Scanner;

import prog.unidad06.arraysuni.ejercicio02.UtilidadesArrays;

public class BusquedaNotasApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int calificacionABuscar = 0;
    int longitud = 30 ;
    int limiteMax = 10;
    int limiteMin = 0 ; 
    int contadorDeAlumnos = 0;
    int contadorArray = 0;
    
   
    
    
    do {
      try
      {
        
      
      System.out.println("¿Que nota quieres buscar? ");
      calificacionABuscar = Integer.parseInt(sc.nextLine());
      if ( calificacionABuscar > 0)
      {
    for ( int numero : UtilidadesArrays.generaArrayEnteroAleatorio(longitud, limiteMin, limiteMax) ){
      if ( contadorArray == 30)
      {
        contadorDeAlumnos = 0;
      }
      if (calificacionABuscar == numero)
      {
        contadorDeAlumnos++;
      }
      contadorArray++;
      
    }
    System.out.println("Hay "+ contadorDeAlumnos +" con la nota buscada");
      }
      }catch ( IllegalArgumentException e) {
        System.out.println("Entrada incorrecta. Debe introducir un número entero entre 1 y 10 "); 
      }
  }while(calificacionABuscar >= 0);
  }

}
