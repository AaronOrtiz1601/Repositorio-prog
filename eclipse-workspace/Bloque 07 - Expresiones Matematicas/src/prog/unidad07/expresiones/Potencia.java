package prog.unidad07.expresiones;

public class Potencia extends OperacionesBinarias {

  public Potencia(double valor, double valor2) throws ExpresionException{
    this.valor = valor;
    if (valor2 > 0)
    {
    this.valor2 = valor2;
    }else
    {
      throw new ExpresionException();
    }
    resultado = operacionPotencia(this.valor, this.valor2);
  }
  private double operacionPotencia(double valor, double valor2)
  {
    return Math.pow(valor, valor2);
  }

}
