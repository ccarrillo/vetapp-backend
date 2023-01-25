package com.vetapp.service;


import java.util.List;
import javax.transaction.Transactional;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.GrupoDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.GrupoDTO;
import com.vetapp.model.Animal;
import com.vetapp.model.Grupo;


@Service
@Transactional
public class GrupoAnimalesServiceImpl implements GrupoAnimalesService{
	
	@Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    GrupoDAO grupoDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();
    
    
    private GrupoDTO convertEntityToDto(Grupo grupo) {
        if (grupo != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            GrupoDTO grupoDto = new GrupoDTO();
            grupoDto = modelMapper.map(grupo, GrupoDTO.class);
            return grupoDto;
        } else {
            return null;
        }
    }

    private Grupo convertDtoToEntity(GrupoDTO grupoDto) {
        if (grupoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Grupo grupo = new Grupo();
            grupo = modelMapper.map(grupoDto, Grupo.class);
            return grupo;
        } else {
            return null;
        }
    }

	@Override
	public GrupoDTO guardarGrupoAnimles(GrupoDTO grupoDto) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Grupo> obtenerGrupoAnimales() {
		// TODO Auto-generated method stub
		
		        return  grupoDao.obtenerGrupoAnimales(true);
		                
		   
		//return (List<GrupoDTO>) grupoDao.obtenerGrupoAnimales(true);
	}
	

	@Override
	public GrupoDTO obtenerGrupoAnimalesPorId(Long id) {
		// TODO Auto-generated method stub

		 Grupo grupo =  grupoDao.buscarPorId(id);
		 
	    return convertEntityToDto(grupo);

	}

	@Override
	public GrupoDTO actualizarGrupoAnimales(GrupoDTO grupoDto, Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean eliminarGrupo(Long id) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<GrupoDTO> obtenerGrupoAnimalesSinHijos() {
		// TODO Auto-generated method stub
		 return  grupoDao.obtenerGrupoAnimalesSinHijos(true);
	}
	
	

}
