import java.util.Scanner;

public class SalarioTrabajador {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double horasTrabajadas;
    final int DINEROPORHORAS=12;
    System.out.println("Dime cuantas horas trabajas al dia");
    horasTrabajadas=Double.parseDouble(sc.nextLine());
    System.out.println("Tu sueldo a la semana es de "+(horasTrabajadas*DINEROPORHORAS)+ (" euros a la semana"));

  }

}
