package pabloPicassoInsti;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class pabloPicassoInsti {

  @Test
  void test() {
   WebDriver driver = new ChromeDriver();
   try {
     driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
     driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("IES Pablo Picasso\n");
     
     WebElement busqueda = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/div[1]/p"));
     assertEquals(busqueda.getText(), "Si consideras que este artículo debería existir, conoces nuestros pilares, dispones de fuentes fiables y sabes indicarlas como referencias, puedes crearlo, opcionalmente usando nuestro asistente.");
     
   }catch ( Exception e)
   {
     System.out.println(e.getMessage());
   }
   finally {
     driver.quit();
   }
  }

}
