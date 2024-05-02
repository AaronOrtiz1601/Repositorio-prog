package prog.unidad07.relacion02.ejercicio03;

public class Estudiante extends Persona {
  private String curso;
  Estudiante(String nombre, String dni, String estadoCivil, String curso) {
    super(nombre, dni, estadoCivil);
    this.curso = curso;
    
  }
  public void setCurso(String curso) {
    this.curso = curso;
  }
  @Override
  public String toString() {
     return "Nombre:" + nombre + ",Dni: " + dni + ",Estado Civil: " + estadoCivil + ",Curso: " + curso;
  }

}
 