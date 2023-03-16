package com.vetapp.service;

import java.util.List;

import com.vetapp.dto.GrupoInventarioDTO;
import com.vetapp.model.GrupoInventario;

public interface GrupoInventarioSemenService {
     
	  GrupoInventarioDTO guardarGrupoInventario(GrupoInventarioDTO grupoDto);
      
	  List<GrupoInventario> obtenerGrupoInventarioSemen();
	  List<GrupoInventarioDTO> obtenerGrupoInventarioSinHijos();
	  GrupoInventarioDTO obtenerGrupoInventarioPorId(Long id);
	  GrupoInventarioDTO actualizarGrupoInventario(GrupoInventarioDTO grupoDto, Long id);
	  boolean eliminarGrupoInventario(Long id);
      boolean existenciaInventario(Long idgrupo);

	
}
