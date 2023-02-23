package com.vetapp.dao;

import java.util.List;

import com.vetapp.dto.DetalleTipoEventoAnimalDTO;
import com.vetapp.model.DetalleTipoEventoAnimal;

public interface DetalleTipoEventoAnimalDAO extends GenericDAO<DetalleTipoEventoAnimal, Long> {

	List<DetalleTipoEventoAnimalDTO> obtenerListaDetallePorIdEventoAnimal(Long id);

}