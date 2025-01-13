package main;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import model.Empleado;
import model.Localidad;
import model.RestEmpleado;
import model.RestEmpleadoId;
import model.Restaurante;

public class consultasHQL {
  public static void main(String[] args) {
    // Crear la SessionFactory con configuración de Hibernate
    SessionFactory factory = new Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Empleado.class)
        .addAnnotatedClass(Restaurante.class).addAnnotatedClass(RestEmpleado.class).addAnnotatedClass(Localidad.class)
        .addAnnotatedClass(RestEmpleadoId.class).buildSessionFactory();

    // Crear la sesión de Hibernate
    Session session = factory.getCurrentSession();

    try {
      // Iniciar transacción
      session.beginTransaction();

      // 1. Consulta Simple: Obtener todos los empleados
      List<Empleado> empleados = session.createQuery("from Empleado", Empleado.class).getResultList();
      for (Empleado emp : empleados) {
        System.out.println("Empleado: " + emp.getNombre());
      }

      // 2. Consulta con JOIN: Obtener empleados y sus funciones en restaurantes
      List<Object[]> results = session.createQuery("select e.nombre, re.funcion, r.nombre " + "from RestEmpleado re "
          + "join re.empleado e " + "join re.restaurante r", Object[].class).getResultList();

      for (Object[] row : results) {
        System.out.println("Empleado: " + row[0] + ", Funcion: " + row[1] + ", Restaurante: " + row[2]);
      }

      // 3. Consulta con GROUP BY: Contar empleados por restaurante
      List<Object[]> groupByResults = session.createQuery("select r.nombre, count(re.empleado) "
          + "from RestEmpleado re " + "join re.restaurante r " + "group by r.nombre", Object[].class).getResultList();

      for (Object[] row : groupByResults) {
        System.out.println("Restaurante: " + row[0] + ", Cantidad Empleados: " + row[1]);
      }

      // 4. Subconsulta: Restaurantes con al menos un empleado
      List<Restaurante> restaurantes = session.createQuery(
          "from Restaurante r where r.codRest in " + "(select re.restaurante.codRest from RestEmpleado re)",
          Restaurante.class).getResultList();

      for (Restaurante rest : restaurantes) {
        System.out.println("Restaurante con empleados: " + rest.getNombre());
      }

      // Confirmar transacción
      session.getTransaction().commit();
    } finally {
      // Cerrar la fábrica de sesiones
      factory.close();
    }
  }
}
