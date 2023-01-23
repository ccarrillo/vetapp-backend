package com.vetapp.service;

import com.vetapp.dto.CategoriaFormulaInsumoDTO;

import java.util.ArrayList;

public interface CategoriaFormulaInsumoService {

    CategoriaFormulaInsumoDTO guardarCategoriaFormulaInsumo(CategoriaFormulaInsumoDTO categoriaFormulaInsumoDTO);

    ArrayList<CategoriaFormulaInsumoDTO> obtenerCategoriaFormulaInsumos();

    CategoriaFormulaInsumoDTO obtenerCategoriaFormulaInsumoPorId(Long id);

    CategoriaFormulaInsumoDTO actualizarCategoriaFormulaInsumo(CategoriaFormulaInsumoDTO categoriaFormulaInsumoDTO, Long id);

    boolean eliminarCategoriaFormulaInsumo(Long id);

    ArrayList<CategoriaFormulaInsumoDTO> obtenerCategoriaFormulaInsumoPorCategoriaFormulaId(Long categoriaFormulaId);
}
