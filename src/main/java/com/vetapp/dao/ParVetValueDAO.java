package com.vetapp.dao;

import com.vetapp.model.ParVetValue;

import java.util.List;

public interface ParVetValueDAO extends GenericDAO<ParVetValue, Long> {

    List<ParVetValue> findParVetValueByParvetId(Long idParVet);

}