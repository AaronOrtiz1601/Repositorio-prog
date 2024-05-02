package sinRefactorizar;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import sinRefactorizar.Trabajador.TipoTrabajo;

class PruebasSinRefactorizar {

  @Test
  void test1() {
    Trabajador[] trabajadores = {
        new Trabajador(1000, 0, TipoTrabajo.DIRECTOR),
        new Trabajador(800, 0, TipoTrabajo.SUBDIRECTOR),
        new Trabajador(500, 5, TipoTrabajo.EMPLEADO)
    };
    float coste = 1000 + 800 + 500 + (5 * 20);
    assertEquals (coste, CostePersonal.costeDelPersona(trabajadores));
  }
  @Test
  void test2() {
    Trabajador[] trabajadores = {
        new Trabajador(3000, 0, TipoTrabajo.DIRECTOR),
        new Trabajador(1000, 0, TipoTrabajo.SUBDIRECTOR),
        new Trabajador(1500, 5, TipoTrabajo.EMPLEADO),
        new Trabajador(200, 20, TipoTrabajo.EMPLEADO)
    };
    float coste = 3000 + 1000 + (1500 + (5 * 20)) + (200 + (20 * 20));
    assertEquals (coste, CostePersonal.costeDelPersona(trabajadores));
  }
  @Test
  void test3() {
    Trabajador[] trabajadores = {
        new Trabajador(2000, 0, TipoTrabajo.DIRECTOR),
        new Trabajador(1500, 0, TipoTrabajo.SUBDIRECTOR),
        
    };
    assertEquals (3500, CostePersonal.costeDelPersona(trabajadores));
  }
  @Test
  void test4() {
    Trabajador[] trabajadores = {
        new Trabajador(100, 30, TipoTrabajo.EMPLEADO),
        new Trabajador(3000, 20, TipoTrabajo.EMPLEADO),
        new Trabajador(1500, 5, TipoTrabajo.EMPLEADO),
        new Trabajador(200, 20, TipoTrabajo.EMPLEADO)
    };
    float coste = (100 + (30 * 20))+(3000 + (20 * 20)) +(1500 + (5 * 20)) + (200 + (20 * 20));
    assertEquals (coste, CostePersonal.costeDelPersona(trabajadores));
  }

}
