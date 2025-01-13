package conexion;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.stream.Collectors;

import org.hibernate.Session;

import model.SuperUsuario;

public class Funciones {

    public static void crearTablaSuperusuarios(Session session, String nombreFichero) throws Exception {
        try {
            // Leer el archivo y procesar los datos
            List<String> lineas = Files.lines(Paths.get(nombreFichero)).collect(Collectors.toList());

            int batchSize = 10;
            int contador = 0;

            for (String linea : lineas) {
                String[] partes = linea.split(",");
                String nombre = partes[0];
                String apellido = partes[1];
                String user = "2DAM" + nombre.substring(0, 2).toUpperCase() + apellido.substring(0, 2).toUpperCase();

                // Crear el objeto Superusuario
                SuperUsuario superusuario = new SuperUsuario(nombre, apellido, user);
                session.persist(superusuario);

                contador++;

                // Ejecutar el lote cuando llegue al tamaño indicado
                if (contador % batchSize == 0) {
                    session.flush();
                    session.clear();
                }
            }

            // Ejecutar cualquier resto pendiente
            session.flush();
            session.clear();

            System.out.println("Datos insertados correctamente en la tabla Superusuarios.");
        } catch (Exception e) {
            System.err.println("Error al procesar los datos: " + e.getMessage());
            throw e; // Propagar la excepción para que el main pueda manejarla
        }
    }
}
