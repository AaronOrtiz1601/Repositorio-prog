package model;

import java.io.Serializable;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SuperUsuario implements Serializable {

    // Comentario descriptivo sobre la clase y el atributo
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser; // Clave primaria, autoincremental

    @Column(nullable = false)
    private String nombre; // Nombre del superusuario

    @Column(nullable = false)
    private String apellidos; // Apellidos del superusuario

    @Column(length = 8, nullable = false, unique = true)
    private String user; // Campo generado dinámicamente con el formato 2DAMXY

    // Constructor por defecto
    public SuperUsuario() {
        super();
    }

    // Constructor con parámetros
    public SuperUsuario(String nombre, String apellidos, String user) {
        super();
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.user = user;
    }

    // Getters y setters
    public int getIdUser() {
        return idUser;
    }

    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }

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

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Superusuario [idUser=" + idUser + ", nombre=" + nombre + ", apellidos=" + apellidos + ", user=" + user + "]";
    }
}
