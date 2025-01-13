package main;

import org.hibernate.Session;
import org.hibernate.Transaction;
import model.Empleado;
import model.RestEmpleado;
import model.Restaurante;
import utils.HibernateUtil;

import java.util.Date;

public class MainApp {

    public static void main(String[] args) {
        // Obtener la sesión de Hibernate
        Session session = HibernateUtil.getSessionFactory().openSession();

        // Iniciar una transacción
        Transaction transaction = session.beginTransaction();

        try {
            // Crear objetos Restaurante, Empleado y RestEmpleado para probar las inserciones

            // Crear un Restaurante
            Restaurante restaurante = new Restaurante();
            restaurante.setCodRest("R002");
            restaurante.setNombre("El Buen Sabor");
            restaurante.setLicenciaFiscal("ABC123456");
            restaurante.setDomicilio("Calle Falsa 123");
            restaurante.setFechaApertura(new Date());
            restaurante.setHorario("De 9:00 a 22:00");

            // Crear un Empleado
            Empleado empleado = new Empleado();
            empleado.setDniEmpleado("12345678B");
            empleado.setNombre("Juan Pérez");
            empleado.setDomicilio("Calle Ejemplo 456");
            empleado.setFechaNacimiento(new Date(1990, 5, 15));

            // Guardar el Restaurante y el Empleado en la base de datos
            session.save(restaurante);
            session.save(empleado);

            // Crear una relación entre Restaurante y Empleado
            RestEmpleado restEmpleado = new RestEmpleado();
            restEmpleado.setRestaurante(restaurante);
            restEmpleado.setEmpleado(empleado);
            restEmpleado.setFuncion("Camarero");

            // Guardar la relación
            session.save(restEmpleado);

            // Commit de la transacción
            transaction.commit();

            System.out.println("Datos guardados correctamente.");
        } catch (Exception e) {
            // Si hay un error, hacemos rollback
            if (transaction != null) {
                transaction.rollback();
            }
            e.printStackTrace();
        } finally {
            // Cerrar la sesión
            session.close();
        }
    }
}
