package main;

import java.sql.SQLException;

import Dao.cityDaoImpl;
import models.city;

public class prueba {

  public static void main(String[] args) {
    // Llamada al método de prueba
    testDao();
  }

  public static void testDao() {
    cityDaoImpl dao = cityDaoImpl.getInstance();
    city cit = new city("hola", "AFG", "GG", 10);

    try {
      int n = dao.add(cit);
      System.out.println("El número de registros insertados es: " + n);
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }
}
