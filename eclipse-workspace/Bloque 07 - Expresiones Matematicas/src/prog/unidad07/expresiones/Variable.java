package prog.unidad07.expresiones;

public class Variable extends Expresiones {
  
  private String letra;

  public Variable(String letra, int valor) {
    this.valor = valor;
    this.letra = letra;
    
  }

  @Override
  public double getValor() {
    return valor;
  }
  

}
