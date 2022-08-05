package com.vetapp.dao;

import com.vetapp.model.ParVet;

import java.util.List;

public interface ParVetDAO extends GenericDAO<ParVet, Long> {

    List<ParVet> buscarInactivos(Boolean estado);

}