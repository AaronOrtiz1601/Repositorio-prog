package aaronAD.aaronAD;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import utils.jdbc;

/**
 * Metodo main donde hacemos una consulta a la base de datos
 */
public class App {
    public static void main(String[] args) {
      //Creamos un objeto de la clase jdbc y usamos el metodo conectar
        jdbc jdbcInstance = new jdbc();
        Connection conexion = jdbcInstance.conectar();
        
        //Si la conexion no devuelve null hacemos la consulta
        if (conexion != null) {
            try (Statement stmt = conexion.createStatement();
                //Creamos un fichero donde almacenaremos el resultado de la consulta
                BufferedWriter escritor = new BufferedWriter(new FileWriter("prueba.txt"))) {
              //Hacemos la consulta
                String query = "SELECT first_name, last_name FROM actor LIMIT 10"; 
                ResultSet rs = stmt.executeQuery(query);
              
                //Guardamos en variables los resultados en unas variables y las escribimos en un fichero
                while (rs.next()) {
                    String firstName = rs.getString("first_name");
                    String lastName = rs.getString("last_name");
                    
                    
                    try {
                      escritor.write("Actor: " + firstName +" "+ lastName);
                      escritor.newLine();
                    } catch (IOException e) {
                      
                      e.printStackTrace();
                    }
                }
                //Cerramos la conexion
                rs.close();
                conexion.close();
            } catch (SQLException e) {
                System.out.println("Error al ejecutar la consulta");
                e.printStackTrace();
            } catch (IOException e1) {
              // TODO Auto-generated catch block
              e1.printStackTrace();
            }
        }
    }
}
