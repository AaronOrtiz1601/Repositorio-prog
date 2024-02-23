package prog.ud06.actividad611.coleccion;

import java.util.List;

import prog.ud06.actividad611.coleccion.diccionario.Diccionario;
/**
 * Contenedor de los usuarios del sistema
 * La clase Usuarios se encarga de almacenar y recuperar los usuarios que forman el sistema
 */
public class Usuarios {
  //Atributos privados 
  private Diccionario diccionarioUsuario = new Diccionario();
  private Diccionario diccionarioNombre = new Diccionario();
  private Diccionario diccionarioTarjeta = new Diccionario();
  private Diccionario diccionarioListaClientes = new Diccionario();
  /**
   * Constructor. Inicializa el contenedor
   * @param usuario
   */
  public Usuarios() {
    
  }
  /**
   * Añade un nuevo usuario al contenedor.
   * Falla si ya hay un usuario con el mismo nombre de usuario
   * @param usuario.No puede ser null
   * @Throws IllegalArgumentException - Si el usuario es null
   * @Throws UsuariosException - Si ya existe un usuario en el contenedor con el mismo nombre de usuario que el que se está intentando añadir
   */
  
  public void addUsuario(Usuario usuario) {
    if (usuario == null) {
      throw new IllegalArgumentException();
    }
    if (diccionarioUsuario.contieneNombre(usuario.getNombreUsuario())) {
      throw new UsuariosException();
    }else {
      diccionarioUsuario.add(usuario.getNombreUsuario(), usuario);
      diccionarioNombre.add(usuario.getNombreUsuario(), usuario.getNombreCompleto());
      diccionarioTarjeta.add(usuario.getNombreUsuario(), usuario.getTarjeta());
      diccionarioListaClientes.add(usuario.getNombreUsuario(), usuario.getClientes());
    }
  }
  /**
   * Localiza un usuario por su nombre de usuario
   * @param nombreUsuario-Nombre de usuario del usuario a localizar
   * @return usuario si se encontró. null si no se encontró
   */
  public Usuario getUsuarioPorNombreUsuario(String nombreUsuario) {
    if (diccionarioUsuario.contieneNombre(nombreUsuario)) {
      String nombre = (String) diccionarioNombre.getEntrada(nombreUsuario);
      TarjetaClaves tarjeta = (TarjetaClaves) diccionarioTarjeta.getEntrada(nombreUsuario);
      Usuario usuario = new Usuario(nombreUsuario, nombre, tarjeta, (List<Cliente>) diccionarioListaClientes.getEntrada(nombreUsuario));
      return usuario;
      
    }else
    {
      return null;
    }
}
}

