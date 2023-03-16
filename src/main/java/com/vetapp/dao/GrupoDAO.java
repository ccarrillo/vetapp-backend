package com.vetapp.dao;

import java.util.List;

import com.vetapp.dto.GrupoDTO;
import com.vetapp.model.Grupo;

public interface GrupoDAO extends GenericDAO<Grupo, Long> {
	List<Grupo> obtenerGrupoAnimales(boolean b);
	List<GrupoDTO> obtenerGrupoAnimalesSinHijos(boolean b);
	boolean existenciaAnimales(Long idgrupo);
}
