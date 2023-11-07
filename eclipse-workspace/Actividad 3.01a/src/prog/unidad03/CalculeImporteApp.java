package prog.unidad03;

import java.util.Scanner;

public class CalculeImporteApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double compra;
    System.out.println("Introduce el importe de la compra en euros");
    compra=Double.parseDouble(sc.nextLine());
    if (compra<100) {
      System.out.println("No se aplica ningun descuento");
      
    }else {
      System.out.print("La compra tiene un descuento del 20%");
      compra=compra*0.8;
      System.out.println("La cantidad a pagar es de "+compra);
    }

  }

}
