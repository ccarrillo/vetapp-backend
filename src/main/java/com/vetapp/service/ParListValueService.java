package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.ParListValueRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.ParListValueDto;
import com.vetapp.model.ParListValue;
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
public class ParListValueService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    ParListValueRepository parListValueRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ParListValueDto guardarParListValue(ParListValueDto parListValueDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        parListValueDto.setUserCreation(user.getId());
        parListValueDto.setCreatedAt(Calendar.getInstance().getTime());
        ParListValue obj = parListValueRepository.save(convertDtoToEntity(parListValueDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<ParListValueDto> obtenerParListValues() {
        return (ArrayList<ParListValueDto>) parListValueRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public ParListValueDto obtenerParListValuePorId(Long id) {
        ParListValue obj = parListValueRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public ParListValueDto actualizarParListValue(ParListValueDto parListValueDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        ParListValue objTemp = parListValueRepository.findById(id).orElse(null);
        if (objTemp != null) {
            parListValueDto.setId(objTemp.getId());
            parListValueDto.setUserCreation(objTemp.getUserCreation());
            parListValueDto.setCreatedAt(objTemp.getCreatedAt());
            parListValueDto.setUserUpdated(user.getId());
            parListValueDto.setModifiedAt(Calendar.getInstance().getTime());
            ParListValue obj = parListValueRepository.save(convertDtoToEntity(parListValueDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }
    

    public boolean eliminarParListValue(Long id) {
        try {
            parListValueRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private ParListValueDto convertEntityToDto(ParListValue parListValue) {
        if (parListValue != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParListValueDto parListValueDto = new ParListValueDto();
            parListValueDto = modelMapper.map(parListValue, ParListValueDto.class);
            return parListValueDto;
        } else {
            return null;
        }
    }

    private ParListValue convertDtoToEntity(ParListValueDto parListValueDto) {
        if (parListValueDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ParListValue parListValue = new ParListValue();
            parListValue = modelMapper.map(parListValueDto, ParListValue.class);
            return parListValue;
        } else {
            return null;
        }
    }
}
