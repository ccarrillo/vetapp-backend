package com.vetapp.service;

import com.vetapp.dto.RepartoDTO;

import java.util.ArrayList;

public interface RepartoService {

    RepartoDTO guardarReparto(RepartoDTO repartoDTO);

    ArrayList<RepartoDTO> obtenerRepartos();

    RepartoDTO obtenerRepartoPorId(Long id);

    RepartoDTO actualizarReparto(RepartoDTO repartoDTO, Long id);

    boolean eliminarReparto(Long id);

    ArrayList<RepartoDTO> obtenerRepartoPorFormulaId(Long formulaId);

    RepartoDTO guardarReparto(Long formulaId, RepartoDTO repartoDTO);

    RepartoDTO actualizarReparto(Long formulaId, Long repartoId, RepartoDTO repartoDTO);

    boolean eliminarReparto(Long formulaId, Long repartoId);
}
