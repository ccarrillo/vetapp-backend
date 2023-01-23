package com.vetapp.dao;

import com.vetapp.model.Reparto;
import com.vetapp.model.Reparto;

import java.util.List;

public interface RepartoDAO extends GenericDAO<Reparto, Long> {

    List<Reparto> obtenerRepartoPorFormulaId(Long formulaId);

    Reparto obtenerRepartoPorIdYFormulaId(Long formulaId, Long repartoId);

}
