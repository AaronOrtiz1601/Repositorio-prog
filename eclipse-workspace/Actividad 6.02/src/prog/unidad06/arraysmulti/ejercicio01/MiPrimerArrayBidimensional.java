package prog.unidad06.arraysmulti.ejercicio01;

public class MiPrimerArrayBidimensional {

  public static void main(String[] args) {
    int [][] array = new int [3][6];
    array[0][0] = 35;
    array [0][2] = 64;
    array[0][3] = 69;
    array [0][5] = 93;
    array[1][1] = 12;
    array [1][4] = 92;
    array [2][0] = 13;
    array[2][2] = 33;
    array [2][4] = 52;
    System.out.println("MI PRIMER ARRAY BIDIMENSIONAL");
    for (int i = 0; i < 3;i++){
      int contador = 0;
      for (int j = 0; j < 6;j++)
      {
        contador ++;
        System.out.print(String.format("%5d", array[i][j]));
        if (contador ==6)
        {
          System.out.println("");
        }
        
      }
    }

  }

}
