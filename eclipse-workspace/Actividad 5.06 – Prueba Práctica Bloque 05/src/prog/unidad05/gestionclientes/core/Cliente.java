package prog.unidad05.gestionclientes.core;

public class Cliente {

  // Atributos privados
  private String nif;
  private String apellidos;
  private String nombre;
  private int empleados;
  private double facturacion;
  private boolean nacionalUe;

  /**
   * Constructor de la clase clientes
   * 
   * @param nif.         Debera tener 8 números y 1 letra mayuscula, esta letra debera ser la que le corresponda a esos números
   * @param apellidos.   Cada palabra debera empezar con mayuscula
   * @param nombre.      Igual que los apellidos
   * @param empleados.   Debera ser un entero superior a 0
   * @param facturacion. Debera ser un número real superior a 0
   * @param nacionalUe.  Booleano que indica si pertenece a la UE o no
   * @throws IllegalArgumentException. Lanza esta excepción si alguno de los valores no es correcto
   */
  public Cliente(String nif, String apellidos, String nombre, int empleados, double facturacion, boolean nacionalUe) {
    // Compruebo si el dni es correcto, si lo es le paso el valor al atributo y si
    // no lo es lanzo una excepción
    if (comprobarNif(nif)) {
      this.nif = nif;
    } else {
      throw new IllegalArgumentException();
    }
    // Compruebo si el nombre es correcto, si lo es le paso el valor al atributo y
    // si no lo es lanzo una excepción
    if (comprobarNombre(nombre)) {
      this.nombre = nombre;
    } else {
      throw new IllegalArgumentException();
    }

//Compruebo si el apellidos es correcto, si lo es le paso el valor al atributo y si no lo es lanzo una excepción
    if (comprobarApellidos(apellidos)) {
      this.apellidos = apellidos;
    } else {
      throw new IllegalArgumentException();
    }
//Compruebo si el empleados es correcto, si lo es le paso el valor al atributo y si no lo es lanzo una excepción
    if (comprobarEmpleados(empleados)) {
      this.empleados = empleados;
    } else {
      throw new IllegalArgumentException();
    }
//Compruebo si el facturación es correcto, si lo es le paso el valor al atributo y si no lo es lanzo una excepción
    if (comprobarFacturacion(facturacion)) {
      this.facturacion = facturacion;
    } else {
      throw new IllegalArgumentException();
    }
//Paso el valor al atributo
    this.nacionalUe = nacionalUe;

  }

  /**
   * Metodo que devuelve el dni
   * 
   * @return devuelve el dni
   */
  public String getNif() {
    // Metodo que devuelve el dni
    return nif;
  }

  /**
   * Metodo que devuelve los apellidos
   * 
   * @return devuelve los apellidos
   */
  public String getApellidos() {
    // Metodo que devuelve el apellidos
    return apellidos;
  }

  /**
   * Metodo que devuelve el nombre
   * 
   * @return devuelve el nombre
   */
  public String getNombre() {
    // Metodo que devuelve el nombre
    return nombre;
  }

  /**
   * Metodo que devuelve los empleados
   * 
   * @return devuelve los empleados
   */
  public int getEmpleados() {
    // Metodo que devuelve el empleados
    return empleados;
  }

  /**
   * Metodo que devuelve la facturacion
   * 
   * @return devuelve la facturacion
   */
  public double getFacturacion() {
    // Metodo que devuelve el facturación
    return facturacion;
  }

  /**
   * Metodo que devuelve si eres miembro de la union europea o no
   * 
   * @return devuelve si eres miembro de la union europea o no
   */
  public boolean isNacionalUe() {
    // Metodo que devuelve la nacionalidad
    return nacionalUe;
  }

  /**
   * Metodo privado que coprueba el nombre
   * 
   * @param nombre
   * @return devulve un booleano que indica si el nombre es correcto
   */
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

  /**
   * Metodo privado que coprueba los apellidos
   * 
   * @param apellidos
   * @return devulve un booleano que indica si los apellidos son correctos
   */
  private boolean comprobarApellidos(String apellidos) {
    // Creo una bandera y una expresión regular para comprobar los apellidos
    boolean prueba = false;
    String expresion = "^[A-Z][a-záéíóúñ]+(\\s[A-Z][a-záéíóúñ]+)*$";
    // Compruebo que los apellidos no sea nulo, no este en blanco y cumpla con el
    // patron de la expresión regular, si la cumple la bandera sera verdadera
    if (apellidos != null && apellidos.matches(expresion) && !apellidos.isBlank()) {
      prueba = true;
    }
    // Devuelvo la bandera
    return prueba;
  }

  /**
   * Metodo privado que comprueba si el dni es correcto
   * 
   * @param nif
   * @return devuelve un booleano que indica si el dni es correcto o no
   */

  private boolean comprobarNif(String nif) {
    // Creo una bandera y una expresión regular para comprobar el dni
    boolean prueba = false;
    String expresion = "^[0-9]{8}[A-Z]$";
    // Si el dni no es nulo y cumple con el patron de la expresion
    if (nif != null && nif.matches(expresion)) {
      // Declaro una variable entera para almacenar el resto de dividir los numeros
      // del dni/23
      int letra;
      // Para comprobar la letra he hecho un string con las letras que pueden salir
      // del dni ordenadas por resto
      String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
      // Saco del dni los numeros
      int dniSinLetra = Integer.parseInt(nif.substring(0, 8));
      // Calculo el resto
      letra = dniSinLetra % 23;
      // Hago un String con los numeros del dni y la letra que deberia tener ese
      // numero(esta letra ha sido encontrada por el resto de la division anterior que
      // ha hecho la funcion de posicion en el String de letras del dni)
      String dniComp = String.valueOf(dniSinLetra) + letras.charAt(letra);
      // Si el dni ha comprobar y el dni que hemos creado con la letra que deben tener
      // esos numeros son iguales entonces el dni es correcto
      if (dniComp.equals(nif)) {
        prueba = true;
      }
    }
    // Devuelvo la bandera
    return prueba;
  }

  /**
   * Metodo privado que comprueba si el numero de empleados es correcto
   * 
   * @param empleados
   * @return devuelve un booleano que indica si el numero de empleados es correcto
   *         o no
   */
  private boolean comprobarEmpleados(int empleados) {
    // Declaro una bandera
    boolean prueba = false;
    // Compruebo que empleados sea mayor a 0, si lo es la bandera es verdadera
    if (empleados > 0) {
      prueba = true;
    }
    // Devuelvo la bandera
    return prueba;
  }

  /**
   * Metodo privado que comprueba si la facturacion es correcta
   * 
   * @param facturacion
   * @return devuelve un booleano que indica si la facturacion es correcta o no
   */
  private boolean comprobarFacturacion(double facturacion) {
    // Declaro una bandera (falsa por defecto)
    boolean prueba = false;
    // Compruebo que la facturación sea mayor a 0, si lo es, la bandera es verdadera
    if (facturacion > 0) {
      prueba = true;
    }
    // Devuelvo la bandera
    return prueba;
  }
}
