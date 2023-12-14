package prog.unidad04.actividad403.ejercicio04.pruebas;

import java.util.Scanner;

import prog.unidad04.actividad403.ejercicio04.Zona;

public class VenderEntradasApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner(System.in);
    int opcion;
    System.out.println("GESTION DE ENTRADAS");
    System.out.println("-------------------");
    Zona ZonaPl =new Zona(150);
    Zona ZonaPal= new Zona(50);
    Zona ZonaAt= new Zona(100);
    do
    {
      System.out.println("1.-Mostrar asientos libres por zonas");
      System.out.println("2.-Vender asientos");
      System.out.println("3.Salir del programa");
      System.out.println("Elige una opcion(1,2 o 3)");
     opcion=Integer.parseInt(sc.nextLine());
    switch (opcion) {
    case 1:
    {
      System.out.println("Asientos por zona");
      System.out.println("Zona Platea "+ZonaPl.getEntradasPorVender());
      System.out.println("Zona Palco "+ZonaPal.getEntradasPorVender());
      System.out.println("Zona Ático "+ZonaAt.getEntradasPorVender());
      break;
    }
    
    case 2:
    {
      System.out.println("VENTA DE ENTRADAS");
      System.out.println("Seleccione la zona de la que quiera comprar las entradas");
      System.out.println("Elige una opcion 1(Platea),2(Palco) o 3(Ático)");
       int opcion2=Integer.parseInt(sc.nextLine());
      
      switch (opcion2) {
      case 1:
      {
        try {
        System.out.println("Dime el numero de entradas que quieres comprar");
        int entradas=Integer.parseInt(sc.nextLine());
        ZonaPl.vender(entradas);
        System.out.println("Procesando compra de entradas...");
      }catch (IllegalArgumentException e) {
        System.out.println("Error.La venta no ha podido realizarse por que no quedan entradas suficientes para ello");
      }
        break;
      }
      case 2:
      {
        try {
        System.out.println("Dime el numero de entradas que quieres comprar");
        int entradas=Integer.parseInt(sc.nextLine());
        ZonaPal.vender(entradas);
        System.out.println("Procesando compra de entradas...");
      }catch (IllegalArgumentException e) {
        System.out.println("Error.La venta no ha podido realizarse por que no quedan entradas suficientes para ello");
      }
        break;
      }
      case 3:
      {
       
      try
      {
        System.out.println("Dime el numero de entradas que quieres comprar");
        int entradas=Integer.parseInt(sc.nextLine());
        ZonaAt.vender(entradas);
        System.out.println("Procesando compra de entradas...");
      }catch (IllegalArgumentException e) {
        System.out.println("Error.La venta no ha podido realizarse por que no quedan entradas suficientes para ello");
      }
        
      }
        break;
      }
      
      default:
        System.out.println("Esa no es una opcion valida");
        break;
      
      }
      break;
    }
    case 3:
    {
      System.out.println("Saliendo del programa...");
      break;
    }
    default:
      System.out.println("Esa no es una opcion valida");
      break;
  
    
    }while(opcion!=3);
    }
  }


