package pruebasCalculadora;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class pruebasCalculadora {

  @Test
  void suma() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("5");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("5");
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      WebElement resultado = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
     
      assertEquals("10", resultado.getAttribute("value"));
      
    }catch (Exception e) {
     System.out.println(e.getMessage());
    }
    finally {
      driver.quit();
    }
  }
  
  @Test
  void resta() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("5");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("5");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      
     
      
      // Encuentra el elemento por su atributo id
      driver.findElement(By.id("selectOperationDropdown")).click();

      // Selecciona la opción "restar" por su valor
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[2]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      WebElement resultado = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]"));
     
      assertEquals("0", resultado.getAttribute("value"));
      
    }catch (Exception e) {
     System.out.println(e.getMessage());
    }
    finally {
      driver.quit();
    }
  }

}
