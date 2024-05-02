package prog.unidad07.relacion02.ejercicio01;

public abstract class Persona {
  protected String nombre;
  protected String dni;
  protected String estadoCivil;
  
  Persona(String nombre,String dni,String estadoCivil)
  {
    this.nombre = nombre;
    this.dni = dni;
    this.estadoCivil = estadoCivil;
  }

  public void setEstadoCivil(String estadoCivil) {
    this.estadoCivil = estadoCivil;
  }
  

}
