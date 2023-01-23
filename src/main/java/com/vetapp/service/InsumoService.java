package com.vetapp.service;

import com.vetapp.dto.InsumoDTO;

import java.util.ArrayList;

public interface InsumoService {

    InsumoDTO guardarInsumo(InsumoDTO insumoDTO);

    ArrayList<InsumoDTO> obtenerInsumos();

    InsumoDTO obtenerInsumoPorId(Long id);

    InsumoDTO actualizarInsumo(InsumoDTO insumoDTO, Long id);

    boolean eliminarInsumo(Long id);

    ArrayList<InsumoDTO> obtenerInsumoPorCategoriaFormulaId(Long categoriaFormulaId);
}
