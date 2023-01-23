package com.vetapp.model;

import javax.persistence.*;

@Entity
@Table(name = "formula", schema = "vet")
public class Formula extends BaseModel {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cat_produccion_id")
    private Long categoriaProduccionId;

    @Column(name = "mezcla_tiempo_min")
    private Integer mezclaTiempoMinimo;

    @Column(name = "observacion")
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
