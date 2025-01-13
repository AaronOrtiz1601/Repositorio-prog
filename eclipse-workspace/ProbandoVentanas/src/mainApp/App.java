package mainApp;

import java.util.ArrayList;
import java.util.List;

import models.Usuario;
import views.login;

public class App {
  public  static List <Usuario> usuarios ;
  public static void main(String[] args) {
    login ventana = new login();
    ventana.setVisible(true);
    usuarios = new ArrayList<>();
  }

}
