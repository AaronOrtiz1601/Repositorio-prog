package models;

public class Usuario {
  /**
   * Atributos privados de la clase usuario 
   */
  
  private String usuario;
  private String contraseña;
  
  /**
   * Constructor de la clase Usuario, en la que recogemos el nombre y la contraseña de este
   * @param usuario
   * @param contraseña
   */
  public Usuario(String usuario, String contraseña) {
    this.usuario = usuario;
    this.contraseña = contraseña;
  }
  /**
   * Metodos getter and setter de los atributos de la clase

   */

  public String getUsuario() {
    return usuario;
  }

  public void setUsuario(String usuario) {
    this.usuario = usuario;
  }

  public String getContraseña() {
    return contraseña;
  }

  public void setContraseña(String contraseña) {
    this.contraseña = contraseña;
  }

}
