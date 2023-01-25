package com.vetapp.dao;

import java.util.List;

import com.vetapp.dto.TipoEventoDTO;
import com.vetapp.model.TipoEvento;

public interface TipoEventoDAO extends GenericDAO<TipoEvento, Long> {

	List<TipoEventoDTO> obtenerTipoEventosGrupos();

}