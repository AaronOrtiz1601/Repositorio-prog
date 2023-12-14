package prog.unidad04.actividad403.ejercicio02;
import java.util.Random;
/**
 * Clase que representa a una pizza
 * @author Aarón
 * @version 1.0
 */
public class Persona {
  /**
   * valores por defecto
   */
  /**
   * nombre por defecto 
   * ""
   */
  private static final String NOMBRE_DEFECTO="";
  /**
   * edad por defecto 
   *0
   */
  private static final int EDAD_DEFECTO=0;
  /**
   * sexo por defecto 
   */
  private static final char SEXO_DEFECTO='M';
  /**
   * peso por defecto 
   */
  private static final double  PESO_DEFECTO=0.0;
  /**
   * altura por defecto 
   */
  private static final double ALTURA_DEFECTO=0.0;
  
  private static final String DNI_DEFECTO="";
  
  //Atributos
  private String nombre;
  private int edad;
  private char sexo;
  private double peso;
  private double altura;
  private String DNI=DNI_DEFECTO;
  private double IMC;
  private int pesoCorrecto;
  
  
  
  
  public double getIMC() {
    if(peso!=PESO_DEFECTO && altura!=ALTURA_DEFECTO)
    IMC=peso/(altura*altura);
    else
      IMC=0.0;
    return IMC;
  }
  public int getPesoCorrecto() {
    
    if(IMC<18.5)
    {
      pesoCorrecto=-1;
    }
    if((IMC>18.5)&&(IMC<24.9))
    {
      pesoCorrecto=0;
    }
    if (IMC>=24.9)
    {
      pesoCorrecto=1;
    }
    return pesoCorrecto;
  }
  public boolean esMayorDeEdad()
  {
    boolean MayorDeEdad=true;
    if(edad<18)
    {
      MayorDeEdad=false;
      
    }else if(edad>=18)
    {
      MayorDeEdad=true;
    }
    return MayorDeEdad;
  }
  public String obtenerCadena() {
    String cadena;
    cadena="Nombre:"+nombre+",Edad:"+edad+",Sexo:"+sexo+",Peso:"+ peso+",Altura:" +altura+ ",DNI:" +DNI;
    return cadena;
  }
  private String generarDNI() {
    Random random = new Random();
    int resultado;
    int resto;
    for(int i=0 ;i<8;i++)
    {
      
    
    int numeroAleatorio = random.nextInt(10); 

     DNI = DNI+String.valueOf(numeroAleatorio);
   
    }
    resultado=Integer.parseInt(DNI);
    resto=resultado%23;
    switch(resto) {
    case 0:
      DNI=DNI+'T';
      break;
    case 1:
      DNI=DNI+'R';
      break;
    case 2:
      DNI=DNI+'W';
      break;
    case 3:
      DNI=DNI+'A';
      break;
    case 4 :
      DNI=DNI+'G';
      break;
    case 5:
      DNI=DNI+'M';
      break;
    case 6:
      DNI=DNI+'Y';
      break;
    case 7:
      DNI=DNI+'F';
      break;
    case 8:
      DNI=DNI+'P';
      break;
    case 9:
      DNI=DNI+'D';
      break;
    case 10:
      DNI=DNI+'X';
      break;
    case 11:
      DNI=DNI+'B';
      break;
    case 12:
      DNI=DNI+'N';
      break;
    case 13:
      DNI=DNI+'J';
      break;
    case 14:
      DNI=DNI+'Z';
      break;
    case 15:
      DNI=DNI+'S';
      break;
    case 16:
      DNI=DNI+'Q';
      break;
    case 17:
      DNI=DNI+'V';
      break;
    case 18:
      DNI=DNI+'H';
      break;
    case 19:
      DNI=DNI+'L';
      break;
    case 20:
      DNI=DNI+'C';
      break;
    case 21:
      DNI=DNI+'K';
      break;
    case 22:
      DNI=DNI+'E';
      break;
      
    }
    
    return DNI;
  }
  
  /**
   * Constructor.Inicia los valores por defecto y crea el objeto
   */
  public Persona()
  {
    nombre=NOMBRE_DEFECTO;
    edad=EDAD_DEFECTO;
    sexo=SEXO_DEFECTO;
    peso=PESO_DEFECTO;
    altura=ALTURA_DEFECTO;
    generarDNI();
  }
  public Persona(String nombre,int edad, char sexo )
  {
    this.nombre=nombre;
    if(edad>0)
    {
    this.edad=edad;
    }
    else
    {
      throw new IllegalArgumentException();
    }
    if ((sexo=='M')||(sexo=='H'))
    {
      this.sexo=sexo;
    }else
    {
      throw new IllegalArgumentException();
    }
    peso=PESO_DEFECTO;
    altura=ALTURA_DEFECTO;
    generarDNI();
  }
  public Persona(String nombre,int edad, char sexo,double peso,double altura)
  {
    this.nombre=nombre;
    if(edad>0)
    {
    this.edad=edad;
    }
    else
    {
      throw new IllegalArgumentException();
    }
    if ((sexo=='M')||(sexo=='H'))
    {
      this.sexo=sexo;
    }else
    {
      throw new IllegalArgumentException();
    }
    if (peso>0) {
      this.peso=peso;
    }
    else 
    {
      throw new IllegalArgumentException();
    }
    if (altura>0) {
      this.altura=altura;
    }
    else 
    {
      throw new IllegalArgumentException();
    }
    generarDNI();
  }
  

}
