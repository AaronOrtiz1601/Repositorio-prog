package prog.ud06.actividad611.coleccion;

import java.util.List;

public class Usuario {
  private String nombreUsuario;
  private String nombreCompleto;
  private TarjetaClaves tarjeta;
  private List<Cliente> clientes;
  
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
  public String getNombreUsuario() {
    return nombreUsuario;
  }
  public String getNombreCompleto() {
    return nombreCompleto;
  }
  public TarjetaClaves getTarjeta() {
    return tarjeta;
  }
  public List<Cliente> getClientes() {
    return clientes;
  }
  private boolean comprobarNombreUsuario(String nombreUsuario) {
    boolean prueba = false;
    String expresion = "^[a-zA-Z]{1}[a-zA-Z1-9]{1,7}$";
    if(nombreUsuario != null && nombreUsuario.matches(expresion))
    {
      prueba = true;
    }
    return prueba;
  }
  private boolean comprobarNombreCompleto(String nombreCompleto)
  {
    boolean prueba = false;
    if(nombreCompleto != null && !nombreCompleto.isBlank())
    {
      prueba = true;
    }
    return prueba;
  }
  private boolean comprobarTarjetaClaves(TarjetaClaves tarjeta)
  {
    boolean prueba = false;
    if(tarjeta != null)
    {
      prueba = true;
    }
    return prueba;
  }
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
