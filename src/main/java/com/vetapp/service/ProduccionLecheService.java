package com.vetapp.service;

import com.vetapp.dto.ProduccionLecheDTO;

import java.util.ArrayList;

public interface ProduccionLecheService {
    ProduccionLecheDTO guardarProduccionLeche(ProduccionLecheDTO produccionLecheDto);

    ArrayList<ProduccionLecheDTO> obtenerProduccionLeches();

    ProduccionLecheDTO obtenerProduccionLechePorId(Long id);

    ProduccionLecheDTO actualizarProduccionLeche(ProduccionLecheDTO produccionLecheDto, Long id);

    boolean eliminarProduccionLeche(Long id);
}
