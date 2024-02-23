package Practica_2_selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class mas_pruebas_wiki {

  
  
  @Test
  void testChrome() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://es.wikipedia.org/wiki/Wikipedia:Portada");
      
   
     driver.findElement(By.xpath("//*[@id=\"searchInput\"]")).sendKeys("Java\n");
      Thread.sleep(3000);
      Thread.sleep(2000);
      WebElement titulo = driver.findElement(By.xpath("//*[@id=\"firstHeading\"]/span"));
     
      assertEquals("Java", titulo.getText());
     
      //Thread.sleep(2000);
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


