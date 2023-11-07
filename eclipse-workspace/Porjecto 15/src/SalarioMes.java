import java.util.Scanner;

public class SalarioMes {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double venta1;
    double venta2;
    double venta3;
    double ventaTotal;
    double salarioBase;
    final double COMISION=10;
    System.out.println("Dime tu salario base");
    salarioBase=Double.parseDouble(sc.nextLine());
    System.out.println("Dime el precio de tu primera venta del mes");
    venta1=Double.parseDouble(sc.nextLine());
    System.out.println("Dime el precio de tu segunda venta del mes");
    venta2=Double.parseDouble(sc.nextLine());
    System.out.println("Dime el precio de tu tercera venta del mes");
    venta3=Double.parseDouble(sc.nextLine());
    ventaTotal=venta1+venta2+venta3;
    System.out.println("Tu sueldo al final del mes sumandole el 10% de la venta es de "+(salarioBase+ventaTotal/10));
    
    

  }

}
