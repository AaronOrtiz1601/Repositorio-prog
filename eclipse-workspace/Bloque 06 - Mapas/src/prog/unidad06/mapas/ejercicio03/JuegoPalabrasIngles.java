package prog.unidad06.mapas.ejercicio03;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import java.util.Set;

import prog.unidad06.mapas.ejercicio01.DiccionarioSpanishEnglish;

public class JuegoPalabrasIngles {

  public static void main(String[] args) {
      DiccionarioSpanishEnglish diccionario = new DiccionarioSpanishEnglish();
      Scanner sc=new Scanner (System.in);
      Set<String> conjuntoDeClaves = diccionario.getPalabrasSpanish();
      List<String> listaDeClaves = new ArrayList<>(conjuntoDeClaves);

      Random random = new Random();
      int contador = 0;
      for (int i = 0 ; i < 5 ;i++)
      {
        String palabra;
        int indiceAleatorio = random.nextInt(listaDeClaves.size());
        String claveAleatoria = listaDeClaves.get(indiceAleatorio);
        System.out.println("Dime la traduccion de " + claveAleatoria);
        palabra = sc.nextLine();
        if (palabra.equals(diccionario.traducir(claveAleatoria)))
        {
          System.out.println("Has acertado");
          contador ++;
        }else {
          System.out.println("Has fallado. La respuesta correcta era " + diccionario.traducir(claveAleatoria));
        }
        
      }
      System.out.println("Has acertado " + contador + " de 5");
        
     
  

  }

}
