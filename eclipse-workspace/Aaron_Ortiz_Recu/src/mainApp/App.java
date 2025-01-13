package mainApp;

import java.util.ArrayList;
import java.util.List;

import modelos.Serie;
import modelos.Usuario;
import views.Principal;

public class App {
  public static List<Usuario> usuarios = new ArrayList<>();
  public static List<Serie> series = new ArrayList<>();

  public static void main(String[] args) {
    Principal ventana = new Principal();
    ventana.setVisible(true);

  }

}
