package javataller;

import java.util.Random;
import java.util.Scanner;

/**
 * Clase que simula una partida de pinball y la puntuación resultante
 * 
 * @author Aarón Ortiz Sánchez
 */
public class Ball {

  private static final Random RANDOM = new Random();

  /**
   * Metodo que inicia la partida y de forma aleatoria va generando situaciones en las que ganas x puntos
   * @return puntuacion obtenida
   */
  public static double launchAndStart() {

    // Variables del metodo
    double points = 0;
    int bonus = 1;

    // Metodo privado que ejecuta el juego
    points = game(points, bonus);

    // Calculo de la puntuacion final
    points *= bonus;
    return points;
  }

  /**
   * Metodo que sirve para no tener que escribir todo el rato los syso
   * @param message
   */
  private static void showScreen(String message) {
    System.out.println(message);
  }

  private static double game(double points, int bonus) {
    int randomNumber = 0;
    String pausa = "";
    Scanner sc = new Scanner(System.in);
  
      do {
        // Generación del número aleatorio
        randomNumber = RANDOM.nextInt(1001) - 500;
        // Situaciones generas atraves del numero aleatorio
        if (randomNumber > -500 && randomNumber < -450) {
          showScreen("La bola ha empezado a rebotar y ha caido en un agujero negro, has perdido 1/3 de tus puntos...");
          points /= 3;

        } else if (randomNumber >= -450 && randomNumber < -200) {
          showScreen("La bola ha empezado a rebotar y se ha estrellado con la muralla china, has perdido la mitad de tus puntos...");
          points /= 2;

        } else if (randomNumber >= -200 && randomNumber <= -1) {
          showScreen("La bola ha escapado entre las paletas, la partida ha terminado.");
          break;

        } else if (randomNumber >= 1 && randomNumber <= 50) {
          showScreen("La bola es golpeada por la paleta (por los pelos), despues de eso la bola rebota un par de veces y vuelve hacia abajo");
          points += randomNumber;

        } else if (randomNumber > 50 && randomNumber <= 200) {
          showScreen("La bola es golpeada con fuerza, entre rebote y rebote la bola se da una vuelta por París y después empieza a volver");
          points += randomNumber * 1.5;

        } else if (randomNumber > 200 && randomNumber <= 450) {
          showScreen("Guay, se nota que vas al gimnasio, la bola ha sido golpeada con una fuerza increíble, ahora mismo está dando la vuelta al mundo, en un rato volverá");
          points += randomNumber * 2;

        } else {
          showScreen("Illoooo, donde vas, que has mandao la bola a la luna, mientras cae y tal fijate bien, que esta te trae un regalo, es un bonus, tu puntuacion final se multiplicara por el número de bonus que tengas");
          points += randomNumber * 2;

          // En el caso de que salga la mejor situación, al final de la partida tendrás un bonus
          bonus += 1;
        }

        // Condición que sirve para hacer una pausa y que no salga todo de golpe, además de simular mediante el intro el golpe con la paleta
        if (randomNumber > 0) {
          showScreen("Corre, vuelve a golpear la bola con la paleta (Dale al intro)");
          pausa = sc.nextLine();
        }
      } while (points > 0 && !pausa.equalsIgnoreCase("exit"));
    
    return points;
  }

}
