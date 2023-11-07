import java.util.Scanner;

public class ej5 {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc = new Scanner (System.in);
    int numero;
    int numero2;
    System.out.println(" Dame dos numeros enteros y yo te dire su +,-,*,/,%");
    numero=Integer.parseInt(sc.nextLine());
    numero2=Integer.parseInt(sc.nextLine());
    System.out.println(" Su suma es= "+(numero + numero2));
    System.out.println(" Su resta es= "+(numero - numero2));
    System.out.println(" Su producto es= "+(numero * numero2));
    System.out.println(" Su cociente es= "+(numero / numero2));
    System.out.println(" Su resto es= "+(numero % numero2));
    
  }

}
