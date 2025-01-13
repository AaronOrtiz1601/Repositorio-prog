package hlc.ud03.examen;
/**
 * Clase ValidaProducto esta clase se encarga de validar los campos de un fichero de texto
 */
public class ValidaProducto {
  /**
   * Contanstes de la clase ValidaProducto
   */
  public static final String CAMPO_REFERENCIA = "referencia";
  public static final String CAMPO_NOMBRE = "nombre";
  public static final String CAMPO_PRECIO = "precio";
  public static final String CAMPO_MARCA = "marca";
  public static final String CAMPO_PUNTUACION = "puntuacion";
  public static final String CAMPO_FECHA_INICIO_VENTA = "fecha_inicio_venta";
  public static final String CAMPO_DOMICIO = "dominio";
  public static final String CAMPO_URL = "url";
  public static final String CAMPO_CORREO_PEDIDOS = "correo_pedidos";
  public static final String CAMPO_PUNTOS_FUERTES = "puntos_fuertes";
  public static final String CAMPO_PUNTOS_DEBILES= "puntos_debiles";
  
  private static final String EXPRESION_REFERENCIA = "^(3[4-9]|[4-5][0-9]|6[0-7])\\d{11}$";;
  private static final String EXPRESION_NOMBRE = "^[A-Za-z0-9 ]{1,200}$";
  private static final String EXPRESION_PRECIO = "^[0-9]+(\\.[0-9]{2})$";
  private static final String EXPRESION_MARCA = "^[A-Z][a-zA-Z0-9]*(\\s[A-Z][a-zA-Z0-9]*)*{1,100}$";
  private static final String PUNTUACION = "^[0-9]+(\\.[0-5]{1})$";
  private static final String EXPRESION_FECHA_INICIO_VENTA = "^(0[1-9]|[12][0-9]|3[01])/(0[1-9]|1[0-2])/([0-9]{4})$";
  private static final String EXPRESION_DOMINIO = "^(?=.{1,63}$)[a-zA-Z](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?(?:\\.[a-zA-Z](?:[a-zA-Z0-9-]*[a-zA-Z0-9])?)*$";
  private static final String EXPRESION_URL = "^http://www\\.[a-zA-Z0-9-]+\\.[a-zA-Z]{2,6}/?$";
  private static final String EXPRESION_CORREO_PEDIDOS = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,6}$";
  private static final int PUNTOS_FUERTES_MIN = 1;
  private static final int PUNTOS_FUERTES_MAX = 5;
  private static final int  PUNTOS_DEBILES_MIN = 1;
  private static final int PUNTOS_DEBILES_MAX = 5;
  private static final String[]   PUNTOS_VALORES = {
      "Precio",
      "Tecnologia",
      "Durabilidad",
      "Disponibilidad",
      "Marca",
      "Sostenible",
      "Calidad",
      "Tamaño",
  };
  
  /**
   * Campos de la clase para pasarselos al metodo getCampos
   */
  public final String[] CAMPOS = {
      CAMPO_REFERENCIA,
      CAMPO_NOMBRE,
      CAMPO_PRECIO,
      CAMPO_MARCA,
      CAMPO_PUNTUACION,
      CAMPO_FECHA_INICIO_VENTA,
      CAMPO_DOMICIO,
      CAMPO_URL,
      CAMPO_CORREO_PEDIDOS,
      CAMPO_PUNTOS_FUERTES,
      CAMPO_PUNTOS_DEBILES
  };
  
  private String error = null;
  /**
   * Metodo getCampos()
   * Este metodo se encarga de devolver los campos que la clase se ha encargado de validar
   * @return campos []
   */
  public String[] getCampos() {
    return CAMPOS;
  }
  /**
   * Esta clase se encarga de decirnos si un campo a tenido un error y cual ha sido
   * @param campo ha validar
   * @param valor Pasamos una expresion regular para validar el campo
   * @return un booleano con el resultado de la comprobación
   */
  public boolean esValidoCampo(String campo, String valor) {
    //Switch al que le pasamos un campo y este nos dara la comprovación de este llamando a un  metodo  que se encargara de ello
    switch (campo) {
      case CAMPO_REFERENCIA:
        return esValidoReferencia(valor);
      case CAMPO_NOMBRE:
        return esValidoNombre(valor);
      case CAMPO_PRECIO:
        return esValidoPrecio(valor);
      case CAMPO_MARCA:
        return esValidoMarca(valor);
      case CAMPO_PUNTUACION:
        return esValidoPuntuacion(valor);
      case CAMPO_FECHA_INICIO_VENTA:
        return esValidoFechaInicioVenta(valor);
      case CAMPO_DOMICIO:
        return esValidoDominio(valor);
      case CAMPO_URL:
        return esValidoUrl(valor);
      case CAMPO_CORREO_PEDIDOS:
        return esValidoCorreoPedidos(valor);
      case CAMPO_PUNTOS_FUERTES:
        return esValidoPuntosFuertes(valor);
      case CAMPO_PUNTOS_DEBILES:
        return esValidoPuntosDebiles(valor);
      default:
        setError("El campo " + campo + " no existe");
        return false;
    }
  }
  /**
   * Metodo que se encarga de asignar el error 
   * @param mensaje
   */
  private void setError(String mensaje) {
    error = mensaje;
  }
  /**
   * Metodo que te devuelve el error de un campo
   * @return
   */
  public String getError() {
    return error;
  }
/**
 * Metodo que se encarga de comprobar si la referencía es correcta
 * @param valor, Expresion regular para comprobarlo
 * @return booleano con el resultado de la comprobacion
 */
  public boolean esValidoReferencia(String valor) {
    //Sacamos los dos primeros valores de la cadena para comprobar que esten estre el rango permitido
    int primerosDigitos = Integer.parseInt(valor.substring(0, 2));
    //Comprobamos que el campo no este vacion
    if (Validacion.noEsVacio(valor)) {
      //Si no lo esta hacemos que pase la expresion
      if (valor.matches(EXPRESION_REFERENCIA)) {
        //Si lo pasa devolvemos true
        return true;
        //Si no lo pasa comprobamos que el rango este entre 34 y 67
      }else if(primerosDigitos < 34 || primerosDigitos > 67) {
        setError("Los dos primeros digitos no estan entre 34 y 67");
      return false;
        
      }
      //Si lo esta damos directamente el siguiente error
      else {
        setError("El formato no es válido");
        return false;
      }
      //Si el campo esta vacio
    } else {
      setError("El campo está vacío pero es obligatorio");
      return false;
    }
  }
/**
 * Metodo que se encarga de comprobar si el nombre es valido
 * @param valor ,Exprsion para comprobar los errores
 * @return booleano con la respuesta de la comprobacion
 */
  public boolean esValidoNombre(String valor) {
    //Hacemos lo mismoque en el metodo anterior para comprobar si esta vacio
    if (Validacion.noEsVacio(valor)) {
      if (valor.matches(EXPRESION_NOMBRE)) {
        return true;
        //Comprobamos que la longitud del nombre sea mayor a 200
      }else if(valor.length() > 200) {
        setError("El contenido excede la longitud maxima");
        return false;
      }
      else {
        setError("El formato no es correcto");
        return false;
      }
    } else {
      setError("El campo está vacío pero es obligatorio");
      return false;
    
    }
  }
/**
 * Metodo para comprobar si el precio es valido
 * @param valor, Expresion regular para comprobar si el precio es valido
 * @return booleano con la respuesta de la comprobacion
 */
  public boolean esValidoPrecio(String valor) {
    //Sacamos lo ultimos 3 digitos del precio
    String ultimosDigitos = valor.substring(valor.length()-3, valor.length());
    //Comprobamos que no este vacio con en los anteriores metodos
    if (Validacion.noEsVacio(valor)) {
      if (valor.matches(EXPRESION_PRECIO)) {
        return true;
        //Comprobamos que precio no tenga mas de 2 decimales
      }else if(!ultimosDigitos.contains(".")) {
        setError("El campo excede el numero de decimales (2)");
        return false;
      }
      else {
        setError("El formato no es correcto");
        return false;
      }
    } else {
      setError("El campo está vacío y es obligatorio");
      return false;
    }
  }
/**
 * Metodo para comprobar que la marca es correcta
 * @param valor, Expresion para hacer la comprobacion
 * @return booleano con la resppuesta de la comprobacion
 */
  public boolean esValidoMarca(String valor) {
    //Comprobamos si esta vacio o no, aunque en este caso no importa por que el campo es opcional
    if (Validacion.noEsVacio(valor)) {
      if (valor.matches(EXPRESION_MARCA)) {
        return true;
        //Comprobamos que el contenido de la marca supera el limite de caracteres
      }else if(valor.length() > 100){
        setError("El contenido excede la longitud maxima(100)");
        return false;
      }
        else {
        return false;
      }
    } else {
      return true;
    }
  }
/**
 * Metodo para comprobar si la puntuacion es valida   
 * @param valor, Expresion para comprobarlo
 * @return boolean con el resultado de la comprobacion
 */
  public boolean esValidoPuntuacion(String valor) {
    //Sacamos lo ultimos digitos de la puntuacion
    String ultimosDigitos = "";
    if(valor.length() > 3) {
      ultimosDigitos = valor.substring(valor.length()-2, valor.length());
    }
    //Comprobamos que no este vacia como en los metodos anteriores
    if (Validacion.noEsVacio(valor)) {
      if (valor.matches(PUNTUACION)) {
        return true;
        //Comprobamos que esta no este fuera del rango indicado
      }else if(!ultimosDigitos.contains(".")) {
        setError(" El valor esta fuera del rango indicado (0.0 - 5.0)");
        return false;
      }
      else {
        setError("El formato no es correcto");
        return false;
      }
    } else {
      setError("El campo está vacío y es obligatorio");
      return false;
    }
  }
/**
 * Metodo para comprobar que la fecha de inicio sea correcta
 * @param valor, expresion para realizar la comprobacion
 * @return boolean con el resultado
 */
  public boolean esValidoFechaInicioVenta(String valor) {
    //Comprobamos que no este vacia aunque es opcionaal
    if (Validacion.noEsVacio(valor)) {
      if (valor.matches(EXPRESION_FECHA_INICIO_VENTA)) {
        return true;
        //Comprobamos que cumpla el formato de la fecha
      } else {
        setError("La fecha no cumple con el formato DD/MM/YYYY");
        return false;
      }
    } else {
      return true;
    }
  }
/**
 * Metodo para comprobar que el dominio es valido
 * @param valor, expresion para hacer la comprobacion
 * @return boolean con el resultado 
 */
  public boolean esValidoDominio(String valor) {
    //Comprobamos que no este vacio
    if (Validacion.noEsVacio(valor)) {
      if (valor.matches(EXPRESION_DOMINIO)) {
        return true;
      } else {
        setError("El formato del dominio no es válido");
        return false;
      }
    } else {
      setError("El campo está vacío y es obligatorio");
      return false;
    }
  }
/**
 * Metodo para comprobar que la url sea valida
 * @param valor, expresion para comprobar el resultado
 * @return booleano con el resultado
 */
  public boolean esValidoUrl(String valor) {
    //Comprobamos que no este vacio
    if (Validacion.noEsVacio(valor)) {
      if (valor.matches(EXPRESION_URL)) {
        return true;
      } else {
        setError("El formato de la URL no es válido");
        return false;
      }
    } else {
      setError("El campo está vacío y es obligatorio");
      return false;
    }
  }
/**
 * Metodo para comprobar que el correo sea correcto
 * @param valor, expresion para la comprobacion
 * @return boolean con el resultado
 */
  public boolean esValidoCorreoPedidos(String valor) {
    if (Validacion.noEsVacio(valor)) {
      if (valor.matches(EXPRESION_CORREO_PEDIDOS)) {
        return true;
      } else {
        setError("El formato del correo no es válido");
        return false;
      }
    } else {
      setError("El campo está vacío y es obligatorio");
      return false;
    }
  }
/**
 * Metodo para comprobar los puntos fuertes
 * @param valor 
 * @return boolean con el resultado
 */
  public boolean esValidoPuntosFuertes(String valor) {
    //Comprobamos que no este vacio
    if (Validacion.noEsVacio(valor)) {
      //Vamos sacando y validando los valores
      String[] valores = valor.split(",");
      if (!Validacion.hayDuplicados(valores)) {
        //Comprobamos que este en el rango 
        if (Validacion.estaEnRango(valores.length, PUNTOS_FUERTES_MIN, PUNTOS_FUERTES_MAX)) {
          for (String actual : valores) {
            //Comprobamos que este en la lista
            if (!Validacion.estaEnLista(actual, PUNTOS_VALORES, true)) {
              setError("El valor " + actual + " no está permitido");
              return false;
            }
          }
          return true;
          
        } else {
          setError("El número de puntos  no es correcto");
          return false;
        }
      } else {
        setError("Hay valores duplicados en el campo");
        return false;
      }
    } else {
      return true;
    }
  }
  /**
   * Metodo para comprobar los puntos debiles
   * @param valor
   * @return
   */
  public boolean esValidoPuntosDebiles(String valor) {
    //Hacemos las mismas comprobacion que en el metodo anterior
    if (Validacion.noEsVacio(valor)) {
      String[] valores = valor.split(",");
      if (!Validacion.hayDuplicados(valores)) {
        if (Validacion.estaEnRango(valores.length, PUNTOS_DEBILES_MIN, PUNTOS_DEBILES_MAX)) {
          for (String actual : valores) {
            if (!Validacion.estaEnLista(actual, PUNTOS_VALORES, true)) {
              setError("El valor " + actual + " no está permitido");
              return false;
            }
          }
          return true;
        } else {
          setError("El número de puntos  no es correcto");
          return false;
        }
      } else {
        setError("Hay valores duplicados en el campo");
        return false;
      }
    } else {
      return true;
    }
  }
}
