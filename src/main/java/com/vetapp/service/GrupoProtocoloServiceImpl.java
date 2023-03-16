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
import com.vetapp.dao.GrupoProtocoloDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.GrupoEventoDTO;
import com.vetapp.dto.GrupoProtocoloDTO;
import com.vetapp.model.Grupo;
import com.vetapp.model.GrupoEvento;
import com.vetapp.model.GrupoInventario;
import com.vetapp.model.GrupoProtocolo;
import com.vetapp.model.UserAuth;

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
		Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        grupoProtocoloDto.setUserCreation(user.getId());
        grupoProtocoloDto.setCreatedAt(Calendar.getInstance().getTime());
        GrupoProtocolo obj = grupoProtocoloDao.insertar(convertDtoToEntity(grupoProtocoloDto));
        return convertEntityToDto(obj);
	}

	@Override
	public List<GrupoProtocolo> obtenerGrupoProtocolo() {
		return grupoProtocoloDao.obtenerGrupoProtocolo(true);
	}

	@Override
	public List<GrupoProtocoloDTO> obtenerGrupoProtocoloSinHijos() {
		// TODO Auto-generated method stub
		return grupoProtocoloDao.obtenerGrupoEventoSinHijos(true);
	}

	@Override
	public GrupoProtocoloDTO obtenerGrupoProtocoloPorId(Long id) {
		GrupoProtocolo grupo =  grupoProtocoloDao.buscarPorId(id);
		 
	    return convertEntityToDto(grupo);
	}

	@Override
	public GrupoProtocoloDTO actualizarGrupoProtocolo(GrupoProtocoloDTO grupoProtocoloDto, Long id) {
		Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        GrupoProtocolo objTemp = grupoProtocoloDao.buscarPorId(id);
        if (objTemp != null) {
        	grupoProtocoloDto.setId(objTemp.getId());
        	grupoProtocoloDto.setUserCreation(objTemp.getUserCreation());
        	grupoProtocoloDto.setCreatedAt(objTemp.getCreatedAt());
        	grupoProtocoloDto.setUserUpdated(user.getId());
        	grupoProtocoloDto.setModifiedAt(Calendar.getInstance().getTime());
            GrupoProtocolo obj = grupoProtocoloDao.actualizar(convertDtoToEntity(grupoProtocoloDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
	}

	@Override
	public boolean eliminarGrupoProtocolo(Long id) {
		try {
			grupoProtocoloDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
	}

	@Override
	public boolean existenciaProtocolo(Long idgrupo) {
		// TODO Auto-generated method stub
		return grupoProtocoloDao.existenciaProtocolo(idgrupo);
	}

}
