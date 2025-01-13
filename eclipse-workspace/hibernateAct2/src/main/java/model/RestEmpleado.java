package model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.IdClass;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "rest_empleado")
@IdClass(RestEmpleadoId.class)
public class RestEmpleado {

    @Id
    @ManyToOne
    @JoinColumn(name = "cod_rest")
    private Restaurante restaurante;

    @Id
    @ManyToOne
    @JoinColumn(name = "dni_empleado")
    private Empleado empleado;

    @Column(name = "funcion")
    private String funcion;

    // Getters y setters
    public Restaurante getRestaurante() {
        return restaurante;
    }

    public void setRestaurante(Restaurante restaurante) {
        this.restaurante = restaurante;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }

    public String getFuncion() {
        return funcion;
    }

    public void setFuncion(String funcion) {
        this.funcion = funcion;
    }
}
