package mainApp;

import java.util.ArrayList;

import java.util.List;

import models.Cliente;
import models.Producto;
import views.Principal;
import models.Reservas;
/**
 * Metodo main donde se ejecuta la aplicación
 */
public class MainApp  {
  //Listas para almacenar los datos de los clientes y los productos
  public static List<Cliente> clientes = new ArrayList<>(); 
  public static List<Producto> productos = new ArrayList<>(); 
  public static List<Reservas> reservas = new ArrayList<>(); 
  
  public static void main(String[] args) {
   Principal ventana = new Principal();
   ventana.setVisible(true);

  }

}
