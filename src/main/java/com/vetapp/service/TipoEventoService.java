package com.vetapp.service;

import com.vetapp.dto.TipoEventoDTO;

import java.util.ArrayList;
import java.util.List;

public interface TipoEventoService {

    TipoEventoDTO guardarTipoEvento(TipoEventoDTO tipoEventoDto);

    ArrayList<TipoEventoDTO> obtenerTipoEventos();
    
    List<TipoEventoDTO> obtenerTipoEventosGrupos();

    TipoEventoDTO obtenerTipoEventoPorId(Long id);

    TipoEventoDTO actualizarTipoEvento(TipoEventoDTO tipoEventoDto, Long id);

    boolean eliminarTipoEvento(Long id);
    
}
