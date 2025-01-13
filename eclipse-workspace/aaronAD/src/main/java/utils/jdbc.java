package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * Clase que sirve para crear la conexion a la base de datos
 */
public class jdbc {
  /**
   * Atributos privados de la clase que sirven para preparar la ruta 
   */
  private static final String URL = "jdbc:mysql://localhost:3306/";
  private static final String BBDD = "sakila";
  private static final String PARAMETROS = "?serverTimezone=UTC";
  private static final String USUARIO = "root";
  private static final String CLAVE = "manolo777Ab";
  
  /**
   * Metodo que nos devuelve la conexion
   * @return
   */
  public Connection conectar() {
      Connection conexion = null;
      //Si todo va bien saldra un mensaje confirmandolo
      try {
          conexion = DriverManager.getConnection(URL+BBDD+PARAMETROS, USUARIO, CLAVE);
          System.out.println("Conexion OK");
      } catch (SQLException e) {
          System.out.println("Error en la conexion");
          e.printStackTrace();
      }
      
      return conexion;
  }

}
