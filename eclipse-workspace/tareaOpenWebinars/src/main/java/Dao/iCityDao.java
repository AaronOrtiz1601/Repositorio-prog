package Dao;

import java.sql.SQLException;
import java.util.List;

import models.city;

public interface iCityDao {
  /**
   * Metodo que se encarga de añadir registros a la base de datos
   */
  int add(city cit) throws SQLException;
  /**
   * Metodo que te devuelve una ciudad mediante su id
   */
  city getById(int id) throws SQLException;
  /**
   * Metodo que te devuelve una lista con todas los registros
   */
  List<city> getAll() throws SQLException;
  /**
   * Metodo que actualiza un registro
   */
  int update (city cit) throws SQLException;
  /**
   * Metodo que actualiza un registro
   */
  void delete(int id) throws SQLException;
}

