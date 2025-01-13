package tarea6;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.SQLException;

import utils.jdbc;

public class procedure {

    public static void main(String[] args) throws SQLException {
        // Instancia de la clase jdbc para obtener la conexión
        jdbc conexionBD = new jdbc();
        Connection connection = null;

        try {
            // Conectar a la base de datos
            connection = conexionBD.conectar();
            if (connection == null) {
                System.out.println("No se pudo establecer la conexión.");
                return;
            }

            // Llamar al procedimiento almacenado iva_nota
            String sql = "{CALL iva_nota(?)}";
            try (CallableStatement callableStmt = connection.prepareCall(sql)) {
                // Establecer el parámetro de entrada
                int productoId = 1; // Ejemplo de producto_id, puedes cambiarlo según sea necesario
                callableStmt.setInt(1, productoId);

                // Ejecutar el procedimiento almacenado
                callableStmt.execute();
                System.out.println("Procedimiento iva_nota ejecutado exitosamente.");

            } catch (SQLException e) {
                e.printStackTrace();
            }

        } finally {
            // Cerrar la conexión
            if (connection != null) {
                try {
                    connection.close();
                    System.out.println("Conexión cerrada.");
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
