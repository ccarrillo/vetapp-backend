package com.vetapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "parte_preparacion", schema = "vet")
public class PartePreparacion extends BaseModel {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "orden")
    private Integer orden;

    @Column(name = "insumo_id")
    private Long insumoId;

    @Column(name = "batch", precision = 7, scale = 3)
    private Double batch;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "formula_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Formula formula;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getOrden() {
        return orden;
    }

    public void setOrden(Integer orden) {
        this.orden = orden;
    }

    public Long getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Long insumoId) {
        this.insumoId = insumoId;
    }

    public Double getBatch() {
        return batch;
    }

    public void setBatch(Double batch) {
        this.batch = batch;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }
}
