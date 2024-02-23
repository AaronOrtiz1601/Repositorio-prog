package prog.unidad06.conjuntos.ejercicio01;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class NombresEliminaDuplicadosApp {

  public static void main(String[] args) {
    // TODO Auto-generated method stub
    Scanner sc=new Scanner (System.in);
    System.out.println("NOMBRES DUPLICADOS I ");
    boolean comprueba = true;
    String nombre;
    String vacio = "";
    Set<String> nombres = new HashSet<>();
    do {
      System.out.println("Introduce un nombre");
      nombre = sc.nextLine();
      nombres.add(nombre);
      if (nombre.equals(vacio))
      {
        comprueba = false;
      }
    }while(comprueba);
    System.out.println("Los nombres sin duplicados son");
    for (String mostrar : nombres) {
      System.out.println(mostrar);
    

  }

}
}
