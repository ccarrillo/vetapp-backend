package com.vetapp.dto;

public class RepartoDTO extends BaseModelDTO {

    private Long id;

    private Long corralId;

    private Integer cantidadVacas;

    private Double cantidadReparto;

    private Double descargaAprox;

    private Double ajuste;

    private FormulaDTO formulaDTO;

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

    public FormulaDTO getFormulaDTO() {
        return formulaDTO;
    }

    public void setFormulaDTO(FormulaDTO formulaDTO) {
        this.formulaDTO = formulaDTO;
    }

}
