package prog.unidad04.practica406.libreria;
/**
 * La clase Motocicleta representa un vehiculo del tipo motocicleta.
 */
public class Motocicleta extends Vehiculo implements ConvertibleATexto {
  
  protected int cilindrada;
  /**
   * Constructor de la clase Motocicleta.
   *
   * @param matricula La matricula de la motocicleta.
   * @param fechaMatriculacion La fecha de matriculacion de la motocicleta.
   * @param cilindrada La cilindrada de la motocicleta.
   * @throws IllegalArgumentException Si la matricula, la fecha de matriculacion o la cilindrada no son validas.
   */
  public Motocicleta(String matricula , Fecha fechaMatriculacion , int cilindrada)
  {
    super(matricula, fechaMatriculacion);
    boolean prueba = true;
    comprobarCilindrada(cilindrada);
    if(comprobarCilindrada(cilindrada) == true)
    {
      this.cilindrada = cilindrada;
    }
    else
    {
      prueba = false;
      throw new IllegalArgumentException();
    }
    if (prueba == true) {
      vehiculosMatriculados++;
      
    }
  }
  /**
   * Obtiene la cilindrada de la motocicleta.
   *
   * @return La cilindrada de la motocicleta.
   */
  public int getCilindrada() {
    return cilindrada;
  }
  /**
   * Convierte la motocicleta a su representacion en formato de texto.
   *
   * @return La representacion en formato de texto de la motocicleta.
   */
  @Override
  public String aTexto() {
    String cadena; 
    cadena = "Matricula: " +matricula+", Fecha Matriculacion: " +fechaMatriculacion.aTexto()+", cilindrada: " + cilindrada;
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
