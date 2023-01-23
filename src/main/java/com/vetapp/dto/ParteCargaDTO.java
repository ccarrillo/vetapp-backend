package com.vetapp.dto;

public class ParteCargaDTO extends BaseModelDTO {

    private Long id;

    private Integer orden;

    private Long insumoId;

    private Double cantidadInsumo;

    private Double pesoAcumulado;

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

    public Double getCantidadInsumo() {
        return cantidadInsumo;
    }

    public void setCantidadInsumo(Double cantidadInsumo) {
        this.cantidadInsumo = cantidadInsumo;
    }

    public Double getPesoAcumulado() {
        return pesoAcumulado;
    }

    public void setPesoAcumulado(Double pesoAcumulado) {
        this.pesoAcumulado = pesoAcumulado;
    }

    public FormulaDTO getFormulaDTO() {
        return formulaDTO;
    }

    public void setFormulaDTO(FormulaDTO formulaDTO) {
        this.formulaDTO = formulaDTO;
    }
}
