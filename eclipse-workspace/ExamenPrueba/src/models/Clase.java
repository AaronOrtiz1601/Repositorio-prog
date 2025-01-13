package models;

public class Clase {
  
  private String profesor;
  private String nombre;
  private String tiempo;
  
  
  
  public Clase(String nombre, String profesor, String tiempo) {
    this.profesor = profesor;
    this.nombre = nombre;
    this.tiempo = tiempo;
  }
  
  public String getProfesor() {
    return profesor;
  }
  public void setProfesor(String profesor) {
    this.profesor = profesor;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getTiempo() {
    return tiempo;
  }
  public void setTiempo(String tiempo) {
    this.tiempo = tiempo;
  }
  

}
