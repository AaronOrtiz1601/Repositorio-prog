package prog.unidad04.actividad406.libreria;

public class Automovil extends Vehiculo {
  
  public static final  String COLOR_AZUL = "Azul";
  public static final String COLOR_BLANCO = "Blanco";
  public static final String COLOR_NEGRO = "Negro";
  
  protected String color;
  protected int plazas;
  
  public Automovil (String matricula,Fecha fechaMatriculacion, String color,int plazas)
  {
    super(matricula,fechaMatriculacion);
    colorCorrecto(color);
    if (colorCorrecto(color) == true)
    {
      this.color = color;
    }
    else
    {
      throw new IllegalArgumentException();
    }
     
   
    if(plazas >= 1)
    {
      this.plazas=plazas;
    }else
    {
      throw new IllegalArgumentException();
      
    }
   
    
  }

  public String getColor() {
    return color;
  }

  public int getPlazas() {
    return plazas;
  }
  public String aTexto()
  {
    String cadena="";
    return cadena;
  }
  
  private boolean colorCorrecto(String color)
  {
    boolean prueba = true; 
    if(color.equals(COLOR_AZUL)||color.equals(COLOR_BLANCO)||color.equals(COLOR_NEGRO))
    {
      prueba = true;
    }
    else
    {
      prueba = false;
    }
    return prueba;
  }
  
  
  

}

