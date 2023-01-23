package com.vetapp.service;

import com.vetapp.dto.CategoriaFormulaDTO;

import java.util.ArrayList;

public interface CategoriaFormulaService {

    CategoriaFormulaDTO guardarCategoriaFormula(CategoriaFormulaDTO categoriaFormulaDto);

    ArrayList<CategoriaFormulaDTO> obtenerCategoriaFormulas();

    CategoriaFormulaDTO obtenerCategoriaFormulaPorId(Long id);

    CategoriaFormulaDTO actualizarCategoriaFormula(CategoriaFormulaDTO employeeDto, Long id);

    boolean eliminarCategoriaFormula(Long id);
}
