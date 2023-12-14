package prog.unidad04.actividad406.libreria;

public class Fecha {
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
    if (anyo % 4 == 0 )
    {
      prueba = true;
    }
    return prueba;
  }
  public String aTexto() 
  {
   String cadena = "" ;
   return cadena;
  }
  
  public long diasTranscurridos()
  {
    long diasTranscurridos;
    long añosEnDias = 0;
    long mesesEnDias = 0;
    
    for ( int i = 1900 ; i < anyo ; i++)
    {
      if (i % 4 == 0)
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
        if ( anyo % 4 == 0)
        {
          mesesEnDias = mesesEnDias + 29; 
        }else
        {
          mesesEnDias = mesesEnDias + 28;
        }
      }
    }
    diasTranscurridos = dia + mesesEnDias + añosEnDias;
    
    return diasTranscurridos;
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
}
