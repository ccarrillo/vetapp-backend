package com.vetapp.service;

import com.vetapp.dto.RepartoProgramacionDTO;

import java.util.ArrayList;

public interface RepartoProgramacionService {

    RepartoProgramacionDTO guardarRepartoProgramacion(RepartoProgramacionDTO repartoProgramacionDTO);

    ArrayList<RepartoProgramacionDTO> obtenerRepartoProgramacions();

    RepartoProgramacionDTO obtenerRepartoProgramacionPorId(Long id);

    RepartoProgramacionDTO actualizarRepartoProgramacion(RepartoProgramacionDTO repartoProgramacionDTO, Long id);

    boolean eliminarRepartoProgramacion(Long id);

    ArrayList<RepartoProgramacionDTO> obtenerRepartoProgramacionPorFormulaId(Long formulaId);

    RepartoProgramacionDTO guardarRepartoProgramacion(Long formulaId, RepartoProgramacionDTO repartoProgramacionDTO);

    RepartoProgramacionDTO actualizarRepartoProgramacion(Long formulaId, Long repartoProgramacionId, RepartoProgramacionDTO repartoProgramacionDTO);

    boolean eliminarRepartoProgramacion(Long formulaId, Long repartoProgramacionId);
}
