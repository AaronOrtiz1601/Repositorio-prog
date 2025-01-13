package examen;

import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.Signature;
import java.util.Base64;

import javax.crypto.Cipher;

public class FirmaApp {

    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Faltan parámetros\r\n"
                + "USO:\r\n"
                + "FirmaApp archivo password\r\n"
                + "archivo - archivo del que se quiere obtener la firma\r\n"
                + "password - Password para desbloquear la clave privada");
            return;
        }

        String archivo = args[0];
        String keystorePassword = args[1];
        String alias = "examen";
        String keystorePath = "examenclaves.jks";  

        try {
            //  Leer el archivo en binario
            byte[] contenidoArchivo = Files.readAllBytes(Paths.get(archivo));

            //  Calcular el resumen (hash) del archivo usando SHA-256
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(contenidoArchivo);

            // Cargar el KeyStore y obtener la clave privada
            KeyStore keystore = KeyStore.getInstance("JKS");
            try (FileInputStream fis = new FileInputStream(keystorePath)) {
                keystore.load(fis, keystorePassword.toCharArray());
            }

            PrivateKey miClavePrivada = (PrivateKey) keystore.getKey(alias, keystorePassword.toCharArray());

            //  Firmar el hash utilizando SHA256withRSA
            // Crear una instancia del cifrador usando RSA
            Cipher cipher = Cipher.getInstance("RSA");
            cipher.init(Cipher.ENCRYPT_MODE, miClavePrivada);

            // Cifrar el mensaje
            byte[] encryptedBytes = cipher.doFinal(hash);
            
           

            //  Convertir la firma a Base64 y mostrarla
            String firmaBase64 = Base64.getEncoder().encodeToString(encryptedBytes);
            System.out.println(firmaBase64);

        } catch (Exception e) {
            System.err.println("Error al procesar el archivo o la clave: " + e.getMessage());
            e.printStackTrace();
        }
    }
}
