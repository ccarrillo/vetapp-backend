package com.vetapp.dao;

import java.util.List;
import com.vetapp.dto.GrupoProtocoloDTO;
import com.vetapp.model.GrupoProtocolo;

public interface GrupoProtocoloDAO {
      
	List<GrupoProtocolo> obtenerGrupoEvento(boolean b);
	List<GrupoProtocoloDTO> obtenerGrupoEventoSinHijos(boolean b);
}
