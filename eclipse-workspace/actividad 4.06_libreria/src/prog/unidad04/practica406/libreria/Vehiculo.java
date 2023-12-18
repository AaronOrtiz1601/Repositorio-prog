package prog.unidad04.practica406.libreria;

/**
 * La clase Vehiculo representa un vehiculo generico.
 */
public class Vehiculo  {
  protected Fecha fechaMatriculacion;
  protected String matricula;
  protected static int vehiculosMatriculados;
  /**
   * Constructor de la clase Vehiculo.
   *
   * @param matricula La matrícula del vehiculo.
   * @param fechaMatriculacion La fecha de matriculación del vehiculo.
   * @throws IllegalArgumentException Si la matricula o la fecha de matriculacion no son validas.
   */
  protected Vehiculo(String matricula,Fecha fechaMatriculacion) 
  {
    
    
    
     if(matriculaCorrecta(matricula) == true)
     {
    this.matricula = matricula;
     }
     else 
     {
       throw new IllegalArgumentException();
     }
     if ( fechaMatriculacion == null)
     {
       throw new IllegalArgumentException();
     }
     else
     {
       this.fechaMatriculacion=fechaMatriculacion;
       
     }
    
    
    
  }
  /**
   * Obtiene la fecha de matriculacion del vehiculo.
   *
   * @return La fecha de matriculacion del vehiculo.
   */

  public Fecha getFechaMatriculacion() {
    return fechaMatriculacion;
  }
  /**
   * Obtiene la matricula del vehiculo.
   *
   * @return La matricula del vehiculo.
   */

  public String getMatricula() {
    return matricula;
  }
  /**
   * Convierte el vehiculo a su representacion en formato de texto.
   *
   * @return La representacion en formato de texto del vehiculo.
   */
  public String aTexto() {
   String cadena = "";
    return cadena;
  }
  /**
   * Obtiene el número de vehiculos matriculados.
   *
   * @return El número de vehiculos matriculados.
   */
  public static int getVehiculosMatriculados() {
    return vehiculosMatriculados;
  }
  private boolean matriculaCorrecta(String matricula)
  {
    String matriculaSinEspacios;
    matriculaSinEspacios = matricula.replaceAll("\\s", "");
    String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    boolean esValida = true;

    
    if (matriculaSinEspacios.length()!= 7) {
      esValida = false;
    } else {
      
      for (int i = 0; i < 4; i++) {
        char caracter = matriculaSinEspacios.charAt(i);
        if (!Character.isDigit(caracter)) {
          esValida = false;
         throw new IllegalArgumentException();
        }
      }
      
      for (int i = 4; i < 7; i++) {
        String prueba = String.valueOf(matriculaSinEspacios.charAt(i));
        if (!abecedario.contains(prueba)) {
          esValida = false;
          throw new IllegalArgumentException();
        }
      }
    }

    
    return esValida;
    
  }

  

}
