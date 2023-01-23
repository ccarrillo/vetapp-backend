package com.vetapp.dto;

public class IngredientesDTO extends BaseModelDTO {

    private Long id;

    private String nombre;

    private Double costo;

    private Double masaSolida;

    private Double consumoFresco;

    private Double relacionForraje;

    private Double relacionBaseFresca;

    private Double consumoMS;

    private Double relacionBaseMS;

    private Long categoriaInsumoId;

    private Long composicionInsumoId;

    private FormulaDTO formulaDTO;

    private InsumoDTO insumoDTO;

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

    public FormulaDTO getFormulaDTO() {
        return formulaDTO;
    }

    public void setFormulaDTO(FormulaDTO formulaDTO) {
        this.formulaDTO = formulaDTO;
    }

    public InsumoDTO getInsumoDTO() {
        return insumoDTO;
    }

    public void setInsumoDTO(InsumoDTO insumoDTO) {
        this.insumoDTO = insumoDTO;
    }
}
