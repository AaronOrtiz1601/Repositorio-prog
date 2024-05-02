package prog.unidad07.relacion02.ejercicio01;

public class AdministracionServicios extends Empleado {
  private String seccion;

  public AdministracionServicios(String nombre, String dni, String estadoCivil, int anyoDeIncorporacion,String codigoDeDespacho, String seccion) {
    super(nombre, dni, estadoCivil, anyoDeIncorporacion, codigoDeDespacho);
   this.seccion = seccion;
  }

  public void setSeccion(String seccion) {
    this.seccion = seccion;
  }
  @Override
  public String toString() {
     return "Nombre:" + nombre + ",Dni: " + dni + ",Estado Civil: " + estadoCivil + ",Año de incorporación: " + anyoDeIncorporacion + ",Codigo de despacho: " + codigoDeDespacho + ",Sección " + this.seccion ;
  }

}
