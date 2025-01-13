package utils;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.PrintWriter;

public class CuentaLetraApp {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Se requieren dos argumentos: vocal y archivo de entrada.");
            return;
        }
        String vocal = args[0];
        String archivoEntrada = args[1];
        int contador = 0;

        try (BufferedReader reader = new BufferedReader(new FileReader(archivoEntrada))) {
            String linea;
            while ((linea = reader.readLine()) != null) {
                // Contar las vocales (mayúsculas y minúsculas)
                contador = contador + linea.toLowerCase().replaceAll("[^" + vocal.toLowerCase() + "]", "").length();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Escribir el resultado en un archivo
        try (PrintWriter writer = new PrintWriter(new FileWriter("resultado_" + vocal + ".txt"))) {
            writer.println(contador);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
