package prog.unidad07.juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasSanador {

  @Test
  void test1Sanador() {
    String nombre = "Paco";
    int vida = 100;
    Sanador paco = new Sanador(nombre, vida);
    paco.serAtacado(200);
    assertEquals(0, paco.getVida());
    assertEquals(0, paco.atacar());
    assertEquals("muerto", paco.getEstado());
    assertEquals(0, paco.curar());
  }
  @Test
  void test2Sacerdote() {
    String nombre = "Paco";
    int vida = 100;
    Sanador paco = new Sanador(nombre, vida);
    paco.serAtacado(50);
    paco.serAtacado(50);
    assertEquals(0, paco.getVida());
    assertEquals(0, paco.atacar());
    assertEquals("muerto", paco.getEstado());
    assertEquals(0, paco.curar());
  }
  @Test
  void test3Sacerdote() {
    String nombre = "Paco";
    int vida = 100;
    Sanador paco = new Sanador(nombre, vida);
    paco.serCurado(10);
    assertEquals(100, paco.getVida());
    assertEquals(0, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(31, paco.curar());
  }
  @Test
  void test4Sacerdote() {
    String nombre = "Paco";
    int vida = 100;
    Sanador paco = new Sanador(nombre, vida);
    paco.serAtacado(50);
    paco.serCurado(10);
    assertEquals(63, paco.getVida());
    assertEquals(0, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(31, paco.curar());
  }

}
