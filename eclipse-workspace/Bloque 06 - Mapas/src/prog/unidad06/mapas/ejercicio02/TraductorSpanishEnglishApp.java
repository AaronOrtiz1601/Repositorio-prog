package prog.unidad06.mapas.ejercicio02;

import java.util.Scanner;

import prog.unidad06.mapas.ejercicio01.DiccionarioSpanishEnglish;

public class TraductorSpanishEnglishApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    String palabra;
    System.out.println("TRADUCCIÓN ESPAÑOL - INGLÉS");
    do
    {
    System.out.println("Introduzca una palabra a traducir al inglés (vacía para terminar):");
    palabra = sc.nextLine();
    DiccionarioSpanishEnglish diccionario = new DiccionarioSpanishEnglish();
    try
    {
    if (!diccionario.traducir(palabra).equals(null))
    {
    System.out.println("La palabra española " + "''"+palabra+"''" + "significa " + "''"+diccionario.traducir(palabra)+"''");
    }
    }catch (NullPointerException e) 
    {
      
      System.out.println("Lo siento la palabra "+ palabra +  " no esta en nuestro diccionario");
      
    }
    }while(!palabra.equals(""));
    
  }

}
