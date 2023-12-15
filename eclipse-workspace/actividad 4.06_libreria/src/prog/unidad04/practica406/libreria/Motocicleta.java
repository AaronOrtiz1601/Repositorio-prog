package prog.unidad04.practica406.libreria;

public class Motocicleta extends Vehiculo implements ConvertibleATexto {
  
  protected int cilindrada;
  public Motocicleta(String matricula , Fecha fechaMatriculacion , int cilindrada)
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
  @Override
  public String aTexto() {
    // TODO Auto-generated method stub
    return null;
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
