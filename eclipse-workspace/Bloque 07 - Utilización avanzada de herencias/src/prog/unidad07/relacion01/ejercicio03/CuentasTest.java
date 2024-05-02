package prog.unidad07.relacion01.ejercicio03;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import prog.unidad07.relacion01.ejercicio02.empleadosFijos;

class CuentasTest {

  @Test
  void saldo0() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    assertEquals(cuenta.saldoDeLaCuenta, 0);
  }
  @Test
  void saldo0Act() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 0);
  }
  @Test
  void ingreso() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(90);
    assertEquals(cuenta.saldoDeLaCuenta, 90);
  }
  @Test
  void ingresoYAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(90);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 80);
  }
  @Test
  void ingreso100() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(100);
    assertEquals(cuenta.saldoDeLaCuenta, 100);
  }
  @Test
  void ingreso100YAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(100);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 90);
  }
  @Test
  void ingreso110() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(110);
    assertEquals(cuenta.saldoDeLaCuenta, 110);
  }
  @Test
  void ingreso110YAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(110);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 100);
  }
  @Test
  void ingreso200() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(200);
    assertEquals(cuenta.saldoDeLaCuenta, 200);
  }
  @Test
  void ingreso200YAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(200);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 190);
  }
  @Test
  void ingreso200YRetiro() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(200);
    cuenta.retirarSaldo(50);
    assertEquals(cuenta.saldoDeLaCuenta, 150);
  }
  @Test
  void ingreso200RetiroYAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(200);
    cuenta.retirarSaldo(50);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 140);
  }
  @Test
  void ingreso600YRetiro() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(600);
    cuenta.retirarSaldo(50);
    assertEquals(cuenta.saldoDeLaCuenta, 550);
  }
  @Test
  void ingreso600RetiroYAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(600);
    cuenta.retirarSaldo(50);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 540);
  }
  @Test
  void ingreso550YRetiro() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(550);
    cuenta.retirarSaldo(50);
    assertEquals(cuenta.saldoDeLaCuenta, 500);
  }
  @Test
  void ingreso550RetiroYAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(550);
    cuenta.retirarSaldo(50);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 490);
  }
  @Test
  void ingreso549YRetiro() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(549);
    cuenta.retirarSaldo(50);
    assertEquals(cuenta.saldoDeLaCuenta, 499);
  }
  @Test
  void ingreso540RetiroYAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(549);
    cuenta.retirarSaldo(50);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 479);
  }
  @Test
  void retiro550() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(549);
    assertThrows(IllegalArgumentException.class, () -> cuenta.retirarSaldo(550));
  }
  @Test
  void operacionesMultiples() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new Cuenta(dni, nombre);
    cuenta.anyadirSaldo(1200);
    cuenta.retirarSaldo(259.88);
    cuenta.retirarSaldo(94.80);
    cuenta.actualizacionMensual();
    cuenta.anyadirSaldo(1200);
    cuenta.retirarSaldo(372.08);
    cuenta.retirarSaldo(659.14);
    cuenta.retirarSaldo(388.66);
    cuenta.actualizacionMensual();
    cuenta.anyadirSaldo(1200);
    cuenta.retirarSaldo(412.56);
    cuenta.retirarSaldo(30.09);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 1352.79);
  }
  @Test
  void  CuentaDeInteres() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new CuentaInteres(dni, nombre);
    assertEquals(cuenta.saldoDeLaCuenta, 0);
  }
  @Test
  void  CuentaDeInteresAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new CuentaInteres(dni, nombre);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 0);
  }
  @Test
  void  CuentaDeInteresIngreso() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new CuentaInteres(dni, nombre);
    cuenta.anyadirSaldo(90);
    assertEquals(cuenta.saldoDeLaCuenta, 90);
  }
  @Test
  void  CuentaDeInteresIngresoYAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new CuentaInteres(dni, nombre);
    cuenta.anyadirSaldo(90);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 81.53);
  }
  @Test
  void  CuentaDeInteresIngresoYDobleAct() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new CuentaInteres(dni, nombre);
    cuenta.anyadirSaldo(90);
    cuenta.actualizacionMensual();
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 73.86);
  }
  @Test
  void  CuentaDeInteresIngreso100() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new CuentaInteres(dni, nombre);
    cuenta.anyadirSaldo(100);
    assertEquals(cuenta.saldoDeLaCuenta, 100);
    
  }
  @Test
  void  CuentaDeInteresIngreso100Act() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new CuentaInteres(dni, nombre);
    cuenta.anyadirSaldo(100);
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 90.58 );
    
  }
  @Test
  void  CuentaDeInteresIngreso100Y2Act() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new CuentaInteres(dni, nombre);
    cuenta.anyadirSaldo(100);
    cuenta.actualizacionMensual();
    cuenta.actualizacionMensual();
    assertEquals(cuenta.saldoDeLaCuenta, 82.05 );
    
  }
  @Test
  void  CuentaDeInteresIngreso110() {
    String dni = "26845672A";
    String nombre = "Paco";
    Cuenta cuenta = new CuentaInteres(dni, nombre);
    cuenta.anyadirSaldo(110);
    assertEquals(cuenta.saldoDeLaCuenta, 110);
  }
    @Test
    void  CuentaDeInteresIngreso110Act() {
      String dni = "26845672A";
      String nombre = "Paco";
      Cuenta cuenta = new CuentaInteres(dni, nombre);
      cuenta.anyadirSaldo(110);
      cuenta.actualizacionMensual();
      assertEquals(cuenta.saldoDeLaCuenta, 100.64);
    
  }
    @Test
    void  CuentaDeInteresIngreso200() {
      String dni = "26845672A";
      String nombre = "Paco";
      Cuenta cuenta = new CuentaInteres(dni, nombre);
      cuenta.anyadirSaldo(200);
      assertEquals(cuenta.saldoDeLaCuenta, 200);
    }
      @Test
      void  CuentaDeInteresIngreso200Act() {
        String dni = "26845672A";
        String nombre = "Paco";
        Cuenta cuenta = new CuentaInteres(dni, nombre);
        cuenta.anyadirSaldo(200);
        cuenta.actualizacionMensual();
        assertEquals(cuenta.saldoDeLaCuenta, 191.17);
      
    }
      @Test
      void  CuentaDeInteresIngreso200Retiro50() {
        String dni = "26845672A";
        String nombre = "Paco";
        Cuenta cuenta = new CuentaInteres(dni, nombre);
        cuenta.anyadirSaldo(200);
        cuenta.retirarSaldo(50);
        assertEquals(cuenta.saldoDeLaCuenta, 150);
      }
        @Test
        void  CuentaDeInteresIngreso200Retiro50Act() {
          String dni = "26845672A";
          String nombre = "Paco";
          Cuenta cuenta = new CuentaInteres(dni, nombre);
          cuenta.anyadirSaldo(200);
          cuenta.retirarSaldo(50);
          cuenta.actualizacionMensual();
          assertEquals(cuenta.saldoDeLaCuenta, 140.88);
        
      }
        @Test
        void  CuentaDeInteresIngreso600Retiro50() {
          String dni = "26845672A";
          String nombre = "Paco";
          Cuenta cuenta = new CuentaInteres(dni, nombre);
          cuenta.anyadirSaldo(600);
          cuenta.retirarSaldo(50);
          assertEquals(cuenta.saldoDeLaCuenta, 550);
        }
          @Test
          void  CuentaDeInteresIngreso600Retiro50Act() {
            String dni = "26845672A";
            String nombre = "Paco";
            Cuenta cuenta = new CuentaInteres(dni, nombre);
            cuenta.anyadirSaldo(600);
            cuenta.retirarSaldo(50);
            cuenta.actualizacionMensual();
            assertEquals(cuenta.saldoDeLaCuenta, 543.21);
          
        }
          @Test
          void  CuentaDeInteresIngreso550Retiro50() {
            String dni = "26845672A";
            String nombre = "Paco";
            Cuenta cuenta = new CuentaInteres(dni, nombre);
            cuenta.anyadirSaldo(550);
            cuenta.retirarSaldo(50);
            assertEquals(cuenta.saldoDeLaCuenta, 500);
          }
            @Test
            void  CuentaDeInteresIngreso550Retiro50Act() {
              String dni = "26845672A";
              String nombre = "Paco";
              Cuenta cuenta = new CuentaInteres(dni, nombre);
              cuenta.anyadirSaldo(550);
              cuenta.retirarSaldo(50);
              cuenta.actualizacionMensual();
              assertEquals(cuenta.saldoDeLaCuenta, 492.92);
            }
            @Test
            void  CuentaDeInteresIngreso549Retiro50() {
              String dni = "26845672A";
              String nombre = "Paco";
              Cuenta cuenta = new CuentaInteres(dni, nombre);
              cuenta.anyadirSaldo(549);
              cuenta.retirarSaldo(50);
              assertEquals(cuenta.saldoDeLaCuenta, 499);
            }
              @Test
              void  CuentaDeInteresIngreso549Retiro50Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaInteres(dni, nombre);
                cuenta.anyadirSaldo(549);
                cuenta.retirarSaldo(50);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 491.91);
              }
              @Test
              void  CuentaDeInteresIngreso500Retiro501() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaInteres(dni, nombre);
                cuenta.anyadirSaldo(500);
                assertThrows(IllegalArgumentException.class, () -> cuenta.retirarSaldo(501));
              
                
              }
              @Test
              void operacionesMultiplesCuentasInteres() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaInteres(dni, nombre);
                cuenta.anyadirSaldo(1200);
                cuenta.retirarSaldo(259.88);
                cuenta.retirarSaldo(94.80);
                cuenta.actualizacionMensual();
                cuenta.anyadirSaldo(1200);
                cuenta.retirarSaldo(372.08);
                cuenta.retirarSaldo(659.14);
                cuenta.retirarSaldo(388.66);
                cuenta.actualizacionMensual();
                cuenta.anyadirSaldo(1200);
                cuenta.retirarSaldo(412.56);
                cuenta.retirarSaldo(30.09);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 1369.34);
              }
              
              @Test
              void  CuentaAbierta() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                assertEquals(cuenta.saldoDeLaCuenta, 0);
              }
              @Test
              void  CuentaAbiertaAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 0);
                
              }
              @Test
              void  CuentaAbiertaIngreso() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(90);
                assertEquals(cuenta.saldoDeLaCuenta, 90);
              }
              @Test
              void  CuentaAbiertaIngresoAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(90);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 81.43);
              }
              @Test
              void  CuentaAbiertaIngresoDobleAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(90);
                cuenta.actualizacionMensual();
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 73.77 );
              }
              @Test
              void  CuentaAbiertaIngreso100() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(100);
                assertEquals(cuenta.saldoDeLaCuenta, 100);
              }
              @Test
              void  CuentaAbiertaIngreso100Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(100);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 90.48 );
              }
              @Test
              void  CuentaAbiertaIngreso100DobleAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(100);
                cuenta.actualizacionMensual();
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 81.96);
              }
              @Test
              void  CuentaAbiertaIngreso110() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(110);
                assertEquals(cuenta.saldoDeLaCuenta, 110);
              }
              @Test
              void  CuentaAbiertaIngreso110Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(110);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 100.54 );
              }
              @Test
              void  CuentaAbiertaIngreso200() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(200);
                assertEquals(cuenta.saldoDeLaCuenta, 200);
              }
              @Test
              void  CuentaAbiertaIngreso200Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(200);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 191.07 );
              }
              @Test
              void  CuentaAbiertaIngreso200Retiro50() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(200);
                cuenta.retirarSaldo(50);
                assertEquals(cuenta.saldoDeLaCuenta, 150);
              }
              @Test
              void  CuentaAbiertaIngreso200Retiro50Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(200);
                cuenta.retirarSaldo(50);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 140.68 );
              }
              @Test
              void  CuentaAbiertaIngreso600Retiro50() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(600);
                cuenta.retirarSaldo(50);
                assertEquals(cuenta.saldoDeLaCuenta, 550);
              }
              @Test
              void  CuentaAbiertaIngreso600Retiro50Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(600);
                cuenta.retirarSaldo(50);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 543.01 );
              }
              @Test
              void  CuentaAbiertaIngreso550Retiro50() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(550);
                cuenta.retirarSaldo(50);
                assertEquals(cuenta.saldoDeLaCuenta, 500);
              }
              @Test
              void  CuentaAbiertaIngreso550Retiro50Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(550);
                cuenta.retirarSaldo(50);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 492.72 );
              }
              @Test
              void  CuentaAbiertaIngreso549Retiro50() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(549);
                cuenta.retirarSaldo(50);
                assertEquals(cuenta.saldoDeLaCuenta, 499);
              }
              @Test
              void  CuentaAbiertaIngreso549Retiro50Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(549);
                cuenta.retirarSaldo(50);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 491.71 );
              }
              @Test
              void  CuentaAbiertaIngreso500Retiro501() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(500);
                assertThrows(IllegalArgumentException.class, () -> cuenta.retirarSaldo(501));
              
                
              }
              @Test
              void operacionesMultiplesCuentasAbierta() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAbierta(dni, nombre);
                cuenta.anyadirSaldo(1200);
                cuenta.retirarSaldo(259.88);
                cuenta.retirarSaldo(94.80);
                cuenta.actualizacionMensual();
                cuenta.anyadirSaldo(1200);
                cuenta.retirarSaldo(372.08);
                cuenta.retirarSaldo(659.14);
                cuenta.retirarSaldo(388.66);
                cuenta.actualizacionMensual();
                cuenta.anyadirSaldo(1200);
                cuenta.retirarSaldo(412.56);
                cuenta.retirarSaldo(30.09);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 1368.34);
              }
              @Test
              void  CuentaDeAhorro() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                assertEquals(cuenta.saldoDeLaCuenta, 0);
              }
              @Test
              void  CuentaDeAhorroAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 0);
              }
              @Test
              void  CuentaDeAhorroIngreso90() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(90);
                assertEquals(cuenta.saldoDeLaCuenta, 90);
              }
              @Test
              void  CuentaDeAhorroIngreso90Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(90);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta,  82.13);
              }
              @Test
              void  CuentaDeAhorroIngreso100() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(100);
                assertEquals(cuenta.saldoDeLaCuenta, 100);
              }
              @Test
              void  CuentaDeAhorroIngreso100Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(100);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta,  91.25);
              }
              @Test
              void  CuentaDeAhorroIngreso100DobleAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(100);
                cuenta.actualizacionMensual();
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta,  83.27);
              }
              @Test
              void  CuentaDeAhorroIngreso110() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(110);
                assertEquals(cuenta.saldoDeLaCuenta, 110);
              }
              @Test
              void  CuentaDeAhorroIngreso110Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(110);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta,  101.38);
              }
              @Test
              void  CuentaDeAhorroIngreso200() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(200);
                assertEquals(cuenta.saldoDeLaCuenta, 200);
              }
              @Test
              void  CuentaDeAhorroIngreso200Act() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(200);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta,  192.50);
              }
              @Test
              void  CuentaDeAhorroIngreso200Retira() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(200);
                cuenta.retirarSaldo(50);
                assertEquals(cuenta.saldoDeLaCuenta, 150);
              }
              @Test
              void  CuentaDeAhorroIngreso200RetiraAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(200);
                cuenta.retirarSaldo(50);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta,  101.88);
              }
              @Test
              void  CuentaDeAhorroIngreso600Retira() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(600);
                cuenta.retirarSaldo(50);
                assertEquals(cuenta.saldoDeLaCuenta, 550);
              }
              @Test
              void  CuentaDeAhorroIngreso600RetiraAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(600);
                cuenta.retirarSaldo(50);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta,  426.88);
              }
              @Test
              void  CuentaDeAhorroIngreso550Retira() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(550);
                cuenta.retirarSaldo(50);
                assertEquals(cuenta.saldoDeLaCuenta, 500);
              }
              @Test
              void  CuentaDeAhorroIngreso550RetiraAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(550);
                cuenta.retirarSaldo(50);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta,  386.25);
              }
              @Test
              void  CuentaDeAhorroIngreso549Retira() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(549);
                cuenta.retirarSaldo(50);
                assertEquals(cuenta.saldoDeLaCuenta, 499);
              }
              @Test
              void  CuentaDeAhorroIngreso549RetiraAct() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(549);
                cuenta.retirarSaldo(50);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta,  385.44);
              }
              @Test
              void  CuentaAbiertaExcepcion() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(500);
                assertThrows(IllegalArgumentException.class, () -> cuenta.retirarSaldo(501));
              
                
              }
              @Test
              void operacionesMultiplesCuentasAhorro() {
                String dni = "26845672A";
                String nombre = "Paco";
                Cuenta cuenta = new CuentaAhorro(dni, nombre);
                cuenta.anyadirSaldo(1200);
                cuenta.retirarSaldo(259.88);
                cuenta.retirarSaldo(94.80);
                cuenta.actualizacionMensual();
                cuenta.anyadirSaldo(1200);
                cuenta.retirarSaldo(372.08);
                cuenta.retirarSaldo(659.14);
                cuenta.retirarSaldo(388.66);
                cuenta.actualizacionMensual();
                cuenta.anyadirSaldo(1200);
                cuenta.retirarSaldo(412.56);
                cuenta.retirarSaldo(30.09);
                cuenta.actualizacionMensual();
                assertEquals(cuenta.saldoDeLaCuenta, 817.18);
              }
              
              
              
              
            
          
  
  

}
