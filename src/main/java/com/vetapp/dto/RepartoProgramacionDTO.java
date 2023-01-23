package com.vetapp.dto;

import java.util.Date;

public class RepartoProgramacionDTO extends BaseModelDTO {

    private Long id;

    private Integer orden;

    private Date fechaProgramada;

    private FormulaDTO formula;

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

    public Date getFechaProgramada() {
        return fechaProgramada;
    }

    public void setFechaProgramada(Date fechaProgramada) {
        this.fechaProgramada = fechaProgramada;
    }

    public FormulaDTO getFormula() {
        return formula;
    }

    public void setFormula(FormulaDTO formulaDTO) {
        this.formula = formulaDTO;
    }
}
