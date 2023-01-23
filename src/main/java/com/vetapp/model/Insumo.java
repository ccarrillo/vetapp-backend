package com.vetapp.model;

import javax.persistence.*;

@Entity
@Table(name = "insumo", schema = "vet")
public class Insumo extends BaseModel {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="id", nullable=false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "costo",precision= 12, scale= 3)
    private Double costo;

    @Column(name = "masa_solida",precision= 5, scale= 3)
    private Double masaSolida;

    @Column(name = "consumo_ms",precision= 7, scale= 3)
    private Double consumoMS;

    @Column(name = "categoria_id")
    private Long categoriaInsumoId;

    @Column(name = "composicion_id")
    private Long composicionInsumoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Double getCosto() {
        return costo;
    }

    public void setCosto(Double costo) {
        this.costo = costo;
    }

    public Double getMasaSolida() {
        return masaSolida;
    }

    public void setMasaSolida(Double masaSolida) {
        this.masaSolida = masaSolida;
    }

    public Double getConsumoMS() {
        return consumoMS;
    }

    public void setConsumoMS(Double consumoMS) {
        this.consumoMS = consumoMS;
    }

    public Long getCategoriaInsumoId() {
        return categoriaInsumoId;
    }

    public void setCategoriaInsumoId(Long categoriaInsumoId) {
        this.categoriaInsumoId = categoriaInsumoId;
    }

    public Long getComposicionInsumoId() {
        return composicionInsumoId;
    }

    public void setComposicionInsumoId(Long composicionInsumoId) {
        this.composicionInsumoId = composicionInsumoId;
    }
}
