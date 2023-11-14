package prog.unidad03.examen;

import java.util.Scanner;

public class SuperEstadisticaApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    //Declaracin de variables
    int numero = 0;
    boolean condion=true;
    int contImpares=0;
    double media=0;
    System.out.println("EXAMEN DE AARÓN ORTIZ.MEDÍA NÚMEROS IMPARES");
    //Hago un bucle que se repetira hasta que el numero sea 0(que es la condicion de salida requerida)
    do
    {
     //Hago un bucle para que la excepcion se repita hasta que des un número entero valido 
    do
    {
      //Hago una excepcion para comprobar que el numero entero es valido 
    try
    {
    System.out.println("Dime un número entero");
    numero=Integer.parseInt(sc.nextLine());
    condion=false;
    } catch(java.lang.NumberFormatException e) {
      //mensaje por si el numero entero no es valido
      System.out.println("El dato introducido no es un número entero valido");
      condion=true;
    }
    }while(condion);
    //hago un if para asegurarme que el numero no es 0
    if (numero!=0) {
      // hago un if para comprobar si el numero es par o impar,dentro de este habra otro if que compruebe si el numero es positivo o negativo 
      if (numero%2==0) {
        //hago un if que comprueba si el numero par es positivo o negativo
        if (numero>0) {
          System.out.println("El numero "+numero+" es par y positivo");
            System.out.println("El numero"+numero+" no entra en la media ");
        }else 
        {
          System.out.println("El numero "+numero+" es par y negativo");
          System.out.println("El numero"+numero+" no entra en la media ");
        }
        
      }else
      {
        //hago un if que comprueba si el numero impar es positivo o negativo
        if (numero>0) {
          System.out.println("El numero "+numero+" es impar y positivo");
          //hago la comprobación de si el numero impar positivo puede entrar en la media
          if ((numero<20)&&(numero!=3)) {
            System.out.println("El número no entra en la media");
          } else if((numero>20)||(numero==3))
          {
            System.out.println("El número  entra en la media");
            contImpares++;
            media=media + numero;
          }
          
        }else 
        {
          System.out.println("El numero "+numero+" es impar y negativo");
        //hago la comprobación de si el numero impar negativo puede entrar en la media
          if((numero>=-11)&&(numero!=-1))
          {
            System.out.println("El número no entra en la media");
          }else if ((numero<=-11)||(numero==-1))
          {
            System.out.println("El número  entra en la media");
            contImpares++;
            media=media + numero;
            
          }
            
        }
      }
      
    }
    }while(numero!=0);
    //compruebo si el primero numero que introduce el usuario a sido 0, si es asi la media es 0
    if(contImpares==0)
    {
      System.out.println("La media vale 0");
    }else
    {
      //Muestro la media de los numeros impares validos
    System.out.println("La media vale "+(media / contImpares));
    }

  }

}
