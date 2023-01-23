package com.vetapp.dao;

import com.vetapp.model.PartePreparacion;

import java.util.List;

public interface PartePreparacionDAO extends GenericDAO<PartePreparacion, Long> {

    List<PartePreparacion> obtenerPartePreparacionPorFormulaId(Long formulaId);

    PartePreparacion obtenerPartePreparacionPorIdYFormulaId(Long formulaId, Long partePreparacionId);
}
