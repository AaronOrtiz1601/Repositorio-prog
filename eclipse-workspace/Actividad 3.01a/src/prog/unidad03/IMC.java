package prog.unidad03;

import java.util.Scanner;

public class IMC {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    double peso;
    double altura;
    double imc;
    System.out.println("Dime tu peso");
    peso=Double.parseDouble(sc.nextLine());
    System.out.println("Dime tu altura ");
    altura=Double.parseDouble(sc.nextLine());
    imc=peso/(altura*altura);
    System.out.println("Su imc es "+ imc);
    if (imc<16) {
      System.out.println("Ingreso a hospital por infrapeso");
      
    }else if ((16<=imc)&&(17>imc)){
      System.out.println(" infrapeso");
      
    }else if ((17<=imc)&&(18>imc)) {
      System.out.println(" bajopeso");
    }else if ((18<=imc)&&(25>imc)) {
      System.out.println("Peso normal(saludable)");
    }else if ((25<=imc)&&(30>imc)) {
      System.out.println("Sobre peso grado1");
    }else if ((30<=imc)&&(35>imc)) {
      System.out.println("Sobre peso grado cronico");
    }else if ((35<=imc)&&(40>imc)) {
      System.out.println("obresidad premorbida");
    }else {
      System.out.println("Obesidad mobidad");
    }
    
    

  }

}
