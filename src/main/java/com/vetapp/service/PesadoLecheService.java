package com.vetapp.service;

import com.vetapp.dto.PesadoLecheDTO;

import java.util.ArrayList;

public interface PesadoLecheService {

    PesadoLecheDTO guardarPesadoLeche(PesadoLecheDTO pesadoLecheDto);

    ArrayList<PesadoLecheDTO> obtenerPesadoLeches();

    PesadoLecheDTO obtenerPesadoLechePorId(Long id);

    PesadoLecheDTO actualizarPesadoLeche(PesadoLecheDTO pesadoLecheDto, Long id);

    boolean eliminarPesadoLeche(Long id);
}
