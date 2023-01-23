package com.vetapp.dto;

public class FormulaDTO extends BaseModelDTO {

    private Long id;

    private Long categoriaProduccionId;

    private Integer mezclaTiempoMinimo;

    private String observacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoriaProduccionId() {
        return categoriaProduccionId;
    }

    public void setCategoriaProduccionId(Long categoriaProduccionId) {
        this.categoriaProduccionId = categoriaProduccionId;
    }

    public Integer getMezclaTiempoMinimo() {
        return mezclaTiempoMinimo;
    }

    public void setMezclaTiempoMinimo(Integer mezclaTiempoMinimo) {
        this.mezclaTiempoMinimo = mezclaTiempoMinimo;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }
}
