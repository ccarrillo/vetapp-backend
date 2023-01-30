package com.vetapp.service;

import java.util.ArrayList;
import java.util.List;
import com.vetapp.dto.ProtocoloDTO;
import com.vetapp.dto.TipoEventoDTO;

public interface ProtocoloService {
	
	ProtocoloDTO guardarProtocolo(ProtocoloDTO protocoloDto);

    ArrayList< ProtocoloDTO> obtenerProtocolo();

    ProtocoloDTO obtenerProtocoloPorId(Long id);
    
    List<ProtocoloDTO> obtenerProtocoloGrupos();

    ProtocoloDTO actualizarProtocolo(ProtocoloDTO protocoloDto, Long id);

    boolean eliminarProtocolo(Long id);

	List<ProtocoloDTO> buscarProtocoloPorAnimal(Long id);

	ProtocoloDTO obtenerDetalleProtocoloPorIdProtocolo(Long id);

}
