package models;
/**
 * Clase que muestra una reserva
 */
public class Reservas {
  
  /**
   * Atributos privados de la clase
   */
  private String nombre;
  private String apellido;
  private String nombreClase;
  private String turno;
  
  /**
   * Contructor de la clase
   * @param nombre
   * @param apellido
   * @param nombreClase
   * @param turno
   */
  public Reservas(String nombre, String apellido, String nombreClase, String turno) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.nombreClase = nombreClase;
    this.turno = turno;
  }
  /**
   * Metodos getter and setter de la clase
   */
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getApellido() {
    return apellido;
  }
  public void setApellido(String apellido) {
    this.apellido = apellido;
  }
  public String getNombreClase() {
    return nombreClase;
  }
  public void setNombreClase(String nombreClase) {
    this.nombreClase = nombreClase;
  }
  public String getTurno() {
    return turno;
  }
  public void setTurno(String turno) {
    this.turno = turno;
  }
  
  
  
}
