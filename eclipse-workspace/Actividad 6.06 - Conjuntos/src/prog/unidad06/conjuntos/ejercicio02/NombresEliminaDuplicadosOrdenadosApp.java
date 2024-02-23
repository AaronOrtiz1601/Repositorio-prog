package prog.unidad06.conjuntos.ejercicio02;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class NombresEliminaDuplicadosOrdenadosApp {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc=new Scanner (System.in);
    System.out.println("NOMBRES DUPLICADOS I ");
    boolean comprueba = true;
    String nombre;
    String vacio = "";
    Set<String> nombres = new TreeSet<>();
    do {
      System.out.println("Introduce un nombre");
      nombre = sc.nextLine();
      nombres.add(nombre);
      if (nombre.equals(vacio))
      {
        comprueba = false;
      }
    }while(comprueba);
    System.out.println("Los nombres sin duplicados y ordenados son");
    for (String mostrar : nombres) {
      System.out.println(mostrar);
    

  }

}

}
