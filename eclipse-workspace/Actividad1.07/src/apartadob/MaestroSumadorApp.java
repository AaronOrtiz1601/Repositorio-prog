package apartadob;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MaestroSumadorApp {

    public static void main(String[] args) {
        if (args.length != 2) {
            System.err.println("Se necesitan exactamente dos parámetros enteros.");
            return;
        }

        try {
            int valor1 = Integer.parseInt(args[0]);
            int valor2 = Integer.parseInt(args[1]);

            // Determina el menor y el mayor de los dos valores
            int menor = Math.min(valor1, valor2);
            int mayor = Math.max(valor1, valor2);
            
            // Calcula la diferencia siempre restando el mayor menos el menor
            int diferencia = mayor - menor;
            //Sacamos el número de procesos que se van a lanzar
            int numProcesos = determinarNumeroProcesos(diferencia);
            System.out.println("Número de procesos a lanzar: " + numProcesos);
            
            //Sacamos el rango del proceso y su inicio
            int rango = diferencia / numProcesos;
            int inicio = menor;
            int fin = inicio + rango;
            //Hacemos una lista para almacenar todos los procesos
            List<Process> procesos = new ArrayList<>();

            for (int i = 0; i < numProcesos; i++) {
                if (i == numProcesos - 1) {
                    fin = mayor;
                }

                System.out.println("Lanzando proceso con rango: " + inicio + " a " + fin);

                ProcessBuilder proceso = new ProcessBuilder("java", "apartadob.SumadorProcess", String.valueOf(inicio), String.valueOf(fin));
                Process proceso2 = proceso.start();
                procesos.add(proceso2);

                inicio = fin + 1;
                fin = inicio + rango;
            }
            //Acumulamos los resultados de cada proceso
            int sumaTotal = acumularResultados(procesos);
            System.out.println("Suma acumulativa: " + sumaTotal);

        } catch (NumberFormatException e) {
            System.err.println("Los parámetros deben ser enteros.");
        } catch (IOException e) {
            System.err.println("Error al iniciar el proceso: " + e.getMessage());
        }
    }
    /**
     * Metodo privado que se encarga de determinar el número de procesos que se van a ejecutar
     */
    private static int determinarNumeroProcesos(int diferencia) {
      //Si la diferencia es menor de 25 el proceso sera 1
        if (diferencia < 25) {
            return 1;
      //Si la diferencia es menor o igual a 100 seran 2 procesos
        } else if (diferencia <= 100) {
            return 2;
      //Si es mas de 100, seran el numero de procesoso maximo que sea capaz de lanzar tu ordenador
        } else {
            return Runtime.getRuntime().availableProcessors();
        }
    }
    /**
     * Metodo privado que se encarga de acumular los resultados de cada proceso
     * @param procesos
     * @return
     * @throws IOException
     */
    private static int acumularResultados(List<Process> procesos) throws IOException {
        int sumaTotal = 0;
        
        //Haciendo uso de un for each leemos resultado a resultado y lo almacenamos en la variable suma total
        for (Process proceso : procesos) {
            try (BufferedReader lector = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                if ((linea = lector.readLine()) != null) {
                    int valorLeido = Integer.parseInt(linea);
                    System.out.println("Valor leído del proceso: " + valorLeido);
                    sumaTotal += valorLeido;
                } else {
                    System.err.println("No se recibió salida del proceso.");
                }
            }
        }

        return sumaTotal;
    }
}
