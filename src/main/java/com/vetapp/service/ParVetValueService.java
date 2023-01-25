package com.vetapp.service;
import com.vetapp.dto.ParVetDTO;
import com.vetapp.dto.ParVetValueDTO;
import java.util.ArrayList;

public interface ParVetValueService {
	
	ParVetValueDTO guardarParVetValue(ParVetValueDTO parVetValueDTO);
	ArrayList<ParVetValueDTO> obtenerParVetValuesTodos();
    ArrayList<ParVetValueDTO> obtenerParVetValues(Long idParVet);
    ParVetValueDTO obtenerParVetValuePorId(Long id);
    ParVetValueDTO actualizarParVetValue(ParVetValueDTO parVetValueDto, Long id);
}
