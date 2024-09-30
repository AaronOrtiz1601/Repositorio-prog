package parteInterna;

public class Usuario {
  
  /**
   * Atributos de la clase usuario
   */
  
  private String nombreUsuario;
  private String contrasenya;
  
  /**
   * Constructor de la clase usuario
   * @param nombreUsuario
   * @param contrasenya
   */
  
  public Usuario(String nombreUsuario, String contrasenya) {
    
    this.nombreUsuario = nombreUsuario;
    this.contrasenya = contrasenya;
    
  }
  /**
   * Metodo que devuelve el nombre del usuario      
   * @return nombreUsuario
   */
  public String getNombreUsuario() {
    return nombreUsuario;
  }
  /**
   * Metodo que devuelve la contraseña del usuario      
   * @return contrasenya
   */
  public String getContrasenya() {
    return contrasenya;
  }
  

}
