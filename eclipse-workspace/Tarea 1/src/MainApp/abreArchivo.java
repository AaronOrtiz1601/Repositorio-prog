package MainApp;

import java.util.ArrayList;

import models.Empleado;
import utils.UtilsFicheroArray;

public class abreArchivo {

  public static void main(String[] args) {
    Empleado paco = new Empleado();
    paco.setEdad(12);
    paco.setEmpresa("hola");
    paco.setNumEmpleados(2);
    Empleado rosa = new Empleado();
    rosa.setEdad(14);
    rosa.setEmpresa("hola");
    rosa.setNumEmpleados(3);
    Empleado lola = new Empleado();
    lola.setEdad(80);
    lola.setEmpresa("hola");
    lola.setNumEmpleados(90);
    Empleado jose = new Empleado();
    jose.setEdad(30);
    jose.setEmpresa("tonto");
    jose.setNumEmpleados(60);
    ArrayList<Empleado> empleados = new ArrayList<>();
    empleados.add(jose);
    empleados.add(lola);
    empleados.add(rosa);
    empleados.add(paco);
    UtilsFicheroArray prueba = new UtilsFicheroArray();
   
    prueba.leer_Empleados("empleados.txt");
    prueba.toArchivoBinarioInverso(empleados);
    prueba.leer_Empleados_b("empleados.bin");
    
    

  }

}
