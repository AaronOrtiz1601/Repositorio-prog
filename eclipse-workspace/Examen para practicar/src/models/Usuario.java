package models;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
  private String nombre;
  private String apellidos;
  private String email;
  private String contraseña;
  private String telefono;
  private String metodoDeContacto;
  private List <Citas> misCitas = new ArrayList();


  public Usuario(String nombre, String apellidos, String email, String contraseña, String telefono,
       String metodoDeContacto) {
    this.nombre = nombre;
    this.apellidos = apellidos;
    this.email = email;
    this.contraseña = contraseña;
    this.telefono = telefono;
    this.metodoDeContacto = metodoDeContacto;
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public String getEmail() {
    return email;
  }

  public String getContraseña() {
    return contraseña;
  }

  public String getTelefono() {
    return telefono;
  }

  public String getMetodoDeContacto() {
    return metodoDeContacto;
  }

  public List<Citas> getMisCitas() {
    return misCitas;
  }

  

}
