package com.vetapp.service;

import com.vetapp.dto.RecordatorioEventoDTO;

import java.util.ArrayList;

public interface RecordatorioEventoService {

    RecordatorioEventoDTO guardarRecordatorioEvento(RecordatorioEventoDTO recordatorioEventoDto);

    ArrayList<RecordatorioEventoDTO> obtenerRecordatorioEventos();

    RecordatorioEventoDTO obtenerRecordatorioEventoPorId(Long id);

    RecordatorioEventoDTO actualizarRecordatorioEvento(RecordatorioEventoDTO recordatorioEventoDto, Long id);

    boolean eliminarRecordatorioEvento(Long id);
}
