package com.vetapp.dao;

import java.util.List;

import com.vetapp.dto.GrupoInventarioDTO;
import com.vetapp.model.GrupoInventario;

public interface GrupoInventarioSemenDAO extends GenericDAO<GrupoInventario, Long> {
	List<GrupoInventario> obtenerGrupoInventarioSemen(boolean b);

	boolean existenciaInventario(Long idgrupo);

	List<GrupoInventarioDTO> obtenerGrupoInventarioSinHijos(boolean b);
}
