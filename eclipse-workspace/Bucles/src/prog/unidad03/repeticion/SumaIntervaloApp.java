package prog.unidad03.repeticion;

import java.util.Scanner;

public class SumaIntervaloApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int intervaloInic;
    int intervaloFin;
    int suma=0;
    System.out.println("Introduce el inicio del intervalo");
    intervaloInic=Integer.parseInt(sc.nextLine());
    do 
    {
      System.out.println("Introduce el fin del intervalo(este deber ser mayor o igual que el inicio");
      intervaloFin=Integer.parseInt(sc.nextLine());
      if(intervaloFin<intervaloInic)
      {
        System.out.println("Error, el intervalo fin debe ser mayor o igual que el inttervalo inicio)");
      }
    }while(intervaloFin<intervaloInic);
    for(int i=intervaloInic;i<=intervaloFin;i++)
    {
      suma=i+suma;
    }
    System.out.println("La suma es "+suma);

  }

}
