package prog.unidad07.relacion01.ejercicio02;

import java.util.ArrayList;
import java.util.List;

public abstract class Empleado {
  private String nombreCompleto;
  private String dni;
  private String tfn;
  private List<Empleado> empleados = new ArrayList<>() ;
  
 

  protected Empleado (String nombreCompleto, String dni, String tfn){
    if (nombreCompleto == null)
    {
      throw new NullPointerException();
    }else if(comprobarNombre(nombreCompleto))
    {
      this.nombreCompleto = nombreCompleto;
    }
    if(dni == null )
    {
      throw new NullPointerException();
    }else if (comprobarNif(dni)) {
      this.dni = dni;
    }
    if(tfn == null )
    {
      throw new NullPointerException();
    }else if(comprobarTfn(tfn))
    {
      this.tfn = tfn;
    }
  }
  public  abstract  double getSalario();
  
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
  private boolean comprobarTfn (String tfn)
  {
    String comprobante = "^[1-9]{9}$";
    if(tfn.matches(comprobante))
    {
      return true;
    }else
    {
      return false;
    }
  }

  
}
