package apartadob;

public class SumadorProcess {
    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Se necesitan dos parámetros: inicio y fin.");
            return;
        }

        try {
            int inicio = Integer.parseInt(args[0]);
            int fin = Integer.parseInt(args[1]);
            int suma = 0;

            for (int i = inicio; i <= fin; i++) {
                suma += i;
            }

            System.out.println(suma); // Salida de la suma total, sin otros mensajes adicionales

        } catch (NumberFormatException e) {
            System.err.println("Los parámetros deben ser enteros.");
        }
    }
}
