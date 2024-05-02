package prog.unidad07.relacion02.ejercicio02;

import java.util.ArrayList;
import java.util.List;

public class Centro {
    private List <Estudiante> estudiantes;
    private List <Profesor> profesores;
    private List <AdministracionServicios> pas;
    Centro(){
      estudiantes = new ArrayList<>();
      profesores = new ArrayList<>();
      pas = new ArrayList<>();
    }
    public void alta(Persona persona)
    {
      if(persona instanceof Estudiante)
      {
        estudiantes.add((Estudiante) persona);
      } else if (persona instanceof Profesor)
      {
        profesores.add((Profesor) persona);
      }else
      {
        pas.add((AdministracionServicios) persona);
      }
    }
    public void baja(String dni)
    {
      boolean prueba = false;
      
      for(int i = 0 ; i < estudiantes.size() ; i++)
      {
        if(dni.equals(estudiantes.get(i).getDni()))
        {
          estudiantes.remove(i);
          prueba = true;
        }

      }
      if(!prueba)
      {
        for(int i = 0 ; i < profesores.size() ; i++)
        {
          if(dni.equals(profesores.get(i).getDni()))
          {
            profesores.remove(i);
            prueba = true;
          }

        }
        if(!prueba)
        {
          for(int i = 0 ; i < pas.size() ; i++)
          {
            if(dni.equals(pas.get(i).getDni()))
            {
              pas.remove(i);
              prueba = true;
            }

          }
        }
      }
    }
    public void imprimir()
    {
      System.out.println("Estudiantes");
      System.out.println("-----------");
      for(int i = 0 ; i < estudiantes.size() ; i++)
      {
        System.out.println(estudiantes.get(i).toString());
      }
      System.out.println("Profesores");
      System.out.println("----------");
      for(int i = 0 ; i < profesores.size() ; i++)
      {
        System.out.println(profesores.get(i).toString());
      }
      System.out.println("Personal de administracion y servicios");
      System.out.println("--------------------------------------");
      for(int i = 0 ; i < pas.size() ; i++)
      {
        System.out.println(pas.get(i).toString());
      }
    }
    

}
