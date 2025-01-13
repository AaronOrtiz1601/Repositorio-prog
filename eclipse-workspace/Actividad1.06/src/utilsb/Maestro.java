package utilsb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.util.Random;

public class Maestro {
    public static void main(String[] args) {
        Process process = null;
        try {
            // Verificar los argumentos de entrada
            if (args.length == 2) {
                try {
                    // Convertir los argumentos a números reales (double)
                    double primerNumero = Double.parseDouble(args[0]);
                    double segundoNumero = Double.parseDouble(args[1]);

                    // Verificar que el primer número sea menor o igual al segundo
                    if (primerNumero <= segundoNumero) {
                        // Ajusta la ruta para el classpath correcto
                        ProcessBuilder builder = new ProcessBuilder("java", "-cp", "C:\\Users\\Aarón\\Documents\\Repostiorio-prog\\eclipse-workspace\\Actividad1.06\\bin", "utilsb.Esclavo");
                        process = builder.start();

                        // Enviar datos al proceso esclavo
                        PrintWriter outputStreamWriter = new PrintWriter(new OutputStreamWriter(process.getOutputStream()), true);
                        // Leer respuesta del proceso esclavo
                        BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));

                        // Generar 1000 números aleatorios entre los valores proporcionados
                        Random random = new Random();
                        for (int i = 0; i < 1000; i++) {
                            double numeroAleatorio = primerNumero + (segundoNumero - primerNumero) * random.nextDouble();
                            outputStreamWriter.println(numeroAleatorio);
                        }

                        // Enviar una línea en blanco para indicar el final de la lista
                        outputStreamWriter.println();

                        // Leer la respuesta del proceso esclavo
                        String respuesta = reader.readLine();
                        if (respuesta != null) {
                            System.out.println("Resultado del esclavo: " + respuesta);
                        } else {
                            System.out.println("No se recibió respuesta del esclavo.");
                        }

                        // Cerrar los flujos y esperar a que el proceso termine
                        outputStreamWriter.close();
                        reader.close();
                        process.waitFor();
                    } else {
                        System.out.println("El primer argumento debe ser menor o igual al segundo.");
                    }
                } catch (NumberFormatException e) {
                    System.out.println("Ambos argumentos deben ser números reales.");
                }
            } else {
                System.out.println("Debes proporcionar exactamente dos argumentos.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (process != null) {
                process.destroy();
            }
        }
    }
}
