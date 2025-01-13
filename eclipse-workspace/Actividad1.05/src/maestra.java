import java.io.File;
import java.io.IOException;

public class maestra {

  public static void main(String[] args) {
    
    
    ProcessBuilder proceso = new ProcessBuilder("cmd.exe","/c","java -jar Ejecutable2.jar");
    proceso.directory(new File("C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.05\\src"));
    try {
      proceso.start();
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }

  }

}
