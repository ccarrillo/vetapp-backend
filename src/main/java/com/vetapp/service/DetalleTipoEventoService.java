package com.vetapp.service;

import com.vetapp.dto.DetalleTipoEventoDTO;

import java.util.ArrayList;
import java.util.List;

public interface DetalleTipoEventoService {

    DetalleTipoEventoDTO guardarDetalleTipoEvento(DetalleTipoEventoDTO detalleTipoEventoDto);

    ArrayList<DetalleTipoEventoDTO> obtenerDetalleTipoEventos();
    
    List<DetalleTipoEventoDTO>  obtenerListaDetalleTipoEventoPorIdTipo(Long id);

    DetalleTipoEventoDTO obtenerDetalleTipoEventoPorId(Long id);

    DetalleTipoEventoDTO actualizarDetalleTipoEvento(DetalleTipoEventoDTO detalleTipoEventoDto, Long id);

    boolean eliminarDetalleTipoEvento(Long id);
    
    void eliminarDetalleTipoEventoPorIdTipoEvento(Long id);

}
