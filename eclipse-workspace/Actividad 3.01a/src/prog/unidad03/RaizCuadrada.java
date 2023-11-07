package prog.unidad03;

import java.util.Scanner;

public class RaizCuadrada {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double a;
    double b;
    double c;
    double raizPos;
    double raizNeg;
    double raiz;
    System.out.println("Una Ec.de segundo grado tiene esta forma= ax^2+bx+c=0");
    System.out.println("Dime la parte a de tu ec de segundo grado");
    a=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la parte b de tu ec de segundo grado");
    b=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la parte c de tu ec de segundo grado");
    c=Double.parseDouble(sc.nextLine());
    raiz=Math.sqrt(((b*b)-4*a*c));
    raizPos=(-b+raiz)/(2*a);
    raizNeg=(-b-raiz)/(2*a);
    
    
    if (raiz>=0) {
      System.out.println("El resultado positivo de la raiz es "+ raizPos);
      System.out.println("El resultado negativo de la raiz es "+raizNeg);
      
    }else {
      System.out.println("No tiene solución ");
      
    
  
    }
    
    

  }




}
