package com.vetapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "reparto", schema = "vet")
public class Reparto extends BaseModel {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "corral_id")
    private Long corralId;

    @Column(name = "cantidad_vacas")
    private Integer cantidadVacas;

    @Column(name = "cantidad_reparto", precision = 7, scale = 3)
    private Double cantidadReparto;

    @Column(name = "descarga_aprox", precision = 7, scale = 3)
    private Double descargaAprox;

    @Column(name = "ajuste", precision = 5, scale = 3)
    private Double ajuste;

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

    public Long getCorralId() {
        return corralId;
    }

    public void setCorralId(Long corralId) {
        this.corralId = corralId;
    }

    public Integer getCantidadVacas() {
        return cantidadVacas;
    }

    public void setCantidadVacas(Integer cantidadVacas) {
        this.cantidadVacas = cantidadVacas;
    }

    public Double getCantidadReparto() {
        return cantidadReparto;
    }

    public void setCantidadReparto(Double cantidadReparto) {
        this.cantidadReparto = cantidadReparto;
    }

    public Double getDescargaAprox() {
        return descargaAprox;
    }

    public void setDescargaAprox(Double descargaAprox) {
        this.descargaAprox = descargaAprox;
    }

    public Double getAjuste() {
        return ajuste;
    }

    public void setAjuste(Double ajuste) {
        this.ajuste = ajuste;
    }

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }
}
