package com.vetapp.dao;

import com.vetapp.model.RepartoProgramacion;

import java.util.List;

public interface RepartoProgramacionDAO extends GenericDAO<RepartoProgramacion, Long> {

    List<RepartoProgramacion> obtenerRepartoProgramacionPorFormulaId(Long formulaId);

    RepartoProgramacion obtenerRepartoProgramacionPorIdYFormulaId(Long formulaId, Long repartoProgramacionId);

}
