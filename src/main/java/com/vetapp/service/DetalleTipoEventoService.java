package com.vetapp.service;

import com.vetapp.dto.DetalleTipoEventoDTO;

import java.util.ArrayList;

public interface DetalleTipoEventoService {

    DetalleTipoEventoDTO guardarDetalleTipoEvento(DetalleTipoEventoDTO detalleTipoEventoDto);

    ArrayList<DetalleTipoEventoDTO> obtenerDetalleTipoEventos();

    DetalleTipoEventoDTO obtenerDetalleTipoEventoPorId(Long id);

    DetalleTipoEventoDTO actualizarDetalleTipoEvento(DetalleTipoEventoDTO detalleTipoEventoDto, Long id);

    boolean eliminarDetalleTipoEvento(Long id);

}
