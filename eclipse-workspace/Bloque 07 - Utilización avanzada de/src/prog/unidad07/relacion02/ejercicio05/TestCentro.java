package prog.unidad07.relacion02.ejercicio05;

import java.util.Scanner;

/**
 * Prueba la clase Centro
 */
public class TestCentro {
  private static Scanner sc;
  private static Centro centro;

  public static void main(String[] args) {
    // Creamos el centro
     centro = new Centro();
     sc=new Scanner (System.in);
    int opcion;
    
    do {
    System.out.println("GESTIÓN DE PERSONAS DEL CENTRO");
    System.out.println("------------------------------");
    System.out.println("1.-Alta de persona");
    System.out.println("2.-Baja de persona");
    System.out.println("3.-Listado de personas");
    System.out.println("4.-Nomina");
    System.out.println("0.-Salir");
    System.out.println("Introduzca la opción");
    opcion = Integer.parseInt(sc.nextLine());
    switch (opcion) {
    case 0:
      System.out.println("Hasta luego bro");
      break;
    case 1: 
      darDeAlta();
      break;
    case 2:
      System.out.println("Eliminar usuario");
      System.out.println("----------------");
      String dni;
      System.out.println("Dime el dni del usuario que quieres eliminar");
      dni = sc.nextLine();
      centro.baja(dni);
    case 3:
      System.out.println("Imprimir");
      System.out.println("--------");
      centro.imprimir();
      break;
    case 4:
      System.out.println("Imprimir Nomina");
      System.out.println("---------------");
      centro.imprimirNomina();
      break;
      
    
    
    }
    }while(opcion != 0);
    
  }
  private static void darDeAlta()
  {
    String cadenaAlta;
    System.out.println("¿Que tipo de persona quieres dar de alta?");
    System.out.println("Para dar de alta un Personal de Administración y Servicios introducca pas");
    System.out.println("Para dar de alta un Estudiante introduzca est");
    System.out.println("Para dar de alta un Profesor introduzca pro  ");
    System.out.print("Introduzca su sección:");
    cadenaAlta = sc.nextLine();
    if(cadenaAlta.equals("pas"))
    {
      centro.alta(altaPas());
    }else if(cadenaAlta.equals("est"))
    {
      centro.alta(altaEst());
    }else if (cadenaAlta.equals("pro"))
    {
      centro.alta(altaPro());
    }
    System.out.println("Alta realizada");
    
  }
  private static Persona altaPas() {
    String nombreEmpleado;
    String dni;
    String estadoCivil;
    int anyoIncorporación;
    String codigoDespacho;
    String seccion;
    int numeroDeHoras;
    System.out.print("Introduzca el nombre del empleado:");
    nombreEmpleado = sc.nextLine();
    System.out.print("Introduzca el dni del empleado:");
    dni = sc.nextLine();
    System.out.print("Introduzca el estado civil del empleado");
    estadoCivil = sc.nextLine();
    System.out.print("Introduzca el año de incorporación del empleado:");
    anyoIncorporación = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el despacho asignado al empleado:");
    codigoDespacho = sc.nextLine();
    System.out.print("Introduzca la sección a la que está asignado el empleado:");
    seccion = sc.nextLine();
    System.out.print("Introduzca el numero de horas que trabaja el empleado mensualmente:");
    numeroDeHoras = Integer.parseInt(sc.nextLine());
    Persona persona;
    return  persona = new AdministracionServicios(nombreEmpleado, dni, estadoCivil, anyoIncorporación, codigoDespacho, seccion, numeroDeHoras);
  }
  private static Persona altaEst()
  {
    String nombreEmpleado;
    String dni;
    String estadoCivil;
    String curso;
    System.out.print("Introduzca el nombre del empleado:");
    nombreEmpleado = sc.nextLine();
    System.out.print("Introduzca el dni del empleado:");
    dni = sc.nextLine();
    System.out.print("Introduzca el estado civil del empleado");
    estadoCivil = sc.nextLine();
    System.out.print("Introduzca el curso a la que está asignado el empleado:");
    curso = sc.nextLine();
   
    Persona persona;
    return  persona = new Estudiante(nombreEmpleado, dni, estadoCivil, curso);
  }
  private static Persona altaPro()
  {
    String nombreEmpleado;
    String dni;
    String estadoCivil;
    int anyoIncorporación;
    String codigoDespacho;
    String departamento;
    int salario;
    System.out.print("Introduzca el nombre del empleado:");
    nombreEmpleado = sc.nextLine();
    System.out.print("Introduzca el dni del empleado:");
    dni = sc.nextLine();
    System.out.print("Introduzca el estado civil del empleado");
    estadoCivil = sc.nextLine();
    System.out.print("Introduzca el año de incorporación del empleado:");
    anyoIncorporación = Integer.parseInt(sc.nextLine());
    System.out.print("Introduzca el despacho asignado al empleado:");
    codigoDespacho = sc.nextLine();
    System.out.print("Introduzca la departamento a la que está asignado el empleado:");
    departamento = sc.nextLine();
    System.out.print("Introduzca el numero de horas que trabaja el empleado mensualmente:");
    salario = Integer.parseInt(sc.nextLine());
    Persona persona;
    return  persona = new Profesor(nombreEmpleado, dni, estadoCivil, anyoIncorporación, codigoDespacho, departamento, salario);
  }
}
