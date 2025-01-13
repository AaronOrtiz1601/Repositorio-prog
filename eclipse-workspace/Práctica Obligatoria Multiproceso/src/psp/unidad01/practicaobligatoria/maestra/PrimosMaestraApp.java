package psp.unidad01.practicaobligatoria.maestra;

import java.io.*;
import java.util.*;

public class PrimosMaestraApp {
    public static void main(String[] args) {
      //Si no has introducido dos parametros como minimo salta este error y el programa termina
        if (args.length < 2) {
            System.err.println("Error: Insuficiente número de parámetros.");
            System.err.println("Uso: java -jar Maestro.jar <valor inicial> <valor final> [<número de núcleos>]");
            return;
        }
       
        try {
          //Sacamos los parametros que se han recibido por la linea de comandos
            int inicioRango = Integer.parseInt(args[0]);
            int finRango = Integer.parseInt(args[1]);
           //Comprueba que los parametros sean mayores de 0 positivos y enteros
            if (inicioRango <= 0 || finRango <= 0 || inicioRango >= finRango) {
                System.err.println("Error: Los valores de los parámetros deben ser enteros, positivos y mayores que 0.");
                return;
            }
            //Comprueba el numero de nucleos del equipo
            int nucleosDisponibles = Runtime.getRuntime().availableProcessors();
            int rango = finRango - inicioRango + 1;
            //Sacamos el numero de procesos
            int numProcesos = args.length == 3 ? Integer.parseInt(args[2]) : nucleosDisponibles;
            numProcesos = Math.min(Math.min(numProcesos, nucleosDisponibles), rango);
            //Si el numero de procesos es mayor que la cantidad de nucleos disponible salta un error
            if (numProcesos > nucleosDisponibles) {
                System.err.println("Error: Excesivo número de procesos. No se pueden lanzar más procesos que núcleos disponibles en la CPU.");
                return;
            }
            //Mostramos el numero de nucleos que se usaran y por tanto el numero de procesos que se ejecutaran
            System.out.println("Número de núcleos que se intentará usar: " + numProcesos);
            
            //Calculamos el tamaño que tendra el rango
            int tamRango = rango / numProcesos;
            List<Integer> primosTotales = new ArrayList<>();
            int totalAnalizados = 0;
            int totalPrimos = 0;
            long inicioTiempo = System.currentTimeMillis();
            
            //Lanzamos los procesos llamando a la clase esclava atraves de su jar
            for (int i = 0; i < numProcesos; i++) {
                int inicio = inicioRango + i * tamRango;
                int fin = (i == numProcesos - 1) ? finRango : inicio + tamRango - 1;

                ProcessBuilder builder = new ProcessBuilder(
                    "java", "-jar", "Esclava.jar", String.valueOf(inicio), String.valueOf(fin)
                );
                //Empezamos a contar el tiempo que tarda el proceso
                long inicioProceso = System.currentTimeMillis();
                
                //Recogemos la salida del esclavo
                try {
                    Process process = builder.start();
                    //Leemos desde la salida estandar el resultado que nos manda la clase eslava
                    BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream()));
                    String line;
                    int primosEncontrados = 0;
                    
                    //Leemos linea por linea la salida del esclavo
                    //En caso de que el esclavo encuentre un primo, este es añadido a la lista y se le suma 1 a la variable primos encontrados 
                    while ((line = reader.readLine()) != null) {
                        if (line.matches("\\d+")) {
                            primosTotales.add(Integer.parseInt(line));
                            primosEncontrados++;
                        }
                    }

                    int exitCode = process.waitFor();
                    //Lanzamos un error si el proceso no termina
                    if (exitCode != 0) {
                        System.err.println("Error en el proceso esclavo " + i);
                    }
                    //Sacamos el tiempo que ha tardado en finalizar el proceso y el numero de numeros analizados
                    long finProceso = System.currentTimeMillis();
                    long tiempoProceso = finProceso - inicioProceso;
                    int numerosAnalizados = fin - inicio + 1;
                    //Mostramos el tiempo por proceso y los primos que ha habido en ese proceso, ademas de los numeros analizados
                    System.out.printf("Proceso P%d tiempo empleado: %d ms se han encontrado: %d números primos entre los %d analizados%n",
                            i, tiempoProceso, primosEncontrados, numerosAnalizados);
                    
                    //Lo guardamos todo en las variables que mostraremos al final
                    totalPrimos += primosEncontrados;
                    totalAnalizados += numerosAnalizados;

                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            }
           //Sacamos el tiempo total que ha tardado el programa en terminar
            long finTiempo = System.currentTimeMillis();
            long tiempoTotal = finTiempo - inicioTiempo;
          //Mostramos el tiempo que ha empleado el programa , ademas de los primos que ha encontrado
            System.out.printf("Tiempo total empleado en el programa: %d ms se han encontrado %d números primos entre los %d analizados%n",
                    tiempoTotal, totalPrimos, totalAnalizados);
            //Mostramos la lista de primos
            System.out.println(primosTotales);

        } catch (NumberFormatException e) {
            System.err.println("Error: Los valores de los parámetros deben ser enteros, positivos y mayores que 0.");
        }
    }
}
