package main;

import conexion.Funciones;
import org.hibernate.Session;
import org.hibernate.Transaction;
import utils.HibernateUtil;

public class MainApp {
    public static void main(String[] args) {
        String archivo = "Alumnado_nuevo.txt";

        // Abrir la sesión
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            // Iniciar transacción
            tx = session.beginTransaction();

            // Llamar al método para crear la tabla e insertar los datos
            Funciones.crearTablaSuperusuarios(session, archivo);

            // Confirmar la transacción
            tx.commit();
            System.out.println("Operación completada con éxito.");
        } catch (Exception e) {
            // Revertir la transacción en caso de error
            if (tx != null) tx.rollback();
            System.err.println("Error durante la creación de la tabla Superusuarios:");
            e.printStackTrace();
        } finally {
            // Cerrar la sesión
            HibernateUtil.closeSession();
        }
    }
}
