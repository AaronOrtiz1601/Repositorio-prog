package wikipedia;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class wikipedia {

  @Test
  void test() {
    WebDriver driver = new ChromeDriver();
    try {
      
      driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Java\n");
      WebElement titulo = driver.findElement(By.xpath("//*[@id=\"firstHeading\"]/span"));
      System.out.println("El titulo es " + titulo.getText());
     
    }catch (Exception e) {
      System.out.println(e.getMessage());
    }finally {
      driver.quit();
    }
  }

}
