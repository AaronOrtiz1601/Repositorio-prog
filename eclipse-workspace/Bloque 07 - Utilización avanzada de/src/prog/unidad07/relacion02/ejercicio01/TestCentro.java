package prog.unidad07.relacion02.ejercicio01;

/**
 * Crea objetos y los prueba
 */
public class TestCentro {

  public static void main(String[] args) {
    // Profesor
    Profesor profesor = new Profesor("Pako Makako", "11111111A", "Soltero", 2006, "A0211", "Informática");
    // Imprimimos su información
    System.out.printf("Profesor original: %s%n", profesor);
    // Cambiamos su estado civil
    profesor.setEstadoCivil("Casado");
    // Y su despacho
    profesor.setDespacho("A0313");
    // Y su departamento
    profesor.setDepartamento("Lengua");
    // Y volvemos a imprimir
    System.out.printf("Profesor modificado: %s%n", profesor);
    
    // Personal de Administración y Servicios
    AdministracionServicios admin = new AdministracionServicios("Paqui Makaki", "22222222B", "Viuda", 1987, "C01011", "Bibilioteca");
    // Imprimimos su información
    System.out.printf("PAS original: %s%n", admin);
    // Cambiamos su estado civil
    admin.setEstadoCivil("Divorciada");
    // Y su despacho
    admin.setDespacho("A0415");
    // Y su sección
    admin.setSeccion("Administración");
    // Y volvemos a imprimir
    System.out.printf("PAS modificado: %s%n", admin);
    
    // Y por último, estudiante
    Estudiante estudiante = new Estudiante("Harry Potter", "99999999Z", "Soltero", "Pociones");
    // Imprimimos su información
    System.out.printf("Estudiante original: %s%n", estudiante);
    // Cambiamos su estado civil
    estudiante.setEstadoCivil("Ennoviado");
    // Y lo matriculamos
    estudiante.setCurso("Defensa contra las artes oscuras");
    // Y volvemos a imprimir
    System.out.printf("Estudiante modificado: %s%n", estudiante);
    
  }

}
