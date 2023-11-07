import java.util.Scanner;

public class MediaDeseada {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double notaAnterior;
    double mediaDeseada;
    System.out.println("Dime tu nota del examen anterior ");
    notaAnterior=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la media que deseas sacar ");
    mediaDeseada=Double.parseDouble(sc.nextLine());
    System.out.println("Para sacar esa media, necesitas sacar en el segundo examen un "+((mediaDeseada* 2) -notaAnterior));
    
    
    
   

  }

}
