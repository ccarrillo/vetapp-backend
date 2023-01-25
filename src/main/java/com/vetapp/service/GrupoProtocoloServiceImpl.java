package com.vetapp.service;

import java.util.List;

import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.GrupoProtocoloDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.dto.GrupoProtocoloDTO;
import com.vetapp.model.GrupoEvento;
import com.vetapp.model.GrupoProtocolo;

@Service
@Transactional
public class GrupoProtocoloServiceImpl implements GrupoProtocoloService {
    
	@Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    GrupoProtocoloDAO grupoProtocoloDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();
    
    
    private GrupoProtocoloDTO convertEntityToDto(GrupoProtocolo grupoProtocolo) {
        if (grupoProtocolo != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            GrupoProtocoloDTO grupoProtocoloDto = new GrupoProtocoloDTO();
            grupoProtocoloDto = modelMapper.map(grupoProtocolo, GrupoProtocoloDTO.class);
            return grupoProtocoloDto;
        } else {
            return null;
        }
    }

    private GrupoProtocolo convertDtoToEntity(GrupoProtocoloDTO grupoProtocoloDto) {
        if (grupoProtocoloDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            GrupoProtocolo grupoProtocolo = new GrupoProtocolo();
            grupoProtocolo = modelMapper.map(grupoProtocoloDto, GrupoProtocolo.class);
            return grupoProtocolo;
        } else {
            return null;
        }
    }
	
	
	@Override
	public GrupoProtocoloDTO guardarGrupoProtocolo(GrupoProtocoloDTO grupoProtocoloDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrupoProtocolo> obtenerGrupoProtocolo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrupoProtocoloDTO> obtenerGrupoProtocoloSinHijos() {
		// TODO Auto-generated method stub
		return grupoProtocoloDao.obtenerGrupoEventoSinHijos(true);
	}

	@Override
	public GrupoProtocoloDTO obtenerGrupoProtocoloPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoProtocoloDTO actualizarGrupoProtocolo(GrupoProtocoloDTO grupoProtocoloDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarGrupoProtocolo(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
