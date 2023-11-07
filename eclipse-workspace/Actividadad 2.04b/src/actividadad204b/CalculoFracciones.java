package actividadad204b;
import java.util.Scanner;

import paquete1.Fraccion;
public class CalculoFracciones {

  public static void main(String[] args) {
    Scanner scan = new Scanner (System.in);
    int numerador;
    int denominador;
    //primera fraccion
    System.out.print("Dime el numerador de la fracción :");
    numerador=Integer.parseInt(scan.nextLine());
    System.out.print("Dime el numerador de la fracción :");
    denominador=Integer.parseInt(scan.nextLine());
    Fraccion fraccion1= new Fraccion(numerador,denominador);
    //segunda fraccion
    System.out.print("Dime el numerador de la fracción :");
    numerador=Integer.parseInt(scan.nextLine());
    System.out.print("Dime el numerador de la fracción :");
    denominador=Integer.parseInt(scan.nextLine());
    Fraccion fraccion2=new Fraccion(numerador,denominador);
    //mostrar las fraciones 
    System.out.println("La primera fraccion es:" + fraccion1.getNumerador()+"/"+fraccion1.getDenominador());
    System.out.println("La segunda fraccion es:" + fraccion2.getNumerador()+"/"+fraccion2.getDenominador());
    //suma
    Fraccion suma=fraccion1.suma(fraccion2);
    System.out.println("La suma de las fracciones es "+suma.getNumerador()+"/"+suma.getDenominador());
   //resta de fracciones
    Fraccion resta=fraccion1.resta(fraccion2);
    System.out.println("La resta de las fracciones es "+resta.getNumerador()+"/"+resta.getDenominador());
    //producto de fracciones
    Fraccion producto=fraccion1.producto(fraccion2);
    System.out.println("La multiplicacion de las fracciones es "+producto.getNumerador()+"/"+producto.getDenominador());
    //division de fracciones
    Fraccion division=fraccion1.division(fraccion2);
    System.out.println("La division de las fracciones es "+division.getNumerador()+"/"+division.getDenominador());
    //ahora paso los datos de las operaciones a variables para poder dar ese valor a los objetos de la clase 2
    numerador=suma.getNumerador();
     denominador=suma.getDenominador();
     paquete2.Fraccion suma3=new paquete2.Fraccion(numerador,denominador).simplifica();
     //paquete2.Fraccion suma3= suma2.simplifica();
     //muestro la suma simplificada
     System.out.println("La suma simplificada es "+suma3.getNum()+"/"+suma3.getDen());
     numerador=resta.getNumerador();
     denominador=resta.getDenominador();
     paquete2.Fraccion resta2=new paquete2.Fraccion(numerador,denominador);
     paquete2.Fraccion resta3= resta2.simplifica();
   //muestro la resta simplificada
     System.out.println("La resta simplificada es "+resta3.getNum()+"/"+resta3.getDen());
     numerador=producto.getNumerador();
     denominador=producto.getDenominador();
     paquete2.Fraccion pro2=new paquete2.Fraccion(numerador,denominador);
     paquete2.Fraccion pro3= pro2.simplifica();
   //muestro el producto simplificada
     System.out.println("La multiplicacion simplificada es "+pro3.getNum()+"/"+pro3.getDen());
     numerador=division.getNumerador();
     denominador=division.getDenominador();
     paquete2.Fraccion div2=new paquete2.Fraccion(numerador,denominador);
     paquete2.Fraccion div3= div2.simplifica();
   //muestro la división simplificada
     System.out.println("La division simplificada es "+div3.getNum()+"/"+div3.getDen());
    

  }

}
