package com.vetapp.dao;

import java.util.List;
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.model.Grupo;
import com.vetapp.model.GrupoEvento;

public interface GrupoEventoDAO extends GenericDAO<GrupoEvento, Long>{
	
	List<GrupoEvento> obtenerGrupoEvento(boolean b);
	List<GrupoEventoDTO> obtenerGrupoEventoSinHijos(boolean b);
	boolean existenciaEvento(Long idgrupo);

}
