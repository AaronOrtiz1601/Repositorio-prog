package prog.unidad07.juego;

public class Sacerdote extends Curanderos {

  private String reliquia;
  private static final int PLUS_CURA = 2;

  public Sacerdote(String nombre, int vidaInicial, String reliquia) {
    super(nombre, vidaInicial);
    if (reliquia.equals("tiene reliquia") || reliquia.equals("no tiene reliquia")) {
      this.reliquia = reliquia;
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void serAtacado(int danyo) {
    if (danyo < 0) {
      throw new IllegalArgumentException();
    } else {
      if (reliquia.equals("tiene reliquia")) {
        reliquia = "no tiene reliquia";
      } else {
        vidaInicial -= danyo;
      }
      if (vidaInicial <= 0) {
        estado = "muerto";
        vidaInicial = 0;
      }
    }
  }

  @Override
  public int curar() 
  {
    int cura;
    if (estado.equals("muerto"))
    {
      cura = 0;
    }else if (reliquia.equals("tiene reliquia")) {
      cura = vidaInicial;
      
    }else {
      cura = vidaInicial /  PLUS_CURA;
    }
    return cura;
  }

  @Override
  public void serCurado(int puntosCura) {
    if (puntosCura < 0) {
      throw new IllegalArgumentException();
    } else {
      if (reliquia.equals("tiene reliquia")) {
      if( vidaInicial + puntosCura + (puntosCura * PLUS_CURA) > vidaMaxima )
      {
        vidaInicial = vidaMaxima;
      }else
      {
        vidaInicial += puntosCura + (puntosCura * PLUS_CURA);
      }
      
      }
      
    }

  }
  public void optieneReliquia()
  {
    if (reliquia.equals("no tiene reliquia"))
    {
      reliquia = "tiene reliquia";
    }
  }

  public String getReliquia() {
    return reliquia;
  }

  

}
