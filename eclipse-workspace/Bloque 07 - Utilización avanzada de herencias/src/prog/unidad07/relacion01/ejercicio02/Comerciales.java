package prog.unidad07.relacion01.ejercicio02;

public class Comerciales extends Empleado {
  private double ventasTotales;
  private int porcentaje;
  private double comision;
  private double salarioTotal;
  private Empleado empleado;
  Comerciales(String nombreCompleto, String dni, String tfn, double ventasTotales){
    super(nombreCompleto, dni, tfn);
    if(comprobarVentas(ventasTotales))
    {
      this.ventasTotales = ventasTotales;
    }else {
      throw new IllegalArgumentException();
    }
    this.porcentaje = porcentajeCorrespondiente( ventasTotales);
    
  }
  
  public double getSalario() {
    return getComision();
  }

  private double getComision() {
    if((ventasTotales * porcentaje / 100) >= 300) {
      return ventasTotales * porcentaje / 100;
    }else
    {
      return 300;
    }
    
  }
  private boolean comprobarVentas (double totalDeVentas)
  {
    
    if(totalDeVentas >= 0)
    {
     return true;
    }else {
      return false;
    }
    
  }
  private int porcentajeCorrespondiente(double ventasTotales)
  {
   int porcentaje = 0; 
    if(ventasTotales <= 10000)
    {
      porcentaje = 5;
    }else if (ventasTotales >= 10001 && ventasTotales <= 30000)
    {
      porcentaje = 8;
    }else if (ventasTotales > 30000)
    {
      porcentaje = 10;
    }
    return porcentaje;
  }
 
}
