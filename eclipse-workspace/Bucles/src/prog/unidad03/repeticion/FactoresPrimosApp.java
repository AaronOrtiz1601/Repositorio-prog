package prog.unidad03.repeticion;

import java.util.Scanner;

public class FactoresPrimosApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int numero;
    System.out.println("Introduce un numero entero mayor que 1 para descomponerlo es factores primos");
    numero=Integer.parseInt(sc.nextLine());
   
    for(int i = 1; i<=numero;i++){

      if(numero % i == 0) {
        int contador = 0;
        for(int j = 1; j <= i; j++){

          if ( i % j == 0) 
            {
            contador++;
            
            }
            }

          if (contador == 2) 
          {
            System.out.println( "El número "+ i +" es factor primo");
            contador=0;
          }
         }
      }
    }
    }
   
   
          
        
       
      
    
  

      
    

  


