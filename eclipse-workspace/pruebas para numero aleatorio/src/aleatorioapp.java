import java.util.Random;
public class aleatorioapp {

  public static void main(String[] args) {
    Random random = new Random();
    String cadena="";
    int resultado;
    int resto;
    for(int i=0 ;i<8;i++)
    {
      
    
    int numeroAleatorio = random.nextInt(10); 

     cadena = cadena+String.valueOf(numeroAleatorio);
   
    }
    System.out.println("Número aleatorio: " + cadena);
    resultado=Integer.parseInt(cadena);
    System.out.println(resultado);
    resto=resultado%23;
    System.out.println(resto);
    switch(resto) {
    case 0:
      cadena=cadena+'T';
      System.out.println("El dni es "+cadena);
      break;
    case 1:
      cadena=cadena+'R';
      System.out.println("El dni es "+cadena);
      break;
    case 2:
      cadena=cadena+'W';
      System.out.println("El dni es "+cadena);
      break;
    case 3:
      cadena=cadena+'A';
      System.out.println("El dni es "+cadena);
      break;
    case 4 :
      cadena=cadena+'G';
      System.out.println("El dni es "+cadena);
      break;
    case 5:
      cadena=cadena+'M';
      System.out.println("El dni es "+cadena);
      break;
    case 6:
      cadena=cadena+'Y';
      System.out.println("El dni es "+cadena);
      break;
    case 7:
      cadena=cadena+'F';
      System.out.println("El dni es "+cadena);
      break;
    case 8:
      cadena=cadena+'P';
      System.out.println("El dni es "+cadena);
      break;
    case 9:
      cadena=cadena+'D';
      System.out.println("El dni es "+cadena);
      break;
    case 10:
      cadena=cadena+'X';
      System.out.println("El dni es "+cadena);
      break;
    case 11:
      cadena=cadena+'B';
      System.out.println("El dni es "+cadena);
      break;
    case 12:
      cadena=cadena+'N';
      System.out.println("El dni es "+cadena);
      break;
    case 13:
      cadena=cadena+'J';
      System.out.println("El dni es "+cadena);
      break;
    case 14:
      cadena=cadena+'Z';
      System.out.println("El dni es "+cadena);
      break;
    case 15:
      cadena=cadena+'S';
      System.out.println("El dni es "+cadena);
      break;
    case 16:
      cadena=cadena+'Q';
      System.out.println("El dni es "+cadena);
      break;
    case 17:
      cadena=cadena+'V';
      System.out.println("El dni es "+cadena);
      break;
    case 18:
      cadena=cadena+'H';
      System.out.println("El dni es "+cadena);
      break;
    case 19:
      cadena=cadena+'L';
      System.out.println("El dni es "+cadena);
      break;
    case 20:
      cadena=cadena+'C';
      System.out.println("El dni es "+cadena);
      break;
    case 21:
      cadena=cadena+'K';
      System.out.println("El dni es "+cadena);
      break;
    case 22:
      cadena=cadena+'E';
      System.out.println("El dni es "+cadena);
      break;
      
    }
    
    System.out.println(cadena);
    

  }

}
