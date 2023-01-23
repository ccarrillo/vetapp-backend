package com.vetapp.dto;

public class InsumoDTO extends BaseModelDTO {

    private Long id;

    private String nombre;

    private Double costo;

    private Double masaSolida;

    private Double consumoMS;

    private Long categoriaInsumoId;

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
