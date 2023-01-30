package com.vetapp.dao;

import java.util.List;

import com.vetapp.dto.DetalleProtocoloDTO;
import com.vetapp.model.DetalleProtocolo;

public interface DetalleProtocoloDAO extends GenericDAO<DetalleProtocolo, Long> {

	List<DetalleProtocoloDTO> obtenerListaDetalleProtocoloPorIdTipo(Long id);

	void eliminarDetalleProtocoloPorIdProtocolo(Long id);

}
