package prog.ud08.actividad803.GestionTiendaApp;
/**
 * Clase que simula un cliente
 */
public class Cliente {
  /**
   * Atributos de la clase
   */
  private String nif;
  private String nombre;
  private String apellidos;
  private String direccion;
  private String nif_recomendado;
  
  /**
   * Contructor de la clase cliente
   * @param nif
   * @param nombre
   * @param apellido
   * @param direccion
   * @param nif_recomendado
   */
  Cliente(String nif, String nombre, String apellido, String direccion, String nif_recomendado) {
    this.nif = nif;
    this.nombre = nombre;
    this.apellidos = apellido;
    this.direccion = direccion;
    this.nif_recomendado = nif_recomendado;
  }
  /**
   * Me devuelve el dni del cliente
   * @return dni
   */
  public String getNif() {
    return nif;
  }
  
  /**
   * Me devuelve el nombre del cliente
   * @return noombre
   */
  public String getNombre() {
    return nombre;
  }
  
  /**
   * Me devuelve el apellido del cliente
   * @return apellido
   */
  public String getApellidos() {
    return apellidos;
  }
  
  /**
   * Me devuelve la direccion del cliente
   * @return dni
   */
  public String getDireccion() {
    return direccion;
  }
  
  /**
   * Me devuelve el dni de la persona que ha recomendado al cliente del cliente
   * @return dni
   */
  public String getNif_recomendado() {
    return nif_recomendado;
  }

}
