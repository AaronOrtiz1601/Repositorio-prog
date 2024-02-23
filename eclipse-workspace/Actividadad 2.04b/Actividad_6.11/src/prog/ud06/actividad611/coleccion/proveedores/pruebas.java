package prog.ud06.actividad611.coleccion.proveedores;

import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import prog.ud06.actividad611.coleccion.TarjetaClaves;

public class pruebas {
  public static final String BIBLIOTECA ="biblioteca.xml";
  public static void main(String[] args) {
    List<TarjetaClaves> listaTarjetas = new ArrayList<>();
    try
    {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document documento = builder.parse(BIBLIOTECA);
      NodeList tarjetas = documento.getElementsByTagName("tarjetas");
      
      for (int i = 0; i < tarjetas.getLength(); i++) {
        Element tarjeta = (Element)tarjetas.item(i);
        NodeList listaFil = documento.getElementsByTagName("fila");
       
        NodeList celdaCont = documento.getElementsByTagName("celda");
        TarjetaClaves tarjetaClaves  = new TarjetaClaves(celdaCont.getLength(), listaFil.getLength());
        for (int j = 0 ; j < listaFil.getLength();j++)
        {
          Element celda = (Element)listaFil.item(j);
          for (int k = 0 ; k < celdaCont.getLength();k++){
        
          String valorCadena = celdaCont.item(k).getTextContent();
          
          int valor = Integer.parseInt(valorCadena);
          System.out.println(valor);
         tarjetaClaves.setClave(k+1, j+1, valor);
        
          }
        }
        listaTarjetas.add(i,tarjetaClaves);
      }
      if(listaTarjetas.get(0).validarClave(1, 1, 345))
      {
        System.out.println("increible");
      }
      
    }catch (Exception e) {
      System.out.println("Error accediendo al fichero XML:" + e.getMessage());
    }
  }
}
