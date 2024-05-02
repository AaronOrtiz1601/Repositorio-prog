package prog.unidad07.relacion02.ejercicio04;

public class AdministracionServicios extends Empleado {
  private String seccion;
  private int horas;

  public AdministracionServicios(String nombre, String dni, String estadoCivil, int anyoDeIncorporacion,String codigoDeDespacho, String secciona, int horas) {
    super(nombre, dni, estadoCivil, anyoDeIncorporacion, codigoDeDespacho);
   this.seccion = seccion;
   this.horas = horas;
  }

  public void setSeccion(String seccion) {
    this.seccion = seccion;
  }
  @Override
  public String toString() {
     return "Nombre:" + nombre + ",Dni: " + dni + ",Estado Civil: " + estadoCivil + ",Año de incorporación: " + anyoDeIncorporacion + ",Codigo de despacho: " + codigoDeDespacho + ",Sección " + this.seccion ;
  }

  @Override
  public double getSalario() {
    return horas * 15;
  }

  

}
