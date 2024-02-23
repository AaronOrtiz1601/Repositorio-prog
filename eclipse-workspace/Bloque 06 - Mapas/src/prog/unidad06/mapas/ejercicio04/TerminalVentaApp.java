package prog.unidad06.mapas.ejercicio04;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;

public class TerminalVentaApp {

  public static void main(String[] args) {
    Scanner sc=new Scanner (System.in);
    String producto;
    int cantidad ;
    String codigoDesc;
    double precioTotal = 0;
    Map <String,Integer> cantidadTotal = new HashMap<>();
    cantidadTotal.put("avena", 0);
    cantidadTotal.put("garvanzos", 0);
    cantidadTotal.put("tomate", 0);
    cantidadTotal.put("jengibre", 0);
    cantidadTotal.put("quinoa", 0);
    cantidadTotal.put("guisantes", 0);
    Map<String, Double> productos = new HashMap<>();
    productos.put("avena", 2.21);
    productos.put("garvanzos", 1.59);
    productos.put("tomate", 1.59);
    productos.put("jengibre", 3.13);
    productos.put("quinoa", 4.50);
    productos.put("guisantes", 1.60);
    String vacio = "";
    do
    {
      
    
    System.out.println("Introduzca el nombre del producto (Vacío para terminar)");
    producto = sc.nextLine();
    if (!producto.equals(vacio))
{
    System.out.println("Introduzca la cantidad de producto comprada (número entero)");
    cantidad = Integer.parseInt(sc.nextLine());
    cantidad = cantidad + cantidadTotal.get(producto);
    cantidadTotal.put(producto, cantidad);
}
    }while (!producto.equals(vacio));
    
    
    Set<String> productosCon = productos.keySet();
    List<String> listaDeProductos = new ArrayList<>(productosCon);
    System.out.println("Producto Precio Cantidad Subtotal");
    System.out.println("---------------------------------");
    for (int i = 0 ; i < listaDeProductos.size();i++)
    {
      if (cantidadTotal.get(listaDeProductos.get(i)) != 0)
      {
     System.out.println( "producto: "+ listaDeProductos.get(i)); 
     System.out.println("Precio: " + productos.get(listaDeProductos.get(i)));
     System.out.println("Cantidad :  " + cantidadTotal.get(listaDeProductos.get(i)));
     System.out.println("Precio total por el producto :" + cantidadTotal.get(listaDeProductos.get(i)) * productos.get(listaDeProductos.get(i)));
     precioTotal = precioTotal+ cantidadTotal.get(listaDeProductos.get(i)) * productos.get(listaDeProductos.get(i));
      }
    }
    System.out.println();
    System.out.println("Introduzca un codigo de descuento (Vacío si no tiene ninguno)");
     codigoDesc = sc.nextLine();
     if (codigoDesc.equals("ECODTO"))
     {
       double descuento = (precioTotal*10)/100;
       System.out.println("Descuento: "+ descuento);
       System.out.println("El precio total es : " + (precioTotal-descuento));
     }else
     {
       System.out.println("Descuento: ");
       System.out.println("El precio total es : " + precioTotal);
     }
    
  }

}
