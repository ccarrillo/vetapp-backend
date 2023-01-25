package com.vetapp.dao;

import java.util.List;
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.model.GrupoEvento;

public interface GrupoEventoDAO {
	
	List<GrupoEvento> obtenerGrupoEvento(boolean b);
	List<GrupoEventoDTO> obtenerGrupoEventoSinHijos(boolean b);

}
