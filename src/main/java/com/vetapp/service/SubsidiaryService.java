package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.SubsidiaryRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.SubsidiaryDto;
import com.vetapp.model.Subsidiary;
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
public class SubsidiaryService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    SubsidiaryRepository subsidiaryRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public SubsidiaryDto guardarSubsidiary(SubsidiaryDto subsidiaryDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        subsidiaryDto.setUserCreation(user.getId());
        subsidiaryDto.setCreatedAt(Calendar.getInstance().getTime());
        Subsidiary obj = subsidiaryRepository.save(convertDtoToEntity(subsidiaryDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<SubsidiaryDto> obtenerSubsidiarys() {
        return (ArrayList<SubsidiaryDto>) subsidiaryRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public SubsidiaryDto obtenerSubsidiaryPorId(Long id) {
        Subsidiary obj = subsidiaryRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public SubsidiaryDto actualizarSubsidiary(SubsidiaryDto subsidiaryDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Subsidiary objTemp = subsidiaryRepository.findById(id).orElse(null);
        if (objTemp != null) {
            subsidiaryDto.setId(objTemp.getId());
            subsidiaryDto.setUserCreation(objTemp.getUserCreation());
            subsidiaryDto.setCreatedAt(objTemp.getCreatedAt());
            subsidiaryDto.setUserUpdated(user.getId());
            subsidiaryDto.setModifiedAt(Calendar.getInstance().getTime());
            Subsidiary obj = subsidiaryRepository.save(convertDtoToEntity(subsidiaryDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarSubsidiary(Long id) {
        try {
            subsidiaryRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private SubsidiaryDto convertEntityToDto(Subsidiary subsidiary) {
        if (subsidiary != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            SubsidiaryDto subsidiaryDto = new SubsidiaryDto();
            subsidiaryDto = modelMapper.map(subsidiary, SubsidiaryDto.class);
            return subsidiaryDto;
        } else {
            return null;
        }
    }

    private Subsidiary convertDtoToEntity(SubsidiaryDto subsidiaryDto) {
        if (subsidiaryDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Subsidiary subsidiary = new Subsidiary();
            subsidiary = modelMapper.map(subsidiaryDto, Subsidiary.class);
            return subsidiary;
        } else {
            return null;
        }
    }
}
