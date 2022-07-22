package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.RacionRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.RacionDto;
import com.vetapp.model.Racion;
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
public class RacionService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    RacionRepository racionRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public RacionDto guardarRacion(RacionDto racionDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        racionDto.setUserCreation(user.getId());
        racionDto.setCreatedAt(Calendar.getInstance().getTime());
        Racion obj = racionRepository.save(convertDtoToEntity(racionDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<RacionDto> obtenerRacions() {
        return (ArrayList<RacionDto>) racionRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public RacionDto obtenerRacionPorId(Long id) {
        Racion obj = racionRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public RacionDto actualizarRacion(RacionDto racionDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        Racion objTemp = racionRepository.findById(id).orElse(null);
        if (objTemp != null) {
            racionDto.setId(objTemp.getId());
            racionDto.setUserCreation(objTemp.getUserCreation());
            racionDto.setCreatedAt(objTemp.getCreatedAt());
            racionDto.setUserUpdated(user.getId());
            racionDto.setModifiedAt(Calendar.getInstance().getTime());
            Racion obj = racionRepository.save(convertDtoToEntity(racionDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarRacion(Long id) {
        try {
            racionRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private RacionDto convertEntityToDto(Racion racion) {
        if (racion != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            RacionDto racionDto = new RacionDto();
            racionDto = modelMapper.map(racion, RacionDto.class);
            return racionDto;
        } else {
            return null;
        }
    }

    private Racion convertDtoToEntity(RacionDto racionDto) {
        if (racionDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            Racion racion = new Racion();
            racion = modelMapper.map(racionDto, Racion.class);
            return racion;
        } else {
            return null;
        }
    }
}
