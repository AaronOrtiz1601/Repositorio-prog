package prog.unidad07.juego;
/** 
 * Clase que define un guerrero
 */
public class Guerrero extends Atacantes {
 /**
  * Atributo de la clase guerrero
  * Nos dice el arma de nuestro guerrero
  */
  private String arma;
  /**
   * Constante que nos dice el daño dijo de la espada
   */
  private static final int DANYO_ESPADA = 2;
 
  /**
   * Creacion del guerrero
   * @param nombre
   * @param vidaInicial
   * @param armadura
   * @param arma
   */
  protected Guerrero(String nombre, int vidaInicial, String armadura, String arma) {
    super(nombre, vidaInicial, armadura);

    if (arma.equals("espada") || arma.equals("maza")) {
      this.arma = arma;
    } else {
      throw new IllegalArgumentException();
    }

  }
  /**
   * Metodo que simula un ataque de un personaje
   * 
   * @return daño realizado por el personaje
   */
  @Override
  public int atacar() {
    int ataque;
    if (estado.equals("muerto")) {
      ataque = 0;
    } else if (arma.equals("espada")) {
      ataque = vidaInicial / DANYO_ESPADA;
    } else {
      ataque = vidaInicial;
    }
    return ataque;
  }
 /**
  * Metodo que intercambia el arma de nuestro guerrero a la otra posible
  * @param arma
  */
  public void cambiarArma(String arma) {
    if (arma.equals("espada") || arma.equals("maza")) {
      this.arma = arma;
    } else {
      throw new IllegalArgumentException();
    }
  }

  @Override
  public void serCurado(int puntosCura) {
    if (vidaInicial + puntosCura * 2 > vidaMaxima) {
      vidaInicial = vidaMaxima;
    } else {
      vidaInicial += puntosCura * 2;
    }

  }
 /**
  * Nos dice si nuestro guerrero porta una armadura o no
  */
  @Override
  public String getArmadura() {
    return armadura;
  }

}
