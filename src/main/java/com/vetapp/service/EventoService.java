package com.vetapp.service;

import com.vetapp.dto.EventoDto;

import java.util.ArrayList;

public interface EventoService {

    EventoDto guardarEvento(EventoDto eventoDto);

    ArrayList<EventoDto> obtenerEventos();

    EventoDto obtenerEventoPorId(Long id);

    EventoDto actualizarEvento(EventoDto eventoDto, Long id);

    boolean eliminarEvento(Long id);
}
