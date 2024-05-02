package refactorizado;

/**
 * Clase que simula un trabajador
 */

public class Trabajador {
  /**
   * Declaracion de atributos
   */
   
    private double nomina;
    private int horasExtra;
    private  TipoTrabajo tipo;
    
    /**
     * Creación de una numeración con los posibles puestos de los trabajadores
     */
    public enum TipoTrabajo{
      DIRECTOR,
      SUBDIRECTOR,
      EMPLEADO
    }
    /**
     * Constructor de la clse trabajador
     * @param nomina. Guarda lo que cobra el trabajador
     * @param horasExtra. Guarda el número de horas extra que a dado el trabajador
     * @param tipo. Guarda el puesto de trabajo que tiene el trabajador
     */
    Trabajador(double nomina,int horasExtra,TipoTrabajo tipo)
    {
      this.nomina = nomina;
      this.horasExtra = horasExtra;
      this.tipo = tipo;
    }
    /**
     * Metodo que te devuelve lo que cobra un trabajador
     * @return nomina
     */
    public double getNomina() {
      return nomina;
    }
    /**
     * Metodo que te devuelve las horas extra que realiza un trabajador
     * @return horasExtra
     */
    public int getHorasExtra() {
      return horasExtra;
    }
    /**
     * Metodo que te devuelve el puesto que tiene un trabajador
     * @return tipo
     */
    public TipoTrabajo getPuestoDeTrabajo() {
      return tipo;
    }


  }


