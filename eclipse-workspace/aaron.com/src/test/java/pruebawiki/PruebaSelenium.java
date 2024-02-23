package pruebawiki;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class PruebaSelenium {

  @Test
  void testChrome() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
      
   
     driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Selenium\n");
      Thread.sleep(3000);
      //WebElement textbox = driver.findElement(By.xpath("//*[@id=\"searchform\"]/div/div/div[1]/input"));
      //textbox.sendKeys("Selenium");
      Thread.sleep(2000);
      WebElement titulo = driver.findElement(By.xpath("//*[@id=\"firstHeading\"]/span"));
      assertEquals("Selenium", titulo.getText());
      Thread.sleep(2000);
      //Thread.sleep(2000);
      //String titulo = driver.getTitle();
      //Thread.sleep(2000);
      //System.out.println(titulo);
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
    finally {
      driver.quit();
    }
  }

}
