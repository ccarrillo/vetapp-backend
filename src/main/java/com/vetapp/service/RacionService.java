package com.vetapp.service;

import com.vetapp.dto.RacionDTO;

import java.util.ArrayList;

public interface RacionService {

    RacionDTO guardarRacion(RacionDTO racionDto);

    ArrayList<RacionDTO> obtenerRacions();

    RacionDTO obtenerRacionPorId(Long id);

    RacionDTO actualizarRacion(RacionDTO racionDto, Long id);

    boolean eliminarRacion(Long id);

}
