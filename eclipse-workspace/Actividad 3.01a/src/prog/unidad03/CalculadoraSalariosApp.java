package prog.unidad03;

import java.util.Scanner;

public class CalculadoraSalariosApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    int horas;
    int horasExtra;
    int salarioTotal;
    System.out.println("Introduce las horas trabajadas esta semana");
    horas=Integer.parseInt(sc.nextLine());
    if (horas>40) {
      horasExtra=horas-40;
      salarioTotal=40*16+horasExtra*16;
      System.out.println("El salario por trabajar 40 horas normales y "+horasExtra+" horas extra es de "+salarioTotal+" Euros");
    }else {
      salarioTotal=horas*16;
      System.out.println("El salario por trabajar "+horas+" horas es de "+salarioTotal +" Euros");
    }
  }

}
