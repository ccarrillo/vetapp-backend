package com.vetapp.service;

import com.vetapp.dto.RecordatorioEventoDto;

import java.util.ArrayList;

public interface RecordatorioEventoService {

    RecordatorioEventoDto guardarRecordatorioEvento(RecordatorioEventoDto recordatorioEventoDto);

    ArrayList<RecordatorioEventoDto> obtenerRecordatorioEventos();

    RecordatorioEventoDto obtenerRecordatorioEventoPorId(Long id);

    RecordatorioEventoDto actualizarRecordatorioEvento(RecordatorioEventoDto recordatorioEventoDto, Long id);

    boolean eliminarRecordatorioEvento(Long id);
}
