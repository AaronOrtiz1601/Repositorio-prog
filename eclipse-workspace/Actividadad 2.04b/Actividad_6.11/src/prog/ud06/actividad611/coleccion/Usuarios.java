package prog.ud06.actividad611.coleccion;

import java.util.List;

import prog.ud06.actividad611.coleccion.diccionario.Diccionario;

public class Usuarios {
  private Diccionario diccionarioUsuario = new Diccionario();
  private Diccionario diccionarioNombre = new Diccionario();
  private Diccionario diccionarioTarjeta = new Diccionario();
  private Diccionario diccionarioListaClientes = new Diccionario();
  
  public Usuarios() {
    
  }
  
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

