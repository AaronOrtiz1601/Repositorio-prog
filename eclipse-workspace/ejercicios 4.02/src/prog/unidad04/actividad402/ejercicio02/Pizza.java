package prog.unidad04.actividad402.ejercicio02;


/**
 * Clase que representa a una pizza
 * @author Aarón
 * @version 1.0
 */
public class Pizza {

  // Estados de la pizza
  /**
   * Pizza pedida
   */
  public static final String ESTADO_PEDIDA = "pedida";
  
  /**
   * Pizza servida
   */
  public static final String ESTADO_SERVIDA = "servida";
  
  // Tamaños de la pizza
  /**
   * Tamaño mediano
   */
  public static final String TAMANYO_MEDIANA = "mediana";
 
  /**
   * Tamaño familiar
   */
  public static final String TAMANYO_FAMILIAR = "familiar";
 
  // Tipos de la pizza
  /**
   * Tipo cuatro quesos
   */
  public static final String TIPO_CUATRO_QUESOS = "cuatro quesos";
  
  /**
   * Tipo Funghi
   */
  public static final String TIPO_FUNGHI = "funghi";
  
  /**
   * Tipo Margarita
   */
  public static final String TIPO_MARGARITA = "margarita";
  
  //precio de las MASAS
  
  /**
   * PRECIO MASA MEDIANA
   */
  private static final double PRECIO_MEDIANA = 5;
  
  /**
   * PRECIO MASA FAMILIAR
   */
  private static final double PRECIO_FAMILIAR=7.5;
  
  /**
   * precio por ingrediente
   */
  private static final double PRECIO_INGREDIENTE=1;
  //NUMERO DE INGREDIENTES DE CADA PIZZA
  /**
   * INGREDIENTES PIZZA  MARGARITA
   */
  private static final double INGREDIENTES_MARGARITA=2;
  /**
   * Ingredientes pizza funghi
   */
  private static final double INGREDIENTES_FUNGHI=3;
  /**
   * iNGREDIENTES 4 QUESOS
   */
  private static final double INGREDIENTES_4QUESOS=4;
  
  //Atributos estáticos
  // Número total de pizzas creadas
  private static int pizzasCreadas = 0;
  // Número total de pizzas servidas
  private static int pizzasServidas = 0;
   
  
  // Atributos
  private String tamanyo;
  private String tipo;
  private String estado = ESTADO_PEDIDA;
  private double precioTotal;

  


  // Constructor
  /**
   * Constructor. Imprime error si alguno de los parámetros no son correctos.
   * @param tamanyo - Tamaño de la pizza. Debe ser "mediana" o "familiar"
   * @param tipo - Tipo de la pizza. Debe ser "margarita", "cuatro quesos" o "funghi"
   */
  public Pizza(String tamanyo, String tipo) {
    
    // Suponemos los parámetros bien
    boolean bParametrosOK = true;
    //Si el tamaño no es correcto, mostramos error
    if (!tamanyo.equals(TAMANYO_MEDIANA) && !tamanyo.equals(TAMANYO_FAMILIAR)) {
      System.out.println("El parámetro tamaño no es correcto. Debe ser uno de " + TAMANYO_MEDIANA + " o " + TAMANYO_FAMILIAR);
      bParametrosOK = false;
    }
    
    // Si el tipo no es correcto, mostramos error
    if (!tipo.equals(TIPO_MARGARITA) && !tipo.equals(TIPO_CUATRO_QUESOS) && !tipo.equals(TIPO_FUNGHI) ) {
      System.out.println("El parámetro tipo no es correcto. Debe ser uno de " + TIPO_MARGARITA + ", " + TAMANYO_FAMILIAR 
          + " o " + TIPO_FUNGHI);
      bParametrosOK = false;
    }
    
    // Inicializamos los atributos
    this.tamanyo = tamanyo;
    this.tipo = tipo;
    
    if (bParametrosOK)
      pizzasCreadas++;
    
  }

  /**
   * Obtiene el número de pizzas creadas hasta el momento
   * @return El número de pizzas creadas hasta el momento
   */
  public static int getPizzasCreadas() {
    return pizzasCreadas;
  }

  /**
   * Obtiene el número de pizzas servidas hasta el momento
   * @return El número de pizzas servidas hasta el momento
   */
  public static int getPizzasServidas() {
    return pizzasServidas;
  }

  /**
   * Obtiene el tamaño de la pizza
   * @return Tamaño de la pizza
   */
  public String getTamanyo() {
    return tamanyo;
  }

  /**
   * Obtiene el tipo de la pizza
   * @return Tipo de la pizza
   */
  public String getTipo() {
    return tipo;
  }

  /**
   * Obtiene el estado de la pizza
   * @return Estado de la pizza
   */
  public String getEstado() {
    return estado;
  }
 
  /**
   * Sirve la pizza. Muestra un error si la pizza ya está servida.
   */
  public void sirve() {
    if (estado.equals(ESTADO_PEDIDA)) {
      estado = ESTADO_SERVIDA;
      pizzasServidas++;
    }else {
      System.out.println("Error. Esta pizza ya se ha servido.");
    }
  }
  /**
   * Obtiene el coste de la pizza
   * @return 
   * @return Obtiene el coste de la pizza según el tamaño y el tipo
   */
  public double coste() {
    if(tamanyo.equals(TAMANYO_MEDIANA))
    {
      precioTotal=PRECIO_MEDIANA;
      if(tipo.equals(TIPO_MARGARITA)) {
        precioTotal = precioTotal + INGREDIENTES_MARGARITA;
        
      }else if(tipo.equals(TIPO_FUNGHI)) {
        precioTotal = precioTotal + INGREDIENTES_FUNGHI;
        
      }else if(tipo.equals(TIPO_CUATRO_QUESOS)) {
        precioTotal = precioTotal + INGREDIENTES_4QUESOS;
        
      }
      
    }else if (tamanyo.equals(TAMANYO_FAMILIAR))
    {
      precioTotal=PRECIO_FAMILIAR;
      if(tipo.equals(TIPO_MARGARITA)) {
        precioTotal = precioTotal + INGREDIENTES_MARGARITA;
        
      }else if(tipo.equals(TIPO_FUNGHI)) {
        precioTotal = precioTotal + INGREDIENTES_FUNGHI;
        
      }else if(tipo.equals(TIPO_CUATRO_QUESOS)) {
        precioTotal = precioTotal + INGREDIENTES_4QUESOS;
        
      }
      
    }
    return precioTotal;
    
  }
  
  
  
}
