package com.vetapp.service;

import com.vetapp.dto.ParteCargaDTO;

import java.util.ArrayList;

public interface ParteCargaService {

    ParteCargaDTO guardarParteCarga(ParteCargaDTO parteCargaDTO);

    ArrayList<ParteCargaDTO> obtenerParteCargas();

    ParteCargaDTO obtenerParteCargaPorId(Long id);

    ParteCargaDTO actualizarParteCarga(ParteCargaDTO parteCargaDTO, Long id);

    boolean eliminarParteCarga(Long id);

    ArrayList<ParteCargaDTO> obtenerParteCargaPorFormulaId(Long formulaId);

    ParteCargaDTO guardarParteCarga(Long formulaId, ParteCargaDTO parteCargaDTO);

    ParteCargaDTO actualizarParteCarga(Long formulaId, Long parteCargaId, ParteCargaDTO parteCargaDTO);

    boolean eliminarParteCarga(Long formulaId, Long parteCargaId);
}
