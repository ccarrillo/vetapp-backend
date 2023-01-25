package com.vetapp.dao;

import java.util.List;

import com.vetapp.dto.GrupoInventarioDTO;
import com.vetapp.model.GrupoInventario;

public interface GrupoInventarioSemenDAO extends GenericDAO<GrupoInventario, Long> {
	List<GrupoInventarioDTO> obtenerGrupoInventarioSemen(boolean b);
}
