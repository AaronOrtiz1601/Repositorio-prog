package prog.unidad03.repeticion;

public class CuadriculaDiezPorDiez {

  public static void main(String[] args) {
    int contador=0;
   for(int i=0;i<100;i++)
   {
     
     if (i<10)
     {
       System.out.print((i+1)+"  ");
       contador++;
     }else {
       System.out.print((i+1)+" ");
       contador++;
     }
     if (contador==10)
     {
       System.out.println();
       contador=0;
       
    
      
    }
       
   }

  }

}
