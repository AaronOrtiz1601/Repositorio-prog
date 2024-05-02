package prog.unidad07.expresiones;

public class Resto extends OperacionesBinarias{

  public Resto (double valor, double valor2) throws ExpresionException{
    this.valor = valor;
    if (valor2 != 0)
    {
    this.valor2 = valor2;
    }else
    {
      throw new ExpresionException();
    }
    resultado = operacionResto(this.valor, this.valor2);
  }
  private double operacionResto(double valor, double valor2)
  {
    return valor % valor2;
  }

}
