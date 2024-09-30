package utils;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import models.Empleado;

public class UtilsFicheroArray {


  public void toArchivoTexto(ArrayList<Empleado> empleados) {
      String archivo = "empleados.txt";
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo))) {
      for (int i = 0; i < empleados.size(); i++) {
        // Llamamos al método toString() de cada Empleado
        escritor.write(empleados.get(i).toString());
        // Saltar a la siguiente línea para el siguiente empleado
        escritor.newLine();
      }
      System.out.println("Archivo creado correctamente: " + archivo);
    } catch (IOException e) {
      System.err.println("Error al escribir en el archivo: " + e.getMessage());
    }
  }
  public void toArchivoBinarioInverso(ArrayList<Empleado> empleados) {
    String archivo = "empleados.bin";
    try (ObjectOutputStream escritor = new ObjectOutputStream(new FileOutputStream(archivo))) {
      for (int i = empleados.size()- 1; i > 0; i--) {
        escritor.writeObject(empleados.get(i));
      }
      System.out.println("Archivo creado correctamente: " + archivo);
    } catch (IOException e) {
      System.err.println("Error al escribir en el archivo: " + e.getMessage());
    }
  }

  public void leer_Empleados(String archivo) {

    try (BufferedReader reader = new BufferedReader(new FileReader(archivo))) {
      String linea;
      while ((linea = reader.readLine()) != null) {
        System.out.println(linea);
      }

    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    }

  }

  public void leer_Empleados_b(String archivo) {

    try (ObjectInputStream lector = new ObjectInputStream(new FileInputStream(archivo))) {
      Empleado linea;
      while ((linea = (Empleado) lector.readObject()) != null) {
        System.out.println(linea.toString());
      }

    } catch (IOException e) {
      System.err.println("Error al leer el archivo: " + e.getMessage());
    } catch (ClassNotFoundException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
