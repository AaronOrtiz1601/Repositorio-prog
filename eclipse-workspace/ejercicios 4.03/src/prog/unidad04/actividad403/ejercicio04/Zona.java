package prog.unidad04.actividad403.ejercicio04;

public class Zona {
  private  int entradasMax;
  

  public Zona(int entradas)
  {
   entradasMax=entradas;
  }
  public int vender(int compra)
  {
    int comprobar;
    comprobar=entradasMax-compra;
     if(comprobar<0)
     {
       throw new IllegalArgumentException();
     }else
     {
       entradasMax=entradasMax-compra;
       System.out.println("Venta realizada correctamente");
     }
     return compra;
  }
  public int getEntradasPorVender()
  {
    return entradasMax;
  }
}
