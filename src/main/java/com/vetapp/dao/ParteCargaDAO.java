package com.vetapp.dao;

import com.vetapp.model.ParteCarga;

import java.util.List;

public interface ParteCargaDAO extends GenericDAO<ParteCarga, Long> {

    List<ParteCarga> obtenerParteCargaPorFormulaId(Long formulaId);

    ParteCarga obtenerParteCargaPorIdYFormulaId(Long formulaId, Long parteCargaId);
}
