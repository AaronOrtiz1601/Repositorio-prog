import java.util.Scanner;

public class Personañ {

  public static void main(String[] args) {
    Scanner sc = new Scanner (System.in);
    Persona persona1=new Persona();
    persona1.edad=25;
    persona1.numeroHijos=0;
    persona1.peso=75.4;
    Persona persona2=new Persona();
    persona2.edad=65;
    persona2.numeroHijos=3;
    persona2.peso=65;
    System.out.println("La persona 1 tiene "+ (persona1.edad)+" años, pesa "+ (persona1.peso)+" kg y tiene "+ persona1.numeroHijos+" Hijos");
 boolean igual= (persona1==persona2);
 System.out.println(igual);
 
 //ejercicio 3
 
 Persona persona3= new Persona();
 persona3.edad=33;
 persona3.numeroHijos=1;
 persona3.peso=83.43;
 Persona persona4= persona3;
 persona4.peso=79.65;
 boolean edad=( persona3==persona4);
 System.out.println(persona3.edad);
 System.out.println(edad);
 System.out.println(persona3.peso);
 System.out.println(persona3.numeroHijos);
 System.out.println(persona4.edad);
 System.out.println(persona4.numeroHijos);
 System.out.println(persona4.peso);
 //ejercicio5= dara error al hacer un objeto nulo 
 int edad2;
 int hijos;
 double peso;
 edad2=Integer.parseInt(sc.nextLine());
 hijos=Integer.parseInt(sc.nextLine());
 peso=Double.parseDouble(sc.nextLine());
 Persona persona5= new Persona();
 persona5.edad=edad2;
 persona5.numeroHijos=hijos;
 persona5.peso=peso;
 System.out.println(persona5.edad);
 System.out.println(persona5.numeroHijos);
 System.out.println(persona5.peso);
 
 
 
  }

}
