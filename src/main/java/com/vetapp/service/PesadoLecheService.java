package com.vetapp.service;

import com.vetapp.dto.PesadoLecheDto;

import java.util.ArrayList;

public interface PesadoLecheService {

    PesadoLecheDto guardarPesadoLeche(PesadoLecheDto pesadoLecheDto);

    ArrayList<PesadoLecheDto> obtenerPesadoLeches();

    PesadoLecheDto obtenerPesadoLechePorId(Long id);

    PesadoLecheDto actualizarPesadoLeche(PesadoLecheDto pesadoLecheDto, Long id);

    boolean eliminarPesadoLeche(Long id);
}
