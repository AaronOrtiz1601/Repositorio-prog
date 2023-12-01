import java.util.Random;
public class NumerosAleatorios {

  public static void main(String[] args) {
    int i = 1;
    int numeroAleatorio = 0;
    for(i = 1; i <=20; i++) {
      Random rand = new Random();
      numeroAleatorio = rand.nextInt(10) + 1;
      System.out.println("Número aleatorio generado " + i + ": " + numeroAleatorio);
    }
  }

}
