package com.vetapp.dto;

public class CategoriaFormulaAlimentosDTO extends BaseModelDTO {

    private Long id;

    private CategoriaFormulaDTO categoriaFormula;

    private Long insumoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public CategoriaFormulaDTO getCategoriaFormula() {
        return categoriaFormula;
    }

    public void setCategoriaFormula(CategoriaFormulaDTO categoriaFormula) {
        this.categoriaFormula = categoriaFormula;
    }

    public Long getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Long insumoId) {
        this.insumoId = insumoId;
    }
}
