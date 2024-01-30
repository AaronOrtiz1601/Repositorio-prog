package calculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class calculadoraTest {


  @Test 
  public void TestSuma() 
  {
    int resultado = calculadora.suma(5, 8);
        int resultadoEsperado = 13;
        assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestSumaConUnNegativo() 
  {
    int resultado = calculadora.suma(-9, 10);
    int resultadoEsperado = 1;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestSumaConDosNegativos() 
  {
    int resultado = calculadora.suma(-9, -10);
    int resultadoEsperado = -19;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestResta()
  {
    int resultado = calculadora.resta(5, 3);
    int resultadoEsperado = 2;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestRestaConPrimerNumeroNegativo()
  {
    int resultado = calculadora.resta(-9, 6);
    int resultadoEsperado = -15;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestRestaConSegundoNumeroNegativo()
  {
    int resultado = calculadora.resta(9,-6);
    int resultadoEsperado = 15;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test 
  public void TestRestaConLosDosNumerosNegativos()
  {
    int resultado = calculadora.resta(-9, -6);
    int resultadoEsperado = -3;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestMultiplicacionNumerosPositivos()
  {
    int resultado = calculadora.multiplicar(9,6);
    int resultadoEsperado = 54;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestMultiplicacionCom1NumeroNegativo()
  {
    int resultado = calculadora.multiplicar(9,-6);
    int resultadoEsperado = -54;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestMultiplicacionCon2NumeroNegativo()
  {
    int resultado = calculadora.multiplicar(-9,-6);
    int resultadoEsperado = 54;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestMultiplicacionNumerosPositivosGrandes()
  {
    int resultado = calculadora.multiplicar(10000000,60);
    int resultadoEsperado = 600000000;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestDivisionConNumerosPositivos()
  {
    int resultado = calculadora.dividir(10,2);
    int resultadoEsperado = 5;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestDivisionCon1NumeroPositivo()
  {
    int resultado = calculadora.dividir(-10,2);
    int resultadoEsperado = -5;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestDivisionCon2NumeroNegativo()
  {
    int resultado = calculadora.dividir(-10,-2);
    int resultadoEsperado = 5;
    assertEquals(resultado, resultadoEsperado);
  }
  @Test
  public void TestDivisionConPrimerNumeroSiendo0()
  {
    int resultado = calculadora.dividir(0,2);
    int resultadoEsperado = 0;
    assertEquals(resultado, resultadoEsperado);
  }
  
  @Test
  public void TestDivisionConSegundoNumeroSiendo0() {
    assertThrows(ArithmeticException.class, () -> { calculadora.dividir(2, 0); });
  }
 
  @Test
  public void TestEsPositivo()
  {
    //El resultado esperado es true
    assertTrue(calculadora.esPositivo(5));
  }
  @Test
  public void TestEsPositivoConNumeroNegativo()
  {
    //El resultado esperado es false
    assertFalse(calculadora.esPositivo(-5));
  }
  @Test
  public void TestEsPrimoConNumeroPrimo()
  {
    //El resultado esperado es true
    assertTrue(calculadora.esPrimo(5));
  }
  @Test
  public void TestEsPrimoConNumeroNoPrimo()
  {
    //El resultado esperado es true
    assertFalse(calculadora.esPrimo(10));
  }
  @Test
  public void TestEsPrimoConNumeroNegativo()
  {
    //El resultado esperado es true
    assertFalse(calculadora.esPrimo(-5));
  }
  
  
  
  

}
