package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.DetalleTipoEventoAnimalRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.DetalleTipoEventoAnimalDto;
import com.vetapp.model.DetalleTipoEventoAnimal;
import com.vetapp.model.UserAuth;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.stream.Collectors;

@Service
public class DetalleTipoEventoAnimalService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    DetalleTipoEventoAnimalRepository detalleTipoEventoAnimalRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public DetalleTipoEventoAnimalDto guardarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDto detalleTipoEventoAnimalDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        detalleTipoEventoAnimalDto.setUserCreation(user.getId());
        detalleTipoEventoAnimalDto.setCreatedAt(Calendar.getInstance().getTime());
        DetalleTipoEventoAnimal obj = detalleTipoEventoAnimalRepository.save(convertDtoToEntity(detalleTipoEventoAnimalDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<DetalleTipoEventoAnimalDto> obtenerDetalleTipoEventoAnimals() {
        return (ArrayList<DetalleTipoEventoAnimalDto>) detalleTipoEventoAnimalRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public DetalleTipoEventoAnimalDto obtenerDetalleTipoEventoAnimalPorId(Long id) {
        DetalleTipoEventoAnimal obj = detalleTipoEventoAnimalRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public DetalleTipoEventoAnimalDto actualizarDetalleTipoEventoAnimal(DetalleTipoEventoAnimalDto detalleTipoEventoAnimalDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        DetalleTipoEventoAnimal objTemp = detalleTipoEventoAnimalRepository.findById(id).orElse(null);
        if (objTemp != null) {
            detalleTipoEventoAnimalDto.setId(objTemp.getId());
            detalleTipoEventoAnimalDto.setUserCreation(objTemp.getUserCreation());
            detalleTipoEventoAnimalDto.setCreatedAt(objTemp.getCreatedAt());
            detalleTipoEventoAnimalDto.setUserUpdated(user.getId());
            detalleTipoEventoAnimalDto.setModifiedAt(Calendar.getInstance().getTime());
            DetalleTipoEventoAnimal obj = detalleTipoEventoAnimalRepository.save(convertDtoToEntity(detalleTipoEventoAnimalDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarDetalleTipoEventoAnimal(Long id) {
        try {
            detalleTipoEventoAnimalRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private DetalleTipoEventoAnimalDto convertEntityToDto(DetalleTipoEventoAnimal detalleTipoEventoAnimal) {
        if (detalleTipoEventoAnimal != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            DetalleTipoEventoAnimalDto detalleTipoEventoAnimalDto = new DetalleTipoEventoAnimalDto();
            detalleTipoEventoAnimalDto = modelMapper.map(detalleTipoEventoAnimal, DetalleTipoEventoAnimalDto.class);
            return detalleTipoEventoAnimalDto;
        } else {
            return null;
        }
    }

    private DetalleTipoEventoAnimal convertDtoToEntity(DetalleTipoEventoAnimalDto detalleTipoEventoAnimalDto) {
        if (detalleTipoEventoAnimalDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            DetalleTipoEventoAnimal detalleTipoEventoAnimal = new DetalleTipoEventoAnimal();
            detalleTipoEventoAnimal = modelMapper.map(detalleTipoEventoAnimalDto, DetalleTipoEventoAnimal.class);
            return detalleTipoEventoAnimal;
        } else {
            return null;
        }
    }
}
