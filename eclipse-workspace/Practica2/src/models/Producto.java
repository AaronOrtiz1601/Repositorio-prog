package models;

public class Producto {
  
  /**
   * Atributos privados de la clase Productos
   */
  private String nombre;
  private double precio;
  private boolean perecedero;

  /**
   * Contructor de la clase
   * @param nombre
   * @param precio
   * @param perecedero
   */
  public Producto(String nombre, double precio, boolean perecedero) {
    this.nombre = nombre;
    this.precio = precio;
    this.perecedero = perecedero;
  }

  /**
   * Metodos getter and setter de la clase 
   * @return
   */
  public String getNombre() {
    return nombre;
  }

  public void setNombre(String nombre) {
    this.nombre = nombre;
  }

  public double getPrecio() {
    return precio;
  }

  public void setPrecio(int precio) {
    this.precio = precio;
  }

  public boolean isPerecedero() {
    return perecedero;
  }

  public void setPerecedero(boolean perecedero) {
    this.perecedero = perecedero;
  }

}
