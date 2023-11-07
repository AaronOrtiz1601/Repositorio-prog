package actividad204c;
import java.util.Scanner;
public class Cadenas {

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    System.out.println("Define la primera cadena de texto ");
    String cadena=sc.nextLine();
    System.out.println("Define la segunda cadena de texto ");
    String cadena2=sc.nextLine();
    System.out.println(cadena.length());
    System.out.println(cadena2.length());
    System.out.println(cadena.isBlank());
    System.out.println(cadena2.isBlank());
    System.out.println(cadena+" "+cadena2);
    System.out.println(cadena.equals(cadena2));
    System.out.println(cadena2.equalsIgnoreCase(cadena));
    System.out.println(cadena.compareTo(cadena2));
    System.out.println(cadena.compareToIgnoreCase(cadena2));
    System.out.println(cadena.contains(cadena2));
    System.out.println(cadena.startsWith(cadena2));
    System.out.println(cadena.endsWith(cadena2));
    System.out.println(cadena.charAt(0)+ " "+cadena.charAt(cadena.length()-1));
    System.out.println(cadena.substring(1));
    System.out.println(cadena.toUpperCase());
    System.out.println(cadena.toLowerCase());
    
    
    
    
  }

}