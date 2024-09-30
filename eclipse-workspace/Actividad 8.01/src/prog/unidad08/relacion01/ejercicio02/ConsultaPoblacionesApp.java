package prog.unidad08.relacion01.ejercicio02;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class ConsultaPoblacionesApp {
  public static final String JDBC_URL = "jdbc:sqlite:";
  public static final String DATABASE_PATH = "db/poblaciones01.db";
  private static final String SQL = "Select codigo, nombre, extension, pob_total, pob_hombres,pob_mujeres,vehiculos,lineas_tel from pueblos where pob_total > ? and pob_total < ? and nombre LIKE ? ";
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    // Conecta con la base de datos
    try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH);
         PreparedStatement stmt = conn.prepareStatement(SQL) ;) {
      System.out.println("Dime el rango de población menor");
      int poblacionMenor = Integer.parseInt(sc.nextLine());
      stmt.setInt(1, poblacionMenor);
      System.out.println("Dime el rango de población menor");
      int poblacionMayor = Integer.parseInt(sc.nextLine());
      stmt.setInt(2, poblacionMayor);
      System.out.println("Dime una parte que deba contener");
      String cont = sc.nextLine();
      stmt.setString(3, "%"+ cont +"%");
      ResultSet rs = stmt.executeQuery();
      System.out.println("Poblaciones encontradas");
      System.out.println("CODIGO            NOMBRE              EXT   P_TOT  P_HOM   P_MUJ VEHIC LINEAS");
      System.out.println("----------------------------------------------------------------------------");

      while (rs.next()) {
        System.out.printf("%-17s %-12s %-12f %-6d %-7d %-5d %-5d %d%n", rs.getString(1), rs.getString(2), rs.getDouble(3), rs.getInt(4), rs.getInt(5), rs.getInt(6), rs.getInt(7), rs.getInt(8));
      }
        
        
    } catch (SQLException e) {
        System.out.printf("Error: Ocurrió error %s%n", e.getMessage());
    }

  }

}
