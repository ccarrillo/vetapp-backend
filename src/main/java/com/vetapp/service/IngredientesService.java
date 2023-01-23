package com.vetapp.service;

import com.vetapp.dto.IngredientesDTO;

import java.util.ArrayList;

public interface IngredientesService {

    IngredientesDTO guardarIngredientes(IngredientesDTO ingredientesDTO);

    ArrayList<IngredientesDTO> obtenerIngredientess();

    IngredientesDTO obtenerIngredientesPorId(Long id);

    IngredientesDTO actualizarIngredientes(IngredientesDTO ingredientesDTO, Long id);

    boolean eliminarIngredientes(Long id);

    ArrayList<IngredientesDTO> obtenerIngredientesPorFormulaId(Long formulaId);

    IngredientesDTO guardarIngredientes(Long formulaId, IngredientesDTO ingredientesDTO);

    IngredientesDTO actualizarIngredientes(Long formulaId, Long ingredientesId, IngredientesDTO ingredientesDTO);

    boolean eliminarIngredientes(Long formulaId, Long ingredientesId);

    Integer guardarIngredientesMasivo(Long formulaId, Long categoriaFormulaId);

}
