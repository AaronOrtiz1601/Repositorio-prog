package prog.unidad05.gestionclientes.core;

import javax.swing.DefaultListModel;

public class VisitadorUsuario implements VisitadorClientes {
  // Metodo privados
  private DefaultListModel<String> modelo;

  /**
   * Constructor de la clase visitador
   * 
   * @param modelo. Aqui tenemos el modelo que luego pasaremos a la lista
   */
  public VisitadorUsuario(DefaultListModel<String> modelo) {
    this.modelo = modelo;
  }

  /**
   * Metodo visita, que se activa cada vez que creamos un cliente
   * 
   * @param Cliente. objeto de la clase cliente, de este sacamos los datos que vamos introduciendo en el modelo
   */
  @Override
  public void visita(Cliente cliente) {

    String infoCliente = cliente.getNif() + " : " + cliente.getApellidos() + "," + cliente.getNombre();
    modelo.addElement(infoCliente);
  }
}