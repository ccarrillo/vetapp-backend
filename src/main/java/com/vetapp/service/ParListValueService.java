package com.vetapp.service;

import com.vetapp.dto.ParListValueDTO;

import java.util.ArrayList;

public interface ParListValueService {

    ParListValueDTO guardarParListValue(ParListValueDTO parListValueDto);

    ArrayList<ParListValueDTO> obtenerParListValues();

    ParListValueDTO obtenerParListValuePorId(Long id);

    ParListValueDTO actualizarParListValue(ParListValueDTO parListValueDto, Long id);

    boolean eliminarParListValue(Long id);

}
