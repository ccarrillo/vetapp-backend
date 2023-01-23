package com.vetapp.dto;

public class CategoriaFormulaInsumoDTO extends BaseModelDTO {

    private Long id;

    private Long categoriaFormulaId;

    private Long insumoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getCategoriaFormulaId() {
        return categoriaFormulaId;
    }

    public void setCategoriaFormulaId(Long categoriaFormulaId) {
        this.categoriaFormulaId = categoriaFormulaId;
    }

    public Long getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Long insumoId) {
        this.insumoId = insumoId;
    }
}
