package com.vetapp.service;

import com.vetapp.dto.DetalleTipoEventoDto;

import java.util.ArrayList;

public interface DetalleTipoEventoService {

    DetalleTipoEventoDto guardarDetalleTipoEvento(DetalleTipoEventoDto detalleTipoEventoDto);

    ArrayList<DetalleTipoEventoDto> obtenerDetalleTipoEventos();

    DetalleTipoEventoDto obtenerDetalleTipoEventoPorId(Long id);

    DetalleTipoEventoDto actualizarDetalleTipoEvento(DetalleTipoEventoDto detalleTipoEventoDto, Long id);

    boolean eliminarDetalleTipoEvento(Long id);

}
