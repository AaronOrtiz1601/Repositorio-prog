package prog.unidad03.repeticion;

public class TablasMultiplicarApp {

  public static void main(String[] args) {
    int i;
    int numero=1;
      for(int j=0;j<10;j++)
      {
        
      
    for( i=0;i<10;i++)
    {
      System.out.println("Tabla del "+numero);
      System.out.println(i+1+"*"+numero+"="+((i+1)*numero));
      
  }
    numero++;
  }
}
}


