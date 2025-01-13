package models;

import java.util.Date;

public class Citas {
  private String matricula;
  private String Marca;
  private String modelo;
  private Date Fecha;
  private String estado = "Pendiente";
  private String importe;
  private String observaciones;

  public Citas(String matricula, String marca, String modelo, Date fecha) {
    this.matricula = matricula;
    this.Marca = marca;
    this.modelo = modelo;
    this.Fecha = fecha;
  }

  public String getMatricula() {
    return matricula;
  }

  public String getMarca() {
    return Marca;
  }

  public String getModelo() {
    return modelo;
  }

  public Date getFecha() {
    return Fecha;
  }

  public String getEstado() {
    return estado;
  }

  public void setEstado(String estado) {
    this.estado = estado;
  }

  public void setImporte(String importe) {
    this.importe = importe;
  }
  public String getImporte() {
    return importe;
  }

  public void setObservaciones(String observaciones) {
    this.observaciones = observaciones;
  }
  public String getObervaciones() {
    return observaciones;
  }
  

}
