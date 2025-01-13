package Dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import models.city;
import utils.jdbc;
/**
 * Clase que implementa la interfaz icitidao
 */
public class cityDaoImpl implements iCityDao {

    private static cityDaoImpl instance;

    static {
        instance = new cityDaoImpl();
    }

    private cityDaoImpl() {}

    public static cityDaoImpl getInstance() {
        return instance;
    }
    /**
     * Metodo que se encarga de añadir registros a la base de datos
     */
    @Override
    public int add(city cit) throws SQLException {
        String sql = "INSERT INTO city (Name, CountryCode, District, Population) VALUES (?, ?, ?, ?)";
        int result = 0;

        jdbc conexion = new jdbc();
        try (Connection conn = conexion.conectar(); 
             PreparedStatement sentencia = conn.prepareStatement(sql)) {

            sentencia.setString(1, cit.getName());
            sentencia.setString(2, cit.getCountryCode());
            sentencia.setString(3, cit.getDistrict());
            sentencia.setInt(4, cit.getPopulation());

            result = sentencia.executeUpdate();
        }
        return result;
    }
    /**
     * Metodo que te devuelve una ciudad mediante su id
     */
    @Override
    public city getById(int id) throws SQLException {
        String sql = "SELECT * FROM city WHERE ID = ?";
        city cit = null;

        jdbc conexion = new jdbc();
        try (Connection conn = conexion.conectar();
             PreparedStatement sentencia = conn.prepareStatement(sql)) {

            sentencia.setInt(1, id);
            try (ResultSet rs = sentencia.executeQuery()) {
                if (rs.next()) {
                    cit = new city(
                        rs.getInt("ID"),
                        rs.getString("Name"),
                        rs.getString("CountryCode"),
                        rs.getString("District"),
                        rs.getInt("Population")
                    );
                }
            }
        }
        return cit;
    }
    /**
     * Metodo que te devuelve una lista con todas los registros
     */
    @Override
    public List<city> getAll() throws SQLException {
        String sql = "SELECT * FROM city";
        List<city> cities = new ArrayList<>();

        jdbc conexion = new jdbc();
        try (Connection conn = conexion.conectar();
             PreparedStatement sentencia = conn.prepareStatement(sql);
             ResultSet rs = sentencia.executeQuery()) {

            while (rs.next()) {
                city cit = new city(
                    rs.getInt("ID"),
                    rs.getString("Name"),
                    rs.getString("CountryCode"),
                    rs.getString("District"),
                    rs.getInt("Population")
                );
                cities.add(cit);
            }
        }
        return cities;
    }
    /**
     * Metodo que actualiza un registro
     */
    @Override
    public int update(city cit) throws SQLException {
        String sql = "UPDATE city SET Name = ?, CountryCode = ?, District = ?, Population = ? WHERE ID = ?";
        int result = 0;

        jdbc conexion = new jdbc();
        try (Connection conn = conexion.conectar();
             PreparedStatement sentencia = conn.prepareStatement(sql)) {

            sentencia.setString(1, cit.getName());
            sentencia.setString(2, cit.getCountryCode());
            sentencia.setString(3, cit.getDistrict());
            sentencia.setInt(4, cit.getPopulation());
            sentencia.setInt(5, cit.getId());

            result = sentencia.executeUpdate();
        }
        return result;
    }
    /**
     * Metodo que borra un registro mediante su id
     */
    @Override
    public void delete(int id) throws SQLException {
        String sql = "DELETE FROM city WHERE ID = ?";

        jdbc conexion = new jdbc();
        try (Connection conn = conexion.conectar();
             PreparedStatement sentencia = conn.prepareStatement(sql)) {

            sentencia.setInt(1, id);
            sentencia.executeUpdate();
        }
    }
}
