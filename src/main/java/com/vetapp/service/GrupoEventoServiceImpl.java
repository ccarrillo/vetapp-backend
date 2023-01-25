package com.vetapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.GrupoDAO;
import com.vetapp.dao.GrupoEventoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.GrupoDTO;
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.model.Grupo;
import com.vetapp.model.GrupoEvento;

@Service
@Transactional
public class GrupoEventoServiceImpl implements GrupoEventoService {
	
	
	@Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    GrupoEventoDAO grupoEventoDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();
    
    
    private GrupoEventoDTO convertEntityToDto(GrupoEvento grupoEvento) {
        if (grupoEvento != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            GrupoEventoDTO grupoEventoDto = new GrupoEventoDTO();
            grupoEventoDto = modelMapper.map(grupoEvento, GrupoEventoDTO.class);
            return grupoEventoDto;
        } else {
            return null;
        }
    }

    private GrupoEvento convertDtoToEntity(GrupoEventoDTO grupoEventoDto) {
        if (grupoEventoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            GrupoEvento grupoEvento = new GrupoEvento();
            grupoEvento = modelMapper.map(grupoEventoDto, GrupoEvento.class);
            return grupoEvento;
        } else {
            return null;
        }
    }

	@Override
	public GrupoEventoDTO guardarGrupoEvento(GrupoEventoDTO grupoEventoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrupoEvento> obtenerGrupoEvento() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<GrupoEventoDTO> obtenerGrupoEventoSinHijos() {
		// TODO Auto-generated method stub
		return grupoEventoDao.obtenerGrupoEventoSinHijos(true);
	}

	@Override
	public GrupoEventoDTO obtenerGrupoEventoPorId(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public GrupoEventoDTO actualizarGrupoEvento(GrupoEventoDTO grupoEventoDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarGrupoEvento(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

}
