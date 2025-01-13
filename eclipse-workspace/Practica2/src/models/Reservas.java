package models;

public class Reservas {
  
  
  private String nombre;
  private String apellido;
  private String nombreClase;
  private String turno;
  
  
  public Reservas(String nombre, String apellido, String nombreClase, String turno) {
    this.nombre = nombre;
    this.apellido = apellido;
    this.nombreClase = nombreClase;
    this.turno = turno;
  }
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
