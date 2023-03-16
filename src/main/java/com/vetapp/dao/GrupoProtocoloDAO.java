package com.vetapp.dao;

import java.util.List;
import com.vetapp.dto.GrupoProtocoloDTO;
import com.vetapp.model.GrupoInventario;
import com.vetapp.model.GrupoProtocolo;

public interface GrupoProtocoloDAO extends GenericDAO<GrupoProtocolo, Long> {
      
	List<GrupoProtocolo> obtenerGrupoProtocolo(boolean b);
	List<GrupoProtocoloDTO> obtenerGrupoEventoSinHijos(boolean b);
	boolean existenciaProtocolo(Long idgrupo);
}
