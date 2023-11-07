package prog.unidad03;
import java.util.Scanner;
public class SituacionAlumnoApp {

  public static void main(String[] args) {
    Scanner sc= new Scanner(System.in);
    double mates;
    double lengua;
    System.out.println("Dime la calificación que has sacado en Matematicas");
    mates=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la calificación que has sacado en Lengua");
    lengua=Double.parseDouble(sc.nextLine());
    
    if ((mates<5)&&(lengua<5) ){
      System.out.println("El alumno debe repetir");
      
    }else if (((mates>=5)&&(lengua<5))||((mates<5)&&(lengua>=5))) {
      System.out.println("Pasa con asignaturas pendientes");
      
    }else if ((mates>=5)&&(lengua>=5)) {
      System.out.println("El alumno pasa limpio");
      
    }

  }

}
