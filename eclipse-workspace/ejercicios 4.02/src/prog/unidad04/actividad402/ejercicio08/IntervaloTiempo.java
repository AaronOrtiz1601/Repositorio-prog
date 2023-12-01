package prog.unidad04.actividad402.ejercicio08;

public class IntervaloTiempo {
  private int segundos;
  private int minutos;
  private int horas;
  
  public IntervaloTiempo(int horas,int minutos,int segundos)
  {
    if(segundos<60)
      this.segundos=segundos;
      else
      {
        this.segundos = segundos % 60;
        minutos+= segundos / 60;
        
      }
    if(minutos<60)
    this.minutos=minutos;
    else
    {
      
      this.minutos=minutos % 60;
      horas+=minutos / 60;
    }
    this.horas=horas;
   
  }
  public IntervaloTiempo suma(IntervaloTiempo otro)
  {
    int segundos = this.segundos + otro.segundos;
    int minutos = this.minutos + otro.minutos;
    int horas = this.horas + otro.horas;
    return new IntervaloTiempo(horas,minutos,segundos);
    }
  public IntervaloTiempo resta(IntervaloTiempo otro)
  {
    int segundos = this.segundos - otro.segundos;
    int minutos = 0;
    int horas = this.horas + otro.horas;
    if(segundos < 0)
    {
      segundos +=60;
      minutos = 1;
    }
    minutos= this.minutos - otro.minutos - minutos;
    if (minutos < 0) {
      minutos += 60;
      horas =1;
      
    }
    horas = this.horas -otro.horas - horas;
    if (horas >=0) {
      return new IntervaloTiempo(horas,minutos,segundos);
      
      
    }else
    return null;
  }
  public String obtenerCadena()
  {
    return horas + "h "+ minutos + "m "+ segundos + "s";
  }
  

}
