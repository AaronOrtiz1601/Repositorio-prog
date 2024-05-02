package sinRefactorizar;

public class Trabajador {
 
  private double nomina;
  private int horasExtra;
  private  TipoTrabajo tipo;
  
  
  public enum TipoTrabajo{
    DIRECTOR,
    SUBDIRECTOR,
    EMPLEADO
  }
  
  Trabajador(double nomina,int horasExtra,TipoTrabajo tipo)
  {
    this.nomina = nomina;
    this.horasExtra = horasExtra;
    this.tipo = tipo;
  }
 
  public double getNom() {
    return nomina;
  }
  public int getMasTrab() {
    return horasExtra;
  }
  public TipoTrabajo Trab() {
    return tipo;
  }


}
