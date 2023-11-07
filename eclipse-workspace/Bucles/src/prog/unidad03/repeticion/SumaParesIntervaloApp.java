package prog.unidad03.repeticion;

import java.util.Scanner;

public class SumaParesIntervaloApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int intervaloInic;
    int intervaloFin;
    int suma=0;
    System.out.println("Introduce el inicio del intervalo");
    intervaloInic=Integer.parseInt(sc.nextLine());
    do 
    {
      System.out.println("Introduce el fin del intervalo(este deber ser mayor inicio");
      intervaloFin=Integer.parseInt(sc.nextLine());
      if(intervaloFin<intervaloInic)
      {
        System.out.println("Error, el intervalo fin debe ser mayor o igual que el inttervalo inicio)");
      }
    }while(intervaloFin<intervaloInic);
    for(int i=intervaloInic;i<=intervaloFin;i++)
    {
      if(i%2==0)
      {
      suma=i+suma;
    }
    

  }
    System.out.println("La suma de los numeros pares es "+suma);
  }

}
