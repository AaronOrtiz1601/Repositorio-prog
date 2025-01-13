package psp.unidad01.relacion05.ejercicio03;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class generadorModificado {

  public static void main(String[] args) {
    
    String nombreArchivo = "default.txt";
    if (args.length > 0)
    {
      nombreArchivo = args[0];
    }
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(nombreArchivo))) {
    escritor.write("hola como estas yo fatal");
  } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }
    }

  }

