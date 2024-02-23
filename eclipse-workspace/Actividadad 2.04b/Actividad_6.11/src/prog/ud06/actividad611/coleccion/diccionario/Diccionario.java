package prog.ud06.actividad611.coleccion.diccionario;

import java.util.HashMap;
import java.util.Map;

public class Diccionario<V> {
private Map<String, V> diccionario ;
  public Diccionario(){
  diccionario = new HashMap<>();
}
  public boolean contieneNombre(String nombre)
{
  return diccionario.containsKey(nombre);
}
  public void add(String nombre,V valor)
{
  if (nombre != null && !contieneNombre(nombre))
  {
    if (valor != null)
    {
      diccionario.put(nombre, valor);
    }else
    {
      throw new IllegalArgumentException();
    }
  }else if (nombre == null)
  {
    throw new IllegalArgumentException();
  }else if (contieneNombre(nombre))
  {
    throw new DiccionarioException();
  }
    
  {
    
  }
}
  public V getEntrada(String nombre)
    {
  return diccionario.get(nombre);
    } 
}
