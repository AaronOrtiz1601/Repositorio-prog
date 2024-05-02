package prog.unidad07.expresiones;

public class Suma extends OperacionesBinarias {

  public Suma(double valor, double valor2) {
    this.valor = valor;
    this.valor2 = valor2;
    resultado = operacionSuma(this.valor, this.valor2);
  }
  private double operacionSuma(double valor, double valor2)
  {
    return valor + valor2;
  }

}
