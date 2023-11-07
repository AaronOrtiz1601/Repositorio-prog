package prog.unidad03;

import java.util.Scanner;

public class AlumnoAprubaAPP {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double nota1;
    double nota2;
    double nota3;
    double media;
    System.out.println("Dime la nota de la primera evaluación");
    nota1=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la nota de la segunda evaluación");
    nota2=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la nota de la tercera evaluación");
    nota3=Double.parseDouble(sc.nextLine());
    media=(nota1+nota2+nota3)/3;
    if (media>=5) {
      System.out.println("El alumno a aprobado con una nota de "+media);
      
    }else {
      
    
      System.out.println("El alumno a suspendido con una nota de "+media);
    }
    
    

  }

}
