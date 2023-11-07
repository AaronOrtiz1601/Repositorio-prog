package prog.unidad03;

import java.util.Scanner;

public class ClasificaTriangulosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
   double lado1;
    double lado2;
    double lado3;
   System.out.println("Programa clasificador de triangulos");
   System.out.println("Introduce la longitud del primer lado");
   lado1=Double.parseDouble(sc.nextLine());
   System.out.println("Introduce la longitud del segundo lado");
   lado2=Double.parseDouble(sc.nextLine());
   System.out.println("Introduce la longitud del tercer lado");
   lado3=Double.parseDouble(sc.nextLine());
   if ((lado1==lado2)&&(lado1==lado3)) {
     System.out.println("El tringulo es equilatero");
    
  }else if ((lado1!=lado2)&&(lado1==lado3)||(lado1==lado2)&&(lado1!=lado3)||(lado1!=lado2)&&(lado2==lado3)) {
    System.out.println("El trinagulo es isosceles");
    
  }else if ((lado1!=lado2)&&(lado1!=lado3)&&(lado2!=lado3)) {
    System.out.println("El trianguo es escaleno");
    
  }
   
   

  }

}
