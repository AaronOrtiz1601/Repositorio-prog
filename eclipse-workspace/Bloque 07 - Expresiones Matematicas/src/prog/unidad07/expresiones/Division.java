package prog.unidad07.expresiones;

public class Division extends OperacionesBinarias {

  public Division(double valor, double valor2) throws ExpresionException {
    this.valor = valor;
    if (valor2 != 0)
    {
    this.valor2 = valor2;
    }else
    {
      throw new ExpresionException();
    }
    resultado = operacionDivision(this.valor, this.valor2);
  }
  private int operacionDivision(double valor, double valor2)
  {
    return  (int) (valor / valor2);
  }

}
