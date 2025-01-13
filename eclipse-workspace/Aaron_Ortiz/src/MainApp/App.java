package MainApp;

import java.util.ArrayList;
import java.util.List;

import models.Entrenador;
import models.Equipo;
import models.Jugador;
import views.Principal;

/**
 * Main que se encarga de ejecutar la aplicacion desde 0
 */
public class App {
  
  public static List<Jugador> jugadores = new ArrayList<>(); 
  public static List<Entrenador> entrenadores = new ArrayList<>(); 
  public static List<Equipo> equipos = new ArrayList<>();
 
  public static void main(String[] args) {
   Principal ventana = new Principal();
   ventana.setVisible(true);
   Equipo equipo1 = new Equipo("pikachuteam", "2005", "paco", "hombre", "5 de la tarde","3");
   Equipo equipo2 = new Equipo("pika2", "2005", "paco", "mujer", "5 de la tarde","3");
   equipos.add(equipo1);
   equipos.add(equipo2);
  }

}
