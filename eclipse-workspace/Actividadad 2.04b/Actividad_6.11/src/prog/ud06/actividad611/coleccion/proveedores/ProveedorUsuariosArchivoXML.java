package prog.ud06.actividad611.coleccion.proveedores;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

import prog.ud06.actividad611.coleccion.Cliente;
import prog.ud06.actividad611.coleccion.ProveedorUsuarios;
import prog.ud06.actividad611.coleccion.TarjetaClaves;
import prog.ud06.actividad611.coleccion.Usuario;
import prog.ud06.actividad611.coleccion.Usuarios;


public class ProveedorUsuariosArchivoXML implements ProveedorUsuarios {
  private List<String> nombreUsuario = new ArrayList<>();
  private Map<String,String> nombreCompleto = new HashMap<>();
  private Map<String,TarjetaClaves> mapaTarjeta = new HashMap<>();
  private Map<String,List> MapaClientes;
  public ProveedorUsuariosArchivoXML (String biblioteca)
  {
    
    
  }
  public Usuarios obtieneUsuarios(String biblioteca) {
    obtenerNombreUsuario(biblioteca);
    obtenerNombreCompleto(biblioteca);
    obtenerTarjetaCoordenadas(biblioteca);
    obtenerlistaClientes(biblioteca);
    Usuarios listaUsuarios = new Usuarios();
    for (int i = 0 ; i < nombreUsuario.size();i++)
    {
      
      Usuario usuarios = new Usuario(nombreUsuario.get(i), nombreCompleto.get(nombreUsuario.get(i)), mapaTarjeta.get(nombreUsuario.get(i)), MapaClientes.get(nombreUsuario.get(i)));
      listaUsuarios.addUsuario(usuarios);
    }
    return listaUsuarios;
  }
  private void obtenerNombreUsuario(String biblioteca)
  {
    try
    {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document documento = builder.parse(biblioteca);
      NodeList usuarios = documento.getElementsByTagName("usuario");
      
      for (int i = 0; i < usuarios.getLength(); i++) {
        Element usuario = (Element)usuarios.item(i);
        String idUsuario = usuario.getAttribute("id");
        nombreUsuario.add(i, idUsuario);
      }
    }catch (Exception e) {
      throw new ProveedorUsuariosException();
  }
    
  }
  private void obtenerNombreCompleto(String biblioteca)
  {
    try
    {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document documento = builder.parse(biblioteca);
      NodeList usuarios = documento.getElementsByTagName("usuario");
      
      for (int i = 0; i < usuarios.getLength(); i++) {
        Element usuario = (Element)usuarios.item(i);
        String nombreUsuario = usuario.getAttribute("nombre");
        String id = usuario.getAttribute("id");
        nombreCompleto.put(id, nombreUsuario);
        
      }
    }catch (Exception e) {
      throw new ProveedorUsuariosException();
  }
    
  }
  private void obtenerTarjetaCoordenadas(String biblioteca)
  {
    try
    {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document documento = builder.parse(biblioteca);
      NodeList tarjetas = documento.getElementsByTagName("tarjetas");
     
      
      for (int i = 0; i < tarjetas.getLength(); i++) {
        Element tarjeta = (Element)tarjetas.item(i);
        String usuarioTarjeta = tarjeta.getAttribute("usuario");
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
        mapaTarjeta.put(usuarioTarjeta, tarjetaClaves);
      }
    }catch (Exception e) {
      throw new ProveedorUsuariosException();
  }
    
  }
  private void obtenerlistaClientes(String biblioteca)
  {
    try
    {
    DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
    Document documento = builder.parse(biblioteca);
    NodeList clientes = documento.getElementsByTagName("cliente");
    
    for (int i = 0; i < clientes.getLength(); i++) {
      Element cliente = (Element)clientes.item(i);
      String nombre = cliente.getElementsByTagName("nombre").item(0).getTextContent();
      String apellidos = cliente.getElementsByTagName("apellidos").item(0).getTextContent();
      String dni = cliente.getElementsByTagName("dni").item(0).getTextContent();
      String edad = cliente.getElementsByTagName("edad").item(0).getTextContent();
      int valor = Integer.parseInt(edad);
      Cliente clientes1 = new Cliente(nombre,apellidos,dni,valor);
      String vendedor = cliente.getAttribute("usuario");
      
      if (!MapaClientes.containsKey(vendedor)) {
        
        MapaClientes.put(vendedor, new ArrayList<>());
    }
    
    
    MapaClientes.get(vendedor).add(clientes1);
}
    
    }catch (Exception e) {
      throw new ProveedorUsuariosException();
  }
    
  }
  
}

