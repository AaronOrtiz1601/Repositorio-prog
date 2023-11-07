import java.util.Scanner; 

public class convertidor {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double euros;
   System.out.println("Dime el numero de euros que quieres pasar a pesetas");
   euros=Double.parseDouble(sc.nextLine());
   System.out.println("Tienes "+(euros*166.386) + " pesetas ");
   

  }

}
