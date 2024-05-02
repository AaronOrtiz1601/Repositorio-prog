package prog.unidad07.relacion02.ejercicio03;

public class Profesor extends Empleado {
 private String departamento;
  public Profesor(String nombre, String dni, String estadoCivil, int anyoDeIncorporacion, String codigoDeDespacho, String departamento,double salario) {
    super(nombre, dni, estadoCivil, anyoDeIncorporacion, codigoDeDespacho);
    this.departamento = departamento;
    this.salario = salario;
   
  }
  public void setDepartamento(String departamento) {
    this.departamento = departamento;
  }
  @Override
  public String toString() {
     return "Nombre:" + nombre + ",Dni: " + dni + ",Estado Civil: " + estadoCivil + ",Año de incorporación: " + anyoDeIncorporacion + ",Codigo de despacho: " + codigoDeDespacho + ",Departamento " + this.departamento ;
  }
  @Override
  public double getSalario() {
    return salario;
  }
  
 
  

}
