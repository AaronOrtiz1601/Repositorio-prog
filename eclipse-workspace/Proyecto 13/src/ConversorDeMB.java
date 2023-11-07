import java.util.Scanner;

public class ConversorDeMB {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double MB;
    final double CONVERSION=1000;
    System.out.println("Dime la cantidad de mb que quieres convertir a kb");
    MB=Double.parseDouble(sc.nextLine());
    System.out.println("Esa cantidad de MB es igual a "+(MB*CONVERSION)+(" KB"));
    
    

  }

}
