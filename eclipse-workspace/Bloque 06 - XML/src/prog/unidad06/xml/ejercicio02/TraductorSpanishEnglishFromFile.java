package prog.unidad06.xml.ejercicio02;

import java.util.Scanner;

import prog.unidad06.xml.ejercicio01.DiccionarioSpanishEnglishException;
import prog.unidad06.xml.ejercicio01.DiccionarioSpanishEnglishFromFile;

public class TraductorSpanishEnglishFromFile {
  private static final String ARCHIVO_DICCIONARIO = "diccionario.xml";

  public static void main(String[] args) {
    
    Scanner sc = new Scanner(System.in);
    String palabra;
    try {
    DiccionarioSpanishEnglishFromFile diccionario = new DiccionarioSpanishEnglishFromFile(ARCHIVO_DICCIONARIO);
    System.out.println("TRADUCCIÓN ESPAÑOL - INGLÉS (XML)");
    System.out.println("Introduzca una palabra a traducir al inglés (vacía para terminar)");
    palabra = sc.nextLine();
    System.out.println("La palabra española " + palabra +" Traducida al ingles significa " + diccionario.traducir(palabra));
    }catch (DiccionarioSpanishEnglishException e)
    {
      System.out.println("Hubo un error al sacar la información del archivo ");
    }
  }

}
