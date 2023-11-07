package prog.unidad03;

import java.util.Scanner;

public class Calculadora {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double resultado=0;
    double numero1;
    double numero2;
    System.out.println("Introduce la operación que quieras realizar (S para la suma,R para la resta,P para el producto y D para la división ");
    char opcion= sc.nextLine().charAt(0);
    switch(opcion) {
    case  'S':
      System.out.println("Dame el primer numero");
      numero1=Double.parseDouble(sc.nextLine());
      System.out.println("Dime el segundo numero ");
      numero2=Double.parseDouble(sc.nextLine());
      resultado=numero1+numero2;
      break;
    case 'R':
      System.out.println("Dame el primer numero");
      numero1=Double.parseDouble(sc.nextLine());
      System.out.println("Dime el segundo numero ");
      numero2=Double.parseDouble(sc.nextLine());
      resultado=numero1-numero2;
      break;
    case 'P':
      System.out.println("Dame el primer numero");
      numero1=Double.parseDouble(sc.nextLine());
      System.out.println("Dime el segundo numero ");
      numero2=Double.parseDouble(sc.nextLine());
      resultado=numero1*numero2;
      break;
    case 'D':
      System.out.println("Dame el primer numero");
      numero1=Double.parseDouble(sc.nextLine());
      System.out.println("Dime el segundo numero ");
      numero2=Double.parseDouble(sc.nextLine());
      resultado=numero1/numero2;
      break;
      default:
        System.out.println("Error;Prueba de nuevo");
        break;
      
      
      
      
     
    }
    
    
    System.out.println("El resultado de la operación es "+resultado);
  
  }

}
