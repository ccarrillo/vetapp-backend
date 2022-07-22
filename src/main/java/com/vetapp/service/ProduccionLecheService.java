package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.ProduccionLecheRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.ProduccionLecheDto;
import com.vetapp.model.ProduccionLeche;
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
public class ProduccionLecheService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    ProduccionLecheRepository produccionLecheRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public ProduccionLecheDto guardarProduccionLeche(ProduccionLecheDto produccionLecheDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        produccionLecheDto.setUserCreation(user.getId());
        produccionLecheDto.setCreatedAt(Calendar.getInstance().getTime());
        ProduccionLeche obj = produccionLecheRepository.save(convertDtoToEntity(produccionLecheDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<ProduccionLecheDto> obtenerProduccionLeches() {
        return (ArrayList<ProduccionLecheDto>) produccionLecheRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public ProduccionLecheDto obtenerProduccionLechePorId(Long id) {
        ProduccionLeche obj = produccionLecheRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public ProduccionLecheDto actualizarProduccionLeche(ProduccionLecheDto produccionLecheDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        ProduccionLeche objTemp = produccionLecheRepository.findById(id).orElse(null);
        if (objTemp != null) {
            produccionLecheDto.setId(objTemp.getId());
            produccionLecheDto.setUserCreation(objTemp.getUserCreation());
            produccionLecheDto.setCreatedAt(objTemp.getCreatedAt());
            produccionLecheDto.setUserUpdated(user.getId());
            produccionLecheDto.setModifiedAt(Calendar.getInstance().getTime());
            ProduccionLeche obj = produccionLecheRepository.save(convertDtoToEntity(produccionLecheDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarProduccionLeche(Long id) {
        try {
            produccionLecheRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private ProduccionLecheDto convertEntityToDto(ProduccionLeche produccionLeche) {
        if (produccionLeche != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ProduccionLecheDto produccionLecheDto = new ProduccionLecheDto();
            produccionLecheDto = modelMapper.map(produccionLeche, ProduccionLecheDto.class);
            return produccionLecheDto;
        } else {
            return null;
        }
    }

    private ProduccionLeche convertDtoToEntity(ProduccionLecheDto produccionLecheDto) {
        if (produccionLecheDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            ProduccionLeche produccionLeche = new ProduccionLeche();
            produccionLeche = modelMapper.map(produccionLecheDto, ProduccionLeche.class);
            return produccionLeche;
        } else {
            return null;
        }
    }
}
