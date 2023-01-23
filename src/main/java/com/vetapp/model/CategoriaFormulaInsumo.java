package com.vetapp.model;

import javax.persistence.*;

@Table(name = "cat_form_insumo", schema = "vet")
@Entity
public class CategoriaFormulaInsumo extends BaseModel{

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "cat_form_id")
    private Long categoriaFormulaId;

    @Column(name = "insumo_id")
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
