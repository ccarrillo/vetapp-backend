package com.vetapp.service;

import com.vetapp.dto.ParVetValueDTO;

import java.util.ArrayList;

public interface ParVetValueService {

    ArrayList<ParVetValueDTO> obtenerParVetValues(Long idParVet);
}
