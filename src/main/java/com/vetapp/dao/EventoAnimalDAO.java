package com.vetapp.dao;


import java.util.List;

import com.vetapp.dto.EventoAnimalDTO;
import com.vetapp.model.EventoAnimal;

public interface EventoAnimalDAO extends GenericDAO<EventoAnimal, Long> {

	List<EventoAnimalDTO> obtenerEventosPorIdAnimal(Long id);




	

}