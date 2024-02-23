package prog.ud06.actividad611.proveedores;

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
import prog.ud06.actividad611.coleccion.ProveedorUsuariosException;
import prog.ud06.actividad611.coleccion.TarjetaClaves;
import prog.ud06.actividad611.coleccion.Usuario;
import prog.ud06.actividad611.coleccion.Usuarios;

/**
 * Implementación de ProveedorUsuarios que obtiene la información desde un archivo XML
 */
public class ProveedorUsuariosArchivoXML implements ProveedorUsuarios {
  //Atributo privados de la clase
  private List<String> nombreUsuario = new ArrayList<>();
  private Map<String,String> nombreCompleto = new HashMap<>();
  private Map<String,TarjetaClaves> mapaTarjeta = new HashMap<>();
  private Map<String,List> MapaClientes = new HashMap<>();
  /**
   * Constructor
   * @param biblioteca - Ruta al archivo XML que contiene la informacion de todos los usuarios
   */
  public ProveedorUsuariosArchivoXML (String biblioteca)
  {
    
    obtenerNombreUsuario(biblioteca);
    obtenerNombreCompleto(biblioteca);
    obtenerTarjetaCoordenadas(biblioteca);
    obtenerlistaClientes(biblioteca);
    obtieneUsuarios();
  }
  /**
   * Obtiene la informacion de los usuarios desde el archivo XML
   * @return Contenedor con los usuarios.Lo devuelve vacio o incompleto en caso de error
   * @throws ProveedorUsuariosException - Si hay algún error obteniendo la información
   */
  public Usuarios obtieneUsuarios() {
    Usuarios listaUsuarios = new Usuarios();
    for (int i = 0 ; i < nombreUsuario.size();i++)
    {
      
      Usuario usuarios = new Usuario(nombreUsuario.get(i), nombreCompleto.get(nombreUsuario.get(i)), mapaTarjeta.get(nombreUsuario.get(i)), MapaClientes.get(nombreUsuario.get(i)));
      listaUsuarios.addUsuario(usuarios);
    }
    return listaUsuarios;
  }
  /**
   * Metodo privado que obtiene del archivo XML el nombre de usuario
   * @param biblioteca
   */
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
  /**
   * Metodo privado que obtiene el nombre completo del usuario
   * @param biblioteca
   */
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
  /**
   * Metodo privado que obtiene la tarjeta de coordenadas del usuario 
   * @param biblioteca
   */
  private void obtenerTarjetaCoordenadas(String biblioteca) {
    try {
      DocumentBuilder builder = DocumentBuilderFactory.newInstance().newDocumentBuilder();
      Document documento = builder.parse(biblioteca);
      NodeList tarjetas = documento.getElementsByTagName("tarjeta");
      
      for (int i = 0; i < tarjetas.getLength(); i++) {
        Element usuario = (Element) tarjetas.item(i);
        String nombreUsuario = usuario.getAttribute("usuario");
        NodeList fila = usuario.getElementsByTagName("fila");
        
        
        Element columna = (Element) fila.item(0);
        NodeList celdaLista = columna.getElementsByTagName("celda");
        int filas = fila.getLength();
        int columnas = celdaLista.getLength();
        TarjetaClaves tarjeta = new TarjetaClaves(filas, columnas);
        
        for (int j = 0; j < fila.getLength(); j++) {
          Element celdas = (Element) fila.item(j);
          NodeList celda = celdas.getElementsByTagName("celda");
          for (int k = 0; k < celda.getLength(); k++) {
            String contenido = celda.item(k).getTextContent();
            int numeroCelda = Integer.parseInt(contenido);
            tarjeta.setClave(j + 1, k + 1, numeroCelda);
          }
        }
        mapaTarjeta.put(nombreUsuario, tarjeta);
      }
    } catch (Exception e) {
      throw new ProveedorUsuariosException();
    }
  }
  /**
   * Metodo privado que obtiene la lista de clientes de cada usuario
   * @param biblioteca
   */
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

