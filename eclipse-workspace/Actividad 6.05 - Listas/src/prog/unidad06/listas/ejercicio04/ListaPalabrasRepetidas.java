package prog.unidad06.listas.ejercicio04;

import java.util.ArrayList;
import java.util.List;

public class ListaPalabrasRepetidas {
  private List<String> lista = new ArrayList<>();
 
  public void add(String cadena)
  {
    if(!lista.contains(cadena)) {
      lista.add(cadena);
    }
  }
  public String obtenerResumen() {
    String cadena = "";
    int contador = 0;
    if (lista.size() == 0)
    {
      cadena = "()";
    }else
    {
      
    
    for (int i = 0; i < lista.size();i++)
    {
      if (contador == 0)
      {
        cadena = "("+'"'+lista.get(i)+'"';
        contador ++;
      }else
      {
        cadena =  cadena +", "+'"'+lista.get(i)+'"';
        contador++;
        
      }
      if (contador == lista.size())
      {
        cadena = cadena + ")";
      }
    }
    }
    return cadena;
  }
}
