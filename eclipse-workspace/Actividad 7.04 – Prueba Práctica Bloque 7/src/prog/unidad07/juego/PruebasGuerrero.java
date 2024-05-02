package prog.unidad07.juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;



class PruebasGuerrero {

  @Test
  void test1Guerrero() {
    String nombre = "Paco";
    int vida = 100;
    String armadura = "con armadura";
    String arma = "espada";
    Guerrero paco = new Guerrero(nombre, vida, armadura, arma);
    paco.serCurado(10);
    assertEquals(100, paco.getVida());
    assertEquals("con armadura", paco.getArmadura());
    assertEquals(50, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(0, paco.curar());
  }
  @Test
  void test2Guerrero() {
    String nombre = "Paco";
    int vida = 100;
    String armadura = "sin armadura";
    String arma = "espada";
    Guerrero paco = new Guerrero(nombre, vida, armadura, arma);
    paco.serAtacado(50);
    assertEquals(50, paco.getVida());
    assertEquals("sin armadura", paco.getArmadura());
    assertEquals(25, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(0, paco.curar());
  }
  @Test
  void test3Guerrero() {
    String nombre = "Paco";
    int vida = 100;
    String armadura = "con armadura";
    String arma = "espada";
    Guerrero paco = new Guerrero(nombre, vida, armadura, arma);
    paco.serAtacado(200);
    assertEquals(0, paco.getVida());
    assertEquals("sin armadura", paco.getArmadura());
    assertEquals(0, paco.atacar());
    assertEquals("muerto", paco.getEstado());
    assertEquals(0, paco.curar());
  }
  @Test
  void test4Guerrero() {
    String nombre = "Paco";
    int vida = 100;
    String armadura = "sin armadura";
    String arma = "maza";
    Guerrero paco = new Guerrero(nombre, vida, armadura, arma);
    paco.serAtacado(50);
    paco.serCurado(10);
    assertEquals(70, paco.getVida());
    assertEquals("sin armadura", paco.getArmadura());
    assertEquals(70, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(0, paco.curar());
  }

}
