package prog.ud06.actividad611.coleccion;
/**
 * Clase Cliente
 * 
 * Clase que representa un cliente, almacenando sus datos personales como nombre, apellidos, DNI y edad.
 * Implementa la interfaz Comparable para permitir la comparación entre clientes.
 */
//Atributos que almacenan los datos del cliente
public class Cliente implements Comparable<Cliente> {
  private String nombre;
  private String apellidos;
  private String dni;
  private int edad;
  
  /**
   * Constructor de la clase Cliente.
   * 
   * @param nombre - Nombre de pila de la persona. No puede ser null, vacío o contener solo espacios.
   * @param apellidos - Apellidos de la persona. No puede ser null, vacío o contener solo espacios.
   * @param dni - DNI de la persona. Debe constar de 8 números y una letra, con la letra siendo mayúscula y válida.
   * @param edad - Edad de la persona. Debe ser 0 o superior.
   * @throws IllegalArgumentException - Si alguno de los parámetros no es correcto.
   */
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
  /**
   * Metodo que devuelve el nombre
   * @return nombre
   */
  public String getNombre() {
    return nombre;
  }
  /**
   * Metodo que devuelve los apellidos
   * @return apellidos
   */
  public String getApellidos() {
    return apellidos;
  }
  /**
   * Metodo que devuelve el DNI
   * @return DNI
   */
  public String getDni() {
    return dni;
  }
  /**
   * Metodo que devuelve la edad
   * @return Edad
   */
  public int getEdad() {
    return edad;
  }
  /**
   * metodo para comparar clientes por apellidos
   */
  public int compareTo(Cliente o)
  {
    return this.apellidos.compareTo(o.getApellidos());
  }
  //Metodo privado que comprueba si el nombre esta bien introducido
  private boolean comprobarNombre(String nombre)
  {
   boolean prueba = false;
   if (nombre != null && !nombre.isBlank())
   {
     prueba = true;
   }
    return prueba;
  }
  //Metodo privado que comprueba si los apellidos tienen un formato correcto 
  private boolean comprobarApellidos(String apellidos)
  {
    boolean prueba = false;
    if (apellidos != null && !apellidos.isBlank())
    {
      prueba = true;
    }
     return prueba;
  }
  //Metodo privado que comprueba si la edad ha sido bien introducida
  private boolean comprobarEdad(int edad)
  {
    boolean prueba = false;
    if(edad >=0)
    {
      prueba = true;
    }
    return prueba;
  }
  //Metodo privado que comprueba si el dni sigue el formato requerido y si la letra es correcta
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
