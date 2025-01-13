package model;

import java.io.Serializable;
import java.util.Objects;

public class RestEmpleadoId implements Serializable {

    private String restaurante;
    private String empleado;

    // Getters, setters, hashCode y equals
    @Override
    public int hashCode() {
        return Objects.hash(restaurante, empleado);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        RestEmpleadoId that = (RestEmpleadoId) obj;
        return Objects.equals(restaurante, that.restaurante) && Objects.equals(empleado, that.empleado);
    }
}
