package ebay;

import static org.junit.jupiter.api.Assertions.*;

import java.awt.Window;
import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class ebay {

  @Test
  void test() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://www.ebay.es/");
      driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Play Station 5\n");
      driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[62]/div[2]/span/span/nav/ol/li[2]/a")).click();
      
      List <WebElement> elementos = driver.findElements(By.xpath("//*[@id=\"srp-river-results\"]/ul/li"));
      WebElement tercerElemento = elementos.get(2);
      tercerElemento.findElement(By.tagName("img")).click();
      
      String tabPrincipal = driver.getWindowHandle();
      
      String nuevoTab = "";
      
      Set <String> tabs = driver.getWindowHandles();
      
      for (String tabActual : tabs)
      {
        if(!tabActual.equalsIgnoreCase(tabPrincipal))
        {
          driver.switchTo().window(tabActual);
          nuevoTab = tabActual;
        }
      }
      
      WebElement titulo = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[1]/h1/span"));
      System.out.println("El titulo del articulo es " + titulo.getText());
      WebElement titulo2 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div/div[1]/div[2]/ul/li[2]/div/a/span/span"));
      
      assertEquals("Añadir a la cesta", titulo2.getText());
      Thread.sleep(2000);
      
    }catch (Exception e) {
      System.out.println(e.getMessage());
    }
    finally {
      driver.quit();
    }
  }

}
