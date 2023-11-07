package prog.unidad03.repeticion;

import java.util.Scanner;

public class MayorMenorMediaApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int repeticion;
    double numeros;
    double mayor=0;
    double menor=0;
    double media=0;
    System.out.println("¿Cuantos numeros deseas introducir?");
    repeticion=Integer.parseInt(sc.nextLine());
    for(int i=0;i!=repeticion;i++)
    {
      
     System.out.println("Introduce el numero "+(i+1)); 
     numeros=Double.parseDouble(sc.nextLine());
     media=media+numeros;
     if(mayor==0)
     {
       mayor=numeros;
     }else if(mayor<numeros)
     {
       mayor=numeros;
     }
     if (menor==0) {
       menor=numeros;
      
    }else if(numeros<menor)
    {
     menor=numeros;
     
    }
    }
    System.out.println("El numero mayor es "+mayor);
    System.out.println("El numero menor es "+menor);
    System.out.println("La media de los numeros es "+(media/repeticion));

  }
}



