package pruebawiki;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Duration;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class wikipediatest {

  @Test
  void testChrome() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
      driver.findElement(By.xpath("//input[@id='vector-main-menu-dropdown-checkbox']")).click();
      Thread.sleep(2000);
      driver.findElement(By.xpath("//span[normalize-space()='Página aleatoria']")).click();
      Thread.sleep(2000);
      String titulo = driver.getTitle();
      Thread.sleep(2000);
      System.out.println(titulo);
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


