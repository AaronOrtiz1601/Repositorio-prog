package prog.unidad06.listas.ejercicio03;

import java.util.ArrayList;
import java.util.List;

import prog.unidad06.listas.ejercicio01.ListaEnterosUtils;

public class EstadisticasParImparApp {

  public static void main(String[] args) {
    List<Integer> lista = ListaEnterosUtils.generaListaEnterosAleatorios(10, 20, 0, 100);
    List<Integer> listaPares = new ArrayList<>();
    List<Integer> listaImpares = new ArrayList<>();
    System.out.println("La lista generada es " + ListaEnterosUtils.generaCadena(lista));
    
    for (int i = 0; i < lista.size(); i++) {
      if (lista.get(i) % 2 == 0) {
        listaPares.add(lista.get(i));
      } else {
        listaImpares.add(lista.get(i));
      }
    }
    
    
    int suma = 0;
    int maximo = 0;
    int minimo = 100;
    for (int i = 0; i < listaPares.size(); i++) {
      suma += listaPares.get(i);
      if (listaPares.get(i) > maximo) {
        maximo = listaPares.get(i);
      }
      if (listaPares.get(i) < minimo) {
        minimo = listaPares.get(i);
      }
    }
    double media =  suma/listaPares.size();
    System.out.println("Resultados para pares:");
    System.out.println("El máximo es " + maximo);
    System.out.println("El mínimo es " + minimo);
    System.out.println("La suma de todos los valores es " + suma);
    System.out.println("La media de los valores es " + media);

   
    int sumaIp = 0;
    int maximoIp = 0;
    int minimoIp = 100;
    for (int i = 0; i < listaImpares.size(); i++) {
      sumaIp += listaImpares.get(i);
      if (listaImpares.get(i) > maximoIp) {
        maximoIp = listaImpares.get(i);
      }
      if (listaImpares.get(i) < minimoIp) {
        minimoIp = listaImpares.get(i);
      }
    }
    double mediaIp = sumaIp/listaImpares.size();
    System.out.println("Resultados para impares:");
    System.out.println("El máximo es " + maximoIp);
    System.out.println("El mínimo es " + minimoIp);
    System.out.println("La suma de todos los valores es " + sumaIp);
    System.out.println("La media de los valores es " + mediaIp);
  }
}