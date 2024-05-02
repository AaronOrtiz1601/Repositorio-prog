package prog.unidad07.relacion01.ejercicio02;

public class empleadosFijos extends Empleado {
  
  private double salarioFijo;
  

  protected empleadosFijos(String nombreCompleto, String dni, String tfn,double salarioFijo) {
    
   super(nombreCompleto, dni, tfn);
   
   
   if(comprobarSalario(salarioFijo))
   {
     this.salarioFijo = salarioFijo;
   }else {
     throw new IllegalArgumentException();
   }
  
   
 }
  
  public double getSalario() {
    return salarioFijo;
  }

  private boolean comprobarSalario (double salarioFijo)
  {
    if(salarioFijo >= 0 )
    {
      return true;
    }else {
      return false;
    }
  }
}
