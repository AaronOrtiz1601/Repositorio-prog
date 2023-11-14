// Realiza un programa que calcule el precio de unas entradas de cine en función
//del número de personas y del día de la semana. El precio base de una entrada
//son 8 euros. El miércoles (día del espectador), el precio base es de 5 euros. Los
//jueves son el día de la pareja, por lo que la entrada para dos cuesta 11 euros.
//Con la tarjeta CineCampa se obtiene un 10% de descuento. Si un jueves, un
//grupo de 6 personas compran entradas, el precio total sería de 33 euros ya
//que son 3 parejas; pero si es un grupo de 7, pagarán 3 entradas de pareja más
//1 individual que son 41 euros (33 + 8).

import java.util.Scanner;

public class EntradasDeCineApp {
  

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    final double DESCUENTO= 1-0.1;
    char dia;
    int numeroEntradas;
    int coste;
   char tarjeta;
   int entradaSuelta;
    boolean condicion=false;
    System.out.println("Introduce el dia de la semana que vas a ir al cine, usa la primera letra del día para ello(ejemplo=Lunes-L)");
    System.out.println("Recordatorio, Miercoles se expresara con una X para que no se repita la M con Martes");
    do
    {
      dia=sc.nextLine().charAt(0);
      switch(dia) {
      case 'L':
        System.out.println("¿Cuantas entradas quieres?");
        numeroEntradas=Integer.parseInt(sc.nextLine());
        coste= numeroEntradas * 8;
        System.out.println("¿Tienes la tarjeta CineCampa (S para si y N para no)?");
        
        tarjeta=sc.nextLine().charAt(0);
        
        if(tarjeta=='S')
        {
         System.out.println("El precio de tus entradas es de "+ coste*DESCUENTO );
        }
        else if (tarjeta=='N')
        {
          System.out.println("El precio de tus entradas es de "+ coste +" Euros" );
        }
        
        condicion=true;
        break;
      case 'M':
        System.out.println("¿Cuantas entradas quieres?");
        numeroEntradas=Integer.parseInt(sc.nextLine());
        coste= numeroEntradas * 8;
        System.out.println("¿Tienes la tarjeta CineCampa (S para si y N para no)?");
        
        tarjeta=sc.nextLine().charAt(0);
        
        if(tarjeta=='S')
        {
         System.out.println("El precio de tus entradas es de "+ coste*DESCUENTO );
        }
        else if (tarjeta=='N')
        {
          System.out.println("El precio de tus entradas es de "+ coste +" Euros" );
        }
        condicion=true;
        break;
      case 'X':
        System.out.println("¿Cuantas entradas quieres?");
        numeroEntradas=Integer.parseInt(sc.nextLine());
        coste= numeroEntradas * 5;
        System.out.println("¿Tienes la tarjeta CineCampa (S para si y N para no)?");
        
        tarjeta=sc.nextLine().charAt(0);
        
        if(tarjeta=='S')
        {
         System.out.println("El precio de tus entradas es de "+ coste*DESCUENTO );
        }
        else if (tarjeta=='N')
        {
          System.out.println("El precio de tus entradas es de "+ coste +" Euros" );
        }
        condicion=true;
        break;
      case 'J':
        System.out.println("¿Cuantas entradas quieres?");
        numeroEntradas=Integer.parseInt(sc.nextLine());
        if(numeroEntradas%2==0)
        {
          numeroEntradas=numeroEntradas/2;
          coste=numeroEntradas*11;
        }
        else {
          if(numeroEntradas==1)
          {
            coste=8;
          }
          else
          {
            entradaSuelta=numeroEntradas-(numeroEntradas-1);
            numeroEntradas=numeroEntradas/2;
          coste=numeroEntradas*11+8;
          }
        }
System.out.println("¿Tienes la tarjeta CineCampa (S para si y N para no)?");
        
        tarjeta=sc.nextLine().charAt(0);
        
        if(tarjeta=='S')
        {
         System.out.println("El precio de tus entradas es de "+ coste*DESCUENTO );
        }
        else if (tarjeta=='N')
        {
          System.out.println("El precio de tus entradas es de "+ coste +" Euros" );
        }
        condicion=true;
        break;
      case 'V':
        System.out.println("¿Cuantas entradas quieres?");
        numeroEntradas=Integer.parseInt(sc.nextLine());
        coste= numeroEntradas * 8;
        System.out.println("¿Tienes la tarjeta CineCampa (S para si y N para no)?");
        
        tarjeta=sc.nextLine().charAt(0);
        
        if(tarjeta=='S')
        {
         System.out.println("El precio de tus entradas es de "+ coste*DESCUENTO );
        }
        else if (tarjeta=='N')
        {
          System.out.println("El precio de tus entradas es de "+ coste +" Euros" );
        }
        condicion=true;
        break;
      case 'S':
        System.out.println("¿Cuantas entradas quieres?");
        numeroEntradas=Integer.parseInt(sc.nextLine());
        coste= numeroEntradas * 8;
        System.out.println("¿Tienes la tarjeta CineCampa (S para si y N para no)?");
        tarjeta=sc.nextLine().charAt(0);
        
        if(tarjeta=='S')
        {
         System.out.println("El precio de tus entradas es de "+ coste*DESCUENTO );
        }
        else if (tarjeta=='N')
        {
          System.out.println("El precio de tus entradas es de "+ coste +" Euros" );
        }
        break;
      case 'D':
        System.out.println("¿Cuantas entradas quieres?");
        numeroEntradas=Integer.parseInt(sc.nextLine());
        coste= numeroEntradas * 8;
        System.out.println("¿Tienes la tarjeta CineCampa (S para si y N para no)?");
        
        tarjeta=sc.nextLine().charAt(0);
        
        if(tarjeta=='S')
        {
         System.out.println("El precio de tus entradas es de "+ coste*DESCUENTO );
        }
        else if (tarjeta=='N')
        {
          System.out.println("El precio de tus entradas es de "+ coste +" Euros" );
        }
        condicion=true;
        break;
        
        default:
          System.out.println("Lo que has introducido no es un día valido, prueba de nuevo ");
          break;
        
      }
    
      
    }while(condicion!=true);
  }

}
// si lo hago con string usar string.toUpperCase().equals("condicion")