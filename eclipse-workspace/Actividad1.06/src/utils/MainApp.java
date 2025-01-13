package utils;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Scanner;

public class MainApp {
    public static void main(String[] args) {
        Process process = null;
        try {
            // Ajusta la ruta para el classpath correcto
            ProcessBuilder builder = new ProcessBuilder("java", "-cp", "C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.06\\bin", "utils.ProcesoEsclavo");
            process = builder.start();

            // Enviar datos al proceso esclavo
            PrintWriter outputStreamWriter = new PrintWriter(new OutputStreamWriter(process.getOutputStream()), true);
            // Leer respuesta del proceso esclavo
            BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

            Scanner scanner = new Scanner(System.in);
            String mensaje;

            // Bucle para enviar mensajes al proceso esclavo
            while (true) {
                System.out.print("Introduce un texto (o vacío para salir): ");
                mensaje = scanner.nextLine();

                if (mensaje.isEmpty()) {
                    // Indicar al proceso esclavo que debe finalizar
                    outputStreamWriter.println();
                    break;
                }

                // Enviar el mensaje al proceso esclavo
                outputStreamWriter.println(mensaje);
                // Asegurarse de que se envía el mensaje
                outputStreamWriter.flush(); 

                // Leer la respuesta del proceso esclavo
                String respuesta = reader.readLine();
                if (respuesta != null) {
                    System.out.println("Respuesta del esclavo: " + respuesta);
                } else {
                    System.out.println("No se recibió respuesta del esclavo.");
                    break;
                }
            }

            //Cerramos la entrada y la salida hacia el esclavo
            outputStreamWriter.close(); 
            reader.close(); 
            process.waitFor(); 
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
