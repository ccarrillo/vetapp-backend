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
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.GrupoDTO;
import com.vetapp.model.Animal;
import com.vetapp.model.Grupo;
import com.vetapp.model.UserAuth;


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
		     Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        grupoDto.setUserCreation(user.getId());
	        grupoDto.setCreatedAt(Calendar.getInstance().getTime());
	        Grupo obj = grupoDao.insertar(convertDtoToEntity(grupoDto));
	        return convertEntityToDto(obj);
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
		  Authentication auth = authenticationFacade.getAuthentication();
	        UserAuth user = userAuthRepository.findByEmail(auth.getName());
	        Grupo objTemp = grupoDao.buscarPorId(id);
	        if (objTemp != null) {
	            grupoDto.setId(objTemp.getId());
	            grupoDto.setUserCreation(objTemp.getUserCreation());
	            grupoDto.setCreatedAt(objTemp.getCreatedAt());
	            grupoDto.setUserUpdated(user.getId());
	            grupoDto.setModifiedAt(Calendar.getInstance().getTime());
	            Grupo obj = grupoDao.actualizar(convertDtoToEntity(grupoDto));
	            return convertEntityToDto(obj);
	        } else {
	            return null;
	        }
	}

	@Override
	public boolean eliminarGrupo(Long id) {
		 try {
	            grupoDao.eliminarPorId(id);
	            return true;
	        } catch (Exception err) {
	            return false;
	        }
	}

	@Override
	public List<GrupoDTO> obtenerGrupoAnimalesSinHijos() {
		// TODO Auto-generated method stub
		 return  grupoDao.obtenerGrupoAnimalesSinHijos(true);
	}

	@Override
	public boolean existenciaAnimales(Long idgrupo) {
		// TODO Auto-generated method stub
		return grupoDao.existenciaAnimales(idgrupo);
		
	}
	
	

}
