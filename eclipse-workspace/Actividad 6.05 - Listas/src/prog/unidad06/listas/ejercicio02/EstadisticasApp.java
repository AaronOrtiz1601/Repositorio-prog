package prog.unidad06.listas.ejercicio02;

import java.util.List;

import prog.unidad06.listas.ejercicio01.ListaEnterosUtils;

public class EstadisticasApp {

  public static void main(String[] args) {
    int maximo = 0;
    int minimo = 100;
    double media;
    int suma = 0;
   List<Integer> lista = ListaEnterosUtils.generaListaEnterosAleatorios(10, 20, 0, 100);
   System.out.println("La lista generada es "+ListaEnterosUtils.generaCadena(lista));
   for (int i = 0 ;i < lista.size();i++)
   {
     suma = suma + lista.get(i);
     if (lista.get(i) > maximo)
     {
       maximo = lista.get(i);
     }
     if (lista.get(i) < minimo)
     {
       minimo = lista.get(i);
     }
   }
   media = suma /lista.size();
   System.out.println("El maximo es "+ maximo );
   System.out.println("El minimo es "+ minimo);
   System.out.println("La suma de todos los valores de la lista es "+ suma);
   System.out.println("La media de los valores de la lista es "+ media );
   

  

}
}
