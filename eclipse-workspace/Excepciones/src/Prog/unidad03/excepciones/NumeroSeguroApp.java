package Prog.unidad03.excepciones;

import java.util.Scanner;

public class NumeroSeguroApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int n1;
    try
    {
    System.out.println("Dime un numero");
    n1=Integer.parseInt(sc.nextLine());
    } catch(java.lang.NumberFormatException e) {
      System.out.println("Eso no es un numero");
    }

  }

}
