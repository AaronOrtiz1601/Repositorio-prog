package prog.unidad07.juego;

public class Arquero extends Atacantes {
  private String nivel;
  private static final int DANYO_NOVATO = 5;
  private static final int DANYO_MEDIO = 3;
  private static final int DANYO_EXPERTO = 2;

  public Arquero(String nombre, int vidaInicial, String armadura, String nivel) {
    super(nombre, vidaInicial, armadura);
    if(nivel.equals("novato") || nivel.equals("medio")||nivel.equals("experto"))
    {
      this.nivel = nivel;
    }else {
      throw new IllegalArgumentException();
    }
   
  }
  public void subirNivel(String nivel)
  {
    if(nivel.equals("novato") || nivel.equals("medio")||nivel.equals("experto"))
    {
      subidaCorrectaNivel(nivel);
    }else
    {
      throw new IllegalArgumentException();
    }
  }
  @Override
  public int atacar() {
    int ataque;
    if (estado.equals("muerto"))
    {
      ataque = 0;
    }else {
      if (nivel.equals("novato"))
      {
        ataque = vidaInicial / DANYO_NOVATO;  
      }else if (nivel.equals("medio"))
      {
        ataque = vidaInicial / DANYO_MEDIO;
      }else {
        ataque = vidaInicial / DANYO_EXPERTO;
      }
    }
    return ataque;
  }
  private void subidaCorrectaNivel(String nivel)
  {
    if (this.nivel.equals("novato"))
    {
      if (nivel.equals("medio"))
      {
      this.nivel = nivel;
      }
    }else if (this.nivel.equals("medio"))
    {
      if (nivel.equals("experto"))
      {
        this.nivel = nivel;
      }
    }else if (this.nivel.equals("experto"))
    {
      if (nivel.equals("experto"))
      {
        this.nivel= nivel;
      }
    }
  }
  @Override
  public void serCurado(int puntosCura) {
    
      if (vidaInicial + puntosCura > vidaMaxima)
      {
        vidaInicial = vidaMaxima;
      }else
      {
        vidaInicial += puntosCura;
      }
      
    
    
  }
  @Override
  public String getArmadura() {
    return armadura;
  }

}
