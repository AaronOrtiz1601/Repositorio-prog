import java.util.Scanner;

public class ejtm {

  public static void main(String[] args) {
    Scanner sc = new Scanner(System.in);
   double mayor=0;
   double medio=0;
   double menor=0;
   double numero;
   double numero2;
   for(int i=0;i<2;i++)
   {
     System.out.println("Introduce un numero");
     numero=Double.parseDouble(sc.nextLine());
     if((numero>mayor)||(mayor==0))
     {
       mayor=numero;
     
     }
     if((numero<menor)||(menor==0))
     {
       menor=numero;
     }
  
   }
   System.out.println("Introduce un numero");
   numero2=Double.parseDouble(sc.nextLine());
   if((numero2<mayor)&&(numero2>menor))
   {
     medio=numero2;
   }else if((numero2>menor)&&(numero2>mayor))
   {
     medio=mayor;
     mayor=numero2;
   }else if ((numero2<menor)&&(numero2<mayor))
   {
     medio=menor;
     menor=numero2;
   }
   System.out.println(mayor+" "+medio+" "+menor);

}
}
