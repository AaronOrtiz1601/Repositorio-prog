package MainApp;

import java.util.ArrayList;
import java.util.List;

import models.Citas;
import models.Usuario;
import views.Principal;

public class App {
  public static List<Usuario> clientes = new ArrayList<>();
  public static List<Usuario> empleados = new ArrayList<>();
  public static List<Citas> listaCita = new ArrayList<>();

  public static void main(String[] args) {
    Principal ventana = new Principal();
    ventana.setVisible(true);
    Usuario usuario1 = new Usuario("Carlos", "Gomez", "calitos", "1234", "123456789", "Email");
    Usuario usuario2 = new Usuario("Ana", "Lopez", "anita", "1234", "987654321", "Teléfono");
    empleados.add(usuario1);
    empleados.add(usuario2);

  }

}
