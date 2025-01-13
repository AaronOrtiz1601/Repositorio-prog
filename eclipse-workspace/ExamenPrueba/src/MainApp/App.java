package MainApp;

import java.util.ArrayList;
import java.util.List;

import models.Administracion;
import models.Clase;
import models.Cliente;
import models.Reservas;
import views.Principal;

/**
 * Main que se encarga de ejecutar la aplicacion desde 0
 */
public class App {
  
  public static List<Cliente> clientes = new ArrayList<>(); 
  public static List<Administracion> admins = new ArrayList<>(); 
  public static List<Clase> clases = new ArrayList<>();
  public static List<Reservas> reservas = new ArrayList<>(); 
  public static void main(String[] args) {
   Principal ventana = new Principal();
   ventana.setVisible(true);

  }

}
