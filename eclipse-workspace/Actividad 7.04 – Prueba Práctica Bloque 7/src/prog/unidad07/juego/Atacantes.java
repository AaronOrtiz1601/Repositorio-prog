package prog.unidad07.juego;

public abstract class Atacantes extends Personaje {
  private static final int PROTECCION_ARMADURA = 2;
  protected String armadura;

  protected Atacantes(String nombre, int vidaInicial, String armadura) {
    super(nombre, vidaInicial);
    vidaMaxima = this.vidaInicial;
    if (armadura.equals("sin armadura") || armadura.equals("con armadura")) {
      this.armadura = armadura;

    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public abstract int atacar();

  @Override
  public void serAtacado(int danyo) {

    if (danyo < 0) {
      throw new IllegalArgumentException();
    } else if (armadura.equals("con armadura")) {
      vidaInicial -= danyo / PROTECCION_ARMADURA;
      armadura = "sin armadura";
    } else {
      vidaInicial -= danyo;
    }
    if (vidaInicial <= 0) {
      estado = "muerto";
    }

  }

  @Override
  public int curar() {
    return 0;
  }

  @Override
  public abstract void serCurado(int puntosCura);
  public void obtieneArmadura()
  {
    if (armadura.equals("sin armadura"))
    {
      armadura = "con armadura";
    }
  }

  public abstract String getArmadura() ;

}
