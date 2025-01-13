package main;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.util.Base64;

import javax.crypto.Cipher;

public class DescifraYVerifica {

  public static void main(String[] args) {
    // Voy a desencriptar, por lo que uso mi clave privada para desencriptar el texto y la clave publica de la otra persona para desencriptar el hash
    // Supongo que los 2 valores de abajo se pasan por args
      String mensajeCifradoBase64 = "mensajeCifradoRecibido";
      String firmaBase64 = "firmaHashRecibida";

      // Rutas a tu almacén de claves y las contraseñas
      String keystorePath = "C:/Users/Aarón/e.jks";
      String keystorePassword = "manolo777Ab.";
      // Mi clave privada
      String aliasClavePrivadaReceptor = "aaron";
      // Clave publica de la otra persona
      String aliasClavePublicaRemitente = "mykey";

      try {
          // Cargar el KeyStore y las claves necesarias
          KeyStore keystore = KeyStore.getInstance("JKS");
          keystore.load(new FileInputStream(keystorePath), keystorePassword.toCharArray());
          
          // Obtener la clave privada del receptor para descifrar
          PrivateKey clavePrivadaReceptor = (PrivateKey) keystore.getKey(aliasClavePrivadaReceptor, keystorePassword.toCharArray());

          // Obtener la clave pública del remitente para verificar la firma
          PublicKey clavePublicaRemitente = keystore.getCertificate(aliasClavePublicaRemitente).getPublicKey();
          
          // 1. Descifrar el mensaje con la clave privada del receptor
          Cipher cifrador = Cipher.getInstance("RSA");
          cifrador.init(Cipher.DECRYPT_MODE, clavePrivadaReceptor);
          // saca los bytes originales del mensaje cifrado
          byte[] mensajeCifrado = Base64.getDecoder().decode(mensajeCifradoBase64);
          // Descifra el mensaje usando la clave privada mia y devuelve el mensaje original en bytes
          byte[] mensajeDescifrado = cifrador.doFinal(mensajeCifrado);
          // Convierte los bytes a texto normal
          String mensajeOriginal = new String(mensajeDescifrado);
          System.out.println("Mensaje descifrado: " + mensajeOriginal);

          // 2. Verificar la firma
          MessageDigest digest = MessageDigest.getInstance("SHA-256");
          byte[] hash = digest.digest(mensajeOriginal.getBytes());
          
          // Crea un objeto Signature que usara el algoritmo Sha-256 para verificar la firma con RSA
          Signature firma = Signature.getInstance("SHA256withRSA");
          // Configura el objeto para verificar la firma
          firma.initVerify(clavePublicaRemitente);
          firma.update(hash);
          // Decodifica la firma recibida de base64 y la compara con el hash utilizando la clave publica de la otra persona
          boolean esFirmaValida = firma.verify(Base64.getDecoder().decode(firmaBase64));
          System.out.println("¿Firma válida? " + esFirmaValida);

      } catch (Exception e) {
          e.printStackTrace();
      }
  }
}