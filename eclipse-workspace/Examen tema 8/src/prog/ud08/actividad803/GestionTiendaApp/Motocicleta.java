package prog.ud08.actividad803.GestionTiendaApp;
/**
 * 
 * Clase que simula una motocicleta
 */

public class Motocicleta {
  /**
   * Atributos de la clase
   */
  private String referencia;
  private int cilindrada;
  private String tipo;
  private double precio;
  private String fabricante;
  /**
   * Contructor de la clases motocicleta
   * @param referencia
   * @param cilindrada
   * @param tipo
   * @param precio
   * @param fabricante
   */
  Motocicleta(String referencia, int cilindrada, String tipo, double precio, String fabricante) {
    this.referencia = referencia;
    this.cilindrada = cilindrada;
    this.tipo = tipo;
    this.tipo = tipo;
    this.precio = precio;
    this.fabricante = fabricante;
  }
  
  /**
   * Me devuelve la referencia de la motocicleta
   * @return referencia
   */
  public String getReferencia() {
    return referencia;
  }
  /**
   * Me devuelde la cilindrada de la motocicleta
   * @return cilindrada
   */
  public int getCilindrada() {
    return cilindrada;
  }
  /**
   * Me devuelde el tipo de la motocicleta
   * @return tipo
   */
  public String getTipo() {
    return tipo;
  }
  /**
   * Me devuelve el precio de la motocicleta
   * @return precio
   */
  public double getPrecio() {
    return precio;
  }
  /**
   * Me devuelve el fabricante de la motocicleta
   * @return fabricante
   */
  public String getFabricante() {
    return fabricante;
  }

}
