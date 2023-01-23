package com.vetapp.dao;

import com.vetapp.model.CategoriaFormulaInsumo;

import java.util.List;

public interface CategoriaFormulaInsumoDAO extends GenericDAO<CategoriaFormulaInsumo, Long> {

    List<CategoriaFormulaInsumo> obtenerCategoriaFormulaInsumoPorCategoriaFormulaId(Long categoriaFormulaId);
}
