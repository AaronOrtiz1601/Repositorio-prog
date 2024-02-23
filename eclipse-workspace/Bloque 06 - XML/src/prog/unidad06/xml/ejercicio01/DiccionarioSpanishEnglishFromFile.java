package prog.unidad06.xml.ejercicio01;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.DOMException;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class DiccionarioSpanishEnglishFromFile {
  private Map<String, String> diccionario;
  public DiccionarioSpanishEnglishFromFile (String archivo)
  {

      diccionarioDesdeXml(archivo);
  }
    
  public String traducir (String palabra) {
return diccionario.get(palabra);
  }
  private void diccionarioDesdeXml(String archivo) 
  {
    try
    {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document documento = builder.parse(archivo);
    NodeList palabras = documento.getElementsByTagName("palabra");
    diccionario = new HashMap<>();
    for (int i = 0; i < palabras.getLength(); i++) {
      Element palabra = (Element)palabras.item(i);
      String palabraES = palabra.getElementsByTagName("español").item(0).getTextContent();
      String palabraEN = palabra.getElementsByTagName("ingles").item(0).getTextContent();
      diccionario.put(palabraES, palabraEN);
    
    }
    }catch (Exception e) {
      throw new DiccionarioSpanishEnglishException();
  }
}
}
