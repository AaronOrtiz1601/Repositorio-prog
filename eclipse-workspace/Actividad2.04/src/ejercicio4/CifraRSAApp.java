package ejercicio4;

import javax.crypto.Cipher;
import java.security.KeyStore;
import java.security.PublicKey;
import java.util.Base64;
import java.io.FileInputStream;

public class CifraRSAApp {

    

    public static void main(String[] args) {
        try {
            // Parámetros
            String mensaje = "Este es el mensaje a cifrar";
            String alias = "aaron";  
            String keystorePath = "C:/Users/Aarón/almacenClaves.jks";
            String keystorePassword = "manolo777Ab.";  

            // Cifrar el mensaje
            String mensajeCifrado = encryptMessage(mensaje, alias, keystorePath, keystorePassword);

            // Mostrar el resultado cifrado en base64
            System.out.println("Mensaje cifrado: " + mensajeCifrado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
 /**
  *  Método para cifrar un mensaje utilizando la clave pública del Keystore
  * @param message
  * @param alias
  * @param keystorePath
  * @param keystorePassword
  * @return
  * @throws Exception
  */
    private static String encryptMessage(String message, String alias, String keystorePath, String keystorePassword) throws Exception {
        // Cargar el Keystore desde el archivo especificado
        FileInputStream keystoreFile = new FileInputStream(keystorePath);
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(keystoreFile, keystorePassword.toCharArray());

        // Obtener la clave pública usando el alias dado 
        PublicKey publicKey = keystore.getCertificate(alias).getPublicKey();

        // Crear una instancia del cifrador usando RSA
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);

        // Cifrar el mensaje
        byte[] encryptedBytes = cipher.doFinal(message.getBytes());

        // Convertir el resultado a Base64 para que sea legible
        return Base64.getEncoder().encodeToString(encryptedBytes);
    }
}
