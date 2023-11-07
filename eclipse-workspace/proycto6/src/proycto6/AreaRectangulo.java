package proycto6;

import java.util.Scanner;

public class AreaRectangulo {
  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double ancho;
    double largo;
    System.out.println("Dime el ancho y el largo de un rectangulo y te dire su area ");
    ancho=Double.parseDouble(sc.nextLine());
    largo=Double.parseDouble(sc.nextLine());
    System.out.println("El area del rectangulo es "+(ancho*largo));
    
    
  }
  }
