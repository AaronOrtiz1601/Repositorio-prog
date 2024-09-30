package prog.ud08.actividad803.GestionTiendaApp;
/**
 * Interfaz de la base de datos de la tienda
 */
public interface BaseDatosTienda {
  /**
   * Metodo que recibe una motocicleta y la añade a la base de datos
   * @param motocicleta
   */
  void anyadirMotocicleta(Motocicleta motocicleta);
  /**
   * Metodo que recibe un cliente y actualiza sus datos en la base de datos
   * @param cliente
   */
  void actualizarCliente(Cliente cliente);
  /**
   * Metodo para buscar por su dni a un cliente
   * @param dni
   * @return Cliente
   */
  Cliente getClienteByCodigo(String dni);
  /**
   * Metodo que recibe el dni de un cliente y la referencia de una moto y resgitra la venta
   * @param referenciaMotocicleta
   * @param dniCliente
   */
  void registrarVenta(String referenciaMotocicleta, String dniCliente);
  /**
   * Metodo que busca una motocicleta por su referencia
   * @param referencia
   * @return Motocicleta
   */
  Motocicleta getMotocicletaByCodigo(String referencia);
  /**
   * Metodo que recibe una referencia y elimina la motocicleta que se corresponda a ella
   * @param referencia
   */
  void eliminacioMotocicleta(String referencia);
}
