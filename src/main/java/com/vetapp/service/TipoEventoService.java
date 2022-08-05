package com.vetapp.service;

import com.vetapp.dto.TipoEventoDto;

import java.util.ArrayList;

public interface TipoEventoService {

    TipoEventoDto guardarTipoEvento(TipoEventoDto tipoEventoDto);

    ArrayList<TipoEventoDto> obtenerTipoEventos();

    TipoEventoDto obtenerTipoEventoPorId(Long id);

    TipoEventoDto actualizarTipoEvento(TipoEventoDto tipoEventoDto, Long id);

    boolean eliminarTipoEvento(Long id);
}
