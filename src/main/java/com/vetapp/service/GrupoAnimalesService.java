package com.vetapp.service;


import java.util.List;

import com.vetapp.dto.GrupoDTO;
import com.vetapp.model.Grupo;


public interface GrupoAnimalesService {
	
	
	    GrupoDTO guardarGrupoAnimles(GrupoDTO grupoDto);

	    
	    List<Grupo> obtenerGrupoAnimales();
	    
	    List<GrupoDTO> obtenerGrupoAnimalesSinHijos();

	    GrupoDTO obtenerGrupoAnimalesPorId(Long id);

	    GrupoDTO actualizarGrupoAnimales(GrupoDTO grupoDto, Long id);

	    boolean eliminarGrupo(Long id);


		boolean existenciaAnimales(Long idgrupo);


		

}
