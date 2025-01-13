package models;

public class Clientes {
  /**
   * Atributos privados de la clase Clientes
   */

  private String nombre;
  private String apellido;
  private String edad;
  private String provincia;

  /**
   * Contructor de la clase cliente
   * 
   * @param nombre
   * @param apellido
   * @param edad
   * @param provincia
   */
  public Clientes(String nombre, String apellido, String edad, String provincia) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.edad = edad;
    this.provincia = provincia;
  }

  /**
   * Getter and setter de los atributos privados de la clase
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

  public String getEdad() {
    return edad;
  }

  public void setEdad(String edad) {
    this.edad = edad;
  }

  public String getProvincia() {
    return provincia;
  }

  public void setProvincia(String provincia) {
    this.provincia = provincia;
  }

}
