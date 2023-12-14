package prog.unidad04.actividad406.libreria;

public class Motocicleta extends Vehiculo {
  
  protected int cilindrada;
  Motocicleta(String matricula , Fecha fechaMatriculacion , int cilindrada)
  {
    super(matricula, fechaMatriculacion);
    comprobarCilindrada(cilindrada);
    if(comprobarCilindrada(cilindrada) == true)
    {
      this.cilindrada = cilindrada;
    }
    else
    {
      throw new IllegalArgumentException();
    }
  }
  public int getCilindrada() {
    return cilindrada;
  }
  public String aTexto()
  {
    String cadena="";
    return cadena;
  }
  private boolean comprobarCilindrada(int cilindrada)
  {
    boolean prueba = true;
    if(cilindrada < 50)
    {
      prueba = false;
    }
    return prueba;
  }

}
