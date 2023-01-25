package com.vetapp.service;

import java.util.List;


import com.vetapp.dto.GrupoEventoDTO;

import com.vetapp.model.GrupoEvento;

public interface GrupoEventoService {
	
	    GrupoEventoDTO guardarGrupoEvento(GrupoEventoDTO grupoEventoDto);
	    
	    List<GrupoEvento> obtenerGrupoEvento();
	    
	    List<GrupoEventoDTO> obtenerGrupoEventoSinHijos();

	    GrupoEventoDTO obtenerGrupoEventoPorId(Long id);

	    GrupoEventoDTO actualizarGrupoEvento(GrupoEventoDTO grupoEventoDto, Long id);

	    boolean eliminarGrupoEvento(Long id);

}
