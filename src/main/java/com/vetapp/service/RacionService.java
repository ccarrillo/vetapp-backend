package com.vetapp.service;

import com.vetapp.dto.RacionDto;

import java.util.ArrayList;

public interface RacionService {

    RacionDto guardarRacion(RacionDto racionDto);

    ArrayList<RacionDto> obtenerRacions();

    RacionDto obtenerRacionPorId(Long id);

    RacionDto actualizarRacion(RacionDto racionDto, Long id);

    boolean eliminarRacion(Long id);

}
