package com.vetapp.service;

import com.vetapp.dto.ProduccionLecheDto;

import java.util.ArrayList;

public interface ProduccionLecheService {
    ProduccionLecheDto guardarProduccionLeche(ProduccionLecheDto produccionLecheDto);

    ArrayList<ProduccionLecheDto> obtenerProduccionLeches();

    ProduccionLecheDto obtenerProduccionLechePorId(Long id);

    ProduccionLecheDto actualizarProduccionLeche(ProduccionLecheDto produccionLecheDto, Long id);

    boolean eliminarProduccionLeche(Long id);
}
