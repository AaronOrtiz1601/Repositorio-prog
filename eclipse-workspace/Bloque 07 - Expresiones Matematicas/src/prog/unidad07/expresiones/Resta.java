package prog.unidad07.expresiones;

public class Resta extends OperacionesBinarias {

  public Resta(double valor, double valor2) {
    this.valor = valor;
    this.valor2 = valor2;
    resultado = operacionResta(this.valor, this.valor2);
  }
  private double operacionResta(double valor, double valor2)
  {
    return valor - valor2;
  }
  

}
