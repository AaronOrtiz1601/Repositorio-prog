import java.util.Scanner;

public class Factura {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double baseImponible;
    double iva;
    System.out.println("Dime la base imponible");
    baseImponible=Double.parseDouble(sc.nextLine());
    System.out.println("Dime el iva");
    iva=Double.parseDouble(sc.nextLine());
    iva=iva/100+1;
    System.out.println("La factura es de "+(baseImponible*iva));

  }

}
