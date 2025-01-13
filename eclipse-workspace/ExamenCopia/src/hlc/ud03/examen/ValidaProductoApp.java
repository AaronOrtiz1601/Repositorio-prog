package hlc.ud03.examen;

import hlc.ud03.examen.datos.BloqueDatos;
import hlc.ud03.examen.datos.BloqueDatosEnFichero;

public class ValidaProductoApp {
  
  public static void main(String[] args) {
    // Si se proporciono el archivo
    if (args.length > 0) {
      // Crea un bloque de datos basado en archivo y lo procesa
      BloqueDatos datos = new BloqueDatosEnFichero(args[0]);
      // Crea un validador de personas
      ValidaProducto validador = new ValidaProducto();
      // Obtiene una lista de campos del validador y lo va validando uno por uno
      // También se ofrecen métodos específicos por campo
      int contador = 0;
      for (String campo: validador.getCampos()) {
        // Si el campo no valida
        if (!validador.esValidoCampo(campo, datos.getDato(campo))) {
          // Muestra el error
          System.err.println("El campo " + campo + " no es válido. Razón: " + validador.getError());
          contador++;
        }
      }
      if (contador == 0) {
        System.out.println("No se han encontrado errores");
      }else {
        System.out.println("Se han encontado " + contador + " errores");
      }
    } else {
      // Error.
      System.err.println("No se ha proporcionado el archivo a validar");
    }
  }
  
}
