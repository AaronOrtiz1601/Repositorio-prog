import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class PlantillaTest {

  @Test
  void MosaicoTest(String idJugador, String nombreJugadorEsperado, String ficheroJugador) {
    WebDriver driver = new ChromeDriver();
    driver.get("file:///C:/Users/AARN~1/AppData/Local/Temp/Rar$EXa0.512/ExUD3/web/plantilla.html");
    
    driver.findElement(By.id(idJugador)).click();
    String nombreJugador = driver.findElement(By.id("lblNombreJugador")).getText();
    assertEquals(nombreJugadorEsperado, nombreJugador);
    
  }

}
