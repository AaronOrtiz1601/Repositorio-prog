package prog.unidad07.relacion01.ejercicio02;

public class Consultores extends Empleado {
  private double tarifaPorHoras;
  private double numHoras;
  private double salario;

  public Consultores(String nombreCompleto, String dni, String tfn, double tarifaPorHoras, double numHoras) {
    super(nombreCompleto, dni, tfn);
    
    if(comprobarTarifaPorHoras(tarifaPorHoras))
    {
      this.tarifaPorHoras = tarifaPorHoras;
    }else {
      throw new IllegalArgumentException();
    }
    if(comprobarNumHoras(numHoras))
    {
      this.numHoras = numHoras;
    }else {
      throw new IllegalArgumentException();
    }
  }
  public double getSalario() {
    return tarifaPorHoras * numHoras;
  }
  private boolean comprobarTarifaPorHoras(double tarifaPorHoras)
  {
    if( tarifaPorHoras >= 0)
    {
      return true;
    }else {
      return false;
    }
  }
  private boolean comprobarNumHoras (double numHoras)
  {
    if( numHoras >= 0)
    {
      return true;
    }else
    {
      return false;
    }
  }
  

}
