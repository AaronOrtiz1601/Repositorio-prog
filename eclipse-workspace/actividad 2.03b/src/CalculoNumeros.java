import java.util.Scanner;

public class CalculoNumeros {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double parteReal ;
    double parteImaginaria;
    System.out.println("Dime la parte real del complejo");
    parteReal=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la parte imaginaria del complejo");
    parteImaginaria=Double.parseDouble(sc.nextLine());
    Complejo complejo1= new Complejo(parteReal,parteImaginaria);
    System.out.println("Dime la parte real del complejo");
    //reciclo la variable por que al crear el objeto ya el dato se ha guardado.
    parteReal=Double.parseDouble(sc.nextLine());
    System.out.println("Dime la parte imaginaria del complejo");
    parteImaginaria=Double.parseDouble(sc.nextLine());
    Complejo complejo2= new Complejo(parteReal,parteImaginaria);
    System.out.println(complejo2.getParteReal());
    System.out.println(complejo2.getParteImaginaria());
    Complejo suma= complejo1.sumar(complejo2);
    System.out.println("La suma de las partea reales del los complejos es " +suma.getParteReal()+" La suma de las partes imaginarias del los complejos es " +suma.getParteImaginaria()+"i");
    Complejo resta=complejo1.restar(complejo2);
    System.out.println("La  resta de las partes reales del los complejos es " +resta.getParteReal()+" La resta de las partes imaginarias de los complejos es " +resta.getParteImaginaria()+"i");
    Complejo multiplicacion=complejo1.multiplicar(complejo2);
    System.out.println("El producto de las partes reales del los complejos es " +multiplicacion.getParteReal()+" El producto de las partes imaginarias de los complejos es " +multiplicacion.getParteImaginaria()+"i");
    Complejo division=complejo1.dividir(complejo2);
    System.out.println("La division de las partes reales del los complejos es " +division.getParteReal()+" La division de las partes imaginarias de los complejos es " +division.getParteImaginaria()+"i");


  }

}
