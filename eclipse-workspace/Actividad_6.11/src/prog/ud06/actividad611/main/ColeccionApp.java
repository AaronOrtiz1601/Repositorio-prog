package prog.ud06.actividad611.main;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
import prog.ud06.actividad611.coleccion.Cliente;
import prog.ud06.actividad611.coleccion.ProveedorUsuariosException;
import prog.ud06.actividad611.coleccion.TarjetaClaves;
import prog.ud06.actividad611.coleccion.Usuario;
import prog.ud06.actividad611.coleccion.Usuarios;
import prog.ud06.actividad611.proveedores.ProveedorUsuariosArchivoXML;

/**
 * Programa principal
 */
public class ColeccionApp {
  // Constantes
  // Archivo XML con los datos
  private static final String ARCHIVO = "biblioteca.xml";
  // Opción salir del programa
  private static final int OPCION_SALIR = 0;
  // Opción Listar libros
  private static final int OPCION_LISTAR = 1;
  // Opción Buscar por titulo
  private static final int OPCION_BUSCAR_NOMBRE = 2;
  // Opcion Buscar por autor
  private static final int OPCION_BUSCAR_APELLIDOS = 3;
  // Opción Buscar por año de publicación
  private static final int OPCION_BUSCAR_DNI = 4;
  // Opción Buscar por año de publicación
  private static final int OPCION_BUSCAR_EDAD = 5;
  // Opciones minima y maxima (para comprobar los rangos)
  private static final int OPCION_MINIMA = OPCION_SALIR;
  private static final int OPCION_MAXIMA = OPCION_BUSCAR_EDAD;
  
  // Atributos
  // Contenedor de usuarios
  private Usuarios usuarios;
  // Scanner para leer desde teclado
  private Scanner sc;
  // Usuario autenticado
  Usuario usuario;

  /**
   * Constructor del objeto<br>
   * Recibe un contenedor de usuarios y crea el scanner para acceder al teclado
   * @param usuarios Contenedor de usuarios
   */
  public ColeccionApp(Usuarios usuarios) {
    this.usuarios = usuarios;
    sc = new Scanner(System.in);
    usuario = null;
  }

  /**
   * Main. Punto de entrada de la aplicación
   * @param args Argumentos de la línea de comandos
   */
  public static void main(String[] args) {
    
    // Obtenemos los usuarios
    try {
      Usuarios usuarios = new ProveedorUsuariosArchivoXML(ARCHIVO).obtieneUsuarios();
      // Creamos un objeto de la clase
      ColeccionApp app = new ColeccionApp(usuarios);
      // Y lanzamos el interfaz
      app.run();
      
    } catch (ProveedorUsuariosException e) {
      // Si no se puede obtener la información de usuarios y libros terminamos
      System.out.println("Error. No se puede acceder al archivo XML. Terminando");
    }
  }

  /**
   * Método principal del interfaz
   */
  private void run() {
    // Lo primero es autenticar al usuario
    usuario = autenticarUsuario();
    // Si se pudo hacer
    if (usuario != null) {
      // Muestra el menú repetidamente hasta que se elija la opción Salir
      int opcionElegida = OPCION_SALIR;
      do {
        // Muestra el menú y obtiene una elección
        opcionElegida = mostrarMenu();
        // Según la opción elegida
        switch (opcionElegida) {
          case OPCION_LISTAR:
            comandoListarClientes();
            break;
          case OPCION_BUSCAR_NOMBRE:
            comandoBuscarNombre();
            break;
          case OPCION_BUSCAR_APELLIDOS:
            comandoBuscarApellidos();
            break;
          case OPCION_BUSCAR_DNI:
            comandoBuscarDni();
            break;
          case OPCION_BUSCAR_EDAD:
            comandoBuscarEdad();
            break;
          case OPCION_SALIR:
            break;
          default:
            // No se debe llegar aqui
            System.out.println("Error. Opción incorrecta.");
        }
      } while (opcionElegida != OPCION_SALIR);
    } else {
      // No se pudo autenticar al usuario. Termina
      System.out.println("Error de autenticación. Terminando programa");
    }
  }

  /**
   * Autentifica al usuario
   * @return Usuario si la autenticación tuvo éxito. null si no lo tuvo
   */
  private Usuario autenticarUsuario() {
    // Solicitamos el nombre del usuario
    System.out.println("Autenticación");
    System.out.print("Introduzca el nombre de usuario: ");
    String nombreUsuario = sc.nextLine();
    // Accede al usuario en el contenedor
    Usuario usuario = usuarios.getUsuarioPorNombreUsuario(nombreUsuario);
    // Si no es null
    if (usuario != null) {
      // Accedemos a la tarjeta
      TarjetaClaves tarjeta = usuario.getTarjeta();
      // Obtenemos el número de filas y columnas de la tarjeta
      int filas = tarjeta.getFilas();
      int columnas = tarjeta.getColumnas();
      
      // Obtenemos un valor aleatorio de fila y columna
      Random random = new Random();
      int fila = random.nextInt(1, filas + 1);
      int columna = random.nextInt(1, columnas + 1);
      
      // Lo mostramos al usuario
      System.out.print("Introduzca la clave en las coordenadas (" + fila + ", " + columna + "): ");
      int clave = 1000;
      try {
        clave = Integer.parseInt(sc.nextLine());
      } catch (NumberFormatException e) {
        // Autenticación incorrecta. terminamos
        System.out.println("Autenticación incorrecta");
        return null;
      }
      // Si el usuario autentica correctamente
      if (tarjeta.validarClave(fila, columna, clave)) {
        // Mostramos un mensaje y devolvemos el usuario
        System.out.println("Autenticación correcta.");
        return usuario;
      } else {
        // Autenticación incorrecta
        System.out.println("Autenticación incorrecta");
        return null;
      }
    } else {
      // Usuario no encontrado
      System.out.println("Autenticación incorrecta");
      return null;
    }
  }

  /**
   * Muestra el menú y elige la opción
   * @return Opción elegida. Se comprueba que es correcta y está en rango
   */
  private int mostrarMenu() {
    // Inicializamos la opción elegida a un valor invalido
    int opcion = OPCION_MINIMA - 1;
    // Mientras no se elija una opción correcta
    for (;;) {
      // Mostramos el menu
      System.out.println();
      System.out.println("MENU PRINCIPAL");
      System.out.println("--------------");
      System.out.println("1. Listar clientes");
      System.out.println("2. Buscar clientes por nombre de pila");
      System.out.println("3. Buscar clientes por apellidos");
      System.out.println("4. Buscar clientes por DNI");
      System.out.println("5. Buscar clientes por edad");
      System.out.println("0. Salir del programa");
      System.out.print("Elija una opción (" + OPCION_MINIMA + "-" + OPCION_MAXIMA + "): ");
      try {
        opcion = Integer.parseInt(sc.nextLine());
        // Si la opción está en rango se devuelve. Si no se muestra error y se da otra vuelta
        if (opcion >= OPCION_MINIMA && opcion <= OPCION_MAXIMA) {
          return opcion;
        } else {
          System.out.println("Opción elegida incorrecta. Debe introducir un número"
            + " comprendido entre " + OPCION_MINIMA + " y " + OPCION_MAXIMA);
        }
      } catch (NumberFormatException e) {
        System.out.println("Opción elegida incorrecta. Debe introducir un número"
            + " comprendido entre " + OPCION_MINIMA + " y " + OPCION_MAXIMA);
      }
    }
  }

  /**
   * Lista los clientes del usuario
   */
  private void comandoListarClientes() {
    System.out.println("Los clientes del usuario son:");
    usuario.getClientes().sort(null);
    for(int i = 0;i < usuario.getClientes().size() ; i++)
    {
      System.out.println(usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
      
    }
    
  }

  /**
   * Busca los clientes del usuario cuyo nombre de pila contiene un texto determinado
   */
  private void comandoBuscarNombre() {
    // TODO
    //Declaracion de variables
    char nombre;
    String nombreABuscar;
    //Pido una de las dos opciones (c o p) 
    System.out.println("¿Buscar por nombre completo o parte del nombre? (c=nombre completo, p=parte del nombre):");
    nombre = sc.nextLine().charAt(0);
    //Si elige c se busca el nombre completo 
    if (nombre == 'c')
    {
      System.out.println("Introduzca el texto a buscar en el nombre del cliente:");
      nombreABuscar = sc.nextLine();
      int contador =0;
      for(int i = 0;i < usuario.getClientes().size();i++)
      {
        if(nombreABuscar.equals(usuario.getClientes().get(i).getNombre()))
        {
          if (contador == 0)
          {
            System.out.println("Los clientes del usuario que contienen '" + nombreABuscar + "' en el nombre de pila son:");
          contador++;
          }
          System.out.println(usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
        }
      }
      //Si elige p se busca solo parte del nombre 
    }else if ( nombre == 'p')
    {
      System.out.println("Introduzca el texto a buscar en el nombre del cliente:");
      nombreABuscar = sc.nextLine();
      int contador =0;
      for(int i = 0;i < usuario.getClientes().size();i++)
      {
        if(usuario.getClientes().get(i).getNombre().contains(nombreABuscar))
        {
          if (contador == 0)
          {
            System.out.println("Los clientes del usuario que contienen '" + nombreABuscar + "' en el nombre de pila son:");
          contador++;
          }
          System.out.println(usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
        }
      }
    }else {
      System.out.println("La opción elegida no es válida. Debe ser una de c, p");
      
    }
  }

  /**
   * Busca los clientes del usuario cuyos apellidos contienen un texto determinado
   */
  private void comandoBuscarApellidos() {
    // TODO
    //Este metodo funciona igual que el buscar nombre, asi que la explicación seria la misma
    char nombre;
    String nombreABuscar;
    System.out.println("¿Buscar por nombre completo o parte del nombre? (c=nombre completo, p=parte del nombre):");
    nombre = sc.nextLine().charAt(0);
    if (nombre == 'c')
    {
      System.out.println("Introduzca el texto a buscar en el nombre del cliente:");
      nombreABuscar = sc.nextLine();
      int contador =0;
      for(int i = 0;i < usuario.getClientes().size();i++)
      {
        if(nombreABuscar.equals(usuario.getClientes().get(i).getApellidos()))
        {
          if (contador == 0)
          {
            System.out.println("Los clientes del usuario que contienen '" + nombreABuscar + "' en el nombre de pila son:");
          contador++;
          }
          System.out.println(usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
        }
      }
    }else if ( nombre == 'p')
    {
      System.out.println("Introduzca el texto a buscar en el nombre del cliente:");
      nombreABuscar = sc.nextLine();
      int contador =0;
      for(int i = 0;i < usuario.getClientes().size();i++)
      {
        
        if(usuario.getClientes().get(i).getApellidos().contains(nombreABuscar))
        {
          if (contador == 0)
          {
            System.out.println("Los clientes del usuario que contienen '" + nombreABuscar + "' en el nombre de pila son:");
          contador++;
          }
          System.out.println(usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
        }
      }
    }else {
      System.out.println("La opción elegida no es válida. Debe ser una de c, p");
      
    }
  }

  /**
   * Busca los clientes del usuario cuyos DNI es el proporcionado
   */
  private void comandoBuscarDni() {
    // TODO
    //Declaración de variables 
    String dniABuscar; 
    //Pido un Dni y busco si hay algún cliente que lo tenga
    System.out.print("Introduzca el DNI a buscar (DNI completo):");
    dniABuscar = sc.nextLine();
    int encontrado = 0;
    for(int i = 0;i < usuario.getClientes().size();i++)
    {
    if (dniABuscar.equals(usuario.getClientes().get(i).getDni()))
    {
    System.out.println("El cliente con el dni " + dniABuscar + " es " + usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
    }else if(encontrado == 2){
      System.out.println("El cliente con dni " + dniABuscar + " no ha sido encontrado");
    }
    encontrado++;
    }
  }

  /**
   * Busca los clientes del usuario por su edad
   */
  private void comandoBuscarEdad() {
    // TODO
    //Declaración de variables 
    String edadABuscar;
    String edadABuscar2;
    int edad;
    //Pido una edad para comprobar en la busqueda que los clientes tienen mas edad que esta
    System.out.println("¿Buscar clientes cuya edad sea mayor o igual a? (vacío para cualquiera):");
    edadABuscar2 = sc.nextLine();
  //Pido una edad para comprobar en la busqueda que los clientes tienen menos edad que esta
    System.out.println("¿Buscar clientes cuya edad sea menor o igual a? (vacío para cualquiera):");
    edadABuscar = sc.nextLine();
    //Muestra los clientes encontrados
    System.out.println("Los clientes encontrados son:");
    for(int i = 0 ; i < usuario.getClientes().size();i++)
    {
      //Si no se ha introducido la edad se lista a todos los clientes
      if (edadABuscar.equals("") && edadABuscar2.equals("")) {
        System.out.println(usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
      //Si la edad minima para el rango de edad no ha sido introducida se trabaja cumpliendo solo la condición que impone la maxima
      } else if (edadABuscar2.equals(""))
      {
        edad = Integer.parseInt(edadABuscar);
        if (usuario.getClientes().get(i).getEdad() <= edad )
        {
          System.out.println(usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
        }
      //Si la edad maxima para el rango de edad no ha sido introducida se trabaja cumpliendo solo la condición que impone la minima
      }else if (edadABuscar.equals(""))
      {
        edad = Integer.parseInt(edadABuscar2);
        if (usuario.getClientes().get(i).getEdad() >= edad )
        {
          System.out.println(usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
        }
        //Si se han introducido las dos mostramos solo los clientes que estan dentro del rango de edad
      }else {
        edad = Integer.parseInt(edadABuscar);
        int edad2 = Integer.parseInt(edadABuscar2);
        if(usuario.getClientes().get(i).getEdad() >= edad2 && usuario.getClientes().get(i).getEdad() <= edad  )
        {
          System.out.println(usuario.getClientes().get(i).getApellidos() + ", " + usuario.getClientes().get(i).getNombre() + ", " + usuario.getClientes().get(i).getDni()+ ", " + usuario.getClientes().get(i).getEdad());
        }
      }
    }
  }
}
