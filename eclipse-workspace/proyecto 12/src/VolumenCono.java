import java.util.Scanner;

public class VolumenCono {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double radio;
    double altura;
    final double FORMULA=1.046666666666667;
    System.out.println("Dime el radio del cono");
    radio=Double.parseDouble(sc.nextLine());
    radio=radio*radio;
    System.out.println("Dime la altura del cono");
    altura=Double.parseDouble(sc.nextLine());
    System.out.println("El volumen del cono es = "+((FORMULA*radio)*altura));
    
   

  }

}