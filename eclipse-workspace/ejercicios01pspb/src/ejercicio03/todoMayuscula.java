package ejercicio03;

import java.util.ArrayList;
import java.util.List;

public class todoMayuscula {

  public static void main(String[] args) {
    // Comprobar si se han pasado parámetros
    if (args.length > 0) {
        System.out.println("Parámetros recibidos:");
        // Recorrer y mostrar cada parámetro
        List<String> mayusculas = new ArrayList<>();
        for (String arg : args) {
          
          
          mayusculas.add(arg.toUpperCase());
        }
        for (int i = 0; i < mayusculas.size(); i++)
        {
          System.out.println(mayusculas.get(i));
        }
    } else {
        System.out.println("No se han recibido parámetros.");
    }


  }

}
