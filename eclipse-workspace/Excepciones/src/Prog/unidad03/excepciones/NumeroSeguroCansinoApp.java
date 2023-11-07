package Prog.unidad03.excepciones;

import java.util.Scanner;

public class NumeroSeguroCansinoApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int n1;
    
    boolean condion=true;
    do
    {
    try
    {
    System.out.println("Dime un numero");
    n1=Integer.parseInt(sc.nextLine());
    condion=false;
    } catch(java.lang.NumberFormatException e) {
      System.out.println("Eso no es un numero");
      condion=true;
    }
    }while(condion);

  }

}
