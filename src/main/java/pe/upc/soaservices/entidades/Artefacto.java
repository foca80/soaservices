package pe.upc.soaservices.entidades;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "ARTEFACTO_TBL")
public class Artefacto implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codigo;
    private String descripcion;
    private String marca;
    private String modelo;
    private double garantia;
    private double costo;

    public Long getCodigo() {
        return codigo;
    }

    public void setCodigo(Long codigo) {
        this.codigo = codigo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public double getGarantia() {
        return garantia;
    }

    public void setGarantia(double garantia) {
        this.garantia = garantia;
    }

    public double getCosto() {
        return costo;
    }

    public void setCosto(double costo) {
        this.costo = costo;
    }
}
