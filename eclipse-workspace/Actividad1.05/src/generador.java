import java.io.BufferedWriter;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class generador {

  public static void main(String[] args) {
   
    try (BufferedWriter escritor = new BufferedWriter(new FileWriter("probando.txt"))) {
    escritor.write("hola como estas yo fatal");
  } catch (IOException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
  }

  }

}
