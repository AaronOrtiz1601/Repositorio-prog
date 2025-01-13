package main;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

import javax.crypto.Cipher;
// Nada que ver, pero para ver los alias que tengo en mi almacen de claves es asi en la terminal
// keytool -list -v -keystore almacenClaves.jks
public class EncriptaYFirma {

    public static void main(String[] args) {
      // Voy a encriptar, por lo que uso la clave publica de la otra persona para encriptar el texto y la privada mia para encriptar el hash
      // Supongo que mensajeOriginal see pasara por terminal (mensajeOriginal = args[0])  
      String mensajeOriginal = "Este es un mensaje confidencial";
        
        // Rutas a tu almacén de claves y las contraseñas
        String keystorePath = "C:/Users/Aarón/almacenClaves.jks"; 
        String keystorePassword = "manolo777Ab.";
        // Mi alias que tiene mis llaves
        String miAlias = "aaron";
        // La clave publica de la persona a la que le quiero mandar el mensaje
        String aliasClaveReceptor = "mykey";

        try {
            // Cargar el KeyStore y las claves necesarias
            KeyStore keystore = KeyStore.getInstance("JKS");
            keystore.load(new FileInputStream(keystorePath), keystorePassword.toCharArray());
            
            // Obtener la clave privada para firmar
            PrivateKey miClavePrivada = (PrivateKey) keystore.getKey(miAlias, keystorePassword.toCharArray());

            // Obtener la clave pública del receptor para cifrar
            PublicKey clavePublicaReceptor = keystore.getCertificate(aliasClaveReceptor).getPublicKey();
            
            // 1. Cifrar el mensaje con la clave pública del receptor
            Cipher cifrador = Cipher.getInstance("RSA");
            cifrador.init(Cipher.ENCRYPT_MODE, clavePublicaReceptor);
            // Cifra el mensaje original y lo devuelve en bytes
            byte[] mensajeCifrado = cifrador.doFinal(mensajeOriginal.getBytes());
            // Convierto el mensaje a cadena Base64 para que sea legible
            String mensajeCifradoBase64 = Base64.getEncoder().encodeToString(mensajeCifrado);
            System.out.println("Mensaje cifrado: " + mensajeCifradoBase64);

            // 2. Crear el hash y firmarlo con nuestra clave privada
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            byte[] hash = digest.digest(mensajeOriginal.getBytes());
            
            // Crea un objeto Signature que usara el algoritmo Sha-256 para crear la firma con RSA
            Signature firma = Signature.getInstance("SHA256withRSA");
            // Configura el objeto para firmar con mi clave privada
            firma.initSign(miClavePrivada);
            firma.update(hash);
            // Firma el hash con la clave privada y devuelve la firma en bytes
            byte[] firmaHash = firma.sign();
            // Pasa los bytes a Base64
            String firmaBase64 = Base64.getEncoder().encodeToString(firmaHash);
            System.out.println("Firma del hash (Base64): " + firmaBase64);

            // Aquí, mensajeCifradoBase64 y firmaBase64 se enviarán al receptor

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}