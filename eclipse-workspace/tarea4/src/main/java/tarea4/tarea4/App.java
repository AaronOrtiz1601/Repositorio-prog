package tarea4.tarea4;

import utils.jdbc;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Clase principal para la importación de datos en las tablas Profesor y Asignatura.
 */
public class App {
    public static void main(String[] args) {
        String archivo = "datos.txt";
        importarDatos(archivo);
    }
    /**
     * Metodo privado que se encarga de la importación de los datos que haya en el fichero
     * @param archivo
     */
    private static void importarDatos(String archivo) {
      //Llamamos a la clase jdbc previamente creada para que se encargue de iniciar la conexion a la base de datos
        jdbc conexionBD = new jdbc();
        Connection conexion = null; 
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            // Inicializar la conexión
            conexion = conexionBD.conectar();

            
            

            String linea;
            int idProfesorActual = -1;

            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(";");
                //Hacemos la comprovación que nos indicara si vamos a insertar un profesor o una asignatura
                if (datos.length > 0) {
                    if (datos[0].equalsIgnoreCase("Profesor") && datos.length == 5) {
                        String nifP = datos[1];
                        String nombre = datos[2];
                        String especialidad = datos[3];
                        String telefono = datos[4];

                        // Inserción en la tabla Profesor
                        idProfesorActual = insertarProfesor(conexion, nifP, nombre, especialidad, telefono);
                    } else if (datos[0].equalsIgnoreCase("Asignatura") && datos.length == 3 && idProfesorActual != -1) {
                        String codAsignatura = datos[1];
                        String nombreAsignatura = datos[2];

                        // Inserción en la tabla Asignatura
                        insertarAsignatura(conexion, codAsignatura, nombreAsignatura, idProfesorActual);
                    }
                }
            }

           
            System.out.println("Datos importados correctamente.");

        } catch (IOException | SQLException e) {
            e.printStackTrace();
            try {
                // Revertir los cambios en caso de error
                if (conexion != null) {
                    conexion.rollback();
                    System.out.println("Transacción revertida debido a un error.");
                }
            } catch (SQLException ex) {
                ex.printStackTrace();
            }
        }
    }

    private static int insertarProfesor(Connection conexion, String nifP, String nombre, String especialidad, String telefono) throws SQLException {
        String sql = "INSERT INTO Profesor (NIF_P, Nombre, Especialidad, Telefono) VALUES (?, ?, ?, ?)";
        try (PreparedStatement rs = conexion.prepareStatement(sql, PreparedStatement.RETURN_GENERATED_KEYS)) {
            rs.setString(1, nifP);
            rs.setString(2, nombre);
            rs.setString(3, especialidad);
            rs.setString(4, telefono);
            rs.executeUpdate();

            // Recuperar el ID generado automáticamente
            try (ResultSet resultSet = rs.getGeneratedKeys()) {
                if (resultSet.next()) {
                    return resultSet.getInt(1);
                }
            }
        }
        throw new SQLException("No se pudo obtener el ID del profesor insertado.");
    }

    private static void insertarAsignatura(Connection conexion, String codAsignatura, String nombre, int idProfesor) throws SQLException {
        String sql = "INSERT INTO Asignatura (CodAsignatura, Nombre, IdProfesor) VALUES (?, ?, ?)";
        try (PreparedStatement rs = conexion.prepareStatement(sql)) {
            rs.setString(1, codAsignatura);
            rs.setString(2, nombre);
            rs.setInt(3, idProfesor);
            rs.executeUpdate();
        }
    }
}
