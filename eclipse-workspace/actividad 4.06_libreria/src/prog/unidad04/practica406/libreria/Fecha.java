package prog.unidad04.practica406.libreria;
/**
 * La clase Fecha representa una fecha con dia, mes y anyo.
 */
public class Fecha implements ConvertibleATexto {
  //Atributos de la clase
  private int dia;
  private int mes;
  private int anyo;
  /**
   * constructor de la clase fecha
   * @param dia. Muestra el dia de la fecha
   * @param mes. Muestra el mes de la fecha
   * @param anyo Muestra el anyo de la fecha
   */
  public Fecha(int dia,int mes,int anyo) 
  {
    comprobarAnyo(anyo);
    if (comprobarAnyo(anyo) == true)
    {
      this.anyo = anyo;
    }
    else 
    {
      throw new IllegalArgumentException();
    }
    if (comprobarMes(mes) == true)
    {
      this.mes = mes;
    }
    else
    {
      throw new IllegalArgumentException();
    }
    if (comprobarDia(dia))
    {
      this.dia = dia;
    }
    else
    {
      throw new IllegalArgumentException();
    }
    
  }
  /**
   * 
   * @return Obtiene el dia de la fecha
   */
  public int getDia() {
    return dia;
  }
/**
 * 
 * @return Obtiene el mes de la fecha
 */
  public int getMes() {
    return mes;
  }
/**
 * 
 * @return Obtiene el mes de la fecha
 */
  public int getAnyo() {
    return anyo;
  }
  /**
   * 
   * @return Obtiene true o false dependiendo de si el año es bisiesto o no lo es 
   */
  public boolean esBisiesto()
  {
    boolean prueba = false;
    if ((anyo % 4 == 0)&&(anyo != 1900) )
    {
      prueba = true;
    }
    return prueba;
  }
  /**
   * Combierte los datos de la fecha en una cadena
   * @return Cadena con la informacion de la cadena
   */
  @Override
  public String aTexto() {
   String cadena;
   cadena = dia + " de " + mesEnTexto() + " de " + anyo;
    return cadena;
  }
  /**
   * 
   * @return Devuelve los dias transcurridos entre la fecha creada y el año 1900
   */
  
  public long diasTranscurridos()
  {
    long diasTranscurridos;
    long anyosEnDias = 0;
    long mesesEnDias = 0;
    
    for ( int i = 1900 ; i < anyo ; i++)
    {
      if ((i % 4 == 0)&&(i != 1900))
      {
        anyosEnDias = anyosEnDias + 366;
      }else
      {
        anyosEnDias = anyosEnDias + 365;
      }
    }
    for (int i = 1 ; i < mes ; i++)
    {
      if ((i == 1) || (i == 3)||( i == 5 ) ||( i == 7)||(i == 8)||(i == 10))
      {
        mesesEnDias = mesesEnDias + 31;
      }else if ((i == 4) || (i == 6) || (i == 9) || (i == 11))
      {
        mesesEnDias = mesesEnDias + 30 ;
      }else if (i == 2)
      {
        if ((anyo % 4 == 0)&&(anyo != 1900))
        {
          mesesEnDias = mesesEnDias + 29; 
        }else
        {
          mesesEnDias = mesesEnDias + 28;
        }
      }
    }
    diasTranscurridos = dia -1 + mesesEnDias + anyosEnDias;
    
    return diasTranscurridos ;
  }
  /**
   * 
   * @param fecha posterior a la fecha que llama al metodo
   * @return Devuelve la diferencia de dias de la fecha que llama al metodo y una posterior
   * @throws FechaException. Este error salta si la fecha que llama al metodo es posterior a la otra fecha
   */
  public long diasEntre(Fecha fecha)
  {
    long fecha1 = diasTranscurridos();
    long fecha2 = fecha.diasTranscurridos();
    long fechaTotal;
    fechaTotal = fecha2-fecha1;
    if ( fechaTotal > 0 ) 
    {
      return fechaTotal;
    } else 
    {
      throw new FechaException();
    }
    
  }
  /**
   * 
   * @param fecha 
   * @return Devuelve 1 si la fecha que llama al metodo es mayor que la otra, devuelve 0 si son iguales y -1 si la fecha que llama al metodo es menor que la otra
   */
  public int compara (Fecha fecha)
  {
    int resultadoComp = 0;
    if (diasTranscurridos() >  fecha.diasTranscurridos())
    {
      resultadoComp = 1;
    } else if (diasTranscurridos() <  fecha.diasTranscurridos())
    {
      resultadoComp = -1;
    }
    if (diasTranscurridos() ==  fecha.diasTranscurridos())
    {
      resultadoComp = 0;
    }
    return resultadoComp;
  }

 
  private boolean comprobarAnyo(int anyo)
  {
    boolean prueba = false;
    if (anyo >= 1900)
    {
      prueba = true;
    }
    return prueba;
  }
  private boolean comprobarMes(int mes)
  {
    boolean prueba = false;
    if ((mes>=1)&& (mes<=12))
    {
      prueba = true;
    }
    return prueba; 
  }
  private boolean comprobarDia(int dia)
  {
    boolean prueba = false;
    if (mes != 2) {
      if ((mes == 1) || (mes == 3)||( mes == 5 ) ||( mes == 7)||(mes == 8)||(mes == 10) || (mes == 12))
      {
        if (dia >= 1 && dia <= 31) {
            prueba = true;
        } else {
            prueba = false;
        }
      }else if ((mes == 4) || (mes == 6) || (mes == 9) || (mes == 11))
      {
        if (dia >= 1 && dia <= 30) {
          prueba = true;
      } else {
          prueba = false;
      }
      }
    } else if (mes == 2 && (anyo % 4 == 0)) {
        if (dia >= 1 && dia <= 29) {
            prueba = true;
        } else {
            prueba = false;
        }
    } else if (mes == 2 && (anyo % 4 != 0)) {
        if (dia >= 1 && dia <= 28) {
            prueba = true;
        } else {
            prueba = false;
        }
    }
    return prueba;
  }
  private String mesEnTexto ()
  {
    String mesTx = " ";
    switch (mes) {
    case 1: {
      mesTx = "enero";
      break;
            }
    case 2: {
      mesTx = "febrero";
      break;
            }
    case 3: {
      mesTx = "marzo";
      break;
            }
    case 4: {
      mesTx = "abril";
      break;
            }
    case 5: {
      mesTx = "mayo";
      break;
            }
    case 6: {
      mesTx = "junio";
      break;
            }
    case 7: {
      mesTx = "julio";
      break;
            }
    case 8 : {
      mesTx = "agosto";
      break;
            }
    case 9: {
      mesTx = "septiembre";
      break;
            }
    case 10: {
      mesTx = "octubre";
      break;
            }
    case 11: {
      mesTx = "noviembre";
      break;
            }
    case 12: {
      mesTx = "diciembre";
      break;
      
            }
    
    
    }
    return mesTx;
  }
}
