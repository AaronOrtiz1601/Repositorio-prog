package prog.unidad06.listas.ejercicio01;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class ListaEnterosUtils {
public static List<Integer> generaListaEnterosAleatorios(int longitudMin, int longitudMax, int valorMin, int valorMax){
  if (longitudMin < 0)
  {
    throw new IllegalArgumentException();
  }else if (longitudMin > longitudMax)
  {
    throw new IllegalArgumentException();
  }else {
    List<Integer> lista = new ArrayList<>();
    Random random = new Random();
    int longitud = random.nextInt(longitudMax - longitudMin + 1) + longitudMin;
    for (int i = 0 ; i < longitud ; i++)
    {
      if (valorMax < valorMin)
      {
        throw new IllegalArgumentException();
      }else if (valorMax >= valorMin)
      {
        int numeroAleatorio =   random.nextInt(valorMax - valorMin + 1) + valorMin;
        lista.add(i, numeroAleatorio);
      }
      
    }
    return lista;
    
  }
}
public static String generaCadena(List<Integer> lista) {
  String cadenaLista = "";
  int contador = 0;
  if (lista == null)
  {
    cadenaLista = "";
  }
  else if (lista.size() == 0)
  {
    cadenaLista = "()";
  }else
  {
    for(int i = 0; i < lista.size();i++ )
    {
      if (contador == 0)
      {
      cadenaLista = "("+ String.valueOf(lista.get(i));
      contador++;
      }else {
        cadenaLista =  cadenaLista+ ", " + String.valueOf(lista.get(i));
        contador++;
        
      }
      if (contador  == lista.size())
      {
        cadenaLista = cadenaLista+ ")";
      }
    }
  }
  return cadenaLista;
}
}
