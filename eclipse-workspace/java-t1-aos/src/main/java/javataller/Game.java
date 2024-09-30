package javataller;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

/**
 * Clase que implementa un menu para gestionar los usuarios y sus
 * puntuaciones,sacadas del juego
 * 
 * @author Aarón Ortiz Sánchez
 */

public class Game {
  /**
   * Constantes para iniciar la base de datos
   */
  public static final String JDBC_URL = "jdbc:sqlite:";
  public static final String DATABASE_PATH = "db/puntuaciones_usuarios.db";
  /**
   * Escaner para poder pedir cosas por tecladp
   */
  public static final Scanner SC = new Scanner(System.in);

  /**
   * Método principal donde se ejecuta el menu y el juego.
   *
   * @param args Los argumentos de la línea de comandos (no se utiliza en este
   *             método).
   */
  public static void main(String[] args) {
    // Menu con las diferentes opciones,hasta que se elija la opcion 0 se estara
    // repitiendo este menu
    int opcion;
    do {
      showScreen("Hola bienvenido al menu de jugador de pinball\nEscoge una opcion");
      showScreen("1) Crear Usuario");
      showScreen("2) Borrar Usuario");
      showScreen("3) Mostrar puntuacion de tu usuario");
      showScreen("4) Comenzar una nueva Partida");
      showScreen("0) Salir");
      opcion = Integer.parseInt(SC.nextLine());
      switch (opcion) {
      case 0:
        showScreen("Hasta pronto");
        break;
      case 1:
        createUser();
        break;
      case 2:
        deleteUser();
        break;
      case 3:
        showPoints();
        break;
      case 4:
        startGame();
        break;
      default:
        throw new IllegalArgumentException("Unexpected value: " + opcion);
      }
    } while (opcion != 0);
  }

  /**
   * Metodo que sirve para no tener que escribir todo el rato los syso
   * 
   * @param mensaje
   */

  private static void showScreen(String message) {
    System.out.println(message);
  }
  

  /**
   * Metodo privado para crear el usuario(Sin puntuación)
   */
  private static void createUser() {
    // Información para los usuarios
    showScreen("Bienvenido a la creación de usuario");
    showScreen("Antes de nada te informo que tu usuario solo almacenara la puntuación más alta, que haya en nuestros resgitros,");
    showScreen("si intentas guardar una mas pequeña no lo hara");
    
    try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH);
        Statement stmt = conn.createStatement()) {
      String nombre;
      
      // Se pide el nombre del usuario y este se almacena en la base de datos
      showScreen("Dime el nombre del usuario");
      nombre = SC.nextLine();
      
      String sql = String.format("INSERT INTO Usuarios (Usuario) VALUES ('%s')", nombre);
      stmt.executeUpdate(sql);
      
      showScreen("Usuario creado");
    } catch (SQLException e) {
      showScreen("Error: " + e.getMessage());
    }
  }

  /**
   * Metodo privado para borrar el usuario mediante su nombre
   */
  private static void deleteUser() {
    try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH);
        Statement stmt = conn.createStatement()) {
      String name;
      
      // Se pide el nombre para borrarlo atraves de este
      showScreen("Dime el nombre del usuario que quieres borrar");
      name = SC.nextLine();
      
      String sql = String.format("DELETE FROM Usuarios WHERE Usuario = '%s'", name);
      stmt.executeUpdate(sql);
      
      showScreen("Usuario borrado");
    } catch (SQLException e) {
      showScreen("Error: " + e.getMessage());
    }
  }

  /**
   * Metodo privado para buscar el usuario mediante su nombre
   */
  private static void showPoints() {
    try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH);
        Statement stmt = conn.createStatement()) {
      String name;
      
      // Se pide el nombre para borrarlo atraves de este
      showScreen("Dime el nombre del usuario que quieres ver su puntuación:");
      name = SC.nextLine();
      
      String sql = String.format("SELECT * FROM Usuarios WHERE Usuario = '%s'", name);
      ResultSet rs = stmt.executeQuery(sql);
      
      while (rs.next()) {
        String user = rs.getString("Usuario");
        double points = rs.getInt("Puntuacion");
        showScreen("Usuario: " + user + ", Puntuacion: " + points);
      }
    } catch (SQLException e) {
      showScreen("Error: " + e.getMessage());
    }
  }

  /**
   * Metodo privado que inicia la partida
   */
  private static void startGame() {
    
    // Informacion para los jugadores
    showScreen("La partida va ha empezar");
    showScreen( "si te cansas de esta puedes escribir exit y acabar la partida,en vez de golpear la bola de nuevo");
   
    // Almacenamiento de la puntuacion obtenida
    double gameResult = Ball.launchAndStart();
    showScreen("Tu puntuación es de " + gameResult);
    
    // Llamada a un metodo privado que se encarga de almacenar la puntuacion si el
    // usuario quiere
    savePoints(gameResult);
  }

  /**
   * Metodo privado que se encarga de almacenar la puntuacion si el usuario quiere
   * 
   * @param puntuacion que se obtuvo en la partida
   */
  private static void savePoints(double gameResult) {
    String answer;
    String user;
    
    // Se pregunta si se quiere almacenar la puntuacion,en caso de querer se pide un
    // usuario y se comprueba que existe
    showScreen("¿Te gustaría guardar tu puntuación (si/no)?, para ello debes tener creado un usuario.");
    answer = SC.nextLine();
    
    if (answer.equalsIgnoreCase("si")) {
      showScreen("Dime el nombre de usuario para comprobar si este existe");
      user = SC.nextLine();
      // Se verifica el usuario, y si este existe se procede a almacenarlo ya en la
      // base de datos
      
      if (verifyUser(user)) {
        almacenarPuntuacionSql(user, gameResult);
      } else {
        showScreen("Lo siento pero ese usuario no existe");
      }
    } else {
      showScreen("Vale, hasta pronto");
    }
  }

  /**
   * Metodo que guarda la informacion en la base de datos
   * 
   * @param user.         Nombre del usuario
   * @param newResult. Puntuacion a almacenar
   */
  private static void almacenarPuntuacionSql(String user, double newResult) {
    try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH);
        Statement stmt = conn.createStatement()) {

      // Obtener la puntuación actual del usuario
      String sqlSelect = String.format("SELECT Puntuacion FROM Usuarios WHERE Usuario = '%s'", user);
      ResultSet rs = stmt.executeQuery(sqlSelect);

      if (rs.next()) {
        double puntuacionActual = rs.getDouble("Puntuacion");

        // Comparar la nueva puntuación con la existente
        if (newResult > puntuacionActual) {
          // Actualizar la puntuación solo si la nueva es mayor
          String sqlUpdate = String.format("UPDATE Usuarios SET Puntuacion = %s WHERE Usuario = '%s'", newResult,
              user);
          
          stmt.executeUpdate(sqlUpdate);
          showScreen("Puntuación actualizada.");
        } else {
          showScreen("La nueva puntuación no es mayor que la actual. No se actualizó la puntuación.");
        }
      } else {
        showScreen("Usuario no encontrado.");
      }
    } catch (SQLException e) {
      showScreen("Error: " + e.getMessage());
    }
  }

  /**
   * Metodo privado que devuelve un boolean indicando si el usuario existe o no en
   * la base de datos
   * 
   * @param user. Nombre del usuario
   * @return booleano que indica si existe o no el usuario
   */
  private static boolean verifyUser(String user) {
    try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH);
        Statement stmt = conn.createStatement()) {
      String sql = String.format("SELECT Usuario FROM Usuarios WHERE Usuario = '%s'", user);
      ResultSet rs = stmt.executeQuery(sql);
      return rs.next();
      
    } catch (SQLException e) {
      showScreen("Error: " + e.getMessage());
      return false;
    }
  }
}
