package prog.unidad06.arraysobjetos.ejercicio01;

public class Libro {
private String titulo;
private String autor;
private int anyoDePublicacion;

public Libro(String titulo,String autor,int anyoDePublicacion) {
    this.titulo = titulo;
    this.autor=autor;
    this.anyoDePublicacion=anyoDePublicacion;
}

public String getTitulo() {
  return titulo;
}

public String getAutor() {
  return autor;
}

public int getAnyoDePublicacion() {
  return anyoDePublicacion;
}
public String mostrarLibro() {
  String libro;
  libro = "Titulo:"+getTitulo()+"Autor:"+getAutor()+"Año de publicacion:"+getAnyoDePublicacion();
  return libro;
}
}
