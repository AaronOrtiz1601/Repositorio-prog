package prog.unidad07.juego;

/**
 * Clase personaje,esta clase representa a un personaje de un juego de rol
 */
public abstract class Personaje {
  /**
   * Atributos de la clase personaje 
   * nombre, este define el nombre que tiene el personaje 
   * vidaInicial, este marca la vida inicial y la vida maxima de nuestro personaje
   * estado, este atributo nos indica si nuestro personaje esta vivo o muerto
   * vidaMaxima, es la vida maxima a la que puede llegar nuestro personaje,esta se fija al introducir la vida inicial de nuestro personaje
   */
  protected String nombre;
  protected int vidaInicial;
  protected String estado = "vivo";
  protected int vidaMaxima;
  
/**
 * Metodo que devuelve el nombre
 * @return nombre
 */
  public String getNombre() {
    return nombre;
  }
  /**
   * Metodo que devuelve la vida
   * @return vida inicial
   */
  public int getVida() {
    return vidaInicial;
  }
  /**
   * Metodo que devuelve el estado de nuestro personaje( muerto o vivo )
   * @return estado
   */
  public String getEstado() {
    return estado;
  }

  /**
   * Creación del personaje
   * 
   * @param nombre , nombre del personaje
   * @param vidaInicial, vida inicial y maxima del personaje
   */

  protected Personaje(String nombre, int vidaInicial) {
    if (nombre.isBlank() || vidaInicial <= 0) {
      throw new IllegalArgumentException();
    } else {
      this.nombre = nombre;
      this.vidaInicial = vidaInicial;
     
    }
  }

  /**
   * Metodo que simula un ataque de un personaje
   * 
   * @return daño realizado por el personaje
   */
  public abstract int atacar();

  /**
   * Metodo que simula un ataque de un oponente
   */
  public abstract void serAtacado(int danyo);

  /**
   * Metodo que simula la curación de un personaje
   * 
   * @return daño recuperado por el personaje
   */
  public abstract int curar();

  /**
   * Metodo que simula la curación
   */
  public abstract void serCurado(int puntosCura);
  

}
