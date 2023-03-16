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
import com.vetapp.controller.GrupoInventarioSemen;
import com.vetapp.dao.GrupoInventarioSemenDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.GrupoInventarioDTO;
import com.vetapp.model.Grupo;
import com.vetapp.model.GrupoInventario;
import com.vetapp.model.UserAuth;

@Service
@Transactional
public class GrupoInventarioSemenServiceImpl implements GrupoInventarioSemenService {
	
	@Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    GrupoInventarioSemenDAO grupoInventarioSemenDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();
    
    private GrupoInventarioDTO convertEntityToDto(GrupoInventario grupo) {
        if (grupo != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            GrupoInventarioDTO grupoDto = new GrupoInventarioDTO();
            grupoDto = modelMapper.map(grupo, GrupoInventarioDTO.class);
            return grupoDto;
        } else {
            return null;
        }
    }

    private GrupoInventario convertDtoToEntity(GrupoInventarioDTO grupoDto) {
        if (grupoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            GrupoInventario grupo = new GrupoInventario();
            grupo = modelMapper.map(grupoDto, GrupoInventario.class);
            return grupo;
        } else {
            return null;
        }
    }


	@Override
	public List<GrupoInventario> obtenerGrupoInventarioSemen() {
		// TODO Auto-generated method stub
		return grupoInventarioSemenDao.obtenerGrupoInventarioSemen(true);
	}

	@Override
	public GrupoInventarioDTO guardarGrupoInventario(GrupoInventarioDTO grupoDto) {
		    Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        grupoDto.setUserCreation(user.getId());
	        grupoDto.setCreatedAt(Calendar.getInstance().getTime());
	        GrupoInventario obj = grupoInventarioSemenDao.insertar(convertDtoToEntity(grupoDto));
	        return convertEntityToDto(obj);
	}

	

	@Override
	public GrupoInventarioDTO obtenerGrupoInventarioPorId(Long id) {
		GrupoInventario grupo =  grupoInventarioSemenDao.buscarPorId(id);
		 
	    return convertEntityToDto(grupo);
	}

	@Override
	public GrupoInventarioDTO actualizarGrupoInventario(GrupoInventarioDTO grupoDto, Long id) {
		 Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        GrupoInventario objTemp = grupoInventarioSemenDao.buscarPorId(id);
	        if (objTemp != null) {
	            grupoDto.setId(objTemp.getId());
	            grupoDto.setUserCreation(objTemp.getUserCreation());
	            grupoDto.setCreatedAt(objTemp.getCreatedAt());
	            grupoDto.setUserUpdated(user.getId());
	            grupoDto.setModifiedAt(Calendar.getInstance().getTime());
	            GrupoInventario obj = grupoInventarioSemenDao.actualizar(convertDtoToEntity(grupoDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	}

	@Override
	public boolean eliminarGrupoInventario(Long id) {
		try {
			grupoInventarioSemenDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
	}

	@Override
	public boolean existenciaInventario(Long idgrupo) {
		// TODO Auto-generated method stub
		return grupoInventarioSemenDao.existenciaInventario(idgrupo);
	}

	@Override
	public List<GrupoInventarioDTO> obtenerGrupoInventarioSinHijos() {
		// TODO Auto-generated method stub
		return  grupoInventarioSemenDao.obtenerGrupoInventarioSinHijos(true);
	}

}
