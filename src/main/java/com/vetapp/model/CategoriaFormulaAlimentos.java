package com.vetapp.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Table(name = "cat_form_alimentos", schema = "vet")
@Entity
public class CategoriaFormulaAlimentos extends BaseModel {

    public static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    //@ManyToOne(fetch = FetchType.LAZY, optional = false)
    //@JoinColumn(name = "categoria_formula_id", nullable = false)
    //@OnDelete(action = OnDeleteAction.CASCADE)

    @Column(name = "insumo_id")
    private Long insumoId;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getInsumoId() {
        return insumoId;
    }

    public void setInsumoId(Long insumoId) {
        this.insumoId = insumoId;
    }
}
