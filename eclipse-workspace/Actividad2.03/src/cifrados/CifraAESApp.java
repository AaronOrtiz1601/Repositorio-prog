package cifrados;

import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class CifraAESApp {

    public static void main(String[] args) {
        // Si no se pasan parámetros, usamos los valores por defecto
        String mensaje;
        String password;

        // Comprobamos si se ha pasado un mensaje y una contraseña como argumentos
        if (args.length > 0) {
       // El primer argumento es el mensaje
            mensaje = args[0]; 
        } else {
       // Si no hay argumento, usamos el mensaje por defecto
            mensaje = "Mensaje de prueba"; 
        }

        if (args.length > 1) {
       // El segundo argumento es la contraseña
            password = args[1]; 
        } else {
       // Si no hay argumento, usamos la contraseña por defecto
            password = "pass123"; 
        }

        try {
            // Llamamos a la función de cifrado
            String mensajeCifrado = cifrarAES(mensaje, password);
            System.out.println("Mensaje cifrado: " + mensajeCifrado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Función para cifrar usando AES
    public static String cifrarAES(String mensaje, String password) throws Exception {
        // Ajustamos la contraseña a 16 bytes
        String clave = null;

        // Si la contraseña es mayor o igual a 16 caracteres, tomamos solo los primeros 16
        if (password.length() >= 16) {
       // Tomamos los primeros 16 caracteres
            clave = password.substring(0, 16); 
        } else {
            // Si es menor de 16, rellenamos con espacios hasta llegar a 16 caracteres
            // Usamos StringBuilder para modificar la cadena
            StringBuilder sb = new StringBuilder(password); 
            while (sb.length() < 16) {
           // Rellenamos con espacios
                sb.append(" "); 
            }
         // Convertimos de nuevo a String
            clave = sb.toString(); 
        }

        // Convertimos la clave en bytes
        byte[] key = clave.getBytes("UTF-8");

        // Creamos el objeto SecretKeySpec con la clave generada
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        // Creamos el objeto Cipher para cifrado AES
        Cipher cipher = Cipher.getInstance("AES");

        // Iniciamos el cifrado en modo de cifrado
        cipher.init(Cipher.ENCRYPT_MODE, secretKey);

        // Ciframos el mensaje
        byte[] mensajeCifrado = cipher.doFinal(mensaje.getBytes("UTF-8"));

        // Convertimos el mensaje cifrado a Base64 para hacerlo legible
        return Base64.getEncoder().encodeToString(mensajeCifrado);
    }
}
