/**
 * 
 */
package practica_ebay;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Set;

import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * 
 */
class practica3Selemium {

  @Test
  void testChrome() {
    WebDriver driver = new ChromeDriver();
    try {
      // Enlace para la nueva pagina
      driver.get("https://www.ebay.es/");
      
      //Metemos en la barra de busqueda lo que queremos buscar
      driver.findElement(By.xpath("//*[@id=\"gh-ac\"]")).sendKeys("Play Station 5\n");
     
     
    
     //Pulsamos el botón 2 para cambiar de página
     driver.findElement(By.xpath("//*[@id=\"srp-river-results\"]/ul/li[62]/div[2]/span/span/nav/ol/li[2]/a")).click();
     //Hacemos una lista con todos los productos de la página
     List<WebElement> elementosList = driver.findElements(By.xpath("//ul[@class='srp-results srp-list clearfix']/li"));
    //Guardamos el tercer elemento de la lista en un elemento nuevo
     WebElement tercero = elementosList.get(2);
     //Pulsamos en el tercer elemento por medio de la etiqueta imagen 
     tercero.findElement(By.tagName("img")).click();
     
    
     
     
     
     
//   Obtenemos el nombre del tab donde estamos realizando la selección
     String tabPrincipal = driver.getWindowHandle();
     
     // Creamos un tab vacío a sabiendas de que lo vamos a necesitar al seleccionar el artículo, ya que se abre en una pestaña nueva
     String nuevoTab = "";
     
     // Hacemos un set para obtener todos los tabs que están abiertos
     Set<String> tabs = driver.getWindowHandles();
     
     // Creamos un bucle for en el que hacemos un switch entre tabs si el tab que está en uso es el primero para pasar al segundo
     for(String tabActual : tabs) {
       if(!tabActual.equalsIgnoreCase(tabPrincipal)) {
         driver.switchTo().window(tabActual);
         nuevoTab = tabActual;
       }
     }
     // Guardamos el titulo del articulo en cuestion en un elemento apartae
     WebElement titulo3 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[1]/div[1]/h1/span"));
     //Creamos otro elemento para guardar el texto del boton de añadir a la cesta
     WebElement titulo2 = driver.findElement(By.xpath("//*[@id=\"mainContent\"]/div[2]/div/div[1]/div[2]/ul/li[2]/div/a/span/span"));
     String comprobar = titulo2.getText();
     System.out.println(titulo3.getText());
     // Hacemos una comprovación del botón que deberia de ser añadir a la cesta para asegurarnos de que está
     assertEquals("Añadir a la cesta", comprobar);
     
     
     
     
     
     
     
     
     
      
      
      
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
