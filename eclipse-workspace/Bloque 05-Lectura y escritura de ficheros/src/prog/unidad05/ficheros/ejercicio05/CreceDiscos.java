package prog.unidad05.ficheros.ejercicio05;

public class CreceDiscos {
  
  private String titulo;
  private String artista;
  private int añoDePublicacion;
  private double precio;
  private String Cd;
  
  public CreceDiscos(String titulo, String artista, int añoDePublicacion, double precio, String Cd) {
    if (comprobarTitulo(titulo)) {
      this.titulo = titulo;
    }
    if (comprobarArtista(artista)) {
      this.artista = artista;
    }
    if (comprobarAnyo(añoDePublicacion)) {
      this.añoDePublicacion = añoDePublicacion;
    }
    if (comprobarPrecio(precio)) {
      this.precio = precio;
    }
    if (comprobarCd(Cd)) {
      this.Cd = Cd;
    }
   
  }
  
  public String getTitulo() {
    return titulo;
  }
  
  public String getArtista() {
    return artista;
  }
  
  public int getAñoDePublicacion() {
    return añoDePublicacion;
  }
  
  public double getPrecio() {
    return precio;
  }
  
  public String getCd() {
    return Cd;
  }
  
  public String aTexto() {
    String cadena = "Titulo: " + getTitulo() + " , Artista: " + getArtista() + ", Año de publicación: " + getAñoDePublicacion() + ", Precio: " + getPrecio();
    return cadena;
  }
  
  private boolean comprobarTitulo(String titulo) {
    return !titulo.isEmpty();
  }
  
  private boolean comprobarArtista(String artista) {
    return !artista.isEmpty();
  }
  
  private boolean comprobarAnyo(int anyoDePublicacion) {
    return anyoDePublicacion > 0;
  }
  
  private boolean comprobarPrecio(double precio) {
    return precio > 0;
  }
  
  private boolean comprobarCd(String Cd) {
    return !Cd.equalsIgnoreCase("s") && !Cd.equalsIgnoreCase("n");
  }
}
