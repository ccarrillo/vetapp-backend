package com.vetapp.service;

import com.vetapp.dto.FormulaDTO;

import java.util.ArrayList;

public interface FormulaService {

    FormulaDTO guardarFormula(FormulaDTO formulaDTO);

    ArrayList<FormulaDTO> obtenerFormulas();

    FormulaDTO obtenerFormulaPorId(Long id);

    FormulaDTO actualizarFormula(FormulaDTO formulaDTO, Long id);

    boolean eliminarFormula(Long id);
}
