package com.vetapp.dao;

import java.util.List;

import com.vetapp.dto.RecordatorioEventoAnimalDTO;
import com.vetapp.model.RecordatorioEventoAnimal;

public interface RecordatorioEventoAnimalDAO extends GenericDAO<RecordatorioEventoAnimal, Long> {
    
	List<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventoAnimalPorIdEvento(Long id);

	List<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventoAnimalPorIdTipo(Long id);
	
	void eliminarDetalleRecordatorioAnimalPorIdTipoEvento(Long id);
}
