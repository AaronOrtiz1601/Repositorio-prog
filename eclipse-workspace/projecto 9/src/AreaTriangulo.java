import java.util.Scanner;

public class AreaTriangulo {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double base;
    double altura;
    System.out.println("Dime la longitud de la base del triangulo");
    base=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la longitud de la altura del triangulo");
    altura=Double.parseDouble(sc.nextLine());
    System.out.println("El area del triangulo es de "+(base*altura/2));
    
    
    

  }

}
