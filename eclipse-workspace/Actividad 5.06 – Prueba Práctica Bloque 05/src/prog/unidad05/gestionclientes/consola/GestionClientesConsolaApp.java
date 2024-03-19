package prog.unidad05.gestionclientes.consola;

import java.util.Scanner;

import prog.unidad05.gestionclientes.core.Cliente;
import prog.unidad05.gestionclientes.core.Clientes;
import prog.unidad05.gestionclientes.core.ClientesException;
import prog.unidad05.gestionclientes.impl.ProveedorAlmacenamientoClientesFichero;

public class GestionClientesConsolaApp {
  //Declaro los atrivutos privados
  private static Scanner sc;
  private static ProveedorAlmacenamientoClientesFichero proveedor = new ProveedorAlmacenamientoClientesFichero("clientes.dat");
  private static Clientes clientes = new Clientes(proveedor);

  public static void main(String[] args) {
    //Inicio el scanner
    sc = new Scanner(System.in);
    //Creo una bandera para determinar si queremos acabar ya el programa o no
    boolean prueba = false;
    //Creo la variable que nos servira que opcion del menu queremos usar
    int opcion;
    //Inicio el proveedor y el visitador
    ProveedorAlmacenamientoClientesFichero proveedor = new ProveedorAlmacenamientoClientesFichero("clientes.dat");
    VisitadorClientesTexto visitador = new VisitadorClientesTexto();
    //Empieza el menu
    do {
      //Muestro las opciones del menu
      System.out.println("MENU PRINCIPAL");
      System.out.println("--------------");
      System.out.printf("0) Salir del programa%n");
      System.out.printf("1) Listar clientes%n");
      System.out.printf("2) Nuevo cliente%n");
      System.out.printf("3) Actualizar cliente%n");
      System.out.printf("4) Eliminar cliente%n");

      System.out.print("Introduzca la opción seleccionada (0-4):");
      opcion = Integer.parseInt(sc.nextLine());
      switch (opcion) {
      //Elegimos la opcion 0 el programa se acaba por que le doy a la bandera el valor true
      case 0:
        prueba = true;
        System.out.println("Hasta pronto");
        break;
        //Si elegimos la opcion 1 se muestra todos los clientes
      case 1:
        //Llamada al visitador, este recorre la lista mostrando la informacion que nos interesa de cada cliente
        clientes.visita(visitador);
        break;
        //Si elegimos la opcion 2 añadimos un nuevo cliente
      case 2:
        //Uso un try catch para preveenir errores
        try {
          //Llamo al metodo priavado anyadirClientes
          clientes.addCliente(anyadirClientes());
          System.out.println("Operación realizada con exito");

        } catch (Exception e) {
          //Muestro el siguiente mensaje de error
          System.out.println(" Ha habido un error a la hora de intentar añadir el cliente, porfavor pruebe a volver a introducir los datos de este");
        }
        break;
        //Si elegimos la opcion 3 actualizamos un cliente
      case 3:
      //Uso un try catch para preveenir errores
        try {
          //actualizo el cliente usando el metodo privado actualizarClientes
          clientes.updateCliente(actualizarClientes());
          System.out.println("Operación realizada con exito");
        } catch (Exception e) {
        //Muestro el siguiente mensaje de error
          System.out.println( "Ha habido un error a la hora de intentar actualizar el cliente, porfavor pruebe a volver a introducir los datos ");
        }
        break;
      case 4:
      //Uso un try catch para preveenir errores
        try {
        //borro el cliente usando el metodo privado eliminarCliente
          clientes.removeCliente(eliminarCliente());
          System.out.println("Operación realizada con exito");
        }

        catch (Exception e) {
        //Muestro el siguiente mensaje de error
          System.out.println( "Ha habido un error al intentar borrar el cliente, por favor pruebe a volver a introducir los datos");
        }
        break;
        //En caso de que la variable opcion no este dentro de lo establecido
      default:
        //Mensaje de error
        System.out.println("Ese valor no es valido");
      }
      //Se repetira hasta que prueba no sea true
    } while (!prueba);

  }
  //Metodo privado para añadir clientes
  private static Cliente anyadirClientes() {
    //Pido los datos para crear el cliente
    System.out.println("NUEVO CLIENTE");
    System.out.println("-------------");
    System.out.println("Introdduzca los datos del nuevo cliente");
    System.out.println("NIF (8 números y la letra correspondiente en mayúsculas):");
    String nif = sc.nextLine();
    System.out.print("Nombre (La letra inicial de cada palabra en mayúsculas): : ");
    String nombre = sc.nextLine();
    System.out.print("Apellidos (Igual que el nombre):");
    String apellidos = sc.nextLine();
    System.out.print("Número de empleados (entero mayor que cero):");
    int empleados = Integer.parseInt(sc.nextLine());
    System.out.print("Facturación (valor real superior a cero):");
    double facturacion = Double.parseDouble(sc.nextLine());
    System.out.println("¿Es nacional de un país de la UE?(s/n)");
    String nacional = sc.nextLine();
    //Compruebo que la nacionalidad sea correcta(s/n)
    boolean nacionalADevolver;
    if (nacional.equals("s")) {
      nacionalADevolver = true;
    } else if (nacional.equals("n")) {
      nacionalADevolver = false;
    } else {
      nacionalADevolver = (Boolean) null;
    }
    //Creo el cliente, y lo devuelvo
    Cliente cliente = new Cliente(nif, apellidos, nombre, empleados, facturacion, nacionalADevolver);
    return cliente;

  }
  //Metodo privado para actualizar un cliente
  private static Cliente actualizarClientes() {
    //Pido el dni del cliente a actualizar, despues de eso pido los datos nuevos para el cliente
    System.out.println("ACTUALIZAR CLIENTE");
    System.out.println("------------------");
    System.out.println("Introduzca el dni del cliente a modificar");
    String nif = sc.nextLine();
    String clienteAModificarDni = clientes.getByNif(nif).getNif();
    System.out.print("Nombre (La letra inicial de cada palabra en mayúsculas, en blanco para mantener el nombre anterior):");
    String nombre = sc.nextLine();
    //Compruebo que los datos introducidos esten en blanco o no, en caso de que sea asi dejo el dato que estaba antes de actualizar el cliente
    if (nombre.isBlank()) {
      nombre = clientes.getByNif(clienteAModificarDni).getNombre();
    }
    System.out.print("Apellidos (Igual que el nombre , en blanco para mantener el nombre anterior):");
    String apellidos = sc.nextLine();
    if (apellidos.isBlank()) {
      apellidos = clientes.getByNif(clienteAModificarDni).getApellidos();
    }
    System.out.print("Número de empleados (entero mayor que cero, en blanco para mantener el nombre anterior):");
    String empleados = sc.nextLine();
    int empleadosNum;
    if (empleados.isBlank()) {
      empleadosNum = clientes.getByNif(clienteAModificarDni).getEmpleados();
    } else {
      empleadosNum = Integer.parseInt(empleados);
    }
    System.out.print("Facturación (valor real superior a cero, en blanco para mantener el nombre anterior):");
    String facturacion = sc.nextLine();
    double facturacionNum;
    if (facturacion.isBlank()) {
      facturacionNum = clientes.getByNif(clienteAModificarDni).getFacturacion();
    } else {
      facturacionNum = Integer.parseInt(facturacion);
    }
    System.out.println("¿Es nacional de un país de la UE?(s/n, en blanco para mantener el nombre anterior)");
    String nacional = sc.nextLine();
    //Lo mismo que al crear el cliente
    boolean nacionalADevolver;
    if (nacional.equals("s")) {
      nacionalADevolver = true;
    } else if (nacional.equals("n")) {
      nacionalADevolver = false;
    } else if (nacional.isBlank()) {
      nacionalADevolver = clientes.getByNif(clienteAModificarDni).isNacionalUe();
    } else {
      nacionalADevolver = (Boolean) null;
    }
    //Creo un cliente con los datos actualizados y lo devuelvo
    Cliente cliente = new Cliente(nif, apellidos, nombre, empleadosNum, facturacionNum, nacionalADevolver);
    return cliente;

  }
  
  
  //Metodo privado para eliminar un cliente
  private static String eliminarCliente() {
    //Pido el dni del cliente a borrar y lo devuelvo
    System.out.println("ELIMINAR CLIENTE");
    System.out.println("----------------");
    System.out.println("Introduzca el dni del cliente a eliminar");
    String nif = sc.nextLine();

    return nif;
  }
}
