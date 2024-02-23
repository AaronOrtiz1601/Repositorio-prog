package prog.ud06.actividad611.coleccion;
/**
 * Tarjeta de clave de un usuario Una tarjeta de claves contiene una tabla con claves numéricas enteras
 */
public class TarjetaClaves {
  //Atributos de la clase
  private int filas;
  private int columnas;
  private int clave;
  private int [][] tarjetaClave;
  /**
   * Crea una tarjeta de claves con las filas y columnas indicadas Inicialmente las claves son todas 000
   * @param filas
   * @param columnas
   */
  public TarjetaClaves (int filas,int columnas)
  {
    if(filas <= 0 || columnas <= 0)
    {
      throw new IllegalArgumentException();
    }else
    {
      this.filas = filas;
      this.columnas = columnas;
      tarjetaClave = new int [filas][columnas];
    }
  }
  /**
   * Metodo que te devuelve el número de filas
   * @return Nº de filas
   */
  public int getFilas() {
    return filas;
  }
  /**
   * Metodo que te devuelve el número de columas
   * @return Nº de columnas
   */
  public int getColumnas() {
    return columnas;
  }
  /**
   * Metodo al que tu le pasas una fila , una columna y una clave y introducen en la posicion que indiquen las filas y columnas el valor de la clave
   * @param fila
   * @param columna
   * @param clave
   */
  public void setClave(int fila,int columna,int clave) {
    if(clave >= 0 && clave <=999)
    {
      this.clave = clave;
      if((fila >= 1 && fila <= getFilas())&& (columna >= 1 && columna <= getColumnas()))
      {
        tarjetaClave[fila-1][columna-1] = this.clave;
      }else
      {
        throw new IllegalArgumentException();
      }
    
    }else
    {
      throw new IllegalArgumentException();
    }
    
  }
  /**
   * Metodo que sirve para validar la clave que este en la posicion indicada por las filas y columnas
   * @param fila
   * @param columna
   * @param clave
   * @return True o False, dependiendo si la clave es correcta o no 
   */
  public boolean validarClave(int fila,int columna,int clave)
  {
    boolean prueba;
    if((fila >= 1 && fila <= getFilas())&& (columna >= 1 && columna <= getColumnas()))
    {
     if (tarjetaClave[fila-1][columna-1] == clave) 
     {
       prueba = true;
     }else {
       prueba = false;
     }
     
    }else
    {
      throw new IllegalArgumentException();
    }
    return prueba;
      
  }

}
