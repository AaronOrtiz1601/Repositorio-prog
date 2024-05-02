package prog.unidad07.relacion01.ejercicio03;

public class CuentaInteres extends Cuenta {
  
  protected CuentaInteres(String dni, String nombre) {
    super(dni, nombre);
  }

  @Override
  public void actualizacionMensual() {
    double interes =  saldoDeLaCuenta * 7 /12 / 100;
    if (saldoDeLaCuenta == 0)
    {
      saldoDeLaCuenta = 0;
    }else if((10) < (saldoDeLaCuenta * 10/100))
    {
      saldoDeLaCuenta -= 10;
      
    }else
    {
      saldoDeLaCuenta -= saldoDeLaCuenta * 10 / 100;
     
    }
    saldoDeLaCuenta = Math.round(saldoDeLaCuenta * 100.0) / 100.0;
    if( saldoDeLaCuenta >= 0)
    {
      
      saldoDeLaCuenta  += interes;
      saldoDeLaCuenta = Math.round(saldoDeLaCuenta * 100.0) / 100.0;
    }
  }

}
