package com.vetapp.service;

import com.vetapp.dto.AlimentoDto;

import java.util.ArrayList;

public interface AlimentoService {

    AlimentoDto guardarAlimento(AlimentoDto alimentoDto);

    ArrayList<AlimentoDto> obtenerAlimentos();

    AlimentoDto obtenerAlimentoPorId(Long id);

    AlimentoDto actualizarAlimento(AlimentoDto alimentoDto, Long id);

    boolean eliminarAlimento(Long id);
}
