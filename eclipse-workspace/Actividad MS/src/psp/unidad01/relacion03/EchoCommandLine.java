package psp.unidad01.relacion03;

public class EchoCommandLine {

  public static void main(String[] args) {
    // Comprobar si se han pasado parámetros
    if (args.length > 0) {
        System.out.println("Parámetros recibidos:");
        // Recorrer y mostrar cada parámetro
        for (String arg : args) {
            System.out.println(arg);
        }
    } else {
        System.out.println("No se han recibido parámetros.");
    }
}

}
