package prog.unidad04.prueba;

import java.util.Scanner;
import prog.unidad04.atributoss.*;
public class PersonaPruebaApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    int numPersonas;
    System.out.println("Dime el numero de personas que quieres crear");
    
    numPersonas=Integer.parseInt(sc.nextLine());
    for(int i=0;i<=numPersonas;i++)
    {
      Persona persona=new Persona();
      persona.personas ++;
      System.out.println("Dime el nombre de la persona");
      persona.nombre=sc.nextLine();
      System.out.println("Dime la edad de la persona");
      persona.edad=Integer.parseInt(sc.nextLine());
      System.out.println("Introduce su DNI, debe tener 8 numeros y una letra");
      persona.DNI=sc.nextLine();
      System.out.println("Introduce el sexo de la persona, H para hombre y M para mujer");
      persona.sexo=sc.nextLine();
      if (persona.sexo.equals(persona.SEXO_H)||persona.sexo.equals(persona.SEXO_M)) {
        
      }else {
        System.out.println("error");
      }
      System.out.println("Introduce el peso de la persona");
      persona.peso=Double.parseDouble(sc.nextLine());
      System.out.println("Dime la altura de la persona");
      persona.altura=Double.parseDouble(sc.nextLine());
      System.out.println("El nombre de la persona es "+persona.nombre);
      System.out.println("La edad  de la persona es "+persona.edad);
      System.out.println("El DNI de la persona es "+persona.DNI);
      System.out.println("El sexo de la persona es "+persona.sexo);
      System.out.println("La altura  de la persona es "+persona.altura);
      System.out.println("El peso de la persona es "+persona.peso);
      System.out.println("El numero de personas creadas  es "+persona.personas);
    
    }
    
    
    

  }

  

}
