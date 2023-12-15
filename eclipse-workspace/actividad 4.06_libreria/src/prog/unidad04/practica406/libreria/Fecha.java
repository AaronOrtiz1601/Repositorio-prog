package prog.unidad04.practica406.libreria;

public class Fecha implements ConvertibleATexto {
  private int dia;
  private int mes;
  private int anyo;
  
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
  
  public int getDia() {
    return dia;
  }

  public int getMes() {
    return mes;
  }

  public int getAnyo() {
    return anyo;
  }
  public boolean esBisiesto()
  {
    boolean prueba = false;
    if ((anyo % 4 == 0)&&(anyo != 1900) )
    {
      prueba = true;
    }
    return prueba;
  }
  @Override
  public String aTexto() {
   String cadena;
   cadena = dia + " de" + mesEnTexto() + " de " + anyo;
    return null;
  }
  
  public long diasTranscurridos()
  {
    long diasTranscurridos;
    long añosEnDias = 0;
    long mesesEnDias = 0;
    
    for ( int i = 1900 ; i < anyo ; i++)
    {
      if ((i % 4 == 0)&&(i != 1900))
      {
        añosEnDias = añosEnDias + 366;
      }else
      {
        añosEnDias = añosEnDias + 365;
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
    diasTranscurridos = dia -1 + mesesEnDias + añosEnDias;
    
    return diasTranscurridos ;
  }
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
    if ((mes>=1)||(mes<=12))
    {
      prueba = true;
    }
    return prueba; 
  }
  private boolean comprobarDia(int dia)
  {
    boolean prueba = false;
    if (mes != 2) {
        if (dia >= 1 && dia <= 31) {
            prueba = true;
        } else {
            prueba = false;
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
      mesTx = "Enero";
            }
    case 2: {
      mesTx = "Febrero";
            }
    case 3: {
      mesTx = "Marzo";
            }
    case 4: {
      mesTx = "Abril";
            }
    case 5: {
      mesTx = "Mayo";
            }
    case 6: {
      mesTx = "Junio";
            }
    case 7: {
      mesTx = "Julio";
            }
    case 8 : {
      mesTx = "Agosto";
            }
    case 9: {
      mesTx = "Septiembre";
            }
    case 10: {
      mesTx = "Octubre";
            }
    case 11: {
      mesTx = "Noviembre";
            }
    case 12: {
      mesTx = "Diciembre";
      
            }
    
    
    }
    return mesTx;
  }
}
