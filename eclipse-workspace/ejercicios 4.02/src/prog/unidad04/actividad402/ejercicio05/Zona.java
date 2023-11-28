package prog.unidad04.actividad402.ejercicio05;

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
       compra=0;
       System.out.println("No se puedo realizar la venta correctamente,probablemente no haya entradas suficientes");
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
