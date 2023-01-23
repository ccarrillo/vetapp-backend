package com.vetapp.service;

import com.vetapp.dto.CategoriaFormulaAlimentosDTO;
import com.vetapp.dto.FormulaDTO;
import com.vetapp.dto.RepartoDTO;

import java.util.ArrayList;

public interface CategoriaFormulaAlimentosService {

    CategoriaFormulaAlimentosDTO guardarCategoriaFormulaAlimentos(CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO);

    ArrayList<CategoriaFormulaAlimentosDTO> obtenerCategoriaFormulaAlimentos();

    CategoriaFormulaAlimentosDTO obtenerCategoriaFormulaAlimentosPorId(Long id);

    CategoriaFormulaAlimentosDTO actualizarCategoriaFormulaAlimentos(CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO, Long id);

    boolean eliminarCategoriaFormulaAlimentos(Long id);

    ArrayList<CategoriaFormulaAlimentosDTO> obtenerCategoriaFormulaAlimentosPorCategoriaFormulaId(Long categoriaFormulaId);

    CategoriaFormulaAlimentosDTO guardarCategoriaFormulaAlimentos(Long categoriaFormulaId, CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO);

    CategoriaFormulaAlimentosDTO actualizarCategoriaFormulaAlimentos(Long categoriaFormulaId, Long categoriaFormulaAlimentosId, CategoriaFormulaAlimentosDTO categoriaFormulaAlimentosDTO);

    boolean eliminarCategoriaFormulaAlimentos(Long categoriaFormulaId, Long categoriaFormulaAlimentosId);
}
