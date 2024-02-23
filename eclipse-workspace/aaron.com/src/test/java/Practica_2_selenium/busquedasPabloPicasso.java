package Practica_2_selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class busquedasPabloPicasso {

  
  @Test
  void testPicasso() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
      
   
     driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("pablo picasso\n");
      Thread.sleep(3000);
      Thread.sleep(2000);
      WebElement foto = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr[2]/td/span/a/img"));
      String src =  foto.getAttribute("src");
      if (src.contains("220px-Pablo_picasso_1.jpg"))
      {
        System.out.println("Increible");
      }else
      {
        System.out.println("mierda");
      }
     
      //Thread.sleep(2000);
      
      
    }
    catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
    finally {
      driver.quit();
    }
  }
  
  
  
  @Test
  void testChrome() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
      
   
     driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("ies pablo picasso\n");
      Thread.sleep(3000);
      Thread.sleep(2000);
      WebElement resultado = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[3]/div[1]/p[1]"));
     
      assertEquals("Si consideras que este artículo debería existir, conoces nuestros pilares, dispones de fuentes fiables y sabes indicarlas como referencias, puedes crearlo, opcionalmente usando nuestro asistente.", resultado.getText());
     
      //Thread.sleep(2000);
      
      
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
