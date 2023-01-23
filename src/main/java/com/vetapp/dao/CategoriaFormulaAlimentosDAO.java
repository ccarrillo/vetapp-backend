package com.vetapp.dao;

import com.vetapp.model.CategoriaFormulaAlimentos;

import java.util.List;

public interface CategoriaFormulaAlimentosDAO extends GenericDAO<CategoriaFormulaAlimentos, Long> {

    List<CategoriaFormulaAlimentos> obtenerCategoriaFormulaAlimentosPorCategoriaFormulaId(Long categoriaFormulaId);

    CategoriaFormulaAlimentos obtenerCategoriaFormulaAlimentosPorIdYCategoriaFormulaId(Long categoriaFormulaId, Long categoriaFormulaAlimentosId);
}
