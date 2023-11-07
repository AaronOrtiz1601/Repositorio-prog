package Prog.unidad03.excepciones;

import java.util.Scanner;

public class MayorMenorMediaExcepcionesApp {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
    int repeticion = 0;
    double numeros = 0;
    double mayor = 0;
    double menor = 0;
    double media = 0;
    boolean condicion = true;
    int i = 0;
    do {
      try {
        System.out.println("¿Cuantos numeros deseas introducir?");
        repeticion = Integer.parseInt(sc.nextLine());
        condicion = false;

        for (i = 0; i != repeticion; i++) {
          do {
            try {
              System.out.println("Introduce el numero " + (i + 1));
              numeros = Double.parseDouble(sc.nextLine());
              condicion = false;
              media = media + numeros;
            } catch (java.lang.NumberFormatException e) {
              System.out.println("El numero no es valido");
              condicion = true;
            }
            
            if (mayor == 0) {
              mayor = numeros;
            } else if (mayor < numeros) {
              mayor = numeros;
            }
            if (menor == 0) {
              menor = numeros;

            } else if (numeros < menor) {
              menor = numeros;

            }
          } while (condicion);
        }
      } catch (java.lang.NumberFormatException e2) {
        System.out.println("Ese numero no es valido");
        condicion = true;

      }
    } while (condicion);
    System.out.println("El numero mayor es " + mayor);
    System.out.println("El numero menor es " + menor);
    System.out.println("La media de los numeros es " + (media / repeticion));
  }
}
