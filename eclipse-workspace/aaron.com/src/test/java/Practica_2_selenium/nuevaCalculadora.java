package Practica_2_selenium;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

class nuevaCalculadora {

  @Test
  void testSuma() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("5");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("5");
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("10", reesultadoEnWeb);
      
     
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
  void testSumaDecimal() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("5.3");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("5.5");
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("10.8", reesultadoEnWeb);
      
     
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
  void testResta() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("5");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("2");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[2]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("3", reesultadoEnWeb);
      
     
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
  void testRestaNegativa() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("1");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("5");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[2]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("-4", reesultadoEnWeb);
      
     
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
  void testRestaNegativaDecimal() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("2.4");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("200.5");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[2]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("-198.1", reesultadoEnWeb);
      
     
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
  void testMultiplicacion() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("5");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("5");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[3]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("25", reesultadoEnWeb);
      
     
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
  void testMultiplicacionNumerosGrandes() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("200");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("1000000000");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[3]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("200000000000", reesultadoEnWeb);
      
     
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
  void testMultiplicacionNumerosNegativos() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("-2");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("-10");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[3]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("20", reesultadoEnWeb);
      
     
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
  void testMultiplicacion1NumeroNegativo() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("-20");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("2");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[3]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("-40", reesultadoEnWeb);
      
     
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
  void testMultiplicacionPor0() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("0");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("1000000000");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[3]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("0", reesultadoEnWeb);
      
     
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
  void testDivision() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("50");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("2");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[4]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("25", reesultadoEnWeb);
      
     
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
  void testDivisionNumerosGrandes() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("5000000000");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("100000");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[4]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("50000", reesultadoEnWeb);
      
     
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
  void testDivisionSegundoNumeroMasGrande() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("2");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("10");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[4]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("0.2", reesultadoEnWeb);
      
     
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
  void testDivision1NumeroNegativo() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("10");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("-2");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[4]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("-5", reesultadoEnWeb);
      
     
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
  void testDivision2NumeroNegativo() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("-10");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("-2");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[4]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("5", reesultadoEnWeb);
      
     
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
  void testDivisionEntre0() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("-2");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("0");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[4]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"errorMsgField\"]")).getText();
      
      assertEquals("Divide by zero error!", reesultadoEnWeb);
      
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
  void testConcatenar() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("10");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("10");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[5]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("1010", reesultadoEnWeb);
      
     
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
  void testConcatenarGrande() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("100000");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("10000");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[5]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("10000010000", reesultadoEnWeb);
      
     
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
  void testConcatenarNegativo() {
    WebDriver driver = new ChromeDriver();
    try {
      driver.get("https://testsheepnz.github.io/BasicCalculator.html");
      
   
     driver.findElement(By.xpath("//*[@id=\"number1Field\"]")).sendKeys("-12");
      driver.findElement(By.xpath("//*[@id=\"number2Field\"]")).sendKeys("-14");
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]")).click();
      driver.findElement(By.xpath("//*[@id=\"selectOperationDropdown\"]/option[5]")).click();
     
      driver.findElement(By.xpath("//*[@id=\"calculateButton\"]")).click();
      String reesultadoEnWeb = driver.findElement(By.xpath("//*[@id=\"numberAnswerField\"]")).getAttribute("value");
      
      assertEquals("-12-14", reesultadoEnWeb);
      
     
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
