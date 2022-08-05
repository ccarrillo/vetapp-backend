package com.vetapp.service;

import com.vetapp.dto.EventoDTO;

import java.util.ArrayList;

public interface EventoService {

    EventoDTO guardarEvento(EventoDTO eventoDto);

    ArrayList<EventoDTO> obtenerEventos();

    EventoDTO obtenerEventoPorId(Long id);

    EventoDTO actualizarEvento(EventoDTO eventoDto, Long id);

    boolean eliminarEvento(Long id);
}
