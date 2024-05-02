package refactorizado;

import refactorizado.Trabajador.TipoTrabajo;
/**
 * Clase que se encarga de calcular el coste del personal
 */
public class CostePersonal {
  /**
   * Constante que almacena el pago fijo por cada hora extra que des
   */
  private static final int PAGO_HORAS_EXTRA = 20;
  /**
   * Metodo para calcular el coste
   * @param trabajadores. Es una lista de trabajadores
   * @return Devuelve un float con el coste total de los trabajadores
   */
  static float costeDelPersona (Trabajador trabajadores[]) {
    //Llamada a un metodo privado que calcula el coste
    return calculoDelCoste (trabajadores);
  }
  /**
   * Metodo privado que realiza los calculos del metodo publico costeDelPersona
   */
 private static float calculoDelCoste (Trabajador trabajadores[])
 {
   //Declaración de una variable que almacenara el coste
   float costeFinal = 0;
   //Creación de un nuevo trabajador
   Trabajador trabajador;
   //Bucle que recorre la lista dada y empieza a almacenar las nominas de todos los trabajadores en la variable que creamos antes 
   for(int i = 0;i < trabajadores.length; i++)
   {
     trabajador = trabajadores[i];
     //Comprobación de si el trabajador es el director/subdirector o otro, si es el caso de estos la horas extra no se le pagan,si no lo es si se les paga
     if( trabajador.getPuestoDeTrabajo() == TipoTrabajo.DIRECTOR || trabajador.getPuestoDeTrabajo() == TipoTrabajo.SUBDIRECTOR) {
       costeFinal += trabajador.getNomina();
     }else {
       costeFinal += trabajador.getNomina() + (trabajador.getHorasExtra() * PAGO_HORAS_EXTRA);
     }
   }
   //Devuelve el coste final
   return costeFinal;
 }
 

}
