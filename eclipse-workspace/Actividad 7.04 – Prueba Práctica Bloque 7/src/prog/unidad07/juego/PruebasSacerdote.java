package prog.unidad07.juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasSacerdote {

  @Test
  void test1Sacerdote() {
    String nombre = "Paco";
    int vida = 100;
    String reliquia = "tiene reliquia";
    Sacerdote paco = new Sacerdote(nombre, vida, reliquia);
    paco.serAtacado(200);
    assertEquals(100, paco.getVida());
    assertEquals("no tiene reliquia", paco.getReliquia());
    assertEquals(0, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(50, paco.curar());
  }
  @Test
  void test2Sacerdote() {
    String nombre = "Paco";
    int vida = 100;
    String reliquia = "no tiene reliquia";
    Sacerdote paco = new Sacerdote(nombre, vida, reliquia);
    paco.serAtacado(200);
    paco.serCurado(50);
    assertEquals(0, paco.getVida());
    assertEquals("no tiene reliquia", paco.getReliquia());
    assertEquals(0, paco.atacar());
    assertEquals("muerto", paco.getEstado());
    assertEquals(0, paco.curar());
  }
  @Test
  void test3Sacerdote() {
    String nombre = "Paco";
    int vida = 100;
    String reliquia = "no tiene reliquia";
    Sacerdote paco = new Sacerdote(nombre, vida, reliquia);
    paco.serAtacado(50);
    assertEquals(50, paco.getVida());
    assertEquals("no tiene reliquia", paco.getReliquia());
    assertEquals(0, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(25, paco.curar());
  }
  @Test
  void test4Sacerdote() {
    String nombre = "Paco";
    int vida = 100;
    String reliquia = "tiene reliquia";
    Sacerdote paco = new Sacerdote(nombre, vida, reliquia);
    paco.serAtacado(200);
    assertEquals(100, paco.getVida());
    assertEquals("no tiene reliquia", paco.getReliquia());
    assertEquals(0, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(50, paco.curar());
  }

}
