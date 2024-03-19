package prog.unidad05.gestionclientes.consola;

import prog.unidad05.gestionclientes.core.Cliente;
import prog.unidad05.gestionclientes.core.VisitadorClientes;

/**
 * Clase visitador, se activara siempre que queramos listar los clientes
 */
public class VisitadorClientesTexto implements VisitadorClientes {
  // Por cada cliente saca su informacion y la muestra
  @Override
  public void visita(Cliente cliente) {
    System.out.printf("%s: %s, %s%n", cliente.getNif(), cliente.getApellidos(), cliente.getNombre());

  }

}
