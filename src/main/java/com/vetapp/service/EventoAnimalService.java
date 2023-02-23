package com.vetapp.service;

import com.vetapp.dto.EventoAnimalDTO;


import java.util.ArrayList;
import java.util.List;

public interface EventoAnimalService {

    EventoAnimalDTO guardarEvento(EventoAnimalDTO eventoDto);

    ArrayList<EventoAnimalDTO> obtenerEventos();

    EventoAnimalDTO obtenerEventoPorId(Long id);

    EventoAnimalDTO actualizarEvento(EventoAnimalDTO eventoDto, Long id);

    boolean eliminarEvento(Long id);

	List<EventoAnimalDTO> obtenerEventosPorIdAnimal(Long id);
}
