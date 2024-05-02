package prog.unidad07.expresiones;

public class CambioSigno extends OperacionUnaria {
  

  public CambioSigno(double valor) {
    this.valor = valor;
    resultado = operacion(this.valor);
  }

  
  private double operacion(double valor)
  {
    return -this.valor;
  }

}
