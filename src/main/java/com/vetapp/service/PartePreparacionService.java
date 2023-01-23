package com.vetapp.service;

import com.vetapp.dto.PartePreparacionDTO;

import java.util.ArrayList;

public interface PartePreparacionService {

    PartePreparacionDTO guardarPartePreparacion(PartePreparacionDTO partePreparacionDTO);

    ArrayList<PartePreparacionDTO> obtenerPartePreparacions();

    PartePreparacionDTO obtenerPartePreparacionPorId(Long id);

    PartePreparacionDTO actualizarPartePreparacion(PartePreparacionDTO partePreparacionDTO, Long id);

    boolean eliminarPartePreparacion(Long id);

    ArrayList<PartePreparacionDTO> obtenerPartePreparacionPorFormulaId(Long formulaId);

    PartePreparacionDTO guardarPartePreparacion(Long formulaId, PartePreparacionDTO partePreparacionDTO);

    PartePreparacionDTO actualizarPartePreparacion(Long formulaId, Long partePreparacionId, PartePreparacionDTO partePreparacionDTO);

    boolean eliminarPartePreparacion(Long formulaId, Long partePreparacionId);
}
