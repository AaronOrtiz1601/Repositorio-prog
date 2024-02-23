package Practica_2_selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class registro {

  @Test
  void testChrome() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://www.odoo.com/es_ES");
      
   
      driver.findElement(By.xpath("//*[@id=\"wrap\"]/section[1]/div/a")).click();
     
     driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div[1]/div[2]/div/div[1]/div[1]/div[1]/label[1]/div/div[1]/img")).click();
    
     Thread.sleep(3000);
     driver.findElement(By.xpath("//*[@id=\"wrapwrap\"]/main/div[1]/div[2]/div/div[1]/div[2]/div/div/button")).click();
     Thread.sleep(2000);
     driver.findElement(By.xpath("//*[@id=\"username\"]")).sendKeys("Aarón Ortiz Sánchez");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"email\"]")).sendKeys("a_aaron.ortiz.sanchez@iespablopicasso.es");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"company-name\"]")).sendKeys("Practica de entorno");
      Thread.sleep(2000);
      driver.findElement(By.xpath("//*[@id=\"phone\"]")).sendKeys("659853930");
      Thread.sleep(2000);
      
      String titulo2 = driver.getTitle();
      System.out.println(titulo2);
      
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
