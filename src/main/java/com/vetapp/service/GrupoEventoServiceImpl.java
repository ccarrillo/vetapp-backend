package com.vetapp.service;

import java.util.Calendar;
import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.GrupoDAO;
import com.vetapp.dao.GrupoEventoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.GrupoDTO;
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.model.Grupo;
import com.vetapp.model.GrupoEvento;
import com.vetapp.model.GrupoInventario;
import com.vetapp.model.UserAuth;

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
		Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        grupoEventoDto.setUserCreation(user.getId());
        grupoEventoDto.setCreatedAt(Calendar.getInstance().getTime());
        GrupoEvento obj = grupoEventoDao.insertar(convertDtoToEntity(grupoEventoDto));
        return convertEntityToDto(obj);
	}

	@Override
	public List<GrupoEvento> obtenerGrupoEvento() {
		// TODO Auto-generated method stub
		return grupoEventoDao.obtenerGrupoEvento(true);
	}

	@Override
	public List<GrupoEventoDTO> obtenerGrupoEventoSinHijos() {
		// TODO Auto-generated method stub
		return grupoEventoDao.obtenerGrupoEventoSinHijos(true);
	}

	@Override
	public GrupoEventoDTO obtenerGrupoEventoPorId(Long id) {
		// TODO Auto-generated method stub
		GrupoEvento grupo =  grupoEventoDao.buscarPorId(id);
		 
	    return convertEntityToDto(grupo);
	}

	@Override
	public GrupoEventoDTO actualizarGrupoEvento(GrupoEventoDTO grupoEventoDto, Long id) {
		 Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        GrupoEvento objTemp = grupoEventoDao.buscarPorId(id);
	        if (objTemp != null) {
	            grupoEventoDto.setId(objTemp.getId());
	            grupoEventoDto.setUserCreation(objTemp.getUserCreation());
	            grupoEventoDto.setCreatedAt(objTemp.getCreatedAt());
	            grupoEventoDto.setUserUpdated(user.getId());
	            grupoEventoDto.setModifiedAt(Calendar.getInstance().getTime());
	            GrupoEvento obj = grupoEventoDao.actualizar(convertDtoToEntity(grupoEventoDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	}

	@Override
	public boolean eliminarGrupoEvento(Long id) {
		 try {
	            grupoEventoDao.eliminarPorId(id);
	            return true;
	        } catch (Exception err) {
	            return false;
	        }
	}

	@Override
	public boolean existenciaEvento(Long idgrupo) {
		// TODO Auto-generated method stub
		return grupoEventoDao.existenciaEvento(idgrupo);
	}

}
