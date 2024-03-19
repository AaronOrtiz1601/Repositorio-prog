package prog.unidad05.gestionclientes.core;

public class Clientes {
  // Atributos privados
  private ProveedorAlmacenamientoClientes proveedor;
  private Cliente[] clientes;

  /**
   * Constructor de la clase clientes
   * 
   * @param proveedorAlmacenamiento. Proveedor de almacenamiento a emplear para
   *                                 leer y escribir los clientes desde o hacia
   *                                 almacenamiento secundario
   * @throws NullPointerException. Si proveedorAlmacenamiento es null
   * @throws ClientesException.Si  hay algún error al acceder al almacenamiento
   */
  public Clientes(ProveedorAlmacenamientoClientes proveedorAlmacenamiento) {
    // Compruebo que el proveedor de almacenamiento no sea nulo y si lo es lanzo una
    // excepción
    if (proveedorAlmacenamiento == null) {
      throw new NullPointerException();
    }
    // Si la excepción no ha saltado, igualo el atributo proveedor con el objeto que
    // ha recibido el constructor
    this.proveedor = proveedorAlmacenamiento;

    // Captuto la posible excepción a la hora de optener los datos para trabajar con
    // ellos
    try {
      // Igualo el atributo clientes al atributo proveedor.getAll, el cual me devuelve
      // toda la información almacenada en el almacenamiento secundario

      this.clientes = this.proveedor.getAll();

    } catch (Exception e) {
      // En caso de capturar algunas exception, lanza la excepcion ClientesException
      throw new ClientesException();

    }
  }

  /**
   * Añade un nuevo cliente. El cliente se almacena en almacenamiento secundario inmediatamente
   * @param cliente.  Nuevo cliente a añadir. No puede ser null ni su NIF coincidir con el NIF de un cliente ya almacenado
   * @throws NullPointerException. Si cliente es null
   * @throws ClientesException. Si ya hay un cliente con el mismo NIF o hay problemas con el almacenamiento
   */

  public void addCliente(Cliente cliente) {
    // Compruebo si el cliente es nulo, si este es nulo lanzo la excepcion
    // NullPointerException
    if (cliente == null) {
      throw new NullPointerException();
    }

    // Usando el metodo getByNif compruebo si el cliente exite ya o no atraves de su
    // dni(no se puede repetir), en caso de que no exista añado el cliente que se me
    // ha pasado por este metodo
    if (getByNif(cliente.getNif()) == null) {
      // Creo un nuevo array con un espacio mas del que tenia el anterior
      Cliente[] nuevoArray = new Cliente[clientes.length + 1];
      // Hago una copia del array usando un bucle for
      for (int i = 0; i < clientes.length; i++) {
        nuevoArray[i] = clientes[i];
      }
      // En la posición extra añado al nuevo cliente
      nuevoArray[clientes.length] = cliente;
      // Guardo los clientes en proveedor para que este lo almacene en el
      // almacenamiento secundario
      clientes = nuevoArray;
      proveedor.saveAll(clientes);

      // Si ya existe un cliente con el dni del cliente que nos han pasado, lanzo la
      // excepción ClientesExceptión
    } else {
      throw new ClientesException();
    }
  }
  /**
   * Actualiza un  cliente. El cliente se actulizara en almacenamiento secundario inmediatamente
   * @param cliente.  cliente a actualizar. No puede ser null ni su NIF coincidir con el NIF de un cliente ya almacenado
   * @throws NullPointerException. Si cliente es null
   * @throws ClientesException. Si ya hay un cliente con el mismo NIF o hay problemas con el almacenamiento
   */
  public void updateCliente(Cliente cliente) {
    // Compruebo si el cliente es nulo, si este es nulo lanzo la excepcion
    // NullPointerException
    if (cliente == null) {
      throw new NullPointerException();
    }

    // Compruebo si existe un cliente con el dni del cliente recibido, si el cliente
    // no existe lanzo la excepción de clientes

    if (getByNif(cliente.getNif()) == null) {
      throw new ClientesException();
    } else {
      // Si el usuario existe creo una lista nueva con la misma longitud

      Cliente[] nuevoArray = new Cliente[clientes.length];
      // copio todos los datos del atributo clientes cambiando unicamente el cliente
      // de la lista que su nif coincida con el del clinte recibido para el metodo
      for (int i = 0; i < clientes.length; i++) {
        if (cliente.getNif().equals(clientes[i].getNif())) {
          nuevoArray[i] = cliente;
        } else {
          nuevoArray[i] = clientes[i];
        }
      }
      // Almaceno la nueva lista en clientes y clientes en el proveedor para que pase
      // la información al almacenamiento secundario
      clientes = nuevoArray;
      proveedor.saveAll(clientes);
    }
  }
  /**
   * Elimina un cliente del almacén. El cliente se eliminará inmediatamente del almacenamiento secundario
   * @param nif. NIF del cliente a eliminar
   * @throws NullPointerException. Si cliente es null
   * @throws ClientesException. Si ya hay un cliente con el mismo NIF o hay problemas con el almacenamiento
   */
  public void removeCliente(String nif) {
    // Compruebo si el cliente es nulo, si este es nulo lanzo la excepcion
    // NullPointerException
    if (nif == null) {
      throw new NullPointerException();
    }
    // Compruebo si existe un cliente con el dni del cliente recibido, si el cliente
    // no existe lanzo la excepción de clientes
    if (getByNif(nif) == null) {
      throw new ClientesException();
    } else {
      // Creo un array con una longitud del atributo clientes - 1
      Cliente[] nuevoArray = new Cliente[clientes.length - 1];
      int j = 0;
      // Empiezo a copiar los datos de clientes al nuevo array y cuando el dni del
      // cliente del array clientes coincida con el dni recibido para el metodo no se
      // copiara ese cliente en la nueva lista
      for (int i = 0; i < clientes.length; i++) {
        if (!clientes[i].getNif().equals(nif)) {
          nuevoArray[j] = clientes[i];
          j++;
        }
      }
      // Almaceno el nuevo array en el atributo clientes y este en proveedor para que
      // se lo pase al almacenamiento secundario
      clientes = nuevoArray;
      proveedor.saveAll(clientes);
    }
  }
  /**
   * Obtiene un cliente por su nif
   * @param nif. NIF del cliente
   * @return Cliente con el NIF especificado, si se encuentra. null si no se encuentra
   */
  public Cliente getByNif(String nif) {
    // Creo una bandera y un cliente para almacenar al cliente buscado
    boolean prueba = false;
    Cliente clienteEncontrado = null;
    // Recorro el array de clientes
    for (int i = 0; i < clientes.length; i++) {
      // Compruebo si el dni que buscamos coincide con el dni de los clientes ya
      // existentes, si es asi almaceno el cliente y hago que la bandera sea verdadera
      if (nif.equals(clientes[i].getNif())) {
        clienteEncontrado = clientes[i];
        prueba = true;
      }
    }

    // Si la banderera es verdadera devuelvo el cliente y si no lo es devuelvo null
    if (prueba) {
      return clienteEncontrado;
    } else {
      return null;
    }

  }
  /**
   * Proporciona un visitador para recorrer los clientes almacenados
   * @param visitador. Visitador al que se llamará con cada uno de los clientes almacenados. No puede ser null
   * @throws NullPointerException. Si el visitador es nulo
   */
  public void visita(VisitadorClientes visitador) {
    // Si el visitador es null lanzo la excepcion NullPointerException
    if (visitador == null) {
      throw new NullPointerException();
    }
    // Recorro la lista de clientes y por cada cliente activo una vez el visitador

    for (Cliente cliente : clientes) {
      visitador.visita(cliente);
    }
  }
}
