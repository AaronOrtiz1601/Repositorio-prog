package conversiones;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDate;

public class logFinal {

  public void escribeLog(String nombreMetodo, String ficheroEntrada, String ficheroSalida) {
    String archivo = "log_csv.txt";
    LocalDate fechaActual = LocalDate.now();
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter(archivo,true))) {
      escritor.newLine();
      escritor.write("Metodo = " + nombreMetodo + ", fichero entrada= " + ficheroEntrada + ",fichero salida= "
          + ficheroSalida + ",Fecha de ejecucion= " + fechaActual);
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
}
