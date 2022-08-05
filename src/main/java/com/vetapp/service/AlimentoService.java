package com.vetapp.service;

import com.vetapp.dto.AlimentoDTO;

import java.util.ArrayList;

public interface AlimentoService {

    AlimentoDTO guardarAlimento(AlimentoDTO alimentoDto);

    ArrayList<AlimentoDTO> obtenerAlimentos();

    AlimentoDTO obtenerAlimentoPorId(Long id);

    AlimentoDTO actualizarAlimento(AlimentoDTO alimentoDto, Long id);

    boolean eliminarAlimento(Long id);
}
