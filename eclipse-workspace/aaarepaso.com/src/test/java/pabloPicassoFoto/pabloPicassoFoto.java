package pabloPicassoFoto;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class pabloPicassoFoto {

  @Test
  void test() {
    
    WebDriver driver = new ChromeDriver();
    try
    {
      driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
      driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Pablo Picasso\n");
      WebElement foto = driver.findElement(By.xpath("//*[@id=\"mw-content-text\"]/div[1]/table/tbody/tr[2]/td/span/a/img"));
      String src = foto.getAttribute("src");
      if (src.contains("220px-Pablo_picasso"))
      {
        System.out.println("La foto aparece");
      }
      else
      {
        System.out.println("La foto no aparece");
      }
    }catch (Exception e)
    {
      System.out.println(e.getMessage());
    }
    finally{
      driver.quit();
    }

  }

}
