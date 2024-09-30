package prog.unidad08.relacion01.ejercicio05;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class EliminaPoblacionesApp {
  private static final String JDBC_URL = "jdbc:sqlite:";
  private static final String DATABASE_PATH = "db/poblaciones02.db";
  private static String SQL1 = "delete from pueblos where codigo = ?";
  private static String SQL2 = "delete from pueblos where extension < ?";
  private static String SQL3 =  "delete from pueblos where pob_total > ?";
  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH)) {
      System.out.println("¿Desea eliminar por código(c), extensión(e) o población total(p)?:");
      String opcion = sc.nextLine();
      if (opcion.equals("c") || opcion.equals("e") || opcion.equals("p"))
      {
        if (opcion.equals("c"))
        {
          System.out.println("Dime el codigo de la ciudad que quieres borrar");
          int codigo = Integer.parseInt(sc.nextLine());
          try (PreparedStatement stmt = conn.prepareStatement(SQL1)) {
            stmt.setInt(1, codigo);
            stmt.executeUpdate();
            }
        } else if (opcion.equals("e"))
        {
          System.out.println("Dime una extension y borrare todos los pueblos con extension menor");
          Double extension = Double.parseDouble(sc.nextLine());
          try (PreparedStatement stmt = conn.prepareStatement(SQL2)) {
            stmt.setDouble(1, extension);
            stmt.executeUpdate();
            }
        }else {
          System.out.println("Dime una poblacion total y borrare todos los pueblos con poblacion mayor");
          int poblacion = Integer.parseInt(sc.nextLine());
          try (PreparedStatement stmt = conn.prepareStatement(SQL3)) {
            stmt.setInt(1, poblacion);
            stmt.executeUpdate();
            }
        }
      }else {
        System.out.println("opcion no valida");
      }
     } catch (SQLException e) {
      System.out.printf("Error: Ocurrió error %s%n", e.getMessage());
    }

  }

}
