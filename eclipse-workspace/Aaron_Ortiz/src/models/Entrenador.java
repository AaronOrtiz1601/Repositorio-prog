package models;

import java.util.Date;

public class Entrenador {

  private String nombre;
  private String apellidos;
  private Date edad;
  private String email;
  private String contraseña;
  private String equipo = "";
  
  public Entrenador(String nombre, String apellidos, Date edad, String email, String contraseña) {
    super();
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.edad = edad;
    this.email = email;
    this.contraseña = contraseña;
  }

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

  public String getEquipo() {
    return equipo;
  }

  public void setEquipo(String equipo) {
    this.equipo = equipo;
  }
  
}
