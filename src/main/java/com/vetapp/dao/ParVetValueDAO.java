package com.vetapp.dao;

import com.vetapp.dto.ParVetValueDTO;
import com.vetapp.model.ParVet;
import com.vetapp.model.ParVetValue;

import java.util.List;

public interface ParVetValueDAO extends GenericDAO<ParVetValue, Long> {

    List<ParVetValue> findParVetValueByParvetId(Long idParVet);
    List<ParVetValueDTO> buscarTodos(Boolean estado);

}