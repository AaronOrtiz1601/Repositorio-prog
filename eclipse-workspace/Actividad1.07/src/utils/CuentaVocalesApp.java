package utils;

import java.io.BufferedReader;
import java.io.FileReader;

public class CuentaVocalesApp {
    public static void main(String[] args) {
        String archivoEntrada = "texto.txt";
        String[] vocales = {"a", "e", "i", "o", "u"};
        Process[] procesos = new Process[vocales.length];
        
        try {
            for (int i = 0; i < vocales.length; i++) {
                // Lanza un proceso hijo para contar la vocal
                procesos[i] = new ProcessBuilder("java", "-cp", "bin", "utils.CuentaLetraApp", vocales[i], archivoEntrada).start();
            }

            // Espera que todos los procesos terminen y recoge los resultados
            for (int i = 0; i < vocales.length; i++) {
                procesos[i].waitFor();
                // Leer el resultado del archivo
                String resultadoArchivo = "resultado_" + vocales[i] + ".txt"; // Cada proceso crea un archivo con el resultado
                BufferedReader reader = new BufferedReader(new FileReader(resultadoArchivo));
                String linea = reader.readLine();
                int contador = Integer.parseInt(linea);
                reader.close();
                System.out.println("Vocal '" + vocales[i] + "' cuenta: " + contador);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
