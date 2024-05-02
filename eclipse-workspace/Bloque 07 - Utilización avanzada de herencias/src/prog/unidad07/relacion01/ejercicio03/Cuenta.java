package prog.unidad07.relacion01.ejercicio03;

public class Cuenta {
  protected double saldoDeLaCuenta;
  protected boolean prueba = false;
  protected String dni;
  protected String nombre;
  
  protected Cuenta (String dni, String nombre)
  {
    if (nombre == null)
    {
      throw new NullPointerException();
    }else if(comprobarNombre(nombre))
    {
      this.nombre = nombre;
    }
    if(dni == null )
    {
      throw new NullPointerException();
    }else if (comprobarNif(dni)) {
      this.dni = dni;
    }
  }
  
  public void anyadirSaldo(double dineroAAnyadir)
  {
    if (dineroAAnyadir >= 0)
    {
      saldoDeLaCuenta += dineroAAnyadir;
    }

  }
  public void retirarSaldo(double dineroARetirar)
  {
    if(saldoDeLaCuenta >= 500)
    {
      prueba = true;
    }
    if(dineroARetirar  >=0)
    {
     if ( saldoDeLaCuenta - dineroARetirar > 0)
     {
       saldoDeLaCuenta -= dineroARetirar;
     }else
     {
      throw new IllegalArgumentException();
     }
    }
  }

  public double comprobarSaldoDeLaCuenta() {
    return saldoDeLaCuenta;
  }
  
  public void actualizacionMensual() {
    
    if (saldoDeLaCuenta < 500 && prueba )
    {
      saldoDeLaCuenta -= 10;
    }
    if (saldoDeLaCuenta == 0)
    {
      saldoDeLaCuenta = 0;
    } else if((saldoDeLaCuenta - 10) > (saldoDeLaCuenta * 10/100))
    {
      saldoDeLaCuenta -= 10;
    }else
    {
      saldoDeLaCuenta -= saldoDeLaCuenta * 10 / 100;
    }
    saldoDeLaCuenta = Math.round(saldoDeLaCuenta * 100.0) / 100.0;
  }
  private boolean comprobarNombre(String nombre) {
    // Creo una bandera y una expresión regular para comprobar el nombre
    boolean prueba = false;
    String expresion = "^[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+(?:\\s[A-ZÁÉÍÓÚÑ][a-záéíóúñ]+)*$";
    // Compruebo que el nombre no sea nulo, no este en blanco y cumpla con el patron
    // de la expresión regular, si la cumple la bandera sera verdadera
    if (nombre != null && nombre.matches(expresion) && !nombre.isBlank()) {
      prueba = true;
    }
    // Devuelvo la bandera
    return prueba;
  }
  private boolean comprobarNif(String dni) {
    // Creo una bandera y una expresión regular para comprobar el dni
    boolean prueba = false;
    String expresion = "^[0-9]{8}[A-Z]$";
    // Si el dni no es nulo y cumple con el patron de la expresion
    if (dni != null && dni.matches(expresion)) {
      // Declaro una variable entera para almacenar el resto de dividir los numeros
      // del dni/23
      int letra;
      // Para comprobar la letra he hecho un string con las letras que pueden salir
      // del dni ordenadas por resto
      String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
      // Saco del dni los numeros
      int dniSinLetra = Integer.parseInt(dni.substring(0, 8));
      // Calculo el resto
      letra = dniSinLetra % 23;
      // Hago un String con los numeros del dni y la letra que deberia tener ese
      // numero(esta letra ha sido encontrada por el resto de la division anterior que
      // ha hecho la funcion de posicion en el String de letras del dni)
      String dniComp = String.valueOf(dniSinLetra) + letras.charAt(letra);
      // Si el dni ha comprobar y el dni que hemos creado con la letra que deben tener
      // esos numeros son iguales entonces el dni es correcto
      if (dniComp.equals(dni)) {
        prueba = true;
      }
    }
    // Devuelvo la bandera
    return prueba;
  }

}
