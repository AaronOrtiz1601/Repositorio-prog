package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Random;

public class ProcesoEsclavo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out, true)) {

            String mensaje;
            Random random = new Random();

            while ((mensaje = reader.readLine()) != null) {
                if (mensaje.isEmpty()) {
                    // Si el mensaje está vacío, terminamos el proceso esclavo
                    break;
                }
             // Genera un número entre 0 y 2

                int operacion = random.nextInt(3); 
                //Cambia el mensaje dependiendo de la opcion que haya salido en alatorio
                String mensajeCambiado;
                switch (operacion) {
                    case 0:
                        mensajeCambiado = mensaje.toUpperCase(); 
                        break;
                    case 1:
                        mensajeCambiado = mensaje.toLowerCase(); 
                        break;
                    case 2:
                        mensajeCambiado = capitalizar(mensaje); 
                        break;
                    default:
                        mensajeCambiado = mensaje; 
                }

                // Enviar el resultado de vuelta al maestro
                writer.println(mensajeCambiado);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static String capitalizar(String mensaje) {
        String[] palabras = mensaje.split(" ");
        StringBuilder resultado = new StringBuilder();

        for (String palabra : palabras) {
            if (!palabra.isEmpty()) {
                resultado.append(Character.toUpperCase(palabra.charAt(0)))
                        .append(palabra.substring(1).toLowerCase())
                        .append(" ");
            }
        }

        return resultado.toString();
    }
}
