package prog.unidad08.relacion01.ejercicio04;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class ModificarPoblacionApp {
  private static final String JDBC_URL = "jdbc:sqlite:";
  private static final String DATABASE_PATH = "db/poblaciones02.db";
  private static String SQL = "update pueblos set %s = ? where codigo = ? ";

  
  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH)) {
      System.out.println("Dime el codigo de la ciudad que quieras actualizar");
      int codigo = Integer.parseInt(sc.nextLine());
      System.out.println("¿Quiere modificar el número de vehiculos (v) o el de líneas telefónicas (l)?");
      String valor = sc.nextLine();
      if (valor.equals("v") || valor.equals("l"))
      {
        String columna;
        int valorADar;
        
        if (valor.equals("v"))
        {
          System.out.println("Dime el nuevo valor para vehiculos");
           valorADar = Integer.parseInt(sc.nextLine());
           columna = "vehiculos";
        }else {
          System.out.println("Dime el nuevo valor para lineas de telefono");
           valorADar = Integer.parseInt(sc.nextLine());
           columna = "lineas_tel";
        }
        String sql = String.format(SQL, columna);
        try (PreparedStatement stmt = conn.prepareStatement(sql)) {
            stmt.setInt(1, valorADar);
            stmt.setInt(2, codigo);
            
            int filasActualizadas = stmt.executeUpdate();
            
            if (filasActualizadas > 0) {
                System.out.println("Actualización exitosa");
            } else {
                System.out.println("No se pudo actualizar la ciudad con el código proporcionado");
            }
        }


      
      }else
      {
        System.out.println("Valor no valido ");
      }
     
     
    } catch (SQLException e) {
      System.out.printf("Error: Ocurrió error %s%n", e.getMessage());
    }
  }
  }

