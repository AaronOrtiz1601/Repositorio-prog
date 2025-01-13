

package model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "restaurante")
public class Restaurante {

    @Id
    @Column(name = "cod_rest")
    private String codRest;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "licencia_fiscal")
    private String licenciaFiscal;

    @Column(name = "domicilio")
    private String domicilio;

    @Column(name = "fecha_apertura")
    private Date fechaApertura;

    @Column(name = "horario")
    private String horario;

    @ManyToOne
    @JoinColumn(name = "cod_localidad")
    private Localidad localidad;

    // Getters y setters
    public String getCodRest() {
        return codRest;
    }

    public void setCodRest(String codRest) {
        this.codRest = codRest;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getLicenciaFiscal() {
        return licenciaFiscal;
    }

    public void setLicenciaFiscal(String licenciaFiscal) {
        this.licenciaFiscal = licenciaFiscal;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Date getFechaApertura() {
        return fechaApertura;
    }

    public void setFechaApertura(Date fechaApertura) {
        this.fechaApertura = fechaApertura;
    }

    public String getHorario() {
        return horario;
    }

    public void setHorario(String horario) {
        this.horario = horario;
    }

    public Localidad getLocalidad() {
        return localidad;
    }

    public void setLocalidad(Localidad localidad) {
        this.localidad = localidad;
    }
}
