package prog.unidad07.relacion02.ejercicio01;

public abstract class Empleado extends Persona {
  protected int anyoDeIncorporacion;
  protected String codigoDeDespacho;
  
    Empleado(String nombre, String dni, String estadoCivil, int anyoDeIncorporacion, String codigoDeDespacho) {
      super(nombre, dni, estadoCivil);
      this.anyoDeIncorporacion = anyoDeIncorporacion;
      this.codigoDeDespacho = codigoDeDespacho;
   
    }

    public void setDespacho(String codigoDeDespacho) {
      this.codigoDeDespacho = codigoDeDespacho;
    }

}
