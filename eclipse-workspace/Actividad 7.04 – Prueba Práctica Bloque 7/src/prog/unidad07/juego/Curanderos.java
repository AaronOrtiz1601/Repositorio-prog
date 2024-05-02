package prog.unidad07.juego;

public abstract class Curanderos extends Personaje {

  public Curanderos(String nombre, int vidaInicial) {
    super(nombre, vidaInicial);
    // TODO Auto-generated constructor stub
  }

  @Override
  public int atacar() {
    return 0;
  }

  @Override
  public abstract void serAtacado(int danyo);

  @Override
  public abstract int curar();

  @Override
  public abstract void serCurado(int puntosCura) ;

}
