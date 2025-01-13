package seg.ejercicio01;

import java.io.FileInputStream;
import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class CreadorDeResumenes {
    /**
     * Metodo main en el que se realiza todo el programa
     * @param args
     */
    public static void main(String[] args) {
      //Comprobamos que haya escrito al menos el nombre del fichero
        if (args.length < 1) {
            System.out.println("Debes proporcionar al menos el nombre del fichero");
        }else {
        //Metemos en una variable el nombre del fichero y le damos al algoritmo su valor base
        String nombreFichero = args[0];
        String algoritmo = "SHA-256";
         //Comprobamos que haya puesto un segundo parametro, si lo ha hecho,comprobamos si es MD5 y si es cambiamos el algoritmo
        if (args.length >= 2) {
            if (args[1].equalsIgnoreCase("MD5")) {
                algoritmo = "MD5";
            }
        }
        //Mostramos por pantalla el resumen que ha generado el metodo privado
        try {
            String resumen = generarResumen(nombreFichero, algoritmo);
            System.out.println("Resumen (" + algoritmo + "): " + resumen);
        } catch (IOException e) {
            System.out.println("Error al leer el fichero: " + e.getMessage());
        } catch (NoSuchAlgorithmException e) {
            System.out.println("Algoritmo no soportado: " + e.getMessage());
        }
        }
    }

    private static String generarResumen(String nombreFichero, String algoritmo) throws IOException, NoSuchAlgorithmException {
        //Preparamos el algoritmo que vatamos a usar
        MessageDigest md = MessageDigest.getInstance(algoritmo);
        //empezamos a leer el archivo
        try (FileInputStream fis = new FileInputStream(nombreFichero)) {
          //leemos los bytes por bloques
            byte[] buffer = new byte[1024];
            int bytesRead;
            //Empieza la lectura,esta acaba cuando el fichero acaba
            while ((bytesRead = fis.read(buffer)) != -1) {
              //Actualizamos con el numero de byte leidos
                md.update(buffer, 0, bytesRead);
            }
        }
        //Generamos el resumen del fichero
        byte[] resumenBytes = md.digest();
        //Creamos un StringBuilder para poder pararlo ahora a hexadecimal
        StringBuilder resumenHex = new StringBuilder();
         //Combertimos a hexadecimal el resumen
        for (byte b : resumenBytes) {
            resumenHex.append(String.format("%02x", b));
        }

        return resumenHex.toString();
    }
}
