package sinRefactorizar;

import sinRefactorizar.Trabajador.TipoTrabajo;

public class CostePersonal {
  
  static float costeDelPersona (Trabajador trabajadores[]) {
    float costeFinal = 0;
    Trabajador trabajador;
    for(int i = 0;i < trabajadores.length; i++)
    {
      trabajador = trabajadores[i];
      
      if( trabajador.Trab() == TipoTrabajo.DIRECTOR || trabajador.Trab() == TipoTrabajo.SUBDIRECTOR) {
        costeFinal += trabajador.getNom();
      }else {
        costeFinal += trabajador.getNom() + (trabajador.getMasTrab() * 20);
      }
    }
    return costeFinal;
    
  }

}
