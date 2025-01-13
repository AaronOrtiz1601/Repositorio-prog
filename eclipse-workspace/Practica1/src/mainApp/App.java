package mainApp;

import java.util.ArrayList;
import java.util.List;

import models.Clientes;
import models.Productos;
import views.Principal;

public class App {
    /**
     * Creacion de dos listas para almacenar los clientes y los productos que usaremos
     */
    public static List<Clientes> clientes = new ArrayList<>(); 
    public static List<Productos> productos = new ArrayList<>();
    
    /**
     * Iniciamos la app
     * @param args
     */
    public static void main(String[] args) {
        Principal principal = new Principal();
        principal.setVisible(true);
    }
}
