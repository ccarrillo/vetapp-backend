package com.vetapp.dto;

public class PartePreparacionDTO extends BaseModelDTO {

    private Long id;

    private Integer orden;

    private Long insumoId;

    private Double batch;

    private FormulaDTO formulaDTO;

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

    public FormulaDTO getFormulaDTO() {
        return formulaDTO;
    }

    public void setFormulaDTO(FormulaDTO formulaDTO) {
        this.formulaDTO = formulaDTO;
    }
}
