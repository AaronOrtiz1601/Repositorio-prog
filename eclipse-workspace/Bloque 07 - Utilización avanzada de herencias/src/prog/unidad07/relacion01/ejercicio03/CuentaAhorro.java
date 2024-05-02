package prog.unidad07.relacion01.ejercicio03;

public class CuentaAhorro extends Cuenta {
  protected CuentaAhorro(String dni, String nombre) {
    super(dni, nombre);
  }
  private double penalizacionTotal;
  @Override
  public void retirarSaldo(double dineroARetirar)
  {
    if(dineroARetirar  >=0)
    {
      if ( saldoDeLaCuenta - dineroARetirar >= 0)
      {
      penalizacionTotal = penalizacionTotal + saldoDeLaCuenta * 20 / 100;
      saldoDeLaCuenta -= dineroARetirar;
      }else {
        throw new IllegalArgumentException();
      }
    
    }
  }
  @Override
  public void actualizacionMensual() {
      double interes = saldoDeLaCuenta * (15.0 / 12) / 100; // Corrección en el cálculo del interés
      interes = Math.round(interes * 100.0) / 100.0;
      if (saldoDeLaCuenta == 0) {
          // No es necesario establecer el saldo a 0 aquí, ya que si no se cumple ninguna de las condiciones, el saldo se restará por el interés más adelante.
      } else if((10) < (saldoDeLaCuenta * 10/100)) { // Corrección en la condición para verificar si el saldo es menor que el 10% del saldo
          saldoDeLaCuenta -= 10;
      } else {
          saldoDeLaCuenta -= saldoDeLaCuenta * 10 / 100;
      }
      saldoDeLaCuenta = Math.round(saldoDeLaCuenta * 100.0) / 100.0;
      if (saldoDeLaCuenta >= 0) {
          saldoDeLaCuenta +=interes;
      }
      
      saldoDeLaCuenta -= penalizacionTotal;
      penalizacionTotal = 0;
      saldoDeLaCuenta = Math.round(saldoDeLaCuenta * 100.0) / 100.0;
  }


  

}
