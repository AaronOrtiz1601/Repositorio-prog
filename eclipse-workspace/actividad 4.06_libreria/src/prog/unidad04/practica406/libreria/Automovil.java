package prog.unidad04.practica406.libreria;
/**
 * La clase Automovil representa un vehiculo del tipo automovil.
 */
public class Automovil extends Vehiculo implements ConvertibleATexto {
 //color azul
  public static final  String COLOR_AZUL = "azul";
  //color blanco
  public static final String COLOR_BLANCO = "blanco";
  //color negro
  public static final String COLOR_NEGRO = "negro";
  
  protected String color;
  protected int plazas;
  /**
   * Constructor de la clase Automovil.
   *
   * @param matricula La matricula del automóvil.
   * @param fechaMatriculacion La fecha de matriculacion del automovil.
   * @param color El color del automovil.
   * @param plazas El numero de plazas del automovil.
   * @throws IllegalArgumentException Si los valores de matricula, fecha de matriculacion, color o plazas no son validos.
   */
  
  public Automovil (String matricula,Fecha fechaMatriculacion, String color,int plazas)
  {
   
    super(matricula,fechaMatriculacion);
    boolean prueba = true;
    try {
      if (colorCorrecto(color) == true)
      {
        this.color = color;
      }
      else
      {
        prueba = false;
        throw new IllegalArgumentException();
      }
      
    }catch (NullPointerException e) {
      throw new IllegalArgumentException();
    }
    
     
   
    if(plazas >= 1)
    {
      this.plazas=plazas;
    }else
    {
      prueba = false;
      throw new IllegalArgumentException();
      
    }
    if (prueba == true)
    {
      vehiculosMatriculados++;
    }
   
    
  }
  /**
   * Obtiene el color del automovil.
   *
   * @return El color del automovil.
   */

  public String getColor() {
    return color;
  }
  /**
   * Obtiene el número de plazas del automóvil.
   *
   * @return El número de plazas del automóvil.
   */

  public int getPlazas() {
    return plazas;
  }
  /**
   * Convierte el automóvil a su representación en formato de texto.
   *
   * @return La representación en formato de texto del automóvil.
   */
  @Override
  public String aTexto() {
    String cadena; 
    cadena = "Matricula: " + matricula + ", Fecha Matriculacion: " + fechaMatriculacion.aTexto() + ", color: " + color + ", Num. Plazas: " + plazas ; 
    return cadena;
  }
  
  private boolean colorCorrecto(String color)
  {
    boolean prueba = false; 
    if(color.equals(COLOR_AZUL)||color.equals(COLOR_BLANCO)||color.equals(COLOR_NEGRO))
    {
      prueba = true;
    }
    
    
    return prueba;
  }
  
  
  

}

