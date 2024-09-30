package models;

import java.io.Serializable;

public class Empleado implements Serializable {
  
  private String empresa;
  private int edad;
  private int numEmpleados;
  
  
  @Override
  public String toString() {
    return " Empresa=" + empresa + "\n edad=" + edad + "\n numero de empleados=" + numEmpleados;
  }
  public String getEmpresa() {
    return empresa;
  }
  public void setEmpresa(String empresa) {
    this.empresa = empresa;
  }
  public int getEdad() {
    return edad;
  }
  public void setEdad(int edad) {
    this.edad = edad;
  }
  public int getNumEmpleados() {
    return numEmpleados;
  }
  public void setNumEmpleados(int numEmpleados) {
    this.numEmpleados = numEmpleados;
  }
  

}
