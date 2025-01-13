package cifrados;

import java.util.Base64;
import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

public class DesencriptaAESApp {

    public static void main(String[] args) {
        // Si no se pasan parámetros, usamos los valores por defecto
        String mensajeCifrado = null;
        String password = null;

        // Comprobamos si se ha pasado un mensaje cifrado y una contraseña como argumentos
        if (args.length == 2) {
       // El primer argumento es el mensaje cifrado en Base64
       // El segundo argumento es la contraseña
            mensajeCifrado = args[0]; 
            password = args[1];       
        } else {
            System.out.println("Introduce los dos parámetros: mensaje cifrado y contraseña");
         // Salimos si no se introducen los parámetros necesarios
            return; 
        }

        try {
            // Llamamos a la función de desencriptado
            String mensajeDesencriptado = desencriptarAES(mensajeCifrado, password);
            System.out.println("Mensaje desencriptado: " + mensajeDesencriptado);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Función para desencriptar usando AES
    public static String desencriptarAES(String mensajeCifrado, String password) throws Exception {
        // Ajustamos la contraseña a 16 bytes (AES requiere claves de 128 bits)
        String clave;

        // Si la contraseña es mayor o igual a 16 caracteres, tomamos solo los primeros 16
        if (password.length() >= 16) {
       // Tomamos los primeros 16 caracteres
            clave = password.substring(0, 16); 
        } else {
            // Si es menor de 16, rellenamos con espacios hasta llegar a 16 caracteres
            StringBuilder sb = new StringBuilder(password); 
            while (sb.length() < 16) {
           // Rellenamos con espacios
                sb.append(" "); 
            }
         // Convertimos de nuevo a String
            clave = sb.toString(); 
        }

        // Convertimos la clave a bytes
        byte[] key = clave.getBytes("UTF-8");

        // Creamos el objeto SecretKeySpec con la clave generada
        SecretKeySpec secretKey = new SecretKeySpec(key, "AES");

        // Creamos el objeto Cipher para desencriptar AES
        Cipher cipher = Cipher.getInstance("AES");

        // Iniciamos el descifrado en modo de descifrado
        cipher.init(Cipher.DECRYPT_MODE, secretKey);

        // Decodificamos el mensaje cifrado (en Base64) a bytes
        byte[] mensajeCifradoBytes = Base64.getDecoder().decode(mensajeCifrado);

        // Desencriptamos el mensaje
        byte[] mensajeDesencriptado = cipher.doFinal(mensajeCifradoBytes);

        // Convertimos el mensaje desencriptado a String
        return new String(mensajeDesencriptado, "UTF-8");
    }
}
