package prog.unidad03.repeticion;

import java.util.Scanner;

public class MediaPositivosApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int numero;
    double media=0;
    int contador=0;
    do {
    System.out.println("Introduce un numero postivo 0 cuenta  ");
    numero=Integer.parseInt(sc.nextLine());
    if(numero>0)
    {
      media=numero+media;
      contador++;
    }
    
    }while(numero>=0);
    if(contador>0)
      {
    System.out.println("La media de los "+ contador+" numeros introduciddos es "+(media/contador));
      }else 
      {
        System.out.println("Como no has introducido ningun numero valido, la media es 0");
      }

  }

}
