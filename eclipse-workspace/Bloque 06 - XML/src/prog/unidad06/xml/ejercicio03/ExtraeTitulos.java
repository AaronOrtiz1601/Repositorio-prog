package prog.unidad06.xml.ejercicio03;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

public class ExtraeTitulos {
 public static final String ARCHIVO_HTML = "parte1.html";
  public static void main(String[] args) {
    try {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document documento = builder.parse(ARCHIVO_HTML);
      Element titulo = (Element)documento.getElementsByTagName("title").item(0);
      System.out.println("El titulo es " + titulo.getTextContent());
      // Nombre de los capitulos
     NodeList capitulos = documento.getElementsByTagName("h3");
     int contadorCaps = 1;
     for (int i = 0 ;i < capitulos.getLength();i++)
     {
       Element capitulo = (Element)capitulos.item(i);
       System.out.println("El titulo del capitulo "+ contadorCaps +" es: " + capitulo.getTextContent());
     contadorCaps ++;
     }
    } catch (Exception e) {
     System.out.println("Error accediendo al fichero XML:" + e.getMessage());
   
    }
  }

}
