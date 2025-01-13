package models;

import java.util.Date;

/**
 * Clase que simula un cliente
 */
public class Cliente {
    /**
     * Atributos de la clase
     */
    private String nombre;
    private String apellidos;
    private Date fechaNacimiento; 
    private String email;
    private String contraseña;

    /**
     * Constructor de la clase cliente
     * @param nombre
     * @param apellidos
     * @param fechaNacimiento
     * @param perfil
     * @param email
     * @param contraseña
     */
    public Cliente(String nombre, String apellidos, Date fechaNacimiento, String email, String contraseña) {
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.fechaNacimiento = fechaNacimiento; 
        this.email = email;
        this.contraseña = contraseña;
    }

    /**
     * Métodos getter y setter de la clase cliente
     */
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public Date getFechaNacimiento() {
        return fechaNacimiento; 
    }

    public void setFechaNacimiento(Date fechaNacimiento) {
        this.fechaNacimiento = fechaNacimiento; 
    }

 

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
}
