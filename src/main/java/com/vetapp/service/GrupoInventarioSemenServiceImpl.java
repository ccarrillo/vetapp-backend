package com.vetapp.service;

import java.util.List;

import javax.transaction.Transactional;

import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.GrupoInventarioSemenDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.GrupoInventarioDTO;
import com.vetapp.model.GrupoInventario;

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
	public List<GrupoInventarioDTO> obtenerGrupoInventarioSemen() {
		// TODO Auto-generated method stub
		return grupoInventarioSemenDao.obtenerGrupoInventarioSemen(true);
	}

}
