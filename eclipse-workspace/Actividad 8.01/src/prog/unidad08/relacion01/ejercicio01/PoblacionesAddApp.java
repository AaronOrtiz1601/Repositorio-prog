package prog.unidad08.relacion01.ejercicio01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PoblacionesAddApp {
    public static final String JDBC_URL = "jdbc:sqlite:";
    public static final String DATABASE_PATH = "db/poblaciones01.db";

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
       
        try (Connection conn = DriverManager.getConnection(JDBC_URL + DATABASE_PATH);
             Statement stmt = conn.createStatement();) {
            System.out.println("Dime el codigo de la ciudad a añadir");
            String codigo = sc.nextLine();
            System.out.println("Ahora su nombre");
            String nombre = sc.nextLine();
            System.out.println("Su extension");
            double extension = Double.parseDouble(sc.nextLine());
            System.out.println("ahora su poblacion total");
            int pobTotal = Integer.parseInt(sc.nextLine());
            System.out.println("Ahora su poblacion masculina");
            int pobMasculina = Integer.parseInt(sc.nextLine());
            System.out.println("Ahora su poblacion femenina");
            int pobFemenina = Integer.parseInt(sc.nextLine());
            System.out.println("Ahora el número de vehiculos");
            int numVehiculos = Integer.parseInt(sc.nextLine());
            System.out.println("Ahora el numero de lineas de telefono");
            int lineasTelf = Integer.parseInt(sc.nextLine());
            String sql = String.format("INSERT INTO pueblos (codigo, nombre, extension, pob_total, pob_hombres,pob_mujeres,vehiculos,lineas_tel)"
                            + " VALUES ('%s', '%s', %s, %d, %d, %d, %d, %d)",
                    codigo, nombre, extension, pobTotal, pobMasculina, pobFemenina, numVehiculos, lineasTelf);
            stmt.executeUpdate(sql);
        } catch (SQLException e) {
            System.out.printf("Error: Ocurrió error %s%n", e.getMessage());
        }

    }
}
