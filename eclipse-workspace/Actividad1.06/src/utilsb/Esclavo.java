package utilsb;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class Esclavo {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter writer = new PrintWriter(System.out, true)) {

            String mensaje;
            double suma = 0;

            while ((mensaje = reader.readLine()) != null) {
                if (mensaje.isEmpty()) {
                    // Si el mensaje está vacío, terminamos el proceso esclavo
                    break;
                }
                double numero = Double.parseDouble(mensaje);
                suma += numero;  // Sumar el número leído
            }
            writer.println(suma);  // Enviar la suma al maestro
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
