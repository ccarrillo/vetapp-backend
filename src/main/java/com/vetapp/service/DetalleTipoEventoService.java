package com.vetapp.service;

import com.vetapp.config.IAuthenticationFacade;
import com.vetapp.dao.DetalleTipoEventoRepository;
import com.vetapp.dao.UserAuthRepository;
import com.vetapp.dto.DetalleTipoEventoDto;
import com.vetapp.model.DetalleTipoEvento;
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
public class DetalleTipoEventoService {

    @Autowired
    private IAuthenticationFacade authenticationFacade;

    @Autowired
    DetalleTipoEventoRepository detalleTipoEventoRepository;

    @Autowired
    UserAuthRepository userAuthRepository;

    ModelMapper modelMapper = new ModelMapper();

    public DetalleTipoEventoDto guardarDetalleTipoEvento(DetalleTipoEventoDto detalleTipoEventoDto) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        System.out.println("-----------------");
        System.out.println(auth.getName());
        System.out.println(user.getId());
        System.out.println("-----------------");
        detalleTipoEventoDto.setUserCreation(user.getId());
        detalleTipoEventoDto.setCreatedAt(Calendar.getInstance().getTime());
        DetalleTipoEvento obj = detalleTipoEventoRepository.save(convertDtoToEntity(detalleTipoEventoDto));
        return convertEntityToDto(obj);
    }

    public ArrayList<DetalleTipoEventoDto> obtenerDetalleTipoEventos() {
        return (ArrayList<DetalleTipoEventoDto>) detalleTipoEventoRepository.findAll()
                .stream()
                .map(this::convertEntityToDto)
                .collect(Collectors.toList());
    }

    public DetalleTipoEventoDto obtenerDetalleTipoEventoPorId(Long id) {
        DetalleTipoEvento obj = detalleTipoEventoRepository.findById(id).orElse(null);
        return convertEntityToDto(obj);
    }

    public DetalleTipoEventoDto actualizarDetalleTipoEvento(DetalleTipoEventoDto detalleTipoEventoDto, Long id) {
        Authentication auth = authenticationFacade.getAuthentication();
        UserAuth user = userAuthRepository.findByEmail(auth.getName());
        DetalleTipoEvento objTemp = detalleTipoEventoRepository.findById(id).orElse(null);
        if (objTemp != null) {
            detalleTipoEventoDto.setId(objTemp.getId());
            detalleTipoEventoDto.setUserCreation(objTemp.getUserCreation());
            detalleTipoEventoDto.setCreatedAt(objTemp.getCreatedAt());
            detalleTipoEventoDto.setUserUpdated(user.getId());
            detalleTipoEventoDto.setModifiedAt(Calendar.getInstance().getTime());
            DetalleTipoEvento obj = detalleTipoEventoRepository.save(convertDtoToEntity(detalleTipoEventoDto));
            return convertEntityToDto(obj);
        } else {
            return null;
        }
    }

    public boolean eliminarDetalleTipoEvento(Long id) {
        try {
            detalleTipoEventoRepository.deleteById(id);
            return true;
        } catch (Exception err) {
            return false;
        }
    }

    private DetalleTipoEventoDto convertEntityToDto(DetalleTipoEvento detalleTipoEvento) {
        if (detalleTipoEvento != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            DetalleTipoEventoDto detalleTipoEventoDto = new DetalleTipoEventoDto();
            detalleTipoEventoDto = modelMapper.map(detalleTipoEvento, DetalleTipoEventoDto.class);
            return detalleTipoEventoDto;
        } else {
            return null;
        }
    }

    private DetalleTipoEvento convertDtoToEntity(DetalleTipoEventoDto detalleTipoEventoDto) {
        if (detalleTipoEventoDto != null) {
            modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.LOOSE);
            DetalleTipoEvento detalleTipoEvento = new DetalleTipoEvento();
            detalleTipoEvento = modelMapper.map(detalleTipoEventoDto, DetalleTipoEvento.class);
            return detalleTipoEvento;
        } else {
            return null;
        }
    }
}
