package models;

import java.util.Date;

public class Administracion {
  /**
   * Atributos privados de la clase administracion
   */
  private String nombre;
  private String apellidos;
  private Date edad;
  private String perfil;
  private String email;
  private String contraseña;
  
  /**
   * Constructor de la clase administracion
   * @param nombre
   * @param apellidos
   * @param edad
   * @param perfil
   * @param email
   * @param contraseña
   */
  public Administracion(String nombre, String apellidos, Date edad, String email, String contraseña) {
   
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.email = email;
    this.contraseña = contraseña;
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

  public String getApellidos() {
    return apellidos;
  }

  public void setApellidos(String apellidos) {
    this.apellidos = apellidos;
  }

  public Date getEdad() {
    return edad;
  }

  public void setEdad(Date edad) {
    this.edad = edad;
  }

  public String getPerfil() {
    return perfil;
  }

  public void setPerfil(String perfil) {
    this.perfil = perfil;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }
  
  
}
