import java.util.Scanner;

public class NotaEvaluacion {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double unidad1;
    double unidad2;
    double unidad3;
    double computo;
    double examenFinal;
    double trabajoExp;
    System.out.println("Dime la nota que sacaste en la unidad 1");
    unidad1=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la nota que sacaste en la unidad 2");
    unidad2=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la nota que sacaste en la unidad 3");
    unidad3=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la nota que sacaste en el examen final");
    examenFinal=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la nota que sacaste en el trabajo expuesto");
    trabajoExp=Double.parseDouble(sc.nextLine());
    computo=(unidad1+unidad2+unidad3)/3;
    computo=computo*55/100;
    examenFinal=examenFinal*30/100;
    trabajoExp=trabajoExp*15/100;
    System.out.println("Tu nota de la evaluación es "+((computo+examenFinal+trabajoExp)));
    
    
  }

}
