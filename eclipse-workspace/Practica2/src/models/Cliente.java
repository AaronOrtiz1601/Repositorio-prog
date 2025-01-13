package models;

public class Cliente {
    /**
     * Atributos privados de la clase Clientes
     */
    private String nombre;
    private String apellido;
    private int edad;
    private String provincia;

    /**
     * Constructor de la clase Cliente
     * 
     * @param nombre
     * @param apellido
     * @param edad
     * @param provincia
     */
    public Cliente(String nombre, String apellido, int edad, String provincia) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.edad = edad;
        this.provincia = provincia;
    }

    /**
     * Getters y Setters de los atributos privados de la clase
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getProvincia() {
        return provincia;
    }

    public void setProvincia(String provincia) {
        this.provincia = provincia;
    }
}
