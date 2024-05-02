package prog.unidad07.juego;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class PruebasArquero {

  @Test
  void test1Arquero() {
    String nombre = "Paco";
    int vida = 100;
    String armadura = "sin armadura";
    String nivel = "medio";
    Arquero paco = new Arquero(nombre, vida, armadura, nivel);
    paco.serAtacado(50);
    paco.serCurado(60);
    assertEquals(100, paco.getVida());
    assertEquals("sin armadura", paco.getArmadura());
    assertEquals(33, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(0, paco.curar());
  }
  @Test
  void test2Arquero() {
    String nombre = "Paco";
    int vida = 100;
    String armadura = "con armadura";
    String nivel = "novato";
    Arquero paco = new Arquero(nombre, vida, armadura, nivel);
    paco.serAtacado(50);
    assertEquals(75, paco.getVida());
    assertEquals("sin armadura", paco.getArmadura());
    assertEquals(15, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(0, paco.curar());
  }
  @Test
  void test3Arquero() {
    String nombre = "Paco";
    int vida = 100;
    String armadura = "con armadura";
    String nivel = "novato";
    Arquero paco = new Arquero(nombre, vida, armadura, nivel);
    paco.serAtacado(50);
    paco.obtieneArmadura();
    paco.serAtacado(50);
    assertEquals(50, paco.getVida());
    assertEquals("sin armadura", paco.getArmadura());
    assertEquals(10, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(0, paco.curar());
  }
  @Test
  void test4Arquero() {
    String nombre = "Paco";
    int vida = 100;
    String armadura = "con armadura";
    String nivel = "novato";
    Arquero paco = new Arquero(nombre, vida, armadura, nivel);
    paco.serAtacado(50);
    assertEquals(75, paco.getVida());
    assertEquals("sin armadura", paco.getArmadura());
    assertEquals(15, paco.atacar());
    assertEquals("vivo", paco.getEstado());
    assertEquals(0, paco.curar());
  }

}
