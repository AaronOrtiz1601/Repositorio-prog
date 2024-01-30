package prog.unidad06.arraysmulti.ejercicio03;

import java.util.Scanner;
import prog.unidad06.arraysmulti.ejercicio02.TablaEnteraConTotales;

public class MiTablaConTotalesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    TablaEnteraConTotales tabla = new TablaEnteraConTotales(5, 6);
    for (int i = 0; i < 4; i++) { 
      for (int j = 0; j < 5; j++) { 
        int casilla = 0;
        System.out.println("Dime el valor de la posición" + "(" + i + "," + j + ")");
        if (j != 5)
          casilla = Integer.parseInt(sc.nextLine());
        else if (j == 6)
        {
          casilla = tabla.getTotalFila(i);
        } else if (i == 5)
        {
          casilla = tabla.getTotalColumna(j);
        }
        
        tabla.setCasilla(i, j, casilla);
      }
    }
    for (int i = 0; i < 5; i++) { 
      int contador = 0;
      for (int j = 0; j < 6; j++) { 
        contador ++;
        System.out.print(String.format("%5d",tabla.getCasilla(i, j)));
        if (contador ==6)
        {
          System.out.println("");
        }
      }
    }
  }
}