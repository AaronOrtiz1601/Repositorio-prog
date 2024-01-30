package prog.unidad06.arraysuni.ejercicio09;

import prog.unidad06.arraysuni.ejercicio04.UtilidadesArrays;

public class DividirPorLaMedia {

  public static void main(String[] args) {
    int [] array =  UtilidadesArrays.generaArrayEnteroAleatorio(150, 300, 800);
    double [] nuvArray = new double[150];
    int media = 0 ;
    for (int i = 0 ; i < array.length;i++) {
      if (i != 149)
      {
      System.out.print(array[i] + ",");
      }else
      {
        System.out.print(array[i]);
      }
      media = array[i] + media;
      
    }
    media = media /150;
    for (int i = 0 ; i < nuvArray.length ;i++)
    {
      nuvArray[i] = (double) array[i] / media;
      if (i != 149)
      {
      System.out.print(nuvArray[i] + ",");
      }else
      {
        System.out.print(nuvArray[i]);
      }
    }
    

  }

}
