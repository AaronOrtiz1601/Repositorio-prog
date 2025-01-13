package mainApp;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import models.Pelicula;
import utils.jdbc;

public class app {

  /**
   * Metodo que crea una clase para almacenar peliculas cortas
   */
  public void crearTablaPeliculas() {
    // Establecemos la conexion a la base de datos y hacemos el create table
    try (Connection conn = jdbc.conectar();
        PreparedStatement crearTablaStmt = conn.prepareStatement("CREATE TABLE IF NOT EXISTS PeliculasCortas ("
            + "film_id INT NOT NULL, " + "title VARCHAR(255), " + "description TEXT, " + "release_year YEAR, "
            + "language_id TINYINT UNSIGNED, " + "length SMALLINT, " + "rating VARCHAR(10), "
            + "PRIMARY KEY (film_id), " + "FOREIGN KEY (language_id) REFERENCES language (language_id) "
            + "ON DELETE RESTRICT ON UPDATE CASCADE);");
        // Insertamos los datos de la tabla film en los que su longitud sea menos a 100
        PreparedStatement insertarDatosStmt = conn.prepareStatement(
            "INSERT INTO PeliculasCortas (film_id, title, description, release_year, language_id, length, rating) "
                + "SELECT film_id, title, description, release_year, language_id, length, rating "
                + "FROM film WHERE length < 100;")) {

      // Crear la tabla PeliculasCortas si no existe
      crearTablaStmt.executeUpdate();

      // Insertar los registros de Films donde length < 100
      insertarDatosStmt.executeUpdate();

      System.out.println("Tabla PeliculasCortas creada y registros insertados correctamente.");

    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Metodo que se encarga de cargar peliculas desde un fichero csv a la tabla que
   * hemos creado con el metodo anterior
   * 
   * @param archivo
   */
  public void cargarPeliculas(String archivo) {
    // Verificar que el archivo tiene extensión .csv
    if (!archivo.endsWith(".csv")) {
      System.out.println("Error: El archivo debe tener extensión .csv");
      return;
    }

    // SQL para insertar en la tabla PeliculasCortas
    String sqlInsert = "INSERT INTO PeliculasCortas (film_id, title, description, release_year, language_id, length, rating) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    Connection conn = jdbc.conectar();
    try (conn;
        BufferedReader br = new BufferedReader(new FileReader(archivo));
        PreparedStatement pstmt = conn.prepareStatement(sqlInsert)) {

      // Desactivar el auto-commit para manejar manualmente las transacciones
      conn.setAutoCommit(false);

      String line;
      int batchSize = 0;

      while ((line = br.readLine()) != null) {
        boolean primeraLinea = true;
        if (primeraLinea) {
          primeraLinea = false;
          continue;
        }
        String[] data = line.split(";");

        // Asignar los valores del CSV al PreparedStatement
        pstmt.setInt(1, Integer.parseInt(data[0]));
        pstmt.setString(2, data[1]);
        pstmt.setString(3, data[2]);
        pstmt.setInt(4, Integer.parseInt(data[3]));
        pstmt.setInt(5, Integer.parseInt(data[4]));
        pstmt.setInt(6, Integer.parseInt(data[5]));
        pstmt.setString(7, data[6]);

        // Añadir al lote
        pstmt.addBatch();
        batchSize++;

        // Ejecutar el lote cada 10 inserciones
        if (batchSize == 10) {
          pstmt.executeBatch();
          batchSize = 0;
        }
      }

      // Ejecutar cualquier lote restante (si el número de filas no es múltiplo de 10)
      if (batchSize > 0) {
        pstmt.executeBatch();
      }

      // Confirmar la transacción si todo salió bien
      conn.commit();
      System.out.println("Películas insertadas correctamente.");

    } catch (SQLException e) {
      e.printStackTrace();
      try {
        // En caso de error, hacer rollback de la transacción
        conn.rollback();
        System.out.println("Se hizo rollback de la transacción.");
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

  /**
   * Metodo que guarda las informacion de la tabla peliclas cortas en un fichero
   * de texto indicado a traves de la condición de un booleano
   * 
   * @param idioma
   * @param eleccion
   */
  public static void peliculasToFichero(String idioma, boolean eleccion) {
    // Crear nombre del fichero
    String nombreFichero;
    if (eleccion) {
      nombreFichero = "peliculas_lang_" + idioma.toLowerCase() + ".csv";
    } else {
      nombreFichero = "peliculas_lang_" + idioma.toLowerCase() + ".dat";
    }

    // Consultar las películas de la base de datos según el idioma
    String sql = "SELECT PeliculasCortas.film_id, PeliculasCortas.title, PeliculasCortas.description, "
        + "PeliculasCortas.release_year, language.name AS idioma, " + "PeliculasCortas.length, PeliculasCortas.rating "
        + "FROM PeliculasCortas " + "INNER JOIN language ON PeliculasCortas.language_id = language.language_id "
        + "WHERE language.name = ?;";

    try (Connection conn = jdbc.conectar(); PreparedStatement ps = conn.prepareStatement(sql)) {
      ps.setString(1, idioma);
      ResultSet rs = ps.executeQuery();

      if (eleccion) {
        // Escritura en archivo CSV
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(nombreFichero))) {

          // Escribir registros
          while (rs.next()) {
            int filmId = rs.getInt("film_id");
            String title = rs.getString("title");
            String description = rs.getString("description");
            int releaseYear = rs.getInt("release_year");
            String language = rs.getString("idioma");
            int length = rs.getInt("length");
            String rating = rs.getString("rating");

            // Escribir en el archivo CSV
            writer.write(filmId + ";" + title + ";" + description + ";" + releaseYear + ";" + language + ";" + length
                + ";" + rating);
            writer.newLine();

          }
        }
      } else {
        // Escritura en archivo binario
        try (ObjectOutputStream writer = new ObjectOutputStream(new FileOutputStream(nombreFichero))) {
          while (rs.next()) {
            Pelicula pelicula = new Pelicula(rs.getInt("film_id"), rs.getString("title"), rs.getString("description"),
                rs.getInt("release_year"), rs.getString("idioma"), rs.getInt("length"), rs.getString("rating"));

            writer.writeObject(pelicula);
          }
        }
      }
    } catch (SQLException | IOException e) {
      e.printStackTrace();
    }
  }

  public void cargarPeliculasBinario(String archivo) {
    // Verificar que el archivo tiene extensión .dat
    if (!archivo.endsWith(".dat")) {
      System.out.println("Error: El archivo debe tener extensión .dat");
      return;
    }

    // SQL para insertar en la tabla PeliculasCortas
    String sql = "INSERT INTO PeliculasCortas (film_id, title, description, release_year, language_id, length, rating) "
        + "VALUES (?, ?, ?, ?, ?, ?, ?)";
    Connection conn = jdbc.conectar();
    try (conn;
        PreparedStatement pstmt = conn.prepareStatement(sql);
        ObjectInputStream reader = new ObjectInputStream(new FileInputStream(archivo))) { 

      // Desactivar el auto-commit para manejar manualmente las transacciones
      conn.setAutoCommit(false);

      int batchSize = 0;

      while (true) {
        try {
          // Leer una película del archivo
          Pelicula pelicula = (Pelicula) reader.readObject();

          // Obtener el language_id desde la tabla language
          String languageQuery = "SELECT language_id FROM language WHERE name = ?";
          try (PreparedStatement langStmt = conn.prepareStatement(languageQuery)) {
            langStmt.setString(1, pelicula.getIdioma()); 
            ResultSet langRs = langStmt.executeQuery();
            if (langRs.next()) {
              int languageId = langRs.getInt("language_id");

              // Asignar los valores del objeto Pelicula al PreparedStatement
              pstmt.setInt(1, pelicula.getFilmId());
              pstmt.setString(2, pelicula.getTitle());
              pstmt.setString(3, pelicula.getDescription());
              pstmt.setInt(4, pelicula.getReleaseYear());
              pstmt.setInt(5, languageId); 
              pstmt.setInt(6, pelicula.getLength());
              pstmt.setString(7, pelicula.getRating());

              // Añadir al lote
              pstmt.addBatch();
              batchSize++;

              // Ejecutar el lote cada 5 inserciones
              if (batchSize == 5) {
                pstmt.executeBatch();
                batchSize = 0;
              }
            } else {
              System.out
                  .println("Error: El idioma '" + pelicula.getIdioma() + "' no se encuentra en la base de datos.");
            }
          }
        } catch (EOFException e) {
          // Fin del archivo
          break;
        } catch (IOException | ClassNotFoundException e) {
          e.printStackTrace();
        }
      }

      // Ejecutar cualquier lote restante (si el número de filas no es múltiplo de 5)
      if (batchSize > 0) {
        pstmt.executeBatch();
      }

      // Confirmar la transacción si todo salió bien
      conn.commit();
      System.out.println("Películas insertadas correctamente desde el archivo binario.");

    } catch (SQLException e) {
      e.printStackTrace();
      try {
        // En caso de error, hacer rollback de la transacción
        conn.rollback();
        System.out.println("Se hizo rollback de la transacción.");
      } catch (SQLException ex) {
        ex.printStackTrace();
      }
    } catch (IOException e) {
      e.printStackTrace();
    }
  }

}
