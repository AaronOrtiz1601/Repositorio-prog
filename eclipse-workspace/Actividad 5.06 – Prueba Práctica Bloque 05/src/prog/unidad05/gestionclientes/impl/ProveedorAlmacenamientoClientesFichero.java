package prog.unidad05.gestionclientes.impl;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import prog.unidad05.gestionclientes.core.Cliente;
import prog.unidad05.gestionclientes.core.ProveedorAlmacenamientoClientes;
import prog.unidad05.gestionclientes.core.ProveedorAlmacenamientoClientesException;

/**
 * Proveedor de almacenamiento de clientes que almacena los datos de los
 * clientes en un fichero en disco. Si el fichero no existe se crea la primera
 * vez que se guarde y devuelve una colección vacía de clientes al leer.
 */
public class ProveedorAlmacenamientoClientesFichero implements ProveedorAlmacenamientoClientes {
  // Ruta del fichero
  private String rutaFichero;

  /**
   * Constructor de la clase ProveedorAlmacenamientoClientesFichero con ruta
   * 
   * @param rutaFichero. Ruta al fichero a emplear para leer y almacenar los clientes
   * @throws NullPointerException. Si la ruta es nula
   * @throws IOException.          Si da un error la creacion del fichero
   */
  public ProveedorAlmacenamientoClientesFichero(String rutaFichero) {
    // Compruebo que la ruta del fichero no sea nula, si lo es lanzo una excepción
    if (rutaFichero == null) {
      throw new NullPointerException("La ruta del fichero no puede ser nula.");
    }
    // Igualo el atributo a la ruta recibida
    this.rutaFichero = rutaFichero;
    // Creo un objeto de la clase path que prueba si el fichero esta existe o no, si
    // no existe , lo creo
    Path comprueba = Path.of(this.rutaFichero);
    if (!Files.exists(comprueba)) {
      try {
        Files.createFile(comprueba);
        // Si hubiera un error en la creacion del fichero lanzo una excepción
      } catch (IOException e) {
        System.out.println("No se pudo crear el archivo en la ruta especificada: " + rutaFichero);

      }
    }
  }

  /**
   * Obtiene todos los clientes almacenados
   * 
   * @return Array de Cliente con todos los clientes. Puede estar vacío si aún no hay clientes
   * @throws ProveedorAlmacenamientoClientesException. Si ocurre algún error accediendo al  almacenamiento
   */
  @Override
  public Cliente[] getAll() {
    // Pongo un try catch por si hubiera algun problema en la lectura del fichero
    try (DataInputStream flujoEntrada = new DataInputStream(new FileInputStream(rutaFichero))) {
      // Compruebo si el fichero esta vacio, si lo esta devuelvo un cliente vacio para
      // que no me de error
      if (flujoEntrada.available() == 0) {
        return new Cliente[0];
      }
      // Leo el fichero y voy almacenando los datos del cliente
      int numObjetos = flujoEntrada.readInt();
      Cliente[] clientes = new Cliente[numObjetos];
      for (int i = 0; i < numObjetos; i++) {
        String nombre = flujoEntrada.readUTF();
        String apellidos = flujoEntrada.readUTF();
        String dni = flujoEntrada.readUTF();
        int empleados = flujoEntrada.readInt();
        double facturacion = flujoEntrada.readDouble();
        boolean nacionalUe = flujoEntrada.readBoolean();
        // Uso los datos del cliente que he sacado del fichero y con ellos creo un nuevo
        // cliente
        Cliente cliente = new Cliente(dni, apellidos, nombre, empleados, facturacion, nacionalUe);
        // Este cliente lo guardo, es un array de la clase cliente
        clientes[i] = cliente;
      }
      // Devuelvo el array de la clase cliente
      return clientes;
      // Lanzo la excepcion en caso de error
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoClientesException();

    }

  }

  /**
   * Almacena todos los clientes en almacenamiento secundario Los clientes
   * previamente existentes se sustituyen por los que se proporcionan aqui
   * 
   * @param clientes. Clientes a almacenar. Puede ser vacío pero no null
   * @throws NullPointerException.                     Si clientes es null
   * @throws ProveedorAlmacenamientoClientesException. Si ocurre algún error accediendo al almacenamiento
   */

  @Override
  public void saveAll(Cliente[] clientes) {
    // Compruebo que el array de clientes no sea null, si lo es lanzo una excepción
    if (clientes == null) {
      throw new NullPointerException();
    }
    // Uso un try catch para capturar una excepcion en caso de error, empiezo a escribir los datos del array clientes en el fichero
    try (DataOutputStream flujoSalida = new DataOutputStream(new FileOutputStream(rutaFichero))) {
      // El fichero tendra tantas entradas como largo sea el array
      flujoSalida.writeInt(clientes.length);
      // Empiezo a sacar los datos del array y los voy escribiendo a la vez en el fichero
      for (int i = 0; i < clientes.length; i++) {
        flujoSalida.writeUTF(clientes[i].getNombre());
        flujoSalida.writeUTF(clientes[i].getApellidos());
        flujoSalida.writeUTF(clientes[i].getNif());
        flujoSalida.writeInt(clientes[i].getEmpleados());
        flujoSalida.writeDouble(clientes[i].getFacturacion());
        flujoSalida.writeBoolean(clientes[i].isNacionalUe());
      }
      // Devuelve una excepcion en caso de error
    } catch (Exception e) {
      throw new ProveedorAlmacenamientoClientesException();
    }
  }
}
