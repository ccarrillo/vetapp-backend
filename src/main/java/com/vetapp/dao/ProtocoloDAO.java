package com.vetapp.dao;

import java.util.List;
import com.vetapp.dto.ProtocoloDTO;
import com.vetapp.model.Protocolo;

public interface ProtocoloDAO extends GenericDAO<Protocolo, Long> {
      
	List<ProtocoloDTO> obtenerProtocoloGrupos();
}
