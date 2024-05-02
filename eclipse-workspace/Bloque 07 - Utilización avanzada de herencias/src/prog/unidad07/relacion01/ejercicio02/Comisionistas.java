package prog.unidad07.relacion01.ejercicio02;

public class Comisionistas extends empleadosFijos {
  private double totalDeVentas;
  private double porcentajePropio;
  private double salarioTotal;

  
  Comisionistas(String nombreCompleto, String dni, String tfn, double salarioFijo, double totalDeVentas, double porcentajePropio) {
    super(nombreCompleto, dni, tfn, salarioFijo);
   
    if(comprobarVentas(totalDeVentas))
    {
      this.totalDeVentas = totalDeVentas;
    }else {
      throw new IllegalArgumentException();
    }
    if(comprobarPorcentaje(porcentajePropio))
    {
      this.porcentajePropio = porcentajePropio;
    }else {
      throw new IllegalArgumentException();
    }
    if(salarioFijo >= 0)
    {
      salarioTotal = salarioFijo + (this.totalDeVentas * this.porcentajePropio / 100);
    }else
    {
      throw new IllegalArgumentException();
    }
    
    
    
  }
  public double getSalario() {
    return salarioTotal;
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
   private boolean comprobarPorcentaje (double porcentaje)
   {
     if(porcentaje >= 0 && porcentaje <= 100)
     {
       return true;
     }else {
       return false;
     }
   }

}
