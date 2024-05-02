package prog.unidad07.relacion01.ejercicio03;

public class CuentaAbierta extends CuentaInteres {
  
  protected CuentaAbierta(String dni, String nombre) {
    super(dni, nombre);
  }

  private int contadorDeTransacciones = 0;
  private boolean prueba2 = false;
  
  @Override
  public void anyadirSaldo(double dineroAAnyadir)
  {
    if (dineroAAnyadir >= 0)
    {
      saldoDeLaCuenta += dineroAAnyadir;
      contadorDeTransacciones++;
      prueba2 = true;
    }

  }
  @Override
  public void retirarSaldo(double dineroARetirar)
  {
    if(saldoDeLaCuenta >= 100)
    {
      prueba = true;
    }
    if(dineroARetirar  >=0)
    {
     if ( saldoDeLaCuenta - dineroARetirar >= 0)
     {
       saldoDeLaCuenta -= dineroARetirar;
       contadorDeTransacciones++;
       prueba2 = true;
     }else
     {
      throw new IllegalArgumentException();
     }
    }
  }
  
  @Override
  public void actualizacionMensual() {
    double interes =  saldoDeLaCuenta * 7 /12 / 100;
    if (saldoDeLaCuenta < 100 && prueba == true)
    {
      saldoDeLaCuenta -= 10;
    }
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
    saldoDeLaCuenta += interes;
    }
    if (prueba2)
    {
    saldoDeLaCuenta -= contadorDeTransacciones * 0.10;
    prueba2 = false;
    }
    saldoDeLaCuenta = Math.round(saldoDeLaCuenta * 100.0) / 100.0;
    contadorDeTransacciones = 0;
  }

}

