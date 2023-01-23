package com.vetapp.dao;

import com.vetapp.model.Ingredientes;

import java.util.List;

public interface IngredientesDAO extends GenericDAO<Ingredientes, Long> {

    List<Ingredientes> obtenerIngredientesPorFormulaId(Long formulaId);

    Ingredientes obtenerIngredientesPorIdYFormulaId(Long formulaId, Long ingredientesId);

    List<Ingredientes> obtenerIngredientesPorInsumoId(Long insumoId);

    Ingredientes obtenerIngredientesPorIdYInsumoId(Long insumoId, Long ingredientesId);

    Integer guardarIngredientesMasivo(Long formulaId, Long categoriaFormulaId);
}
