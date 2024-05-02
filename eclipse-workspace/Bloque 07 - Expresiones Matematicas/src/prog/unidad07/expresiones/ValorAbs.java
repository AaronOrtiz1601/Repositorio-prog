package prog.unidad07.expresiones;

public class ValorAbs extends OperacionUnaria {

  public ValorAbs(double valor) {
   this.valor = valor;
   resultado = operacion(this.valor);
  }
  private double operacion(double valor) {
    if(valor < 0)
    {
      valor = -valor;
    }
    return valor;
  }

}
