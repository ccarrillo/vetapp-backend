package com.vetapp.dao;

import java.util.List;

import com.vetapp.dto.RecordatorioEventoDTO;
import com.vetapp.model.RecordatorioEvento;

public interface RecordatorioEventoDAO extends GenericDAO<RecordatorioEvento, Long> {

	List<RecordatorioEventoDTO> obtenerRecordatorioEventoPorIdGrupo(Long id);

	List<RecordatorioEventoDTO> obtenerRecordatorioEventoPorIdTipo(Long id);
	
	void eliminarDetalleRecordatorioPorIdTipoEvento(Long id);

}