package prog.ud06.actividad611.coleccion;

public class TarjetaClaves {
  private int filas;
  private int columnas;
  private int clave;
  private int [][] tarjetaClave;
  
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

  public int getFilas() {
    return filas;
  }

  public int getColumnas() {
    return columnas;
  }

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
