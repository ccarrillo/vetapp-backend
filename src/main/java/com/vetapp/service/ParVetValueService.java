package com.vetapp.service;

import com.vetapp.dto.ParVetValueDto;

import java.util.ArrayList;

public interface ParVetValueService {

    ArrayList<ParVetValueDto> obtenerParVetValues(Long idParVet);
}
