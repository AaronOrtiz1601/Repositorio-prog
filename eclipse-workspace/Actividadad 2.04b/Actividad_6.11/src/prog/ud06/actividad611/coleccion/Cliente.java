package prog.ud06.actividad611.coleccion;

public class Cliente implements Comparable<Cliente> {
  private String nombre;
  private String apellidos;
  private String dni;
  private int edad;
  
  public Cliente(String nombre, String apellidos,String dni, int edad) 
  {
    
    if(comprobarNombre(nombre))
    {
      this.nombre = nombre;
    }else
    {
      throw new IllegalArgumentException();
    }
    if(comprobarApellidos(apellidos))
    {
      this.apellidos = apellidos;
    }else
    {
      throw new IllegalArgumentException();
    }
    if(comprobarEdad(edad))
    {
      this.edad = edad;
    }else
    {
      throw new IllegalArgumentException();
    }
    if(comprobarDni(dni))
    {
      this.dni = dni;
    }else
    {
      throw new IllegalArgumentException();
    }
    
  }

  public String getNombre() {
    return nombre;
  }

  public String getApellidos() {
    return apellidos;
  }

  public String getDni() {
    return dni;
  }

  public int getEdad() {
    return edad;
  }
  public int compareTo(Cliente o)
  {
    return this.apellidos.compareTo(o.getApellidos());
  }
  private boolean comprobarNombre(String nombre)
  {
   boolean prueba = false;
   if (nombre != null && !nombre.isBlank())
   {
     prueba = true;
   }
    return prueba;
  }
  private boolean comprobarApellidos(String apellidos)
  {
    boolean prueba = false;
    if (apellidos != null && !apellidos.isBlank())
    {
      prueba = true;
    }
     return prueba;
  }
  private boolean comprobarEdad(int edad)
  {
    boolean prueba = false;
    if(edad >=0)
    {
      prueba = true;
    }
    return prueba;
  }
  private boolean comprobarDni(String dni)
  {
    boolean prueba = false;
    String expresion = "^[0-9]{8}[A-Z]$";
    if(dni != null && dni.matches(expresion))
    {
      int letra;
      String dniComp = null;
    int dniSinLetra = Integer.parseInt(dni.substring(0,8));
    letra = dniSinLetra % 23;
    switch(letra) {
    case 0:
      dniComp=String.valueOf(dniSinLetra)+'T';
      break;
    case 1:
      dniComp=String.valueOf(dniSinLetra)+'R';
      break;
    case 2:
      dniComp=String.valueOf(dniSinLetra)+'W';
      break;
    case 3:
      dniComp=String.valueOf(dniSinLetra)+'A';
      break;
    case 4 :
      dniComp=String.valueOf(dniSinLetra)+'G';
      break;
    case 5:
      dniComp=String.valueOf(dniSinLetra)+'M';
      break;
    case 6:
      dniComp=String.valueOf(dniSinLetra)+'Y';
      break;
    case 7:
      dniComp=String.valueOf(dniSinLetra)+'F';
      break;
    case 8:
      dniComp=String.valueOf(dniSinLetra)+'P';
      break;
    case 9:
      dniComp=String.valueOf(dniSinLetra)+'D';
      break;
    case 10:
      dniComp=String.valueOf(dniSinLetra)+'X';
      break;
    case 11:
      dniComp=String.valueOf(dniSinLetra)+'B';
      break;
    case 12:
      dniComp=String.valueOf(dniSinLetra)+'N';
      break;
    case 13:
      dniComp=String.valueOf(dniSinLetra)+'J';
      break;
    case 14:
      dniComp=String.valueOf(dniSinLetra)+'Z';
      break;
    case 15:
      dniComp=String.valueOf(dniSinLetra)+'S';
      break;
    case 16:
      dniComp=String.valueOf(dniSinLetra)+'Q';
      break;
    case 17:
      dniComp=String.valueOf(dniSinLetra)+'V';
      break;
    case 18:
      dniComp=String.valueOf(dniSinLetra)+'H';
      break;
    case 19:
      dniComp=String.valueOf(dniSinLetra)+'L';
      break;
    case 20:
      dniComp=String.valueOf(dniSinLetra)+'C';
      break;
    case 21:
      dniComp=String.valueOf(dniSinLetra)+'K';
      break;
    case 22:
      dniComp=String.valueOf(dniSinLetra)+'E';
      break;
      
    }
    if(dniComp.equals(dni))
    {
      prueba = true;
    }
    }
    
    return prueba;
  }
}
