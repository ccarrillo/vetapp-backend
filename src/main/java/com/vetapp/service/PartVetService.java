package com.vetapp.service;

import com.vetapp.dto.ParVetDTO;

import java.util.ArrayList;

public interface PartVetService {

    ParVetDTO guardarParVet(ParVetDTO parVetDto);

    ArrayList<ParVetDTO> obtenerParVet();

    ParVetDTO obtenerParVetPorId(Long id);

    ParVetDTO actualizarParVet(ParVetDTO parVetDto, Long id);

    boolean eliminarParVet(Long id);

}
