package conversiones;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.EOFException;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class biblioteca {
  private String nombreMetodo;
  private logFinal registro = new logFinal();

  /**
   * Metodo que convierte un archivo csv en un archivo .dat, pasandole tambien su
   * contenido
   * 
   * @param archivo
   */

  public String fichero_CSV_To_Binario(String archivo) {

    nombreMetodo = "fichero_CSV_To_Binario";
    // Declaracion de la variable necesaria para el fichero dat
    String archivo2 = archivo;
    // Creo un array de caracteres para almacenar el nombre del fichero separandolo
    // de su extension
    String[] separador = archivo2.split("\\.");
    // Añadimos la extension .dat a la parte previamente separada del nombre
    archivo2 = separador[0] + ".dat";
    // Leemos el fichero
    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
      String linea;
      // Y escribimos en el nuevo la informacion
      try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivo2))) {
        while ((linea = reader.readLine()) != null) {
          escritor.writeObject(linea);
        }
        registro.escribeLog(nombreMetodo, archivo, archivo2);
        System.out.println("Archivo creado correctamente: " + archivo);
      } catch (IOException e) {
        System.err.println("Error al escribir en el archivo: " + e.getMessage());
      }

    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    }
    return archivo2;

  }

  public String fichero_Binario_To_Csv(String archivo) {
    nombreMetodo = "fichero_Binario_To_Csv";
 // Cambiamos la extensión a .csv
    String archivo2 = archivo.split("\\.")[0] + ".csv"; 

    try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(archivo));
        BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo2))) {

      String linea;
      try {
     // Bucle infinito que se interrumpe con EOFException
        while (true) { 
       // Leer objeto del archivo binario
          linea = (String) reader.readObject(); 
       // Escribir la línea en el archivo CSV
          escritor.write(linea); 
          escritor.newLine();
        }
      } catch (EOFException e) {
        // Fin del archivo, esto es esperado
        System.out.println("Fin del archivo binario alcanzado.");
      } catch (ClassNotFoundException e) {
        System.err.println("Error al convertir objeto: " + e.getMessage());
      }

      System.out.println("Archivo CSV creado correctamente: " + archivo2);
      registro.escribeLog(nombreMetodo, archivo, archivo2);

    } catch (IOException e) {
      System.err.println("Error al procesar el archivo: " + e.getMessage());
    }

    return archivo2;
  }

  /**
   * Metodo que recive un archivo de texto y crea uno nuevo con las lineas del
   * anterior ordenadas
   * 
   * @param archivo
   */
  public String ordenar_Archivo_CSV(String archivo) {

    return ordenaCsv(archivo, nombreMetodo);

  }

  /**
   * Lo mismo que el metodo anterior pero para ficheros binarios
   * 
   * @param archivo
   */
  public String ordenar_Archivo_Binario(String archivo) {
    nombreMetodo = "ordenar_Archivo_Binario";
    // Repetimos el mismo proceso con las variables
    String archivo2 = null;
    List<String> ordenar = new ArrayList<String>();
    // Empezamos a leer el fichero
    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
      String linea;
      // Creo un array de caracteres para almacenar el nombre del fichero separandolo
      // de su extension
      String[] separador = archivo.split("\\.");
      // Añadimos la extension .dat a la parte previamente separada del nombre
      archivo2 = separador[0] + "_ord.dat";
      registro.escribeLog(nombreMetodo, archivo, archivo2);
      // Empezamos el proceso para escribir en el nuevo fichero
      try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivo2))) {
        while ((linea = reader.readLine()) != null) {
          // Añadimos las lineas a la lista que se creo antes
          ordenar.add(linea);
        }
        // Ordenamos la lista y escrimos todo ordenado todo en el fichero
        Collections.sort(ordenar);
        for (int i = 0; i < ordenar.size(); i++) {
          escritor.writeObject(ordenar.get(i));
        }
        System.out.println("Archivo creado correctamente: " + archivo);
      } catch (IOException e) {
        System.err.println("Error al escribir en el archivo: " + e.getMessage());
      }
    } catch (FileNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    return archivo2;

  }

  public String fichero_Binario_To_CSV_Ordenado(String archivo) {
    // Cambiar la extensión a .csv y el sufijo a _ord
    String archivo2 = archivo.split("\\.")[0] + "_ord.csv";

    List<String> lineas = new ArrayList<>();

    // Leer el archivo binario
    try (ObjectInputStream reader = new ObjectInputStream(new FileInputStream(archivo))) {
      String linea;

      // Leer todas las líneas del archivo binario y almacenarlas en una lista
      try {
        while (true) { // Bucle infinito que se interrumpe con EOFException
          linea = (String) reader.readObject();
          lineas.add(linea);
        }
      } catch (EOFException e) {
        // Fin del archivo, es lo esperado
        System.out.println("Fin del archivo binario alcanzado.");
      } catch (ClassNotFoundException e) {
        System.err.println("Error al convertir objeto: " + e.getMessage());
      }

      // Ordenar las líneas alfabéticamente
      Collections.sort(lineas, String.CASE_INSENSITIVE_ORDER);

      // Escribir las líneas ordenadas en el archivo CSV
      try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo2))) {
        for (String l : lineas) {
          escritor.write(l);
          escritor.newLine();
        }
        System.out.println("Archivo CSV ordenado creado correctamente: " + archivo2);
      } catch (IOException e) {
        System.err.println("Error al escribir en el archivo: " + e.getMessage());
      }

    } catch (IOException e) {
      System.err.println("Error al leer el archivo binario: " + e.getMessage());
    }

    // Devolver el nombre del archivo CSV ordenado
    return archivo2;
  }

  private String ordenaCsv(String archivo, String nombreMetodo) {
    // Creo un segundi archivo y una lista para almacenar las líneas que luego
    // ordenare
    String archivo2 = null;
    List<String> ordenar = new ArrayList<String>();
    // Leo el contenido
    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
      String linea;
      // Creo un array de caracteres para almacenar el nombre del fichero separandolo
      // de su extension
      String[] separador = archivo.split("\\.");
      // Añadimos la extension .dat a la parte previamente separada del nombre
      archivo2 = separador[0] + "_ord.csv";

      // Empezamos el proceso parae escribir en el nuevo fichero
      try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo2))) {
        while ((linea = reader.readLine()) != null) {
          // Almacenamos todas las lineas en la lista
          ordenar.add(linea);
        }

        // Ordenamos las listas
        Collections.sort(ordenar);
        // Escribimos todo en el nuevo fichero
        for (int i = 0; i < ordenar.size(); i++) {
          escritor.write(ordenar.get(i));
          escritor.newLine();
        }
      } catch (EOFException e) {
        System.out.println("Archivo creado correctamente: " + archivo);
      } catch (IOException e) {
        System.err.println("Error al escribir en el archivo: " + e.getMessage());
      }
    } catch (FileNotFoundException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    } catch (IOException e1) {
      // TODO Auto-generated catch block
      e1.printStackTrace();
    }
    registro.escribeLog(nombreMetodo, archivo, archivo2);
    return archivo2;

  }
}