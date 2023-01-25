package com.vetapp.service;

import java.util.List;
import com.vetapp.dto.GrupoProtocoloDTO;
import com.vetapp.model.GrupoProtocolo;

public interface GrupoProtocoloService {
	
	GrupoProtocoloDTO guardarGrupoProtocolo(GrupoProtocoloDTO grupoProtocoloDto);
    
    List<GrupoProtocolo> obtenerGrupoProtocolo();
    
    List<GrupoProtocoloDTO> obtenerGrupoProtocoloSinHijos();

    GrupoProtocoloDTO obtenerGrupoProtocoloPorId(Long id);

    GrupoProtocoloDTO actualizarGrupoProtocolo(GrupoProtocoloDTO grupoProtocoloDto, Long id);

    boolean eliminarGrupoProtocolo(Long id);

}
