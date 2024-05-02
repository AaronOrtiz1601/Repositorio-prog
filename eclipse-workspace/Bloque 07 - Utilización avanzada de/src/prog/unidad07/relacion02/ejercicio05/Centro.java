package prog.unidad07.relacion02.ejercicio05;

import java.util.ArrayList;
import java.util.List;

public class Centro {
    private List <Persona> personas;
    Centro(){
      personas = new ArrayList<>();
    }
    public void alta(Persona persona)
    {
      personas.add(persona);
    }
    public void baja(String dni)
    {
    
      
      for(int i = 0 ; i < personas.size() ; i++)
      {
        if(dni.equals(personas.get(i).getDni()))
        {
          personas.remove(i);
          
        }

      }
      
    }
    public void imprimir()
    {
      System.out.println("Personas");
      System.out.println("--------");
      for(int i = 0 ; i < personas.size() ; i++)
      {
        if(personas.get(i) instanceof Estudiante)
        {
          System.out.println("(Estudiante)" + personas.get(i).toString());
        }else if(personas.get(i) instanceof Profesor)
        {
          System.out.println("(Profesor)" + personas.get(i).toString());
        }else {
          System.out.println("(PAS)" + personas.get(i).toString());
        }
        
      }
     
    }
  public void imprimirNomina() {
      
    System.out.println("Personas");
    System.out.println("--------");
    for(int i = 0 ; i < personas.size() ; i++)
    {
    
     if(personas.get(i) instanceof Profesor)
     {
       Profesor paco = (Profesor)personas.get(i);
       System.out.println(paco.getNombre() + ":" + paco.getSalario());
     }else if (personas.get(i) instanceof AdministracionServicios) {
       AdministracionServicios paco = (AdministracionServicios)personas.get(i);
       System.out.println(paco.getNombre() + ":" + paco.getSalario());
     }
    }
     
      
    }
    

}
