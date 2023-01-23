package com.vetapp.dao;

import com.vetapp.model.Ingredientes;
import com.vetapp.model.Insumo;

import java.util.List;

public interface InsumoDAO extends GenericDAO<Insumo, Long> {

    List<Insumo> obtenerInsumoPorCategoriaFormulaId(Long categoriaFormulaId);

}
