package prog.unidad06.arraysmulti.ejercicio02;

public class TablaEnteraConTotales {
private int filas;
private int columnas;
private int [][] array;


 public TablaEnteraConTotales(int filas,int columnas)
{
  if (filas < 1 || columnas < 1)
  {
    throw new IllegalArgumentException();
  }else
  {
    this.filas=filas;
    this.columnas=columnas;
  }
   array = new int [this.filas][this.columnas];
}
 public void setCasilla (int filas,int columna,int valor)
 {
   if ((filas <= this.filas && filas >=  0)&&(columna <= this.columnas && columna >=  0))
   {
     
   array [filas][columna] = valor;
   }else
   {
     throw new ArrayIndexOutOfBoundsException();
   }
 
   }
 public int getCasilla(int filas, int columna)
 {
   if ((filas > this.filas || filas < 1)&&(columna > this.columnas && columna < 1))
   {
     throw new ArrayIndexOutOfBoundsException();
   }
   
   return array [filas][columna];
   
 }
 public int getTotalFila(int filas)
 {
   int suma = 0;
   if (filas > this.filas || filas < 0)
   {
     throw new ArrayIndexOutOfBoundsException();
   }else
   {
     for (int i = 0; i < columnas;i++){
       suma = suma + array [filas][i];
   }
  
 }
   return suma ;
}

public int getTotalColumna(int columna)
{
  int suma = 0;
  if (columna > this.columnas || columna < 0)
  {
    throw new ArrayIndexOutOfBoundsException();
  }else
  {
    for (int i = 0; i < filas;i++){
      suma = suma + array [i][columna];
  }
 
}
  return suma ;
}

public int getTotalTabla()
{
  int suma = 0;

  
  for (int i = 0; i < this.filas;i++){
    for (int j = 0; j < this.columnas;j++)
    {
      suma = suma + array [i][j];
    }
 

  
}
  return suma ;
}
}
