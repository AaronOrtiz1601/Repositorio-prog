package prog.unidad06.genericos.ejercicio02;

import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;

public class Cola<T> {
  private List<T> lista;
  Cola(){
    lista = new ArrayList<T>();
  }
  public void push(T elemento) {
    lista.add(elemento);
  }
  public T pop() {
    T elemento;
    if (!esVacia())
    {
   elemento = lista.remove(0);
    }else
    {
      throw new EmptyStackException();
    }
    return elemento;
  }
  public boolean esVacia() {
    boolean vacia = true;
    if (lista.size() > 0)
    {
      vacia = false;
    }
    return vacia;
  }
  public int getNumeroElementos()
  {
    return lista.size();
  }
}
