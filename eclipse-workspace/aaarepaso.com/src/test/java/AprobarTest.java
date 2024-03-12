import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.condition.EnabledOnOs;
import org.junit.jupiter.api.condition.OS;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

class AprobarTest {

  @ParameterizedTest
  @CsvSource ({"1,2,3,4","2,3,4,5","6,4,5,7"})
  void rotar(int num1, int num2, int num3, int num4) {
    int [] arrayInicial = new int[] {num1,num2,num3,num4};
    int [] arrayEsperado = new int [] {num4,num1,num2,num2};
    AProbar aprobar = new Aprobar();
    assertArrayEquals(arrayEsperado, aprobar.rotar(arrayInicial));
    
  }
  @ParameterizedTest
  @CsvFileSource (resources = "/fichTest/fichero.csv"),numLinesToSkip = 3,delimiter =";";
  void esMultiplo(int numero1, int numero2) {
    Aprobar aprobar = new Aprobar ();
    assertTrue( aprobar.esMultiplo(numero1,numero2));
    
    
  }
  @ParameterizedTest
  @CsvSource ({"11,3","1,1","100,4"})
  @Tag("version1")
  @EnabledOnOs(OS.WINDOWS)
  void binarioDecimalTest(String numBinario, long numDecimal) {
    Aprobar aprobar = new Aprobar ();
    assertEquals(numDecimal, aprobar.binarioADecimal(numBinario));
    System.out.println("Prueba binarioADecimal: " + numBinario);
  }

}
