package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.DetalleTipoEventoAnimalDAO;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.DetalleTipoEventoAnimalDTO;
import com.vetapp.dto.EventoAnimalDTO;
import com.vetapp.model.DetalleTipoEventoAnimal;
import com.vetapp.model.UserAuth;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class DetalleTipoEventoAnimalServiceImpl implements DetalleTipoEventoAnimalService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    DetalleTipoEventoAnimalDAO detalleTipoEventoAnimalDao;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public DetalleTipoEventoAnimalDTO guardarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        detalleTipoEventoAnimalDto.setUserCreation(user.getId());
        detalleTipoEventoAnimalDto.setCreatedAt(Calendar.getInstance().getTime());
        DetalleTipoEventoAnimal obj = detalleTipoEventoAnimalDao.insertar(convertDtoToEntity(detalleTipoEventoAnimalDto));
        return convertEntityToDto(obj);
    }
    
    public DetalleTipoEventoAnimalDTO guardarDetalleTipoEventoAnimal(EventoAnimalDTO evento, DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        detalleTipoEventoAnimalDto.setUserCreation(user.getId());
        detalleTipoEventoAnimalDto.setCreatedAt(Calendar.getInstance().getTime());
        detalleTipoEventoAnimalDto.setIdeventoanimal(evento);
        DetalleTipoEventoAnimal obj = detalleTipoEventoAnimalDao.insertar(convertDtoToEntity(detalleTipoEventoAnimalDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<DetalleTipoEventoAnimalDTO> obtenerDetalleTipoEventoAnimals() {
        return (ArrayList<DetalleTipoEventoAnimalDTO>) detalleTipoEventoAnimalDao.buscarTodos(new DetalleTipoEventoAnimal())
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public DetalleTipoEventoAnimalDTO obtenerDetalleTipoEventoAnimalPorId(Long id) {
        DetalleTipoEventoAnimal obj = detalleTipoEventoAnimalDao.buscarPorId(id);
        return convertEntityToDto(obj);
    }

    public DetalleTipoEventoAnimalDTO actualizarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        DetalleTipoEventoAnimal objTemp = detalleTipoEventoAnimalDao.buscarPorId(id);
        if (objTemp != null) {
            detalleTipoEventoAnimalDto.setId(objTemp.getId());
            detalleTipoEventoAnimalDto.setUserCreation(objTemp.getUserCreation());
            detalleTipoEventoAnimalDto.setCreatedAt(objTemp.getCreatedAt());
            detalleTipoEventoAnimalDto.setUserUpdated(user.getId());
            detalleTipoEventoAnimalDto.setModifiedAt(Calendar.getInstance().getTime());
            DetalleTipoEventoAnimal obj = detalleTipoEventoAnimalDao.actualizar(convertDtoToEntity(detalleTipoEventoAnimalDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }
    
    @Override
	public DetalleTipoEventoAnimalDTO actualizarDetalleTipoEventoAnimal(EventoAnimalDTO evento,
			DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto, Long id) {
    	 Authentication auth = authenticationFacade.getAuthentication();
         UserAuth user = userAuthRepository.findByEmail(auth.getName());
         DetalleTipoEventoAnimal objTemp = detalleTipoEventoAnimalDao.buscarPorId(id);
         if (objTemp != null) {
             detalleTipoEventoAnimalDto.setId(objTemp.getId());
             detalleTipoEventoAnimalDto.setUserCreation(objTemp.getUserCreation());
             detalleTipoEventoAnimalDto.setCreatedAt(objTemp.getCreatedAt());
             detalleTipoEventoAnimalDto.setUserUpdated(user.getId());
             detalleTipoEventoAnimalDto.setModifiedAt(Calendar.getInstance().getTime());
             detalleTipoEventoAnimalDto.setIdeventoanimal(evento);
             DetalleTipoEventoAnimal obj = detalleTipoEventoAnimalDao.actualizar(convertDtoToEntity(detalleTipoEventoAnimalDto));
             return convertEntityToDto(obj);
         } else {
             return null;
         }
	}

    public boolean eliminarDetalleTipoEventoAnimal(Long id) {
        try {
            detalleTipoEventoAnimalDao.eliminarPorId(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private DetalleTipoEventoAnimalDTO convertEntityToDto(DetalleTipoEventoAnimal detalleTipoEventoAnimal) {
        if (detalleTipoEventoAnimal != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto = new DetalleTipoEventoAnimalDTO();
            detalleTipoEventoAnimalDto = modelMapper.map(detalleTipoEventoAnimal, DetalleTipoEventoAnimalDTO.class);
            return detalleTipoEventoAnimalDto;
        } else {
            return null;
        }
    }

    private DetalleTipoEventoAnimal convertDtoToEntity(DetalleTipoEventoAnimalDTO detalleTipoEventoAnimalDto) {
        if (detalleTipoEventoAnimalDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            DetalleTipoEventoAnimal detalleTipoEventoAnimal = new DetalleTipoEventoAnimal();
            detalleTipoEventoAnimal = modelMapper.map(detalleTipoEventoAnimalDto, DetalleTipoEventoAnimal.class);
            return detalleTipoEventoAnimal;
        } else {
            return null;
        }
    }

	@Override
	public List<DetalleTipoEventoAnimalDTO> obtenerListaDetallePorIdEventoAnimal(Long id) {
		// TODO Auto-generated method stub
		return detalleTipoEventoAnimalDao.obtenerListaDetallePorIdEventoAnimal( id);
	}

	
}
