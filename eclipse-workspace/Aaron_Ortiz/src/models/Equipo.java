package models;

public class Equipo {
  
  private String nombre;
  private String anyo;
  private String entrenador;
  private String genero;
  private String horaEntrenamiento;
  private String numeroDeJugadores;
  
 
  public Equipo(String nombre, String anyo, String entrenador, String genero, String horaEntrenamiento,
      String numeroDeJugadores) {
    this.nombre = nombre;
    this.anyo = anyo;
    this.entrenador = entrenador;
    this.genero = genero;
    this.horaEntrenamiento = horaEntrenamiento;
    this.numeroDeJugadores = numeroDeJugadores;
  }
  public String getNombre() {
    return nombre;
  }
  public void setNombre(String nombre) {
    this.nombre = nombre;
  }
  public String getAnyo() {
    return anyo;
  }
  public void setAnyo(String anyo) {
    this.anyo = anyo;
  }
  public String getEntrenador() {
    return entrenador;
  }
  public void setEntrenador(String entrenador) {
    this.entrenador = entrenador;
  }
  public String getGenero() {
    return genero;
  }
  public void setGenero(String genero) {
    this.genero = genero;
  }
  public String getHoraEntrenamiento() {
    return horaEntrenamiento;
  }
  public void setHoraEntrenamiento(String horaEntrenamiento) {
    this.horaEntrenamiento = horaEntrenamiento;
  }
  public String getNumeroDeJugadores() {
    return numeroDeJugadores;
  }
  public void setNumeroDeJugadores(String numeroDeJugadores) {
    this.numeroDeJugadores = numeroDeJugadores;
  }

}
