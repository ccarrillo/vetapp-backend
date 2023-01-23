package com.vetapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import javax.persistence.*;

@Entity
@Table(name = "ingredientes", schema = "vet")
public class Ingredientes extends BaseModel {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", length = 100)
    private String nombre;

    @Column(name = "costo", precision = 12, scale = 3)
    private Double costo;

    @Column(name = "masa_solida", precision = 5, scale = 3)
    private Double masaSolida;

    @Column(name = "consumo_fresco", precision = 7, scale = 3)
    private Double consumoFresco;

    @Column(name = "relacion_forraje", precision = 5, scale = 3)
    private Double relacionForraje;

    @Column(name = "relacion_base_fresca", precision = 5, scale = 3)
    private Double relacionBaseFresca;

    @Column(name = "consumo_ms", precision = 7, scale = 3)
    private Double consumoMS;

    @Column(name = "relacion_base_ms", precision = 5, scale = 3)
    private Double relacionBaseMS;

    @Column(name = "categoria_id")
    private Long categoriaInsumoId;

    @Column(name = "composicion_id")
    private Long composicionInsumoId;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "formula_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Formula formula;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "insumo_id", nullable = false)
    @OnDelete(action = OnDeleteAction.CASCADE)
    @JsonIgnore
    private Insumo insumo;

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

    public Double getConsumoFresco() {
        return consumoFresco;
    }

    public void setConsumoFresco(Double consumoFresco) {
        this.consumoFresco = consumoFresco;
    }

    public Double getRelacionForraje() {
        return relacionForraje;
    }

    public void setRelacionForraje(Double relacionForraje) {
        this.relacionForraje = relacionForraje;
    }

    public Double getRelacionBaseFresca() {
        return relacionBaseFresca;
    }

    public void setRelacionBaseFresca(Double relacionBaseFresca) {
        this.relacionBaseFresca = relacionBaseFresca;
    }

    public Double getConsumoMS() {
        return consumoMS;
    }

    public void setConsumoMS(Double consumoMS) {
        this.consumoMS = consumoMS;
    }

    public Double getRelacionBaseMS() {
        return relacionBaseMS;
    }

    public void setRelacionBaseMS(Double relacionBaseMS) {
        this.relacionBaseMS = relacionBaseMS;
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

    public Formula getFormula() {
        return formula;
    }

    public void setFormula(Formula formula) {
        this.formula = formula;
    }

    public Insumo getInsumo() {
        return insumo;
    }

    public void setInsumo(Insumo insumo) {
        this.insumo = insumo;
    }
}
