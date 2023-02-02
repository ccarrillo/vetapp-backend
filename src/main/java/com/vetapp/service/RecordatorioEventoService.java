package com.vetapp.service;

import com.vetapp.dto.RecordatorioEventoDTO;

import java.util.ArrayList;
import java.util.List;

public interface RecordatorioEventoService {

    RecordatorioEventoDTO guardarRecordatorioEvento(RecordatorioEventoDTO recordatorioEventoDto);

    ArrayList<RecordatorioEventoDTO> obtenerRecordatorioEventos();

    RecordatorioEventoDTO obtenerRecordatorioEventoPorId(Long id);

    RecordatorioEventoDTO actualizarRecordatorioEvento(RecordatorioEventoDTO recordatorioEventoDto, Long id);

    boolean eliminarRecordatorioEvento(Long id);

	List<RecordatorioEventoDTO> obtenerRecordatorioEventoPorIdGrupo(Long id);

	List<RecordatorioEventoDTO> obtenerRecordatorioEventoPorIdTipo(Long id);
	
	void eliminarDetalleRecordatorioPorIdTipoEvento(Long id);
}
