package com.vetapp.service;

import java.util.ArrayList;
import java.util.List;

import com.vetapp.dto.EventoAnimalDTO;
import com.vetapp.dto.RecordatorioEventoAnimalDTO;
import com.vetapp.dto.RecordatorioEventoDTO;

public interface RecordatorioEventoAnimalService {
	
	 RecordatorioEventoAnimalDTO guardarRecordatorioEvento(RecordatorioEventoAnimalDTO recordatorioEventoAnimalDto);
    ArrayList<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventos(RecordatorioEventoAnimalDTO recordatorioEventoAnimalDto);

    RecordatorioEventoAnimalDTO obtenerRecordatorioEventoPorId(Long id);

    RecordatorioEventoAnimalDTO actualizarRecordatorioEvento(RecordatorioEventoAnimalDTO recordatorioEventoAnimalDto, Long id);

    boolean eliminarRecordatorioEventoAnimal(Long id);

	List<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventoAnimalPorIdEvento(Long id);

	List<RecordatorioEventoAnimalDTO> obtenerRecordatorioEventoPorIdTipo(Long id);
	
	void eliminarDetalleRecordatorioPorIdTipoEvento(Long id);
	
	 RecordatorioEventoAnimalDTO guardarRecordatorioEvento(EventoAnimalDTO eventoAnimalDTO, RecordatorioEventoAnimalDTO recordatorioEventoDto);
	 RecordatorioEventoAnimalDTO actualizarRecordatorioEvento(EventoAnimalDTO eventoAnimalDTO ,RecordatorioEventoAnimalDTO recordatorioEventoDto, Long id);

}
