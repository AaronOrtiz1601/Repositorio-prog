package prog.unidad04.actividad402.ejercicio04;

public class Lavadora {
  /**
   * Clase que representa a una pizza
   * @author Aarón
   * @version 1.0
   */
  //colores
  /**
   * color blanco
   */
  public static String COLOR_BLANCO="blanco";
  /**
   * color azul
   */
  public static String COLOR_AZUL="azul";
  /**
   * color gris
   */
  public static String COLOR_GRIS="gris";
  /**
   * color negro
   */
  public static String COLOR_NEGRO="negro";
  
  /**
   * color rojo
   */
  public static String COLOR_ROJO="rojo";
  
  //precios consumo energetico
  /**
   * precio A
   */
 private static double PRECIO_A=100;
  /**
   * precio B
   */
  private static double PRECIO_B=80;
  /**
   * precio C
   */
  private static double PRECIO_C=60;
  /**
   * PRECIO D
   */
  private static double PRECIO_D=50;
  /**
   * precio E
   */
  private static double PRECIO_E=30;
  /**
   * precio F
   */
  private static double PRECIO_F=10;
  
  //Precio por peso
  /**
   * precio si pesa hasta 20kg
   */
  private static double  PRECIO_20kG=10;
  /**
   * precio si pesa entre 20 y 50
   */
  private static double PRECIO_20KG_50KG=50;
  /**
   * precio si pesa entre 50 y 80
   */
  private static double PRECIO_50KG_80KG=80;
  /**
   * precio si pesa mas de 80 kg
   */
  private static double PRECIO_MAS_80KG=100;
  //precio por carga
  /**
   * precio extra por carga
   */
  private static double PRECIO_CARGA_MAS_30KG=50;
  
  //ATRIBUTOS
  
  private double peso;
  private char consumoEnergetico;
  private double precioBase;
  private String color;
  private double carga;
  /**
   * Contructor.contrucor que da los valores por defecto 
   */
  
  public Lavadora() {
    peso=15;
    consumoEnergetico='F';
    precioBase=200;
    color="Blanco";
    carga=5;
    
    
  }
  /**
   * Constructor.Constructor que da valores a precio base y a peso y el resto los deja por defecto 
   * @param precioBase
   * @param peso
   */
  public Lavadora(double precioBase,double peso) 
  {
    this.precioBase=precioBase;
    this.peso=peso;
    consumoEnergetico='F';
    color="Blanco";
    carga=5;
  }
  /**
   * Constructor.Constructor que da valor a todos los atributos
   * @param precioBase
   * @param color
   * @param consumoEnergetico
   * @param peso
   * @param carga
   */
  public Lavadora(double precioBase,String color,char consumoEnergetico,double peso,double carga)
  {
    this.precioBase=precioBase;
    this.color=color;
    ComprobarColor();
    this.consumoEnergetico=consumoEnergetico;
    ComprobarConsumo();
    this.peso=peso;
    this.carga=carga;
  }
  /**
   * Metodo que devuelve el peso
   * @return
   */
  public double getPeso() {
    return peso;
  }
  /**
   * Metodo que devuelve el consumo 
   * @return
   */
  public char getConsumoEnergetico() {
    return consumoEnergetico;
  }
  /**
   * Metodo que devuelve el precio base
   * @return
   */
  public double getPrecioBase() {
    return precioBase;
  }
  /**
   * metodo que devuelve el color
   * @return
   */
  public String getColor() {
    return color;
  }
  /**
   * metodo que devuelve la carga
   * @return
   */
  public double getCarga() {
    return carga;
  }
  /**
   * metodo que nos devuelve el precio final de la lavadora qu hemos comprado 
   * @return
   */
  public double getPrecioFinal()
  {
    double PrecioFinal = 0;
    PrecioFinal=PrecioFinal+precioBase;
    if(peso<=20)
    {
      PrecioFinal=PrecioFinal+PRECIO_20kG;
    }else if((peso>20)&&(peso<=50))
    {
      PrecioFinal=PrecioFinal+PRECIO_20KG_50KG;
    }else if ((peso>50)&&(peso<=80))
    {
      PrecioFinal=PrecioFinal+PRECIO_50KG_80KG;
    }else 
    {
      PrecioFinal=PrecioFinal+PRECIO_MAS_80KG;
    }
    ComprobarConsumo();
    if(consumoEnergetico=='A')
      PrecioFinal=PrecioFinal+PRECIO_A;
    else if(consumoEnergetico=='B')
      PrecioFinal=PrecioFinal+PRECIO_B;
    else if(consumoEnergetico=='C')
        PrecioFinal=PrecioFinal+PRECIO_C;
    else if(consumoEnergetico=='D')
        PrecioFinal=PrecioFinal+PRECIO_D;
    else if(consumoEnergetico=='E')
        PrecioFinal=PrecioFinal+PRECIO_E;
    else if(consumoEnergetico=='F')
        PrecioFinal=PrecioFinal+PRECIO_F;
    
    if(carga>30)
    {
      PrecioFinal=PrecioFinal+PRECIO_CARGA_MAS_30KG;
    }
      
    return PrecioFinal;
  }
  private char ComprobarConsumo()
  {
    if(consumoEnergetico=='A' || consumoEnergetico=='B' || consumoEnergetico=='C' || consumoEnergetico=='D'|| consumoEnergetico=='E' || consumoEnergetico=='F')
    {
      
    }else
    {
      consumoEnergetico='F';
    }
    return consumoEnergetico;
  }
  private String ComprobarColor()
  {
    if (color.equals(COLOR_AZUL)|| color.equals(COLOR_BLANCO) || color.equals(COLOR_GRIS) || color.equals(COLOR_NEGRO) || color.equals(COLOR_ROJO)) {
     
      
    } else
    {
      color="blanco";
    }
    return color;
  }
  
}
