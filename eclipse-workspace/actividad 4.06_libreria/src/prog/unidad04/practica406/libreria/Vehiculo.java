package prog.unidad04.practica406.libreria;

public class Vehiculo  implements ConvertibleATexto{
  protected Fecha fechaMatriculacion;
  protected String matricula;
  protected static int vehiculosMatriculados;
  
  protected Vehiculo(String matricula,Fecha fechaMatriculacion) 
  {
    boolean prueba=false;
    
    
     if(matriculaCorrecta(matricula) == true)
     {
    this.matricula = matricula;
     }
     else 
     {
       throw new IllegalArgumentException();
     }
     if ( fechaMatriculacion == null)
     {
       throw new IllegalArgumentException();
     }
     else
     {
       this.fechaMatriculacion=fechaMatriculacion;
       vehiculosMatriculados++;
     }
    
    
    
  }

  public Fecha getFechaMatriculacion() {
    return fechaMatriculacion;
  }

  public String getMatricula() {
    return matricula;
  }

  @Override
  public String aTexto() {
    // TODO Auto-generated method stub
    return null;
  }

  public static int getVehiculosMatriculados() {
    return vehiculosMatriculados;
  }
  private boolean matriculaCorrecta(String matricula)
  {
    String matriculaSinEspacios;
    matriculaSinEspacios = matricula.replaceAll("\\s", "");
    String abecedario = "ABCDEFGHIJKLMNÑOPQRSTUVWXYZ";
    boolean esValida = true;

    
    if (matriculaSinEspacios.length()!= 7) {
      esValida = false;
    } else {
      
      for (int i = 0; i < 4; i++) {
        char caracter = matriculaSinEspacios.charAt(i);
        if (!Character.isDigit(caracter)) {
          esValida = false;
         throw new IllegalArgumentException();
        }
      }
      
      for (int i = 4; i < 7; i++) {
        String prueba = String.valueOf(matriculaSinEspacios.charAt(i));
        if (!abecedario.contains(prueba)) {
          esValida = false;
          throw new IllegalArgumentException();
        }
      }
    }

    
    return esValida;
    
  }

  

}
