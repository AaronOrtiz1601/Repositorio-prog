package prog.unidad04.actividad406.libreria;
import java.util.Scanner;

public class pruebamatricula {

  public static void main(String[] args) {
      Scanner sc = new Scanner(System.in);
      System.out.println("Introduce la matrícula: ");
      String matricula = sc.nextLine(); 
      matricula=matricula.replaceAll("\\s", "");
      String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
      boolean esValida = true;

      
      if (matricula.length()!= 7) {
        esValida = false;
      } else {
        
        for (int i = 0; i < 4; i++) {
          char caracter = matricula.charAt(i);
          if (!Character.isDigit(caracter)) {
            esValida = false;
           throw new IllegalArgumentException();
          }
        }
        
        for (int i = 4; i < 7; i++) {
          String nueva = String.valueOf(matricula.charAt(i));
          if (!abecedario.contains(nueva)) {
            esValida = false;
            throw new IllegalArgumentException();
          }
        }
      }

      if (esValida == true) {
        System.out.println("La matrícula es válida.");
      } else {
        System.out.println("La matrícula es inválida.");
      }
    }

  }


