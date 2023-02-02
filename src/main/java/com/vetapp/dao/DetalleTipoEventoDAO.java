package com.vetapp.dao;

import java.util.List;

import com.vetapp.dto.DetalleTipoEventoDTO;
import com.vetapp.model.DetalleTipoEvento;

public interface DetalleTipoEventoDAO extends GenericDAO<DetalleTipoEvento, Long> {

	 

	List<DetalleTipoEventoDTO> obtenerListaDetalleTipoEventoPorIdTipo(Long id);

	void eliminarDetalleTipoEventoPorIdTipoEvento(Long id);

}