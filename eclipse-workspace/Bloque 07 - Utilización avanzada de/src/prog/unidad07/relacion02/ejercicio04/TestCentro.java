package prog.unidad07.relacion02.ejercicio04;

/**
 * Prueba la clase Centro
 */
public class TestCentro {

  public static void main(String[] args) {
    // Creamos el centro
    Centro centro = new Centro();
    
    // Añadimos gente
    centro.alta(new Estudiante("Pako Makako", "11111111A", "Soltero", "Pociones"));
    centro.alta(new Estudiante("Paqui Makaki", "22222222B", "Soltera", "Pociones"));
    centro.alta(new Estudiante("Lukas Grijander", "33333333C", "Casado", "Levitación 1"));
    centro.alta(new Estudiante("Torpedo Español", "44444444D", "Soltero", "Quidditch"));
    centro.alta(new Profesor("Antonio Bueno", "55555555E", "Soltero", 1987, "A101", "Informática", 1200));
    centro.alta(new Profesor("Carlos Diaz", "66666666F", "Viudo", 1998, "A102", "Lengua", 1343.54));
    centro.alta(new Profesor("Elena Fernandez", "77777777G", "Divorciada", 2003, "A103", "Francés", 1821.65));
    centro.alta(new Profesor("Genara Hernandez", "88888888H", "Soltera", 2017, "A104", "Inglés", 1232.87));
    centro.alta(new AdministracionServicios("Idelfonsa Jimenez", "99999999I", "Soltera", 2002, "A105", "Biblioteca", 100));
    centro.alta(new AdministracionServicios("Kiko Lopez", "00000000J", "Soltero", 2003, "A105", "Biblioteca", 75));
    centro.alta(new AdministracionServicios("Maria Navarro", "11111112K", "Casada", 2000, "A106", "Administración", 82));
    centro.alta(new AdministracionServicios("Otilio Perez", "22222223L", "Viudo", 1997, "A107", "Mantenimiento", 98));
    
    // Imprimimos
    System.out.println("Antes de dar de baja");
    centro.imprimir();

    // Y la nomina
    centro.imprimirNomina();

    // Eliminamos algunos
    centro.baja("22222222B");
    centro.baja("77777777G");
    centro.baja("11111112K");
    
    // Y volvemos a imprimir
    System.out.println("Después de dar de baja");
    centro.imprimir();

    // Y la nomina
    centro.imprimirNomina();
  }

}
