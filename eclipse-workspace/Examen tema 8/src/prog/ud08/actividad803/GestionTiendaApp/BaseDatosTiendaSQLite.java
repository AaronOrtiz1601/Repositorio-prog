package prog.ud08.actividad803.GestionTiendaApp;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Types;

public class BaseDatosTiendaSQLite implements BaseDatosTienda {
  public static final String JDBC_URL = "jdbc:sqlite:";
  private String dataBasePath;

  public BaseDatosTiendaSQLite(String rutaDb) {
    if (!rutaDb.isBlank() && !rutaDb.equals(null)) {
      this.dataBasePath = rutaDb;
    } else {
      throw new IllegalArgumentException();
    }
  }
  /**
   * Metodo que recibe una motocicleta y la añade a la base de datos
   * @param motocicleta
   */
  @Override
  public void anyadirMotocicleta(Motocicleta motocicleta) {
    Motocicleta nuevoMotocicleta = null;
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(
            "insert into MOTOCICLETA (referencia, cilindrada, tipo, precio, fabricante) VALUES (?,?,?,?,?)");) {
      stmt.setString(1, motocicleta.getReferencia());
      stmt.setInt(2, motocicleta.getCilindrada());
      stmt.setString(3, motocicleta.getTipo());
      stmt.setDouble(4, motocicleta.getPrecio());
      stmt.setString(5, motocicleta.getFabricante());
      stmt.executeUpdate();
    } catch (SQLException e) {
      throw new BaseDatosTiendaException();
    }
  }
  /**
   * Metodo que recibe un cliente y actualiza sus datos en la base de datos
   * @param cliente
   */
  @Override
  public void actualizarCliente(Cliente cliente) {
    String sql = "update CLIENTE set nombre = ?,apellidos = ?, direccion = ?, nif_recomendado = ? WHERE nif = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, cliente.getNombre());
      stmt.setString(2, cliente.getApellidos());
      stmt.setString(3, cliente.getDireccion());
      stmt.setString(4, cliente.getNif_recomendado());

      int comprobar = stmt.executeUpdate();
      if (comprobar != 1) {
        throw new BaseDatosTiendaException();
      }
    } catch (SQLException e) {
      throw new BaseDatosTiendaException();
    }

  }
  /**
   * Metodo para buscar por su dni a un cliente
   * @param dni
   * @return Cliente
   */

  @Override
  public Cliente getClienteByCodigo(String dni) {
    Cliente nuevoCliente = null;
    String sql = "SELECT * FROM CLIENTE WHERE nif = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, dni);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          String valor1 = rs.getString(1);
          String valor2 = rs.getString(2);
          String valor3 = rs.getString(3);
          String valor4 = rs.getString(4);
          String valor5 = rs.getString(5);

          if (rs.wasNull()) {
            valor5 = null;
          }
          nuevoCliente = new Cliente(valor1, valor2, valor3, valor4, valor5);
        }
      }
    } catch (SQLException e) {
      throw new BaseDatosTiendaException();
    }
    return nuevoCliente;

  }

  @Override
  public Motocicleta getMotocicletaByCodigo(String referencia) {
    Motocicleta nuevaMotocicleta = null;
    String sql = "SELECT * FROM MOTOCICLETA WHERE referencia = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, referencia);
      try (ResultSet rs = stmt.executeQuery()) {
        if (rs.next()) {
          String valor1 = rs.getString(1);
          int valor2 = rs.getInt(2);
          String valor3 = rs.getString(3);
          double valor4 = rs.getDouble(4);
          String valor5 = rs.getString(5);

          if (rs.wasNull()) {
            valor5 = null;
          }
          nuevaMotocicleta = new Motocicleta(valor1, valor2, valor3, valor4, valor5);
        }
      }
    } catch (SQLException e) {
      throw new BaseDatosTiendaException();
    }
    return nuevaMotocicleta;

  }
  /**
   * Metodo que recibe el dni de un cliente y la referencia de una moto y resgitra la venta
   * @param referenciaMotocicleta
   * @param dniCliente
   */
  @Override
  public void registrarVenta(String referenciaMotocicleta, String dniCliente) {
    Cliente cliente = getClienteByCodigo(dniCliente);
    Motocicleta motocicleta = getMotocicletaByCodigo(referenciaMotocicleta);
    if (cliente != null && motocicleta != null) {
      try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);

          PreparedStatement stmt = conn
              .prepareStatement("insert into VENTA (nif_cliente, referencia_motocicleta, fecha) VALUES (?,?,?)");) {
        stmt.setString(1, dniCliente);
        stmt.setString(2, referenciaMotocicleta);
        stmt.setString(3, "CURRENT_DATE");
        stmt.executeUpdate();

      } catch (SQLException e) {
        throw new BaseDatosTiendaException();
      }
    } else {
      throw new BaseDatosTiendaException();
    }

  }

  @Override
  public void eliminacioMotocicleta(String referencia) {

    String sql = "delete FROM MOTOCICLETA WHERE referencia = ?";
    try (Connection conn = DriverManager.getConnection(JDBC_URL + dataBasePath);
        PreparedStatement stmt = conn.prepareStatement(sql)) {
      stmt.setString(1, referencia);

      int comprobar = stmt.executeUpdate();
      if (comprobar != 1) {
        throw new BaseDatosTiendaException();
      }
    } catch (SQLException e) {
      throw new BaseDatosTiendaException();
    }

  }
}
