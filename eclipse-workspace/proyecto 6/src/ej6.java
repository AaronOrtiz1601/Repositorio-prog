import java.util.Scanner;

public class ej6 {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double pesetas;
    final double PESETAS=166.386;
    System.out.println("Dime el numero se pesetas que quieras pasar a euros");
    pesetas=Double.parseDouble(sc.nextLine());
    System.out.println("Eso son "+(pesetas/PESETAS)+" euros");
    
    

  }

}
