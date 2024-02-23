package prog.ud06.actividad611.coleccion;

import java.util.List;
 /**
  * Clase que representa a un Usuario
  * Un Usuario tiene un identificador único, un nombre completo, una tarjeta de claves y una lista de clientes
  */
public class Usuario {
  //Atributos de la clase
  private String nombreUsuario;
  private String nombreCompleto;
  private TarjetaClaves tarjeta;
  private List<Cliente> clientes;
  /**
   * 
   * @param nombreUsuario-Nombre de usuario único del usuario. No puede ser null y debe tener entre 2 y 8 caracteres alfanuméricos, siendo el primero una letra.
   * @param nombreCompleto-Nombre y apellidos. No puede ser null ni vacío
   * @param tarjeta-Tarjeta de claves del usuario. No puede ser null
   * @param clientes-Lista de clientes del usuario. No puede ser null aunque puede estar vacía
   * @throws IllegalArgumentException - Si alguno de los parámetros no es correcto
   */
  public Usuario(String nombreUsuario,String nombreCompleto,TarjetaClaves tarjeta,List<Cliente> clientes)
  {
    if(comprobarNombreUsuario(nombreUsuario))
    {
      this.nombreUsuario=nombreUsuario;
    }else
    {
      throw new IllegalArgumentException();
    } if(comprobarNombreCompleto(nombreCompleto))
    {
      this.nombreCompleto=nombreCompleto;
    }else
    {
      throw new IllegalArgumentException();
    }
    if(comprobarTarjetaClaves(tarjeta))
        {
      this.tarjeta = tarjeta;
        }else
        {
          throw new IllegalArgumentException();
        }
    if(comprobarListaClientes(clientes))
    {
      this.clientes = clientes;
    }else
    {
      throw new IllegalArgumentException();
    }
    
  }
  /**
   * Metodo que devuelve el nombre del usuario
   * @return nombre del usuario
   */
  public String getNombreUsuario() {
    return nombreUsuario;
  }
  /**
   * Metodo que devuelve el nombre completo del usuario
   * @return nombre completo
   */
  public String getNombreCompleto() {
    return nombreCompleto;
  }
  /**
   * Metodo que devuelve la tarjeta de claves del usuario
   * @return tarjeta de claves
   */
  public TarjetaClaves getTarjeta() {
    return tarjeta;
  }
  /**
   * Metodo que devuelve la lista de los clientes del usuario
   * @return lista de clientes
   */
  public List<Cliente> getClientes() {
    return clientes;
  }
  /**
   * Metodo privado que comprueba que el nombre de usuario sea correcto 
   * @param nombreUsuario
   * @return true o false, depende del resultado de la prueba
   */
  private boolean comprobarNombreUsuario(String nombreUsuario) {
    boolean prueba = false;
    String expresion = "^[a-zA-Z]{1}[a-zA-Z1-9]{1,7}$";
    if(nombreUsuario != null && nombreUsuario.matches(expresion))
    {
      prueba = true;
    }
    return prueba;
  }
  /**
   * Metodo privado que comprueba que el nombre completo del usuario sea correcto 
   * @param nombreCompleto
   * @return true o false, depende del resultado de la prueba
   */
  private boolean comprobarNombreCompleto(String nombreCompleto)
  {
    boolean prueba = false;
    if(nombreCompleto != null && !nombreCompleto.isBlank())
    {
      prueba = true;
    }
    return prueba;
  }
  /**
   * Metodo privado que comprueba la tarjeta de coordenaas para verificar si es correcta
   * @param tarjeta
   * @return true o false, depende del resultado de la prueba
   */
  
  private boolean comprobarTarjetaClaves(TarjetaClaves tarjeta)
  {
    boolean prueba = false;
    if(tarjeta != null)
    {
      prueba = true;
    }
    return prueba;
  }
  /**
   * Metodo privado que comprueba la lista de los clientes de los usuarios para verificar si es correcta
   * @param clientes
   * @return true o false, depende del resultado de la prueba
   */
  private boolean comprobarListaClientes( List<Cliente> clientes)
  {
    boolean prueba = false;
    if(clientes != null)
    {
      prueba = true;
    }
    return prueba;
  }
}
