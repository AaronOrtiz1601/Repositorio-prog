import java.util.Scanner;

public class PorcentajeInversion {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double inversor1;
    double inversor2;
    double inversor3;
    double inversionTotal;
    System.out.println("Dime cuanto dinero ha invertido el inversor 1");
    inversor1=Double.parseDouble(sc.nextLine());
    System.out.println("Dime cuanto dinero ha invertido el inversor 2");
    inversor2=Double.parseDouble(sc.nextLine());
    System.out.println("Dime cuanto dinero ha invertido el inversor 3");
    inversor3=Double.parseDouble(sc.nextLine());
    inversionTotal=inversor1+inversor2+inversor3;
    System.out.println("El porcentaje de inversion del 1 es "+(inversor1*100/inversionTotal)+"%");
    System.out.println("El porcentaje de inversion del 2 es "+(inversor2*100/inversionTotal)+"%");
    System.out.println("El porcentaje de inversion del 3 es "+(inversor3*100/inversionTotal)+"%");
    

  }

}
