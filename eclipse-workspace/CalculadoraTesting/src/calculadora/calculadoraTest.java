package calculadora;

import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class calculadoraTest {
  
  @Test
  public void TestSumaNegativo() {
    int resultado = calculadora.suma(-2, 4);
    int resultadoEsperado = 2;
    assertEquals(resultado, resultadoEsperado);
  }

  @Test 
  public void TestSuma() 
  {
    int resultado = calculadora.suma(5, 8);
        int resultadoEsperado = 13;
        assertEquals(resultado, resultadoEsperado);
  }
  @Test 
  public void TestResta() 
  {
    int resultado = calculadora.resta(5, 8);
        int resultadoEsperado = -3;
        assertEquals(resultado, resultadoEsperado);
  }
  @Test 
  public void testCompararArray () {
    int [] array = {1,2,3,4};
    int [] arrayEsperado = {1,2,3,4};
   assertArrayEquals(array, arrayEsperado);
  }
  @Test
  public void testComprarTrue() {
      assertTrue(true);
  }
  @Test
  public void testComprarNull() {
      assertNull(null);
  }
  @Test
  public void testComprarIgualPorReferencia() {
      assertSame("String", "String");
  }

  @Test
  public void testComprarPorMatchet() {
    String paco = "hola";
      assertThat("hola", is(paco));
  }

  
}
