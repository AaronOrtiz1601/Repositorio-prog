package models;

import java.io.Serializable;
/**
 * Clase que guarda los datos de una pelicula
 */
public class Pelicula implements Serializable {
    private static final long serialVersionUID = 1L; 
    //Atributos privados de la clase
    private int filmId;          
    private String title;        
    private String description;  
    private int releaseYear;     
    private String idioma;       
    private int length;          
    private String rating;       

    /**
     * Constructor de la clase pelicula
     * @param filmId
     * @param title
     * @param description
     * @param releaseYear
     * @param idioma
     * @param length
     * @param rating
     */
    public Pelicula(int filmId, String title, String description, int releaseYear, String idioma, int length, String rating) {
        this.filmId = filmId;
        this.title = title;
        this.description = description;
        this.releaseYear = releaseYear;
        this.idioma = idioma;
        this.length = length;
        this.rating = rating;
    }

    /**
     * Metodos getter and setter de la clase
     */
    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }

    public String getIdioma() {
        return idioma;
    }

    public void setIdioma(String idioma) {
        this.idioma = idioma;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

 
}
