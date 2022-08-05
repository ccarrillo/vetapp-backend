package com.vetapp.service;

import com.vetapp.dto.ParVetDto;

import java.util.ArrayList;

public interface PartVetService {

    ParVetDto guardarParVet(ParVetDto parVetDto);

    ArrayList<ParVetDto> obtenerParVet();

    ParVetDto obtenerParVetPorId(Long id);

    ParVetDto actualizarParVet(ParVetDto parVetDto, Long id);

    boolean eliminarParVet(Long id);

}
