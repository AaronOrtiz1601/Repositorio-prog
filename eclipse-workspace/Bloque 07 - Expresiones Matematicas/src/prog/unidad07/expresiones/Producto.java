package prog.unidad07.expresiones;

public class Producto extends OperacionesBinarias{

  public Producto(double valor, double valor2) {
    this.valor = valor;
    this.valor2 = valor2;
    resultado = operacionProducto(this.valor, this.valor2);
  }
  private double operacionProducto(double valor, double valor2)
  {
    return valor * valor2;
  }
  

}
