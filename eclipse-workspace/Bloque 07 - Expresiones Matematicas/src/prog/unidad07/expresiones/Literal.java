package prog.unidad07.expresiones;

public class Literal extends Expresiones {

  public Literal(double valor) {
    this.valor = valor;
    
  }

  @Override
  public double getValor() {
    return valor;
  }

}
