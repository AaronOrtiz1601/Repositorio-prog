package prog.unidad06.listas.ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class MezclaListasCadenas {
  public static List<String> union(List<String> lista,List<String> otraLista)
  {
    if  ((lista == null) || otraLista == null)
    {
      throw new IllegalArgumentException();
    }else
    {
      List<String> listaFin = new ArrayList<>();
      boolean comprueba;
      for (int i = 0; i < lista.size(); i++) {
        comprueba = true;
        int j = 0;
        while (j < listaFin.size() && !lista.get(i).equals(listaFin.get(j))) {
          j++;
        }
        if (j == listaFin.size()) {
          listaFin.add(lista.get(i));
        }
      }
      
      for (int i = 0; i < otraLista.size();i++)
      {
         comprueba = true;
        for ( int j = 0 ;j < otraLista.size();j++)
        {
          if (otraLista.get(j).equals(listaFin.get(j)) )
          {
            comprueba = false;
          }
          
         
        }
        if (comprueba)
        {
          listaFin.add(otraLista.get(i));
        }
      }
      return listaFin;
    }
    }

  public static List<String> interseccion(List<String> lista, List<String> otraLista) {
    if  ((lista == null) || otraLista == null) {
      throw new IllegalArgumentException("Las listas no pueden ser nulas");
    } else {
      List<String> repetidos = new ArrayList<>();
      for (String cadena : otraLista) {
        if (lista.contains(cadena)) { 
          repetidos.add(cadena); 
        }
      }
      return repetidos;
    }
  }

  public static List<String> diferencia(List<String> lista, List<String> otraLista) {
    if  ((lista == null) || otraLista == null) {
      throw new IllegalArgumentException("Las listas no pueden ser nulas");
    } else {
      List<String> diferencias = new ArrayList<>();
      for (String cadena : otraLista) {
        if (!lista.contains(cadena)) { 
          diferencias.add(cadena); 
        }
      }
      for (String cadena : lista) {
        if (!otraLista.contains(cadena)) { 
          diferencias.add(cadena); 
        }
      }
      return diferencias;
    }
  }
}