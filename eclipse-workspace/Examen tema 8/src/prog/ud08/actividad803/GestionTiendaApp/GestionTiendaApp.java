package prog.ud08.actividad803.GestionTiendaApp;

import java.util.Scanner;

public class GestionTiendaApp {
  
  private static final String RUTA_DB = "db/tienda_orig.db";
  private static BaseDatosTienda proveedorAlmacenamiento;

  private static Scanner scanner;
  //Inicializo la base de datos
  public GestionTiendaApp(BaseDatosTienda servicioAlmacenamiento, Scanner scanner) {
    this.proveedorAlmacenamiento = servicioAlmacenamiento;
    this.scanner = scanner;
  }

  public static void main(String[] args) {
    GestionTiendaApp app = new GestionTiendaApp(new BaseDatosTiendaSQLite(RUTA_DB), new Scanner(System.in));
    app.run();

  }

  private void run() {
    int opcion = 0;
    do {
      //Creacion del menú
      System.out.println("Gestion Tienda Motocicleta");
      System.out.println("--------------------------");
      System.out.println("(0) - Salir");
      System.out.println("(1) - Crear Motocicleta");
      System.out.println("(2) - Registrar Venta");
      System.out.println("(3) - Listado de Ventas");
      System.out.println("(4) - Actualizar Cliente");
      System.out.println("(5) - Eliminar Cliente");
      System.out.println("Elija la opcion deseada");
      opcion = Integer.parseInt(scanner.nextLine());
      menu(opcion);
    } while (opcion != 0);
  }

  private static void menu(int opcion) {
    //Posibles interacciones del menú
    switch (opcion) {
    case 0:
      System.out.println("Hasta pronto");
      break;
    case 1:
      //Llamada al metodo privado que se encarga de dicha operacion
      anyadirMotocicleta();
      break;
    case 2:
      //Llamada al metodo privado que se encarga de dicha operacion
      registrarVentas();
      break;
    case 4:
      //Llamada al metodo privado que se encarga de dicha operacion
      actualizarCliente();
      break;
    case 5:
      //Llamada al metodo privado que se encarga de dicha operacion
      eliminarMotocicleta();
      break;
    default:
      throw new IllegalArgumentException("Unexpected value: " + opcion);
    }
  }

  private static void anyadirMotocicleta() {
    // Cabecera
    System.out.println();
    System.out.println("NUEVO DEPARTAMENTO");
    System.out.println("------------------");

    // Solicita la información de la nueva motocicleta
    System.out.print("Introduzca la referencia de la motocicleta: ");
    String referencia = scanner.nextLine();
    System.out.print("Introduzca la cilindrada de la motocicleta:");
    int cilindrada = Integer.parseInt(scanner.nextLine());
    System.out.print("Introduzca el tipo de la motocicleta: ");
    String tipo = scanner.nextLine();
    System.out.print("Introduzca el precio de la motocicleta");
    double precio = Double.parseDouble(scanner.nextLine());
    System.out.print("Introduzca el fabricante : ");
    String fabricante = scanner.nextLine();

    // Creamos el objeto motocicleta
    Motocicleta motocicleta = new Motocicleta(referencia, cilindrada, tipo, precio, fabricante);
    try {
      proveedorAlmacenamiento.anyadirMotocicleta(motocicleta);
    } catch (Exception e) {
      System.err.println("Ocurrió un error almacenando la motocicleta");
    }
  }

  private static void registrarVentas() {
    //Cabecera
    System.out.println();
    System.out.println("REGISTRAR VENTAS");
    System.out.println("-----------------");
    //Pido los datos para realizar el registro de ventas
    System.out.print("Introduzca el dni del Cliente: ");
    String dni = scanner.nextLine();
    System.out.println("Introduce la referencia de la moto");
    String referenciaMoto = scanner.nextLine();
    proveedorAlmacenamiento.registrarVenta(referenciaMoto, dni);

  }

  private static void actualizarCliente() {
    // Cabecera
    System.out.println();
    System.out.println("MODIFICAR Cliente");
    System.out.println("----------------------");

    // Solicita el código del departamento para recuperarlo
    System.out.print("Introduzca el dni del Cliente a modificar: ");
    String dni = scanner.nextLine();
    // Recupera el Cliente
    Cliente cliente = proveedorAlmacenamiento.getClienteByCodigo(dni);
    // Si se encontro
    if (cliente != null) {
      // Lo imprime
      System.out.println("Valores actuales del cliente con dni: " + dni);
      System.out.println(cliente.getNif());
      System.out.println(cliente.getNombre());
      System.out.println(cliente.getApellidos());
      System.out.println(cliente.getDireccion());
      System.out.println(cliente.getNif_recomendado());

      // Solicita la información del nuevo Cliente (excepto el dni)
      System.out.print(
          "Introduzca el nuevo nombre del cliente (vacio para mantener el actual \"" + cliente.getNombre() + "\"): ");
      String valor = scanner.nextLine();
      String nombreCliente = actualONuevo(valor, cliente.getNombre());
      System.out.print(
          "Introduzca el nuevo apellido del cliente (vacio para mantener el actual \"" + cliente.getNombre() + "\"): ");
      valor = scanner.nextLine();
      String apellidoCliente = actualONuevo(valor, cliente.getApellidos());
      System.out.print("Introduzca la nueva dirección del Cliente (vacio para mantener la actual \""
          + cliente.getDireccion() + "\"): ");
      valor = scanner.nextLine();
      String direccion = actualONuevo(valor, cliente.getDireccion());
      System.out.print(
          "Si el cliente ha sido recomendado por otro introduzca su dni. Si no deje este campo en blanco (el valor actual es \""
              + cliente.getNif_recomendado() + "\"): ");
      valor = scanner.nextLine();
      String nifRecomendado = actualONuevo(valor, cliente.getNif_recomendado());
      // Almacenamos los cambios
      try {
        proveedorAlmacenamiento.actualizarCliente(
            new Cliente(cliente.getNif(), nombreCliente, apellidoCliente, direccion, nifRecomendado));
      } catch (BaseDatosTiendaException e) {
        // Error
        System.err.println("No se pudieron almacenar los cambios.");
      }
    } else {
      System.err.println("No existe Cliente con ese nif. Abortando operacion");
    }
  }

  private static void eliminarMotocicleta() {
    // Cabecera
    System.out.println();
    System.out.println("ELIMINAR MOTOCICLETA");
    System.out.println("---------------------");

    // Solicita el código de la motocicleta para eliminar
    System.out.print("Introduzca el código del motocicleta a eliminar: ");
    String referencia = scanner.nextLine();
    // Recupera la motocicleta
    Motocicleta motocicleta = proveedorAlmacenamiento.getMotocicletaByCodigo(referencia);
    // Si se encontro
    if (motocicleta != null) {
      // Lo imprime
      System.out.println("Valores actuales de la motocicleta con referencia: " + referencia);
      System.out.println(motocicleta.getCilindrada());
      System.out.println(motocicleta.getTipo());
      System.out.println(motocicleta.getPrecio());
      System.out.println(motocicleta.getFabricante());

      // Solicita confirmación
      System.out.print("¿Está seguro de que desea eliminarlo (s/n)?: ");
      char respuesta = scanner.nextLine().toLowerCase().charAt(0);
      // Si es s (si)
      if (respuesta == 's') {
        try {
          proveedorAlmacenamiento.eliminacioMotocicleta(referencia);
        } catch (BaseDatosTiendaException e) {
          // Error
          System.err.println("No se pudo eliminar la motocicleta.");
          e.getMessage();
        }
      }
    } else {
      //En caso de que la motocicleta no exista salta este mensaje
      System.err.println("No existe motocicleta con esa referencia. Abortando operacion");
    }
  }

  private static String actualONuevo(String nuevo, String actual) {
    //Comprobacion para saber si el usuario quiere actualizar sus datos
    return nuevo.isEmpty() ? actual : nuevo;
  }
}
