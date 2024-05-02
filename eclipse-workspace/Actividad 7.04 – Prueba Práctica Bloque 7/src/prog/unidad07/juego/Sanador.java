package prog.unidad07.juego;
/**
 * Clase que define un sanador
 */
public class Sanador extends Curanderos {
  private static final int PLUS_CURA =  3;
  private static final int CURA_FIJA = 2;

  public Sanador(String nombre, int vidaInicial) {
    super(nombre, vidaInicial);
  }

  @Override
  public void serAtacado(int danyo) {
    
    if (danyo < 0)
    {
      throw new IllegalArgumentException();
    }else {
    vidaInicial -= danyo;

    if (vidaInicial <= 0) {
      estado = "muerto";
      vidaInicial = 0;
    }
    }

  }

  @Override
  public int curar() {
    return vidaInicial / CURA_FIJA;
  }

  @Override
  public void serCurado(int puntosCura) {
    if (vidaInicial + puntosCura + (puntosCura / PLUS_CURA) > vidaMaxima) {
      vidaInicial = vidaMaxima;
    } else {
      vidaInicial += puntosCura + (puntosCura / PLUS_CURA);
    }

  }

  

}
