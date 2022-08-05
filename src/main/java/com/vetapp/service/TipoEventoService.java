package com.vetapp.service;

import com.vetapp.dto.TipoEventoDTO;

import java.util.ArrayList;

public interface TipoEventoService {

    TipoEventoDTO guardarTipoEvento(TipoEventoDTO tipoEventoDto);

    ArrayList<TipoEventoDTO> obtenerTipoEventos();

    TipoEventoDTO obtenerTipoEventoPorId(Long id);

    TipoEventoDTO actualizarTipoEvento(TipoEventoDTO tipoEventoDto, Long id);

    boolean eliminarTipoEvento(Long id);
}
