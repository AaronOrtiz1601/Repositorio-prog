package ejercicio5;

import javax.crypto.Cipher;
import java.security.KeyStore;
import java.security.PrivateKey;
import java.util.Base64;
import java.io.FileInputStream;

public class DescifraRSAApp {

    public static void main(String[] args) {
        try {
            // Parámetros
            String mensajeCifrado = "nFLoDbVv37IrX6VJFCD/xSy2E/w9jvh2Fb5/HZST7aqgPaIXevRnDFZa/e3qkgb2rzwj/lXj6pNchZLmbeY0oFj8HxerC8Nz2Ni9xc2pGJsn04GZp5PpPzYugegB4JeWb7W4hwOWOuKYD98w0qVc+HfMGqpdPCCvhnHUUMZt4SgQMy8NKSZRISYUzb5wTm+1Q0Y+JKKatP5OROtnDQ3ycdo/xGpxPasZj5AV/gWyVzC/wqGYpaRwu44NdtqJmKQfLJAm0MrMbPu37+HN22D6x1kbAeHjxycb0L/D/NgNel0Ly6A9P1Mv+jzOC33vO0lugCuxZeVROCNIXPTdljZtig==";
            String alias = "aaron";  
            String keystorePath = "C:/Users/Aarón/almacenClaves.jks";
            String keystorePassword = "manolo777Ab.";  

            // Descifrar el mensaje
            String mensajeDescifrado = decryptMessage(mensajeCifrado, alias, keystorePath, keystorePassword);

            // Mostrar el resultado descifrado
            System.out.println("Mensaje descifrado: " + mensajeDescifrado);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // Método para descifrar un mensaje utilizando la clave privada del Keystore
    private static String decryptMessage(String encryptedMessage, String alias, String keystorePath, String keystorePassword) throws Exception {
        // Cargar el Keystore desde el archivo especificado
        FileInputStream keystoreFile = new FileInputStream(keystorePath);
        KeyStore keystore = KeyStore.getInstance(KeyStore.getDefaultType());
        keystore.load(keystoreFile, keystorePassword.toCharArray());

        // Obtener la clave privada usando el alias dado 
        PrivateKey privateKey = (PrivateKey) keystore.getKey(alias, keystorePassword.toCharArray());

        // Crear una instancia del cifrador usando RSA
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);

        // Decodificar el mensaje cifrado desde Base64
        byte[] encryptedBytes = Base64.getDecoder().decode(encryptedMessage);

        // Descifrar el mensaje
        byte[] decryptedBytes = cipher.doFinal(encryptedBytes);

        // Convertir los bytes descifrados a una cadena de texto
        return new String(decryptedBytes);
    }
}
