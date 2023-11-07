package prog.unidad03.repeticion;
import java.util.Scanner;
public class CuentaParesImparesApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int numeros;
    int numero2;
    int par=0;
    int impar=0;
    System.out.println("Dime cuantos numeros quieres introducir");
    numeros=Integer.parseInt(sc.nextLine());
    for(int i=0;i!=numeros;i++)
    {
    System.out.println("Introduce el numero "+(i+1));
    numero2=Integer.parseInt(sc.nextLine());
    if (numero2%2==0)
    {
      System.out.println("El numero " + numero2 +" es par");
      par++;
      
    }else {
      System.out.println("El numero " + numero2 +" es impar");
      impar++;
      
    }

  }
    System.out.println("Se han introducido "+ par+" numeros pares y "+impar+ " numeros impares");

    
}
}
