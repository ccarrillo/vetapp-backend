package com.vetapp.service;

import java.util.ArrayList;
import java.util.List;

import com.vetapp.dto.DetalleProtocoloDTO;
import com.vetapp.dto.ProtocoloDTO;

public interface DetalleProtocoloService {
	
	    DetalleProtocoloDTO guardarDetalleProtocolo(DetalleProtocoloDTO detalleDto);

	    ArrayList< DetalleProtocoloDTO> obtenerDetalleProtocolo();

	    DetalleProtocoloDTO obtenerDetalleProtocoloPorId(Long id);
	    

	    DetalleProtocoloDTO actualizarDetalleProtocolo(DetalleProtocoloDTO detalleDto, Long id);

	    boolean eliminarDetalleProtocolo(Long id);
	    
	    void eliminarDetalleProtocoloPorIdProtocolo(Long id);

		List<DetalleProtocoloDTO> buscarDetalleProtocoloPorAnimal(Long id);

		List<DetalleProtocoloDTO> obtenerListaDetalleProtocolo(Long id);
		
		DetalleProtocoloDTO guardarDetalleProtocolo(ProtocoloDTO protocolo,DetalleProtocoloDTO detalleDto);
        
		DetalleProtocoloDTO actualizarDetalleProtocolo( ProtocoloDTO protocolo, DetalleProtocoloDTO detalleDto,Long id);
}
