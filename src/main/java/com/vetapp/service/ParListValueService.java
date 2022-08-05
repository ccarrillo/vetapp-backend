package com.vetapp.service;

import com.vetapp.dto.ParListValueDto;

import java.util.ArrayList;

public interface ParListValueService {

    ParListValueDto guardarParListValue(ParListValueDto parListValueDto);

    ArrayList<ParListValueDto> obtenerParListValues();

    ParListValueDto obtenerParListValuePorId(Long id);

    ParListValueDto actualizarParListValue(ParListValueDto parListValueDto, Long id);

    boolean eliminarParListValue(Long id);

}
