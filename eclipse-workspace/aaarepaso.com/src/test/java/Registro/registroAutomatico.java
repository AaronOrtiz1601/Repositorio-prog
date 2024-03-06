package Registro;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

class registroAutomatico {

  @Test
  void test() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://www.odoo.com/es_ES");
      driver.findElement(By.xpath("//*[@id=\"wrap\"]/section[1]/div/a")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div[1]/div[2]/div/div[1]/div[1]/div[1]/label[1]/div")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div[1]/div[2]/div/div[1]/div[2]/div/div/button")).click();
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Aarón Ortiz Sánchez");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("aaronortizsanchez5@gmail.com");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"company-name\"]")).sendKeys("paquitoSl");
      Thread.sleep(3000);
      driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("657953039");
      Thread.sleep(3000);
      
    }catch (Exception e )
    {
      System.out.println(e.getMessage());
    }
    finally {
      driver.quit();
    }
  }

}
