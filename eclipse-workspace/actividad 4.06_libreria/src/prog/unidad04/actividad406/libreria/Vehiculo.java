package prog.unidad04.actividad406.libreria;

public class Vehiculo {
  protected Fecha fechaMatriculacion;
  protected String matricula;
  protected static int vehiculosMatriculados;
  
  protected Vehiculo(String matricula,Fecha fechaMatriculacion) 
  {
    boolean prueba=false;
    do
    {
      matriculaCorrecta(matricula);
     if(matriculaCorrecta(matricula) == true)
     {
    this.matricula = matricula;
     }
     else 
     {
       throw new IllegalArgumentException();
     }
    this.fechaMatriculacion=fechaMatriculacion;
    }while(prueba!=true);
    vehiculosMatriculados++;
  }

  public Fecha getFechaMatriculacion() {
    return fechaMatriculacion;
  }

  public String getMatricula() {
    return matricula;
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

    if (esValida == true) {
      System.out.println("La matrícula es válida.");
    } else {
      System.out.println("La matrícula es inválida.");
    }
    
    return esValida;
    
  }
  

}
