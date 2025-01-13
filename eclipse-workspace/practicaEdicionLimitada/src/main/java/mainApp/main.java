package mainApp;

public class main {

  public static void main(String[] args) {
   app prueba = new app();
 
   prueba.cargarPeliculas("pelis.csv");
   prueba.peliculasToFichero("English", true);
   prueba.cargarPeliculasBinario("peliculas_lang_english.dat");

  }

}
