package psp.unidad01.relacion05.ejercicio01;

import java.io.IOException;

public class copiarArchivo {

  public static void main(String[] args) {
    String rutaActual = "C:\\Windows\\explorer.exe";
    String rutaDestino = "C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.05";
    
    ProcessBuilder copia = new ProcessBuilder("cmd.exe","/c","xcopy",rutaActual,rutaDestino);
    try {
      copia.start();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
        

  }

}
