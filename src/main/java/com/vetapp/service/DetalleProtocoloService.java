package com.vetapp.service;

import java.util.ArrayList;
import java.util.List;

import com.vetapp.dto.DetalleProtocoloDTO;

public interface DetalleProtocoloService {
	
	    DetalleProtocoloDTO guardarDetalleProtocolo(DetalleProtocoloDTO detalleDto);

	    ArrayList< DetalleProtocoloDTO> obtenerDetalleProtocolo();

	    DetalleProtocoloDTO obtenerDetalleProtocoloPorId(Long id);
	    

	    DetalleProtocoloDTO actualizarDetalleProtocolo(DetalleProtocoloDTO detalleDto, Long id);

	    boolean eliminarDetalleProtocolo(Long id);

		List<DetalleProtocoloDTO> buscarDetalleProtocoloPorAnimal(Long id);

}
